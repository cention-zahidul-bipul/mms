
package bean;


public class OrderBean{

	private String vendor;
	private String item;
	private String schedule;
	private String orderDate;
	private int orderId;
	private String uName;
	
	public void setOrderId(int orderId){
		this.orderId=orderId;
	}
	
	public void setItem(String item){
		this.item=item;
	}
	public void setVendor(String vendor){
		this.vendor=vendor;
	}
	public void setSchedule(String schedule){
		this.schedule=schedule;
	}
	public void setOrderDate(String orderDate){
		this.orderDate=orderDate;
	}
	
	public void setUserName(String uName){
		this.uName=uName;
	}

	public String getVendor(){
		return this.vendor;
	}
	public String getItem(){
		return this.item;
	}
	public String getSchedule(){
		return this.schedule;
	}
	public String getOrderDate(){
		return this.orderDate;
	}
	public int getOrderId(){
		return this.orderId;
	}
	
	public String getUserName(){
		return this.uName;
	}

}