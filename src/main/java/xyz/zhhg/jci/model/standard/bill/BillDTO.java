package xyz.zhhg.jci.model.standard.bill;

import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import xyz.zhhg.jci.api.model.BillListFrom;

public class BillDTO {
	private String openid;
	private List<Integer> detypeList;
	private Date beginDate;
	private Date endDate;
	private double minMoney;
	private double maxMoney;
	private String rdtype;
	private String remarks;
	private List<Order> orders;

	public BillDTO(BillListFrom form) throws ParseException {
		this.openid=form.getOpenid();
		this.detypeList=form.getDetypeList();
		this.setBeginDate(form.getBeginDate());
		this.setEndDate(form.getEndDate());
		this.setMinMoney(form.getMinMoney());
		this.setMaxMoney(form.getMaxMoney());
		setRdtype(form.getRdtype());
		setRemarks(form.getRemarks());
		setOrders(form.getOrders());
	}
	public BillDTO() {
		
	}
	
	
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
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) throws ParseException {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		if(beginDate!=null) {
			setBeginDate((Date) dateFormat.parse(beginDate));			
		}
	}
	
	public void setBeginDate(Date beginDate) {
		this.beginDate=beginDate;
	}
	

	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(String endDate) throws ParseException {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		if(endDate!=null) {
			setEndDate((Date) dateFormat.parse(endDate)); 			
		}
	}
	public void setEndDate(Date endDate) {
		this.endDate=endDate;
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
		return "BillDTO [openid=" + openid + ", detypeList=" + detypeList + ", beginDate=" + beginDate + ", endDate="
				+ endDate + ", minMoney=" + minMoney + ", maxMoney=" + maxMoney + ", rdtype=" + rdtype + ", remarks="
				+ remarks + ", orders=" + orders + "]";
	}
	
	
	
}
