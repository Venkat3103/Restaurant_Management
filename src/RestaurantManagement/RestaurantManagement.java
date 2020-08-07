package RestaurantManagement;

import java.util.*;

import Customer.*;
import Waiter.*;

class RestaurantManagement{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);        
        int choice = Integer.valueOf(1), flag = 0;
        String Name;
        long PhoneNumber = Integer.valueOf(0);
        float BillAmount, totalSales = 0;
        int NoOfGuests;
        int TableNo;
        int Discount;
        Stack<Float> BillHistory = new Stack<>();
        Waiter W = new Waiter();
        do{
            try{
            System.out.print("\n\nLogin/Register:\n1. Already Existing Cutomer\n2. New Customer\n3. Submit Today's Sales\nEnter your Choice: ");
            choice = input.nextInt();
            switch(choice){
                case 1:
                    System.out.println("\nEnter Customer Details:-");
                    System.out.print("Name: ");
                    Name = input.next() + input.nextLine();
                    do{
                        try {
                        System.out.print("Phone Number: ");
                        PhoneNumber = input.nextLong();
                        if(PhoneNumber < 1000000000)
                            throw new PhoneNumberIncorrectException("Entered Phone Number is not a 10 digit Phone Number");
                        else    
                            flag =1;
                        } catch(Exception E) {
                            System.out.println(E);
                            System.out.println("Please Enter Again!");
                            flag = 0;
                        }
                    }while(flag == 0);                    
                    System.out.print("Number of Guests: ");
                    NoOfGuests = input.nextInt();
                    System.out.print("Table Number: ");     //Table Number Will be Manpulated using Allocation Algorithm and Assigned in Case Study
                    TableNo = input.nextInt();                   
                    BillAmount = W.doWaiterJob();
                    PrivilegedCustomer P = new PrivilegedCustomer(Name, PhoneNumber, BillAmount, NoOfGuests, TableNo);
                    BillHistory.push(P.getBill());
                    System.out.printf("\nYour Final Bill Amount: %.2f", BillHistory.peek());
                    break;
                
                case 2:                    
                    System.out.println("\nEnter Customer Details:-");
                    System.out.print("Name: ");
                    Name = input.next() + input.nextLine();
                    do{
                    try {
                    System.out.print("Phone Number: ");
                    PhoneNumber = input.nextLong();
                    if(PhoneNumber < 1000000000)
                        throw new PhoneNumberIncorrectException("Entered Phone Number is not a 10 digit Phone Number");
                    else
                        flag = 1;
                    } catch(Exception E) {
                        System.out.println(E);
                        System.out.println("Please Enter Again!");
                        flag = 0;
                    }
                    }while(flag == 0);
                    System.out.print("Number of Guests: ");
                    NoOfGuests = input.nextInt();
                    System.out.print("Table Number: ");     //Table Number Will be Manpulated using Allocation Algorithm and Assigned in Case Study
                    TableNo = input.nextInt(); 
                    System.out.print("Discount Percentage: ");  //Discount Won't be Asked for in the Case Study
                    Discount = input.nextInt();  
                    BillAmount = W.doWaiterJob();               
                    NonPrivilegedCustomer NP = new NonPrivilegedCustomer(Name, PhoneNumber, BillAmount, NoOfGuests, TableNo, Discount);
                    BillHistory.push(NP.getBill());
                    System.out.printf("\nYour Final Bill Amount: %.2f", BillHistory.peek());
                    break;

                case 3: 
                    while(BillHistory.size() != 0) {
                        totalSales += BillHistory.pop();
                    }
                    System.out.printf("\n\n***************\nTotal Sales: %.2f\n***************", totalSales);
                    break;

                default:
                    throw new ChoiceOutOfBounds("Choice Incorrect");
            }
        }catch(Exception E) {
            System.out.println(E);
            System.out.println("Please Enter Again!");
            choice = 1;
        }
        }while(choice != 3);
    
        input.close();
    }
}
