package wine_storekeeper_consumer;

import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import wine_storekeeper_producer.Liquor;
import wine_storekeeper_producer.StoreKeeperService;




public class Activator implements BundleActivator {
	ServiceReference StoreKeeperServiceReference;
	Scanner input = new Scanner(System.in);

	boolean exit = false;

	@Override
	public void start(BundleContext context) throws Exception {    //Start life cycle method
		System.out.println("\n=============================================== Welcome to  Wine Store Keeper Interface =============================================== \n");
	
		StoreKeeperServiceReference = context.getServiceReference(StoreKeeperService.class.getName());
		
		@SuppressWarnings("unchecked")
		
		StoreKeeperService  StoreKeeperService = (StoreKeeperService) context.getService(StoreKeeperServiceReference);		//Instance of managerService
		
		do {
		int selection = 7;
		do {

		System.out.println("Select an option to continue... \n");
		System.out.println("");
		System.out.println("Options");
		
		System.out.println("--------------------------------------------------");
        System.out.println("           1. Add new liquor to the Wine Store");
        System.out.println("           2. Remove  an exsisiting items");
        System.out.println("           3. List Of available items in store");
        System.out.println("           4. Search  available liquor item by name");
        System.out.println("           5. Exit to store keeper Interface \n"); 
        System.out.println("--------------------------------------------------");
		
		System.out.println("Enter your option :");
		 selection = input.nextInt();
		
		 input.nextLine();
		 if(selection == 5) {
			 exit = true;
		 }
		 
		 if(selection !=1 &&  selection !=2 && selection !=3 && selection !=4 && selection!=5) {
			 System.out.println("Please enter a valid selection");
		 }
		}while(selection !=1  && selection !=2 && selection !=3 && selection !=4 && selection!=5 );
		
	
        String  backToHome = null;
		if (selection == 1) {//Handles the adding new items to the store
			do {
			System.out.println("Enter the New Liquor Item Name: ");
			String liquorName = input.nextLine();

			System.out.println("Enter the stock quantity: ");
			int quantity = input.nextInt();
			
			input.nextLine();
			
			
			int result =StoreKeeperService.addItems(liquorName, quantity);
			String msg = (result ==1) ? "*********** Successfully added the item! *********** \n" : "please enter a valid name";
			System.out.println(msg);
			System.out.println("Press 0 to navigate back to home or press any other key to continue...");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if (selection == 2) {//Handles the removing an existing item in the store
			do {
			System.out.println("Enter the item name you need to remove:");

			String liquorName = input.nextLine();
			int result =StoreKeeperService.removeItems1(liquorName);
			   String msg = (result ==1) ? "*********** Successfully Removed the item!*********** \n" :"please enter a valid name";
			   System.out.println(msg);
              System.out.println("Press 0 to navigate back to home or press any other key to continue...");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if(selection == 3) {//Handles displaying all items in the store
			do {
				List<Liquor> itemsList =StoreKeeperService.listItems();//Consumes the ManagerService listItems()
				System.out.println("=================Liquor Items in the store================");

				System.out.println("Item ID:"+"\t"+"Item Name:"+"\t"+"quantity:"+"\t" );
				
			for(Liquor tempItem: itemsList ) {
				System.out.println(tempItem.getliquorID()+"\t\t"+tempItem.getliquorName()+"\t\t"+tempItem.getQuantity()+"\t ");
								
			}
			System.out.println("===================================================");
            System.out.println("Press 0 to navigate back to home or press any other key to continue....");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if(selection == 4) {//Handles the searching process of an existing item in the store
			do {
			
			System.out.println("Enter the liquor item name you need to search");
			

			String liquorName = input.nextLine();
			int result =StoreKeeperService.searchitems(liquorName);
			 String msg = (result ==1) ? "Item found!" :"Item not found!";
			   System.out.println(msg);
			
			System.out.println("Press 0 to navigate back to home or press any other key to continue...");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));
		}
		else if(selection == 5) { //Exits form the consumer program
			return;
		}
	}while(!exit);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {//stop life cycle method
		System.out.println("============Wine Store Keeper Consumer Stopped.============");
		context.ungetService(StoreKeeperServiceReference);
	}

}