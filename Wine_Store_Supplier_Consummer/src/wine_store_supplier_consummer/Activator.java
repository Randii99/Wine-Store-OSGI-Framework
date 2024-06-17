package wine_store_supplier_consummer;


import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import wine_store_supplier_producer.LiquorSuppierService;
import wine_store_supplier_producer.Supplier;



public class Activator implements BundleActivator {
	ServiceReference liquorSuppierServiceReference;
	Scanner input = new Scanner(System.in);

	boolean exit = false;

	@Override
	public void start(BundleContext context) throws Exception {//Start life cycle method
		System.out.println("\n=============================================== Welcome to  Wine Store Supplier Interface =============================================== \n");
		
		
		liquorSuppierServiceReference = context.getServiceReference(LiquorSuppierService.class.getName());
		
		@SuppressWarnings("unchecked")
		
		LiquorSuppierService  liquorSuppierService = (LiquorSuppierService) context.getService(liquorSuppierServiceReference);		//Instance of managerService
		
		do {
		int selection = 7;
		do {
	
		System.out.println("Please Select an option to continue.....");
		System.out.println("");
		System.out.println("Options");
		System.out.println("--------------------------------------------------");
        System.out.println("           1. Add new liquor items to the Wine Store");
        System.out.println("           2. Remove  an exsisiting Supplied liquor");
        System.out.println("           3. List Of Supplied liquor");
        System.out.println("           4. Search  Supplied liquor by liquor name");
        System.out.println("           5. Exit to Supplier Interface"); 
        System.out.println("--------------------------------------------------");
		
		System.out.println("Enter your selection...");
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
		if (selection == 1) {//Handles the adding process of new items to the list
			do {
			System.out.println("Enter the New Liquor Name to supply: ");
			String liquorName = input.nextLine();

			System.out.println("Enter the Liquor Price: ");
			double itemPrice = input.nextDouble();

			System.out.println("Enter Discount Percentege (%): ");
			double itemDiscount = input.nextDouble();
			input.nextLine();
			
			int result =liquorSuppierService.addItems(liquorName, itemPrice, itemDiscount);//Consumes the ManagerService addItems()
			 String msg = (result ==1) ? "*********** Successfully added the item! ***********" :"please enter a valid name";
			   System.out.println(msg);
			System.out.println("Press 0 to navigate back to home or press any other key to continue....");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if (selection == 2) {//Handles the removing process of an existing item in the list 
			do {
			System.out.println("Enter the liquor name:");

			String liquorName = input.nextLine();
			int result =liquorSuppierService.removeItems1(liquorName);//Consumes the ManagerService removeItems()
			   String msg = (result ==1) ? "*********** Successfully Removed the item! ***********" :"please enter a valid name";
			   System.out.println(msg);
              System.out.println("Press 0 to navigate back to home or press any other key to continue....");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if(selection == 3) {//Handles displaying all items in the list
			do {
				List<Supplier> itemsList =liquorSuppierService.listItems();//Consumes the ManagerService listItems()
				System.out.println("-----------------------------------Supplied Liquor list--------------------------------------------");
				System.out.println("Item ID:"+"\t" +"Item Name:"+"\t" + "Item Price:"+"\t" + "Discount Percentage:"+"\t" + "Price After the Discount:"+"\t" );
				
			for(Supplier tempItem: itemsList ) {
				System.out.println(tempItem.getliquorID()+"\t\t"+tempItem.getliquorName()+"\t\t"+tempItem.getItemPrice()+"\t\t"+tempItem.getDiscount()+"%\t\t\t" +tempItem.getFinalPriceinliquor()+"\t\n");
								
			}
			System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Press 0 to navigate back to home or press any other key to continue....");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if(selection == 4) {//Handles the searching process of an existing item in the list
			do {
			
			System.out.println("Enter the liquor name");
			

			String liquorName = input.nextLine();
			int result =liquorSuppierService.searchitems(liquorName);//Consumes the ManagerService searchItems()
			 String msg = (result ==1) ? "Item found!" :"Item not found!";
			   System.out.println(msg);
			
			System.out.println("Press 0 to navigate back to home or press any other key to continue....");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));
		}
		else if(selection == 5) {//Exits form the Manager consumer program
			return;
		}
	}while(!exit);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {//stop life cycle method
		System.out.println("============Supplier liquor Shop consumer stopped.============");
		context.ungetService(liquorSuppierServiceReference);
	}

}