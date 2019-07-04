package xyz.zhhg.jci.model.standard.type;
/**
 * 账目细类
 * @author 清居
 *
 */
public class AccountDetailType {
	private int id;
	private String name;
	private int typeid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	@Override
	public String toString() {
		return "AccountDetailType [id=" + id + ", name=" + name + ", typeid=" + typeid + "]";
	}
	
	
}
