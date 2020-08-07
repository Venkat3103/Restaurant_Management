package Waiter;

import java.util.*;

public class Waiter {

    int choice, OrderNumber = 0;
    String ItemName;
    int Quantity;
    float Price, totalPrice = 0;
    Scanner input = new Scanner(System.in);
    Queue<FoodItem> OrderQueue = new LinkedList<>();
    
    public float doWaiterJob() {
    do{
        System.out.print("\n\nWAITER MENU:\n1. Take Order\n2. Complete Order\n3. Place Bill\nEnter your Choice: ");
        choice = input.nextInt();
        switch(choice){
            case 1:
                System.out.println("\nEnter Order Details:-");
                System.out.print("Item Name: ");
                ItemName = input.next() + input.nextLine();
                System.out.print("Price: ");                    //Will be retreived from the Interface when Collaborating with Team Member's Modules 
                Price = input.nextFloat();   
                System.out.print("Quantity"); 
                Quantity = input.nextInt();                
                FoodItem F = new FoodItem(ItemName, Quantity);
                OrderQueue.add(F);
                OrderNumber++;
                System.out.println("\nYour Order has been Updated!");
                break;
            
            case 2:                    
                while(OrderNumber-- != 0) {
                    totalPrice += OrderQueue.peek().Price;
                    OrderQueue.remove();
                }
                break;

            case 3: 
                while(OrderNumber-- != 0) {
                    totalPrice += OrderQueue.peek().Price;
                    OrderQueue.remove();
                }
                return (totalPrice);

            default:
                System.out.println("\nWrong Choice Entered!");
                break;
        }
    }while(choice != 3);
    return (totalPrice);
    }
}
