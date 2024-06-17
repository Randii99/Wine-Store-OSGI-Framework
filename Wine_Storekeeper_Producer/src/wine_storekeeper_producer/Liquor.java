package wine_storekeeper_producer;

public class Liquor {

	private int  liquorId;
	private String liquorName;
	private int quantity;

	
	public Liquor(int liquorId, String liquorName, int quantity) {
		super();
		this.liquorId = liquorId;
		this.liquorName = liquorName;
		this.quantity = quantity;
	
		
	}
	

	public int getliquorID() {
		return liquorId;
	}

	public void setliquorID(int liquorId) {
		this.liquorId = liquorId;
	}


	public String getliquorName() {
		return liquorName;
	}


	public void setliquorName(String liquorName) {
		this.liquorName = liquorName;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	}
