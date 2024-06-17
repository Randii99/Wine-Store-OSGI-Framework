package wine_store_cashier_producer;

import java.util.ArrayList;

public class WineStoreBillingServiceImpl implements WineStoreBillingService {

	
	float TotalAmount = 0;
	int StokeHaveQuantity = 10;
	
	@Override
	public float BillingService(ArrayList<String> Liquors, ArrayList<Float> Liquorprice, int LiquorQuantity,int LiquoritemID) {
		// TODO Auto-generated method stub
		
		float Liquor_Or_PartPrice = (float)Liquorprice.get(LiquoritemID-1);
		
		System.out.println(Liquors.get(LiquoritemID-1) + "  X  "+ LiquorQuantity+" = "+(Liquor_Or_PartPrice * LiquorQuantity));
		
		TotalAmount = TotalAmount + (Liquor_Or_PartPrice * LiquorQuantity);
		
		return TotalAmount;
		
	}

	@Override
	public int getLiquorStock() {
		// TODO Auto-generated method stub
		return StokeHaveQuantity;
	}
	

}
