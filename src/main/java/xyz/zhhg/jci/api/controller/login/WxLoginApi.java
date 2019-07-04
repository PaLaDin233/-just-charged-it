package xyz.zhhg.jci.api.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import xyz.zhhg.jci.model.standard.jsons.jsondata.JsonData;
import xyz.zhhg.jci.model.standard.user.Tb_UserInfo;
import xyz.zhhg.jci.model.wechat.user.WeChatIdentifier;
import xyz.zhhg.jci.model.wechat.user.WeChatUserInfo;
import xyz.zhhg.jci.service.UserService;
import xyz.zhhg.jci.tools.AESTools;
import xyz.zhhg.jci.tools.JsonHelper;
import xyz.zhhg.jci.tools.RequestTools;
import xyz.zhhg.jci.tools.session.SessionListener;
/**
 * 小程序用户登陆接口
 * @author 清居
 *
 */
@Controller
public class WxLoginApi {
	
	@Autowired
	private UserService userService;
	/**
	 * 登陆调用主入口
	 * @param code 小程序端传的用户code
	 * @return 
	 */
	@RequestMapping(value="/wxlogin",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public @ResponseBody JsonData wxLogin(String code,HttpServletRequest request) {
		if(code==null)return null;
		JsonData jsonData;
		
		try {
			userService.weChatLogin(code, request);
			HashMap<String, String> map=new HashMap<>();
			map.put("sessionId", RequestTools.getSession(request, null).getId());
			jsonData=JsonData.success(map);
		} catch (Exception e) {
			jsonData=JsonData.failure("网络波动");
			e.printStackTrace();
		}
		
		return jsonData;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public @ResponseBody JsonData wxLogin(String code) {
		//System.out.println("code"+code);
		Map<String, String> data=new HashMap<>();
		JsonData jsonData=JsonData.success(data);
		return jsonData;
	}
	
	@RequestMapping(value="/saveWXUserInfo",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody JsonData setUserInfo(HttpServletRequest request) {
		try {
			String dataString=RequestTools.getDataFromRequest(request);
			WeChatUserInfo chatUserInfo= JsonHelper.jsonStringToJson(dataString, WeChatUserInfo.class);
			HttpSession session=RequestTools.getSession(request,dataString);
			WeChatIdentifier identifier=(WeChatIdentifier)session.getAttribute("sid");
			/*String res=AESTools.AESDncode(chatUserInfo.getEncryptedData(),identifier.getSession_key(),chatUserInfo.getIv());
			System.out.println(res);*/
			chatUserInfo.getUserInfo().setOpenid(identifier.getOpenid());
			userService.saveUserInfo(chatUserInfo.getUserInfo());
			return JsonData.success("ok");
		}catch (Exception e) {
			return JsonData.failure(e.getMessage());
		}
		
	}
	
	
	
}
