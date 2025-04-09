import java.util.*;
interface rideable{
    void fare (int distance, int price);
}
class vehicle{
    String type;
     int price;
    vehicle(String type){
        this.type = type;
    }
    
    String gettype(){
        return type;
    }
    int getprice(){
        return price;
    }
    void setprice(int price){
        this.price = price;
    }
    void check( String type){
        if (type.equalsIgnoreCase("sedan")){
        price = 20;
        }
        else if( type.equalsIgnoreCase("mini")){
            price = 30;
            
        }
        else {
            price = 10;
        }
    }
}
class ride implements rideable{
    public void fare(int distance, int price){
        System.out.println("The total price for the ride is: "+distance * price);
    }
    
}
class user{
    String name;
    long mobile;
    String type;
    int distance;
    int fare;
    
    user(String name, long mobile){
        this.name = name;
        this.mobile = mobile;
    }
    void setriderdetails(String type, int distance, int price){
        this.type = type;
        this.distance = distance;
        this.fare = price;
    }
    void display(){
        System.out.println("Name: "+name);
        System.out.println("Mobile: "+mobile);
        System.out.println("Type of vehicle: "+type);
        System.out.println("Total price: "+distance * fare);
        
    }
}
class Main{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your name:"  );
        String name = in.nextLine();
        System.out.println("Enter the mobile number: ");
        long mobile = in.nextLong();
        in.nextLine();
        user u = new user(name, mobile);
        while (true){
            System.out.println("Enter your choice");
            System.out.println("1.Book a cab");
            System.out.println("2. Exit");
            int choice = in.nextInt();
            in.nextLine();
            
                switch(choice){
                    case 1:
                        System.out.println("Enter the type of cab: ");
                        String type = in.nextLine();
                        System.out.println("Enter the distance to be travelled(in kms)");
                        vehicle v = new vehicle(type);
                        v.check(type);
                        v.gettype();
                        v.getprice();
                        int distance = in.nextInt();
                        ride r = new ride();
                        r.fare(distance,v.getprice());
                        u.setriderdetails(type, distance, v.getprice());
                        u.display();
                        break; 
                        
                        
                    case 2:
                        System.exit(0);
                        
                        
                }
            
        }
        
    }
}
