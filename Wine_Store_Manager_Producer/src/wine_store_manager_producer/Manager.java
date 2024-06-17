package wine_store_manager_producer;

public class Manager {

	private int  qty;
	private int price;
	private String liquorType;
	private int totalvalue;
	
	
	public Manager(int qty, int price, String liquorType) {
		super();
		this.qty=qty;
		this.price = price;
		this.liquorType = liquorType;
		caltotalValue();	
	}
	

	public int getqty() {
		return qty;
	}

	public void setqty(int qty) {
		this.qty = qty;
	}


	public int getprice() {
		return price;
	}


	public void setprice(int price) {
		this.price = price;
	}


	public String getliquorType() {
		return liquorType;
	}

	public void setliquorType(String liquorType) {
		this.liquorType = liquorType;
	}

	public int gettotal() {
		return totalvalue;
	}

	public void settotal(int totalvalue) {
		this.totalvalue = totalvalue;
	}


	void caltotalValue() {
		this.totalvalue=this.qty*this.price;
		
	}
	

}













