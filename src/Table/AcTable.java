package Table;
import java.util.*;

class AcTable extends Table{

    int nog;
    char Type;
    String Tname;
    String ATnum;
    float TotalBill;
    int Tnum;
    

    public AcTable(){                         //Default Constructor
        super();
        Tname=" ";
        ATnum=" ";
    }

    public AcTable(int nog,char Type,long PhoneNumber){        // Parameterised constructor
        super(nog,Type,PhoneNumber);
    }

    public AcTable(int TNum,Float BillAmount){
        
        this.Tnum = TNum;
        this.TotalBill=BillAmount;
    }
    
    public String ReturnTableName(int Tnum){

        ATnum=""+Tnum;
        Tname="A"+Tnum;

        return Tname;
    }

    public float AddCharge(float BillAmount){
        
        TotalBill+=0.05*BillAmount;
        return TotalBill;
    }

    void FreeTable(int Tnum){           //Method overriding
    
        if(Tnum/10==2)
        twos+=1;
        else if(Tnum/10==4)
        fours+=1;
        else if(Tnum/10==6)
        sixs+=1;
        else
        Tgnum+=1;
        System.out.println("Ac Table Freed");

        
    }

    public void CustomerDetails(){                                      //method Overloading
       String Name="Default";
        int ReservationId=0;
    }

    public int CustomerDetails(int ReservationId){
        return ReservationId;        
    }

    public String CustomerDetails(String Name){
        return Name;
    }

}
