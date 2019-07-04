package xyz.zhhg.jci.tools;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import xyz.zhhg.jci.exception.SessionOverDueException;
import xyz.zhhg.jci.model.wechat.user.WeChatIdentifier;

public final class SessionTools {
	private SessionTools() {}
	
	public static String getOpenId(HttpServletRequest request) throws Exception {
		HttpSession session=RequestTools.getSession(request, null);
		String openid=null;
		if(session!=null) {
			WeChatIdentifier weChatIdentifier=
					(WeChatIdentifier) session.getAttribute("sid");
			if(weChatIdentifier!=null) {
				openid=weChatIdentifier.getOpenid();
			}
			
		}
		if(openid==null)throw new SessionOverDueException("会话过期，请重新登陆");
		return openid;
	}
	
	public static HttpSession setOpenId(HttpServletRequest request,WeChatIdentifier identifier) {
		HttpSession session=RequestTools.getSession(request,null);
		System.out.println("设置登陆sessionId:"+session.getId()+"...");
		
		session.setAttribute("sid", identifier);
		return session;
	}
	
}
