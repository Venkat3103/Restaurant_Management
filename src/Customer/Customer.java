package Customer;

abstract class Customer implements customers {
    
    private static int NoOfCustomers;
    protected String Name;
    protected long PhoneNumber;
    protected float BillAmount;
    protected int NoOfGuests;
    protected int TableNo;

    Customer(){
        Name = "Default";
        PhoneNumber = 1111111111;
        BillAmount = 0;
        NoOfGuests = 0;
        TableNo = 0;    
    }

    Customer(String Name, long PhoneNumber, float BillAmount, int NoOfGuests, int TableNo){
        this.Name = Name;
        this.PhoneNumber = PhoneNumber;
        this.BillAmount = BillAmount;
        this.NoOfGuests = NoOfGuests;
        this.TableNo = TableNo; //This will be retrieved from the Table Case using Allocation Algorithm in the Case Study       
        NoOfCustomers += 1;         
    }

    public abstract void calcBill();

    protected int getNoOfCustomers(){
        return (NoOfCustomers);
    }

    final public long getPhoneNumber(){
        return (PhoneNumber);
    }

    public float getBill(){
        return (BillAmount);
    }
}