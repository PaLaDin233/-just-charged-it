package xyz.zhhg.jci.model.standard.bill.statistics;

public class Statistics {
	private double money;
	
	private String time;
	
	private String typename;
	
	private int rdtype;

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}


	@Override
	public String toString() {
		return "Statistics [money=" + money + ", time=" + time + ", typename=" + typename + ", rdtype=" + rdtype + "]";
	}

	public int getRdtype() {
		return rdtype;
	}

	public void setRdtype(int rdtype) {
		this.rdtype = rdtype;
	}
	
	
	
	
}
