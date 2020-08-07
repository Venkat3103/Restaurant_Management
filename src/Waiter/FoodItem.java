package Waiter;

public class FoodItem {
    public static String ItemName;
    float Price;
    public static int Quantity;

    public FoodItem() {
        ItemName = "Default";
        Price = 0;
        Quantity = 0;
    }

    public FoodItem(String ItemName, float Price) {
        this.setItemName(ItemName);
        this.setPrice(Price);
    }

    public FoodItem(String ItemName, int Quantity) {
        this.setItemName(ItemName);
        this.setQuantity(Quantity);
    }

    public FoodItem(String ItemName) {
        this.setItemName(ItemName);

    }

    protected void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    protected void setPrice(float Price) {
        this.Price = Price;
    }

    protected void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    
}