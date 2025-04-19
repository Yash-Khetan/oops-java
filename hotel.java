import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Program started");
        ArrayList<Integer> rooms = new ArrayList<>();

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
                    while (true) {
                        System.out.println("Enter the room number:");
                        int room_number = in.nextInt();
                        in.nextLine();

                        if (!rooms.contains(room_number)) {
                            rooms.add(room_number);
                        } else {
                            System.out.println("Room already exists! Add another entry");
                        }

                        System.out.println("Do you wish to add another room (y/n)?");
                        String moreRooms = in.nextLine();
                        if (moreRooms.equalsIgnoreCase("n")) break;
                    }
                    break;

                case 2:
                    System.out.println("List of available rooms:");
                    for (int room : rooms) {
                        System.out.print(room + ", ");
                    }
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Enter the room number to be booked:");
                    int roomNumber = in.nextInt();

                    if (!rooms.contains(roomNumber)) {
                        System.out.println("Room Unavailable");
                        continue;
                    }

                    System.out.println("Room available!");
                    room booked = new room();
                    booked.setnumber(roomNumber);
                    in.nextLine(); // consume newline

                    System.out.println("Enter the type of room (single/double/delux):");
                    String type = in.nextLine();
                    booked.setprice(type); // includes confirmation inside

                    // Collect customer details
                    System.out.println("Enter your name:");
                    String name = in.nextLine();

                    System.out.println("Enter your age:");
                    int age = in.nextInt();

                    if (age < 18) {
                        System.out.println("Ineligible to book");
                        continue;
                    }

                    System.out.println("Enter your phone number:");
                    long phone = in.nextLong();

                    customer c = new customer();

                    System.out.println("Enter the number of people:");
                    int ppl = in.nextInt();

                    if (ppl > 3) {
                        System.out.println("Not more than 3 persons allowed in the room!");
                        continue;
                    }

                    System.out.println("Enter the number of adults (18+):");
                    int A = in.nextInt();
                    in.nextLine(); // consume newline

                    int B = ppl - A;

                    c.setadults(A);
                    c.setnotadults(B);
                    c.settotal(ppl);
                    c.setname(name);
                    c.setage(age);
                    c.setnumber(phone);
                    c.setr(booked);

                    c.displaydetails();
                    rooms.remove(Integer.valueOf(roomNumber));
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
    private String confirm;
    private int number;
    private boolean status;
    private String type;
    private int price;

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
    private room booked;
    private String name;
    private int age;
    private long number;
    private int adults;
    private int notadults;
    private int total;

    int gettotal() {
        return total;
    }

    void settotal(int ppl) {
        this.total = ppl;
    }

    int getadults() {
        return adults;
    }

    int getnotadults() {
        return notadults;
    }

    void setadults(int A) {
        this.adults = A;
    }

    void setnotadults(int B) {
        this.notadults = B;
    }

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
        System.out.println("Total number of people: " + total);
        System.out.println("Total number of adults: " + adults);
        System.out.println("Total number of not adults: " + notadults);
        System.out.println("Booking Confirmed: " + (booked.getstatus() ? "Yes" : "No"));
        System.out.println();
    }
}
