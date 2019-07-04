package xyz.zhhg.jci.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.mock.web.MockHttpServletRequest;

import com.google.gson.JsonPrimitive;

import oracle.net.aso.e;
import xyz.zhhg.jci.tools.session.SessionListener;

public final class RequestTools {
	private RequestTools() {}
	/**
	 * 获取POST请求的数据
	 * @param request
	 * @return 数据字符串
	 */
	public static String getDataFromRequest(HttpServletRequest request) {
		InputStream is = null;
		
		try {
			//获取输入流
			is= request.getInputStream();
			BufferedReader reader=new BufferedReader(new InputStreamReader(is,"utf-8"));
			StringBuffer buffer=new StringBuffer("");
			String temp=reader.readLine();
			while(temp!=null) {
				//buffer.append(StringEscapeUtils.unescapeJavaScript(temp));
				buffer.append(temp);
				temp=reader.readLine();
			}
			reader.close();
			return buffer.toString();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	public static HttpSession getSession(HttpServletRequest request,String data) {
		String sessionId=(String) request.getParameter("sessionId");
		if(null==sessionId) {//POST方式
			if(data==null||"".equals(data)) {
				
			}else {
				Map<String,Object> map=JsonHelper.toMap(data);
				if(map!=null) {
					sessionId=((JsonPrimitive) map.get("sessionId")).getAsString();					
				}
			}

		}
		HttpSession session=SessionListener.getSession(sessionId);
		
		if(session==null) {
			session=request.getSession();
		}
		return session;
	}
	
	
	
	
	
}
