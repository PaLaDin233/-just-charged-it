package xyz.zhhg.jci.model.standard.bill;

import java.util.Date;

import xyz.zhhg.jci.api.model.BillForm;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Bill {
	private int id;
	private String openid;
	private int savingid;
	private int detype;
	private Date spawndate;
	private double money;
	private String rdtype;
	private String remarks;
	private String dename;
	private String name;
	
	public Bill() {
	}
	
	public Bill(BillForm billFrom) throws ParseException {
		id=billFrom.getId();
		openid=billFrom.getOpenid();
		savingid=billFrom.getSavingid();
		detype=billFrom.getDetype();
		setSpawndate(billFrom.getSpawndate());
		money=billFrom.getMoney();
		rdtype=billFrom.getRdtype();
		remarks=billFrom.getRemarks();
		dename=billFrom.getDename();
		name=billFrom.getName();
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



	public Date getSpawndate() {
		return spawndate;
	}
	
	public void setSpawndate(Date spawndate) {
		this.spawndate=spawndate;
	}


	public void setSpawndate(String spawndate)throws ParseException {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		this.spawndate = (Date) dateFormat.parse(spawndate);
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



	



	@Override
	public String toString() {
		return "Bill [id=" + id + ", openid=" + openid + ", savingid=" + savingid + ", detype=" + detype
				+ ", spawndate=" + spawndate + ", money=" + money + ", rdtype=" + rdtype + ", remarks=" + remarks
				+ ", dename=" + dename + ", name=" + name + "]";
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
	
	
}
