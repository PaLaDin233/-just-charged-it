package xyz.zhhg.jci.model.standard.user;

/**
 * openid               varchar2(64 byte)    not null,
   avata_url            varchar2(256),
   gender               char(1 byte),
   country              varchar2(32),
   province             varchar2(32),
   city                 varchar2(32),
   language             varchar2(8),
   md5code              char(64),
   unionid              varchar2(64),
   nickname             varchar2(64 byte),
 */
public class Tb_UserInfo {
	private String openid;
	private String avatarUrl;
	private String gender;
	private String country;
	private String province;
	private String city;
	private String language;
	private String md5code;
	private String unionid;
	private String nickName;
	
	@Override
	public String toString() {
		return "Tb_UserInfo [openid=" + openid + ", avata_url=" + avatarUrl + ", gender=" + gender + ", country="
				+ country + ", province=" + province + ", city=" + city + ", language=" + language + ", md5code="
				+ md5code + ", unionid=" + unionid + ", nickname=" + nickName + "]";
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avata_url) {
		this.avatarUrl = avata_url;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getMd5code() {
		return md5code;
	}
	public void setMd5code(String md5code) {
		this.md5code = md5code;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickname) {
		this.nickName = nickname;
	}

}
