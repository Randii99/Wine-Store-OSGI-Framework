package wine_store_supplier_producer;

import java.util.List;



public interface LiquorSuppierService {

	List<Supplier> listItems();


	
	
	public  int  addItems(String liquorName,double itemPrice,double itemDiscount);//Adds the new items to the item list
	public   int  updateItems(String updatedItemName,double updatedItemPrice,double updatedItemDiscount);//Updates the item details
	public   int removeItems1(String itemName);//Removes the items from the list
	public   int searchitems(String itemName);//Searches and item by name
	public   List<Supplier> listItems1();//Returns the item list







	

}
