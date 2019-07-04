package xyz.zhhg.jci.api.model;

import java.text.SimpleDateFormat;

import xyz.zhhg.jci.model.standard.bill.Bill;

public class BillForm {
	private int id;
	private String openid;
	private int savingid;
	private int detype;
	private String spawndate;
	private double money;
	private String rdtype;
	private String remarks;
	private String dename;
	private String name;
	
	public BillForm() {
		
	}
	public BillForm(Bill bill) {
		id=bill.getId();
		openid=bill.getOpenid();
		savingid=bill.getSavingid();
		detype=bill.getDetype();
		setSpawndate(new SimpleDateFormat("yyyy-MM-dd").format(bill.getSpawndate()));
		money=bill.getMoney();
		rdtype=bill.getRdtype();
		remarks=bill.getRemarks();
		dename=bill.getDename();
		name=bill.getName();
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
	public int getSavingid() {
		return savingid;
	}
	public void setSavingid(int savingid) {
		this.savingid = savingid;
	}
	public int getDetype() {
		return detype;
	}
	public void setDetype(int detype) {
		this.detype = detype;
	}
	public String getSpawndate() {
		return spawndate;
	}
	public void setSpawndate(String spawndate) {
		this.spawndate = spawndate;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getRdtype() {
		return rdtype;
	}
	public void setRdtype(String rdtype) {
		this.rdtype = rdtype;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getDename() {
		return dename;
	}
	public void setDename(String dename) {
		this.dename = dename;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "BillForm [id=" + id + ", openid=" + openid + ", savingid=" + savingid + ", detype=" + detype
				+ ", spawndate=" + spawndate + ", money=" + money + ", rdtype=" + rdtype + ", remarks=" + remarks
				+ ", dename=" + dename + ", name=" + name + "]";
	}
	
	
}
