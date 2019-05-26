// Mobile App for Flyers’. 

import java.util.Scanner;

enum Delivery
{
       DELIVERY_AVAILABLE,
       DELIVERY_WITH_EXTRA_COST
}
 
public class Fastfood {
 
       // Mode of delivery.
	
       // Displays type of delivery (i.e. Pickup or Delivery).
	
       @SuppressWarnings("resource")
	public static int modeMenu()
       {
             int choice;
             Scanner scan = new Scanner(System.in);
             System.out.println(" Delivery mode : ");
             System.out.println("1. Pick-Up");
             System.out.println("2. Delivery");
             System.out.print("Enter your choice(1/2) : ");
             choice = Integer.parseInt(scan.nextLine());
             while(choice<1 || choice>2)
            	 
             {
                    System.out.print("\nInvalid choice .\nEnter your choice(1/2) : ");
                    choice = Integer.parseInt(scan.nextLine());
             }
             
             return choice;
       }
      
       // Items available at Flyers'.
       
       // Displays price of the item selected.
       
       public static float itemsMenu()
       {
            
             int choice,qty;
             float price = 0;
             @SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
             System.out.println(" Items : ");
             System.out.println("1. Flyers' Burger: $4.50");
             System.out.println("2. Flyers' Drink: $1.50");
             System.out.println("3. Flyers' Fries: $2.50");
             System.out.println("4. Flyers' Desert: $3.00");
             System.out.print("Enter your choice(1-4) : ");
             choice = Integer.parseInt(scan.nextLine());
             while(choice<1 || choice>4)
            	 
             {
                    System.out.print("Invalid choice .\nEnter your choice(1-4) : ");
                    choice = Integer.parseInt(scan.nextLine());
             }
            
             System.out.print("Enter the quantity : ");
             qty = Integer.parseInt(scan.nextLine());
             switch(choice)
             {
                    case 1: price = (float)(qty * 4.5);
                                 break;
                    case 2: price = (float)(qty * 1.5);
                                 break;
                    case 3:price = (float)(qty * 2.5);
                                 break;
                    case 4:price = (float)(qty * 3);
                                 break;
             }
            
             return price;
             
       }
      
       public static void main(String[] args) {
            
             int deliveryOption;
             int shopZipCode = 60446, userZipCode;
             Delivery type =null;
             String itemsChoice = "y";
             float price = 0;
             @SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
             System.out.println("Welcome to Flyers' Restaurant ");
            
             deliveryOption = modeMenu();
             
             //Add zip code and check if delivery is available, if delivery is selected. 
             
             if(deliveryOption == 2 )
             {
                    System.out.print("Enter your zip code : ");
                    userZipCode = Integer.parseInt(scan.nextLine());
                    if(Math.abs(shopZipCode - userZipCode) < 5)
                           {
                                 System.out.println("Delivery available." );
                                 type = Delivery.DELIVERY_AVAILABLE;
                           }
                    else if(Math.abs(shopZipCode - userZipCode) == 5)
                           {
                                 System.out.println("Delivery available with extra cost." );
                                 type = Delivery.DELIVERY_WITH_EXTRA_COST;
                           }
                    else
                           {
                                 System.out.println("Delivery not available.");
                                 System.exit(0);
                           }                  
             }
            
             // This loop will take the order.
                        
             while(itemsChoice.equalsIgnoreCase("y"))
            	 
             {
            	 
                    price += itemsMenu();
                    System.out.print("Would you like to order more(y/n) ? ");
                    itemsChoice = scan.nextLine();
                    if(itemsChoice.equalsIgnoreCase("n"))
                           break;
                    
             }
             
             // Tax calculation.
             
             price += 0.05*price;
             if(deliveryOption == 2 )
            	 
             {
            	 
                    if(type == Delivery.DELIVERY_AVAILABLE)
                           price += 5;
                    else if(type == Delivery.DELIVERY_WITH_EXTRA_COST)
                           price += 7;
                    
             }
            
             // print the total bill.
             
             System.out.println(" Your total bill = $"+price+". ");
            
       }
 
}

 

