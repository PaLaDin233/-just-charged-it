package xyz.zhhg.jci.api.model;

import java.util.List;

import xyz.zhhg.jci.model.standard.bill.Order;

public class BillListFrom {
	private String openid;
	private List<Integer> detypeList;
	private String beginDate;
	private String endDate;
	private double minMoney;
	private double maxMoney;
	private String rdtype;
	private String remarks;
	private List<Order> orders;
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public List<Integer> getDetypeList() {
		return detypeList;
	}
	public void setDetypeList(List<Integer> detypeList) {
		this.detypeList = detypeList;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public double getMinMoney() {
		return minMoney;
	}
	public void setMinMoney(double minMoney) {
		this.minMoney = minMoney;
	}
	public double getMaxMoney() {
		return maxMoney;
	}
	public void setMaxMoney(double maxMoney) {
		this.maxMoney = maxMoney;
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
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "BillListFrom [openid=" + openid + ", detypeList=" + detypeList + ", beginDate=" + beginDate
				+ ", endDate=" + endDate + ", minMoney=" + minMoney + ", maxMoney=" + maxMoney + ", rdtype=" + rdtype
				+ ", remarks=" + remarks + ", orders=" + orders + "]";
	}

	
	
}
