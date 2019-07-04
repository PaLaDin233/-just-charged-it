package xyz.zhhg.jci.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.zhhg.jci.tools.session.SessionListener;

@Controller
public class ServerInfo {
	
	@RequestMapping("/api/isSessionTimeOut")
	public boolean isSessionTimeOut(HttpServletRequest request) {
		if(null!=SessionListener.getSession((String) request.getAttribute("sessionId"))) {
			return true;
		}
		return false;
	}
}
