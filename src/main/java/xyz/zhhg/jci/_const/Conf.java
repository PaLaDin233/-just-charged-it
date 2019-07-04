package xyz.zhhg.jci._const;

public final class Conf {
	private Conf() {}
	private String appid;
	private String secretCode;
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getSecretCode() {
		return secretCode;
	}
	public void setSecretCode(String secretCode) {
		this.secretCode = secretCode;
	}
}
