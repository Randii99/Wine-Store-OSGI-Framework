package wine_store_manager_producer;

import java.util.List;



public interface ManagerActivaterService {

	List<Manager> listItems();
	
	public  int  addItems(int qty,int price,String model);//Adds the new items to the item list
	
	public   int removeItems1(String model);//Removes the items from the list
	
	public   int searchitems(String model);//Searches and item by name
	
	public   List<Manager> listItems1();//Returns the item list







	

}
