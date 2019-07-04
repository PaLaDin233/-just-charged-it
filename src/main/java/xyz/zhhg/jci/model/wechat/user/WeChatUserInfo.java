package xyz.zhhg.jci.model.wechat.user;

import xyz.zhhg.jci.model.standard.user.Tb_UserInfo;
import xyz.zhhg.jci.tools.JsonHelper;

/*
 * rawData:res.rawData,
  encryptedData: res.encryptedData,
  iv: res.iv,
  signature: res.signature,
  userInfo:res.rawData,
  sessionId:_this.globalData.sessionId
 * 
 * 
 */
public class WeChatUserInfo {
	private String openid;
	private String sessionId;
	private String encryptedData;
	private String iv;
	private String signature;
	private Tb_UserInfo userInfo;
	
	public Tb_UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(Tb_UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public String getEncryptedData() {
		return encryptedData;
	}
	public void setEncryptedData(String encryptedData) {
		this.encryptedData = encryptedData;
	}
	public String getIv() {
		return iv;
	}
	public void setIv(String iv) {
		this.iv = iv;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	@Override
	public String toString() {
		return "WeChatUserInfo [userInfo=" + userInfo + ", encryptedData=" + encryptedData + ", iv=" + iv
				+ ", signature=" + signature + "]";
	}

	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	
}
/*class UserInfo{
	private String nickName;
	private String gender;
	private String language;
	private String city;
	private String province;
	private String country;
	private String avatarUrl;
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	@Override
	public String toString() {
		return "UserInfo [nickName=" + nickName + ", gender=" + gender + ", language=" + language + ", city=" + city
				+ ", provice=" + province + ", country=" + country + ", avatarUrl=" + avatarUrl + "]";
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
}*/
