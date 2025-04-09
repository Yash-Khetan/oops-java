import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Program started");

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Add a room");
            System.out.println("2. Show available rooms");
            System.out.println("3. Book a room");
            System.out.println("6. Exit");
            int choice = in.nextInt();
            in.nextLine(); // consume leftover newline

            switch (choice) {
                case 1:
                    // You can implement room addition here
                    System.out.println("Feature not implemented yet.");
                    break;

                case 2:
                    // You can implement a list of available rooms
                    System.out.println("Feature not implemented yet.");
                    break;

                case 3:
                    // Create a new room and book it
                    room booked = new room();

                    System.out.println("Enter the room number to be booked: ");
                    int roomNumber = in.nextInt();
                    booked.setnumber(roomNumber);
                    in.nextLine(); // consume newline

                    System.out.println("Enter the type of room you would like (single/double/delux):");
                    String type = in.nextLine();
                    booked.setprice(type); // set price and confirmation inside

                    // Collect customer details
                    System.out.println("Enter your name:");
                    String name = in.nextLine();

                    System.out.println("Enter your age:");
                    int age = in.nextInt();

                    System.out.println("Enter your phone number:");
                    long phone = in.nextLong();

                    // Create customer object and link room
                    customer c = new customer();
                    c.setname(name);
                    c.setage(age);
                    c.setnumber(phone);
                    c.setr(booked); // assign room
                    c.displaydetails(); // show all details
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

// ---------------- Room Class ----------------
class room {
    String confirm;
    int number;
    boolean status;
    String type;
    int price;

    String gettype() {
        return type;
    }

    int getprice() {
        return price;
    }

    void setprice(String type) {
        Scanner in = new Scanner(System.in);
        this.type = type;
        if (type.equalsIgnoreCase("single")) {
            this.price = 5000;
        } else if (type.equalsIgnoreCase("delux")) {
            this.price = 10000;
        } else {
            this.price = 12000;
        }

        System.out.println("Confirm the booking? (y/n)");
        this.confirm = in.nextLine();
        setstatus(confirm);
    }

    boolean getstatus() {
        return status;
    }

    void setstatus(String confirm) {
        this.status = confirm.equalsIgnoreCase("y");
    }

    int getnumber() {
        return number;
    }

    void setnumber(int number) {
        this.number = number;
    }
}

// ---------------- Customer Class ----------------
class customer {
    room booked;
    String name;
    int age;
    long number;

    void setr(room r) {
        this.booked = r;
    }

    String getname() {
        return name;
    }

    int getage() {
        return age;
    }

    long getnumber() {
        return number;
    }

    void setname(String name) {
        this.name = name;
    }

    void setage(int age) {
        this.age = age;
    }

    void setnumber(long number) {
        this.number = number;
    }

    void displaydetails() {
        System.out.println("\n=== Customer Booking Details ===");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Phone Number: " + number);
        System.out.println("Room Number: " + booked.getnumber());
        System.out.println("Room Type: " + booked.gettype());
        System.out.println("Room Price: ₹" + booked.getprice());
        System.out.println("Booking Confirmed: " + (booked.getstatus() ? "Yes" : "No"));
    }
}
