package Table;

abstract class Table{

    protected int sixs;
    protected int fours;
    protected int twos;
    protected int gTable;
    protected int Tfnum;
    protected int Ttnum;
    protected int Tsnum;
    protected int Tgnum;
    protected int Tnum;
    protected int nog;
    protected char Type;
    protected int ReservationId;
    private long PhoneNumber;
    
    public abstract float AddCharge(float BillAmount);
    public abstract String ReturnTableName(int Tnum);
    

 

    Table(){                        // Default constructor
        sixs = 10;      //six seater
        fours = 10;     //Four seater
        twos = 10;      //Two seater
        gTable=10;      //Group Table
        Tfnum=39;       //4_(number in '_' describes table number of 4 seater)
        Ttnum=19;
        Tsnum=59;
        Tgnum=9;        //Table Group Num
        PhoneNumber=1111111111;

        }

    public Table(int nog,char Type,long PhoneNumber){        // Parameterised constructor
        this.Type=Type;
        this.nog=nog;
        this.PhoneNumber=PhoneNumber;
        sixs = 10;      //six seater
        fours = 10;     //Four seater
        twos = 10;      //Two seater
        gTable=10;      //Group Table
        Tfnum=39;       //4_(number in '_' describes table number of 4 seater)
        Ttnum=19;
        Tsnum=59;
        Tgnum=9;        //Table Group Num
    }

    
        
        public int ReturnTableNumber( int nog,char Type){
            if(nog<=2&&twos>0)
            {   Ttnum+=1;
                twos-=1;
                Tnum=Ttnum;
                
            }
            else if(nog>2&&nog<=4&&fours>0)
            {   Tfnum+=1;
                fours-=1;
                Tnum=Tfnum;
            }
            else if(nog>4&&nog<=6&&sixs>0)
            {   Tsnum+=1;
                sixs-=1;
                Tnum=Tsnum;
            }    
            
            else {
                Tgnum+=1;
                gTable-=1;
                Tnum=Tgnum;
            }

            
            return Tnum;
            
            
        }
    
    
            void FreeTable(int Tnum){               // To be implemented by waiter
    
            if(Tnum/10==2)
            twos+=1;
            else if(Tnum/10==4)
            fours+=1;
            else if(Tnum/10==6)
            sixs+=1;
            else
            Tgnum+=1;
    
    
            
        }

        final public long getPhoneNumber(){
            return (PhoneNumber);
        }

        public int CustomerDetails(int ReservationId){
            return ReservationId;        
        }

        public String CustomerDetails(String Name){
            return Name;
        }

}

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


/*   MAIN FOR REFERENCE 

class Restaurant{

    public static void main(String[] args){
        //AcTable AT= new AcTable();
        //NonAcTable NT= new NonAcTable();       
        
        

        Scanner input=new Scanner(System.in);
        System.out.print("Enter Phone Number: ");
        long PhoneNumber = input.nextLong();
        System.out.print("Enter Name: ");
        String Name = input.next();
        System.out.print("Enter a Reservation ID: ");
        int ReservationId = input.nextInt();
        
        
        int cont=1;
        while(cont==1){
        System.out.println("\nMENU:\n1.Book Table\n2.Free Table");
        int choice=input.nextInt();

        

        if(choice==1){

        System.out.println("Booking Table:");
        System.out.print("Enter Number of guests: ");
        int nog=input.nextInt();
        System.out.print("\nEnter Type (A for AC / N for Non AC): ");        
        char Type=input.next().charAt(0);

        if(Type=='A'){
            Table A=new AcTable(nog,Type,PhoneNumber);
            int TNUM=A.ReturnTableNumber(nog,Type);
            System.out.println("Table Booked Succesfully by "+A.CustomerDetails(Name)+" using Phone Number "+A.getPhoneNumber()+" with Reservation ID "+A.CustomerDetails(ReservationId)+".");
            System.out.print("\nYour Table is: "+A.ReturnTableName(TNUM));
        }

        else if(Type=='N'){
            Table N=new NonAcTable(nog,Type,PhoneNumber);
            int TNUM=N.ReturnTableNumber(nog,Type);
            
            System.out.println("Table Booked Succesfully by "+N.CustomerDetails(Name)+" using Phone Number "+N.getPhoneNumber()+" with Reservation ID "+N.CustomerDetails(ReservationId)+".");
            System.out.print("\nYour Table is: "+N.ReturnTableName(TNUM));


        }   
        
        else
        System.out.println("Wrong Table Type!!");

        System.out.print("\nPress 1 to continue to book/free table, Press 0 to exit: ");
        cont=input.nextInt();       

    }

        else if(choice==2){

            System.out.println("Freeing Table");
            System.out.println("Enter Type of Restaurant(A for AC / N for Non AC)");
            char Type=input.next().charAt(0);
            System.out.print("Enter Table Number: ");
            int TNum=input.nextInt();
            System.out.print("Enter current bill amount: ");
            float BillAmount=input.nextFloat();

            if(Type=='A'||Type=='a'){
                AcTable A=new AcTable(TNum,BillAmount);
                System.out.println("Total Bill Amount(After Additional Charges): "+A.AddCharge(BillAmount));
                A.FreeTable(TNum);
            }

            else if(Type=='N'||Type=='n'){
                NonAcTable N=new NonAcTable(TNum,BillAmount);
                System.out.println("Total Bill Amount(After Additional Charges): "+N.AddCharge(BillAmount));
                N.FreeTable(TNum);

            }

            else{
                System.out.println("Wrong Table Type!!");
            }

            System.out.print("\nPress 1 to continue to book/free table, Press 0 to exit: ");
            cont=input.nextInt();

        }

            
        }

        
    
    }
    

}



*/