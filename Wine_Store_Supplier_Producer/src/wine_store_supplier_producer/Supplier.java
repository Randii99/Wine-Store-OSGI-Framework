package wine_store_supplier_producer;

public class Supplier {

	private int  liquorId;
	private String liquorName;
	private double itemPrice;
	private double discount;
	private double finalPriceinliquor;
	
	public Supplier(int liquorId, String liquorName, double itemPrice, double discount) {
		super();
		liquorId = liquorId;
		this.liquorName = liquorName;
		this.itemPrice = itemPrice;
		this.discount = discount;
		calculatefinalPriceInliquor();
		
	}
	

	public int getliquorID() {
		return liquorId;
	}

	public void setliquorID(int liquorId) {
		liquorId = liquorId;
	}


	public String getliquorName() {
		return liquorName;
	}


	public void setliquorName(String liquorName) {
		this.liquorName = liquorName;
	}


	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getFinalPriceinliquor() {
		return finalPriceinliquor;
	}

	public void setFinalPriceinliquor(double finalPriceinliquor) {
		this.finalPriceinliquor = finalPriceinliquor;
	}


	void calculatefinalPriceInliquor() {
		this.finalPriceinliquor = itemPrice * ((100.00- discount)/100.00) ;
		// TODO Auto-generated method stub
		
	}
	
	

}