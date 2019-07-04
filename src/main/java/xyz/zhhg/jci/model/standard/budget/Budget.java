package xyz.zhhg.jci.model.standard.budget;

public class Budget {
	private int id;
	private String openid;
	private String begindate;
	private String enddate;
	private String remarks;
	private int budgettype;
	private double budget;

	@Override
	public String toString() {
		return "Budget [id=" + id + ", openid=" + openid + ", begindate=" + begindate + ", enddate=" + enddate
				+ ", remarks=" + remarks + ", budgettype=" + budgettype + ", budget=" + budget + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getBegindate() {
		return begindate;
	}
	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getBudgettype() {
		return budgettype;
	}
	public void setBudgettype(int budgettype) {
		this.budgettype = budgettype;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	
	
	
}
