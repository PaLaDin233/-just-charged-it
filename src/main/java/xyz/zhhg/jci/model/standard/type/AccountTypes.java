package xyz.zhhg.jci.model.standard.type;

import java.util.List;

/**
 * 账户类列表项,分为账户大类和其对应的小类
 * @author 清居
 *
 */
public class AccountTypes {
	private int id;
	private String openid;
	private String type;
	private String name;
	private List<AccountDetailType> list;
	
	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

	public AccountTypes() {
		super();
	}
	
	public List<AccountDetailType> getList() {
		return list;
	}

	public void setList(List<AccountDetailType> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "AccountTypes [id=" + id + ", openid=" + openid + ", type=" + type + ", name=" + name + ", list=" + list
				+ "]";
	}


	
	
	
	
}
