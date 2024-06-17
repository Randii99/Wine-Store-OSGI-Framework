package wine_store_manager_producer;

import java.util.List;



public class ManagerServiceImpl implements ManagerActivaterService {


	@Override
	public synchronized int  addItems(int qty,int price,String liquorType) {

		Manager newItem = new Manager( qty, price, liquorType);
		ManagerDataStore.itemsList.add(newItem);

	return 1;		
	}


	@Override
	public  synchronized int removeItems1(String liquorType) {

		boolean invalid = true;
		int count = -1;
		for (Manager tempItem :ManagerDataStore.itemsList) {
			count++;
			if (tempItem.getliquorType().equalsIgnoreCase(liquorType)) {
			
				invalid = false;
				break;
			}
		}
		if (!invalid) {

			ManagerDataStore.itemsList.remove(count);
			return 1;

		} else {
			return -1;
		}
	}

	@Override
	public int searchitems(String liquorType) {
		boolean valid = false;
	
		for (Manager tempItem : ManagerDataStore.itemsList) {
		
			if (tempItem.getliquorType().equalsIgnoreCase(liquorType)) {

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
	public List<Manager> listItems() {

		return ManagerDataStore.itemsList;
	}

	@Override
	public List<Manager> listItems1() {
		// TODO Auto-generated method stub
		return null;
	}
}