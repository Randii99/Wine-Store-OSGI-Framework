package wine_store_cashier_producer;

import java.util.ArrayList;

public interface WineStoreBillingService {

	float BillingService(ArrayList<String> phones, ArrayList<Float> PHONEprice, int PhoneQuantity, int PhoneitemID);
	
	int getLiquorStock();

}
