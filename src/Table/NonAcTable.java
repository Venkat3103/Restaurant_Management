package Table;
import java.util.*;

class NonAcTable extends Table{

    int nog;
    char Type;
    String Tname;
    String NTnum;
    float TotalBill;
    int Tnum;

    public NonAcTable(){                        //Default constructor
        Tname=" ";
        NTnum=" ";
    }

    public NonAcTable(int nog,char Type,Long PhoneNumber){        // Parameterised constructor
        super(nog,Type,PhoneNumber);
        
        }

    public NonAcTable(int TNum,Float BillAmount){
        
        this.Tnum = TNum;
        this.TotalBill=BillAmount;
        }

    public String ReturnTableName(int Tnum){

        NTnum=""+Tnum;
        Tname="N"+Tnum;
        
        return Tname;
        }

    public float AddCharge(float BillAmount){
        TotalBill=BillAmount;
        return TotalBill;
    }

    void FreeTable(int Tnum){
    
        if(Tnum/10==2)
        twos+=1;
        else if(Tnum/10==4)
        fours+=1;
        else if(Tnum/10==6)
        sixs+=1;
        else
        Tgnum+=1;
        System.out.println(" Non Ac Table Freed");

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