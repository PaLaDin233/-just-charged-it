package xyz.zhhg.jci.tools.session;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener{

    private static HashMap<String, HttpSession> mymap = new HashMap<String, HttpSession>();


    public static synchronized HttpSession getSession(String session_id) {
        if (session_id == null) return null;
        return mymap.get(session_id);
    }

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		long t=se.getSession().getCreationTime();
		
		System.out.println(new Date(t)+"正在创建"+se.getSession().getId());
		
		mymap.put(se.getSession().getId(),se.getSession());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		mymap.remove(se.getSession().getId());
		 System.out.println(se.getSession() + "被销毁了");
	}
}