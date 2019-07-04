package xyz.zhhg.jci.model.wechat.user;

import xyz.zhhg.jci.model.standard.jsons.Jsonable;

public class WeChatIdentifier implements Jsonable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5281476557959689897L;
	private String openid;
	private String session_key;
	private String unionId;
	
	public WeChatIdentifier() {
	
	}
	
	
	
	public WeChatIdentifier(String openid) {
		super();
		this.openid = openid;
	}



	public WeChatIdentifier(String openId, String session_key) {
		super();
		this.openid = openId;
		this.session_key = session_key;
	}

	@Override
	public String toString() {
		return "WeChatIdentifier [openid=" + openid + ", session_key=" + session_key + ", unionId=" + unionId + "]";
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getSession_key() {
		return session_key;
	}

	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}
	
	
}
