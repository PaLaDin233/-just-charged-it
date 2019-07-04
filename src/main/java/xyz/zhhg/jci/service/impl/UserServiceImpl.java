package xyz.zhhg.jci.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.zhhg.jci._const.Conf;
import xyz.zhhg.jci.dao.TypeMapper;
import xyz.zhhg.jci.dao.UserMapper;
import xyz.zhhg.jci.model.standard.user.Tb_UserInfo;
import xyz.zhhg.jci.model.wechat.user.WeChatIdentifier;
import xyz.zhhg.jci.service.UserService;
import xyz.zhhg.jci.tools.HttpClientHelper;
import xyz.zhhg.jci.tools.JsonHelper;
import xyz.zhhg.jci.tools.RequestTools;
import xyz.zhhg.jci.tools.SessionTools;
import xyz.zhhg.jci.tools.session.SessionListener;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper mapper;
	@Autowired
	TypeMapper typeMapper;
	@Autowired
	Conf conf;
	
	public void weChatLogin(String code,HttpServletRequest request) throws Exception{
		
		String url="https://api.weixin.qq.com/sns/jscode2session?appid="+conf.getAppid()+"&secret="
				+conf.getSecretCode()+"&js_code="+code+"&grant_type=authorization_code";
		
		//调用小程序api获取用户标识
		String checkJson=HttpClientHelper.doHttpsGet(url, null);
		WeChatIdentifier identifier=(WeChatIdentifier) 
				JsonHelper.jsonStringToJson(checkJson, WeChatIdentifier.class);

		//用户标识放入session
		SessionTools.setOpenId(request, identifier);
		
		//判断数据库是否存在该用户，不存在则插入
		Tb_UserInfo userInfo=new Tb_UserInfo();
		userInfo.setOpenid(identifier.getOpenid());
		
		if(!mapper.isExistOpenId(userInfo.getOpenid())) {
			mapper.insertUser(userInfo);
			
		}
		
	}
	

	@Override
	public void saveUserInfo(Tb_UserInfo userInfo) {
		if(!mapper.isExistOpenId(userInfo.getOpenid())) {
			mapper.insertUser(userInfo);
		}
		mapper.updateUserInfo(userInfo);			
		
	}
}
