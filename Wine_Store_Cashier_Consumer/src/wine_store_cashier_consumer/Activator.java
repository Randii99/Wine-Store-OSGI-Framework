package wine_store_cashier_consumer;


import java.util.ArrayList;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

import wine_store_cashier_producer.WineStoreBillingService;
import wine_store_cashier_producer.WineStoreBillingServiceImpl;


public class Activator implements BundleActivator {

    private static BundleContext context = null;
    ServiceReference serviceReference;
    private ServiceTracker serviceTracker = null;
    
    boolean exit = false;
    
    static BundleContext getContext() {
        return context;
    }
    
    
    public void start(BundleContext bundleContext) throws Exception {
        Activator.context = bundleContext;
        System.out.println("Start Wine Store Consumer Service");
        serviceTracker = new ServiceTracker(context, context.createFilter("(&(objectClass="+WineStoreBillingService.class.getName()+")"+"(Language=*))"),null);
        serviceTracker.open();
        

        int LiquoritemID;
        int LiquorQuantity = 0;
        float Amount = 0;
        float discountPrice = (float) 0.10;
        float TotalPrice = 0;
        int StokeHaveQuantity = 10;
        char choicedItem;
        
        ArrayList<String> Liquors = new ArrayList<String>();
        ArrayList<Float> Liquorprice = new ArrayList<Float>();
        ArrayList<String> selectedLiquors = new ArrayList<>();
        ArrayList<Integer> selectedQuantities = new ArrayList<>();
        
        Liquors.add("Bols ");
        Liquorprice.add((float)13000.00);
        
        Liquors.add("Minke");
        Liquorprice.add((float) 27000.00); 
        
        Liquors.add("Calvet");
        Liquorprice.add((float) 12500.00);
        
        Liquors.add("Hardy");
        Liquorprice.add((float)  22000.00);
        
        Liquors.add("Bacardi");
        Liquorprice.add((float)  21000.00);
        
        Liquors.add("Panama");
        Liquorprice.add((float) 20000.00);
        
        Liquors.add("Green Moon");
        Liquorprice.add((float) 23000.00);
        
        Liquors.add("Avion");
        Liquorprice.add((float) 25000.00);
        
        Liquors.add("Jameson");
        Liquorprice.add((float) 25000.00);
        
        Liquors.add("UK Whisky");
        Liquorprice.add((float) 25500.00);
        
        Liquors.add("Bourbon ");
        Liquorprice.add((float) 24000.00);
        
        Liquors.add("Lion Beer");
        Liquorprice.add((float) 1200.00);
        
        Liquors.add("Black label");
        Liquorprice.add((float)  27200.00);
        
        Liquors.add("White label");
        Liquorprice.add((float)  5000.00);
         
         Liquors.add("Red label");
         Liquorprice.add((float) 14500.00);
        

        Scanner scanner = new Scanner(System.in);
        WineStoreBillingService LiquorBill = new WineStoreBillingServiceImpl();
        

        do {
            int selection = 3;
            do {
            
            	System.out.println("\n=============================================== Welcome to  Wine Store Cashier Interface =============================================== \n");
            	
            	System.out.println("Please Select an option to continue.....\n                ");
	            System.out.println("--------------------------------------------------");
	            System.out.println("           1. View availabe liquor in our store");
	            System.out.println("           2. Generate bill");
	            System.out.println("           3. Exit \n");
	            System.out.println("--------------------------------------------------");
	            System.out.println("Enter your selection :  ");
	            selection = scanner.nextInt();
	            scanner.nextLine();

	            if(selection == 3) {
                 exit = true;
             }
             
             if(selection !=1 &&  selection !=2 && selection !=3 ) {
                 System.out.println("Please enter a valid selection");
             }
            }while(selection !=1  && selection !=2 && selection !=3 );
            
        
            String  backToHome = null;
            if (selection == 1) {
                do {
                	System.out.println("These are available liquor items and prices");
                    System.out.println();
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("Item ID :"+"\t" +"Item Name :"+"\t"+"\t" +"Item Price :"+"\t" );
                    
                    for (int i = 0; i < Liquorprice.size(); i++)
                    {
                    	System.out.println((i + 1) + "\t          " + Liquors.get(i) + " \t        Rs: " + Liquorprice.get(i) + "\t         \n");

                    }
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.println("Press 0 to navigate to home or press any other key to continue....");
                
                backToHome=scanner.nextLine();
                
                }
                
                while(!(backToHome.equals("0")));
    
            }
            else if (selection == 2) {
                do {

                	System.out.println("These are available liquor items and prices");
                    System.out.println();
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("Item ID :"+"\t" +"Item Name :"+"\t"+"\t" +"Item Price :"+"\t" );
                    
                    for (int i = 0; i < Liquorprice.size(); i++)
                    {
                    	System.out.println((i + 1) + "\t          " + Liquors.get(i) + " \t        Rs: " + Liquorprice.get(i) + "\t         \n");
                    }
                  System.out.println("--------------------------------------------------------------------------------");
                  System.out.println();
                  do {
                      System.out.println("\n Enter the Liquor item number you need : ");
                      LiquoritemID = scanner.nextInt();
                      String selectedItemName = Liquors.get(LiquoritemID - 1); // Adjust for 0-based index
                      
                      System.out.println("Enter number of items you need : ");
                      if(LiquorQuantity > StokeHaveQuantity) {
                          System.out.println("* * * * * * * * * * * * * * * * *There is No More stock Available At This Moment* * * * * * * * * * * * * * * * *");
                      }
                      else {
                          
                      }
                      LiquorQuantity = (int) scanner.nextFloat();
                      selectedLiquors.add(selectedItemName);
                      selectedQuantities.add(LiquorQuantity);
                          
                          System.out.print("Do you want to buy Other item?  (y or n): \n ");
                          choicedItem = scanner.next().charAt(0);   
                  
                   Amount = LiquorBill.BillingService(Liquors, Liquorprice,LiquorQuantity, LiquoritemID);
                  }while(choicedItem == 'y' || choicedItem == 'Y');
                  System.out.println("=========================================");
                  
                  if(Amount >= 50000) {
                      TotalPrice = Amount - (Amount * discountPrice);
                  }
                  else {
                      
                      TotalPrice = Amount;
                  }
                    System.out.println("Here is your total bill");
					System.out.println("");
					System.out.println("=========================================");
					System.out.println("    Item Name\t\tQuantity");
					for (int i = 0; i < selectedLiquors.size(); i++) {
					    System.out.println("    " + selectedLiquors.get(i) + "\t\t" + selectedQuantities.get(i));
					}
					System.out.println("-----------------------------------------");
				if(Amount >= 50000) {
					System.out.println("    Discount\t\t: " + "10%");
					System.out.println("    Discount Price\t:" + " " +Amount * discountPrice);
				}
					System.out.println("    Amount\t\t: " + Amount);
					System.out.println("    Payble Price\t: " + TotalPrice);
					System.out.println("=========================================");                   
                
                    System.out.println("Press 0 to navigate back to home or press any other key to continue...");
                
                    backToHome=scanner.nextLine();
                    backToHome=scanner.nextLine();
                    
                }
                
                while(!(backToHome.equals("0")));
    
            }
        
            else if(selection == 3) {//Exits form the Cashier program
                return;
            }
        }while(!exit);  
}

    
    public void stop(BundleContext bundleContext) throws Exception {
        Activator.context = null;
    }

}
