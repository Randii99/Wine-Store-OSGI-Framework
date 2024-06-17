package wine_store_supplier_producer;

import java.util.List;



public class LiquorSuppierServiceImpl implements LiquorSuppierService {


	@Override
	public synchronized int  addItems(String liquorName,double itemPrice,double discount) {

		Supplier newItem = new Supplier(LiquorDataStore.itemsList.size() + 1, liquorName, itemPrice, discount);
		LiquorDataStore.itemsList.add(newItem);

	return 1;		
	}

	@Override
	public  synchronized int updateItems(String updatedItemName,double updatedItemPrice,double updatedItemDiscount) {
		Supplier itemToBeUpdated = null;
		boolean invalid = true;
		int count = -1;
		for (Supplier tempItem : LiquorDataStore.itemsList) {
			count++;
			if (tempItem.getliquorName().equalsIgnoreCase(updatedItemName)) {

				itemToBeUpdated = tempItem;
				invalid = false;
				break;
			}
		
		}
		if (!invalid) {

			itemToBeUpdated.setliquorName(updatedItemName);
			itemToBeUpdated.setItemPrice(updatedItemPrice);
			itemToBeUpdated.setDiscount(updatedItemDiscount);
			itemToBeUpdated.calculatefinalPriceInliquor();

			LiquorDataStore.itemsList.set(count, itemToBeUpdated);
			return 1;

		} else {
			return -1;
		}
				
	}

	@Override
	public  synchronized int removeItems1(String liquorName) {

		boolean invalid = true;
		int count = -1;
		for (Supplier tempItem :LiquorDataStore.itemsList) {
			count++;
			if (tempItem.getliquorName().equalsIgnoreCase(liquorName)) {
			
				invalid = false;
				break;
			}
		}
		if (!invalid) {

			LiquorDataStore.itemsList.remove(count);
			return 1;

		} else {
			return -1;
		}
	}

	@Override
	public int searchitems(String liquorName) {
		boolean valid = false;
	
		for (Supplier tempItem : LiquorDataStore.itemsList) {
		
			if (tempItem.getliquorName().equalsIgnoreCase(liquorName)) {

				valid = true;
				break;

			}			

		}
		if(valid) {
			return 1;
			
		}
		else {
			return -1;
		}
		
	}

	@Override
	public List<Supplier> listItems() {

		return LiquorDataStore.itemsList;
	}

	@Override
	public List<Supplier> listItems1() {
		// TODO Auto-generated method stub
		return null;
	}
}