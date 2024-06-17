package wine_storekeeper_producer;

import java.util.List;



public class StoreKeeperServiceImpl implements StoreKeeperService {


	@Override
	public synchronized int  addItems(String liquorName,int quantity) {

		
		Liquor newItem = new Liquor(LiquorDataStore.itemsList.size() + 1, liquorName, quantity);
		LiquorDataStore.itemsList.add(newItem);

	return 1;		
	}


	@Override
	public  synchronized int removeItems1(String liquorName) {

		boolean invalid = true;
		int count = -1;
		for (Liquor tempItem :LiquorDataStore.itemsList) {
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
	
		for (Liquor tempItem : LiquorDataStore.itemsList) {
		
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
	public List<Liquor> listItems() {

		return LiquorDataStore.itemsList;
	}

	@Override
	public List<Liquor> listItems1() {
		// TODO Auto-generated method stub
		return null;
	
	}


}