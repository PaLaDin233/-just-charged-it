package xyz.zhhg.jci.model.standard.bill;

public class Order{
	private String name;
	private String order;
	
	public Order() {
		super();
	}
	public Order(String name, String order) {
		super();
		this.name = name;
		this.order = order;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "Order [name=" + name + ", order=" + order + "]";
	}
	
	
	
	
	
}