package Kitchen;
import Waiter.*;
import java.util.*;
import java.util.Stack;
import java.lang.Thread;

class cookTime implements Runnable{                // MULTI THREADING


    @Override
    public void run() {
        System.out.println ("Your Food is getting cooked!!\nThread " + 
                                Thread.currentThread().getId() + 
                                " is running"); 

    }
    
}

class Kitchen implements foodMenu,searchMenu{

    public Stack checkItem(Queue<FoodItem> OrderQueue){
        Queue<FoodItem> Available = new LinkedList<>();
        Stack<FoodItem> Unavailable = new Stack<>();

        for(int i = 0;i<=OrderQueue.size();i++){
            if(foodMenu.containsKey(FoodItem.ItemName)){
                FoodItem AF = new FoodItem(FoodItem.ItemName, FoodItem.Quantity);
                Available.add(AF);
            }

            else{
                FoodItem UAF = new FoodItem(FoodItem.ItemName);
                Unavailable.push(UAF);
            }
        }

        return Unavailable;
        
    }

    public Queue cookedItems(Queue<FoodItem> Available){

        for(int i=0;i<=4;i++){
            Thread object = new Thread(new cookTime()); 
            object.start(); 
        }

        System.out.println("\n\nFood Prepared!!");
        return Available;
    }
    
}