import java.util.*;

public class stock {
    int id;
    String name;
    int quantity;
    float price;

    public stock(int id, String name, int quantity, float price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public static void des() {
        for (int i = 0; i < 100; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void des1() {
        for (int i = 0; i < 100; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void addstocks(ArrayList<stock> stocklist) {
        boolean flag = true;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the name of the item: ");
        String name1 = scan.nextLine();
        System.out.print("Enter the id of the item: ");
        int id1 = scan.nextInt();
        System.out.print("Enter the quantity of the item: ");
        int quan1 = scan.nextInt();
        System.out.print("Enter the price of the item: ");
        float price1 = scan.nextFloat();
        des1();

        for (stock item : stocklist) {
            if (item.id == id1) {
                flag = false;
                break;
            }
        }
        if (flag) {
            stocklist.add(new stock(id1, name1, quan1, price1));
            System.out.println("Item has been added successfully");
            des();
        }
        else {
            System.out.println("The id already exists.");
            des();
        }
        
    }

    public static void deletestocks(ArrayList<stock> stocklist) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the id of the stock to delete: ");
        int id1 = scan.nextInt();

        boolean found = false;
        for (int i = 0; i < stocklist.size(); i++) {
            if (stocklist.get(i).id == id1) {
                stocklist.remove(i);
                System.out.println("The stock has been removed successfully.");
                des();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("ID not found.");
            des();
        }
    }

    public static void displaystocks(ArrayList<stock> stocklist) {
        des1();
        System.out.printf("| %-5s | %-20s | %-10s | %-10s |\n", "ID", "NAME", "QUANTITY", "PRICE");
        des1();
        for (stock item : stocklist) {
            System.out.printf("| %-5d | %-20s | %-10d | %-10.2f |\n",item.id, item.name, item.quantity, item.price);
        }
        des1();
        System.out.println();
        des();
    }
    

    public static void editstocks(ArrayList<stock> stocklist) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the id of the stock you want to edit: ");
        int id1 = scan.nextInt();
        des1();
        for (stock item : stocklist) {
            if (item.id == id1) {
                while (true) {
                    System.out.print("1.Name\n2.Quantity\n3.Price\nEnter your choice: ");
                    int ch = scan.nextInt();
                    scan.nextLine();
                    des();
                    if (ch == 1) {
                        System.out.print("Enter the new name of the product: ");
                        String name1 = scan.nextLine();
                        item.name = name1;
                        System.out.println("Sucessfully updated");
                        break;
                    } 
                    else if (ch == 2) {
                        System.out.print("Enter the new quantity of the product: ");
                        int quan1 = scan.nextInt();
                        item.quantity = quan1;
                        System.out.println("Sucessfully updated");
                        break;
                    } 
                    else if (ch == 3) {
                        System.out.print("Enter the new price of the product: ");
                        float price1 = scan.nextFloat();
                        item.price = price1;
                        System.out.println("Sucessfully updated");
                        break;
                    } 
                    else {
                        System.out.println("INVALID CHOICE");
                    }
                }
            }
        }
        des1();
        des();
    }

    public static void billgenerator(ArrayList<stock> stocklist) {
        des1();
        System.out.println("Generating a bill");
        des1();
    
        ArrayList<stock> bill = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        float totalCost = 0;
    
        while (true) {
            System.out.print("Enter the id of the product you want to buy: ");
            int ids = scan.nextInt();
    
            stock member = null;
            for (stock item : stocklist) {
                if (item.id == ids) {
                    member = item;
                    break;
                }
            }
    
            if (member != null) {
                System.out.print("Enter the number of " + member.name + " you want to buy: ");
                int n = scan.nextInt();
                if (n > member.quantity) {
                    System.out.println("Insufficient stock.");
                    des1();
                } else {
                    float cost = n * member.price;
                    totalCost += cost;
                    bill.add(new stock(member.id, member.name, n, member.price));
                    member.quantity -= n;
                    System.out.println(n + " " + member.name + "(s) added to the bill. Subtotal: " + cost);
                    des1();
                }
            } 
            else {
                System.out.println("The id was not found.");
                des1();
            }
    
            System.out.print("Do you want to continue (1.Yes/2.No): ");
            int ch = scan.nextInt();
            if (ch != 1) {
                break;
            }
            des();
        }
    
        // Final Bill Display
        if (!bill.isEmpty()) {
            des();
            System.out.println("\t\tFINAL BILL");
            des1();
            System.out.printf("| %-5s | %-20s | %-10s | %-10s |\n", "ID", "NAME", "QUANTITY", "PRICE");
            des1();
            for (stock item : bill) {
                System.out.printf("| %-5d | %-20s | %-10d | %-10.2f |\n", item.id, item.name, item.quantity, item.price);
            }
            des1();
            System.out.printf("Total Cost: %.2f\n", totalCost);
            des();
        }
        else 
        {
            System.out.println("No items purchased.");
        }
    }
    

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<stock> stocklist = new ArrayList<>();

        stocklist.add(new stock(1, "Apple", 50, 50.0f));
        stocklist.add(new stock(2, "Banana", 100, 20.0f));
        stocklist.add(new stock(3, "Orange", 75, 60.0f));
        stocklist.add(new stock(4, "Milk", 30, 40.0f));
        stocklist.add(new stock(5, "Bread", 20, 30.0f));
        stocklist.add(new stock(6, "Eggs", 60, 70.0f));
        stocklist.add(new stock(7, "Rice", 40, 100.0f));
        stocklist.add(new stock(8, "Pasta", 25, 90.0f));
        stocklist.add(new stock(9, "Chicken", 15, 200.0f));
        stocklist.add(new stock(10, "Fish", 10, 250.0f));
        stocklist.add(new stock(11, "Sugar", 50, 30.0f));
        stocklist.add(new stock(12, "Salt", 100, 10.0f));
        stocklist.add(new stock(13, "Flour", 75, 50.0f));
        stocklist.add(new stock(14, "Butter", 20, 60.0f));
        stocklist.add(new stock(15, "Cheese", 30, 120.0f));
        stocklist.add(new stock(16, "Yogurt", 25, 40.0f));
        stocklist.add(new stock(17, "Tomato", 50, 20.0f));
        stocklist.add(new stock(18, "Potato", 100, 15.0f));
        stocklist.add(new stock(19, "Onion", 75, 20.0f));
        stocklist.add(new stock(20, "Carrot", 60, 30.0f));
        stocklist.add(new stock(21, "Lettuce", 40, 50.0f));
        stocklist.add(new stock(22, "Cucumber", 30, 25.0f));
        stocklist.add(new stock(23, "Peppers", 25, 70.0f));
        stocklist.add(new stock(24, "Spinach", 20, 40.0f));
        stocklist.add(new stock(25, "Garlic", 15, 60.0f));
        stocklist.add(new stock(26, "Ginger", 20, 50.0f));
        stocklist.add(new stock(27, "Tea", 40, 120.0f));
        stocklist.add(new stock(28, "Coffee", 30, 150.0f));
        stocklist.add(new stock(29, "Juice", 25, 80.0f));
        stocklist.add(new stock(30, "Soda", 50, 30.0f));
        stocklist.add(new stock(31, "Chocolate", 60, 40.0f));
        stocklist.add(new stock(32, "Candy", 75, 20.0f));
        stocklist.add(new stock(33, "Cookies", 40, 60.0f));
        stocklist.add(new stock(34, "Cake", 20, 300.0f));
        stocklist.add(new stock(35, "Ice Cream", 30, 100.0f));
        stocklist.add(new stock(36, "Chips", 25, 50.0f));
        stocklist.add(new stock(37, "Biscuits", 40, 40.0f));
        stocklist.add(new stock(38, "Pickles", 30, 70.0f));
        stocklist.add(new stock(39, "Honey", 20, 150.0f));
        stocklist.add(new stock(40, "Jam", 25, 80.0f));
        stocklist.add(new stock(41, "Peanut Butter", 30, 200.0f));
        stocklist.add(new stock(42, "Oil", 20, 180.0f));
        stocklist.add(new stock(43, "Vinegar", 25, 60.0f));
        stocklist.add(new stock(44, "Ketchup", 30, 50.0f));
        stocklist.add(new stock(45, "Mayonnaise", 20, 100.0f));
        stocklist.add(new stock(46, "Detergent", 50, 150.0f));
        stocklist.add(new stock(47, "Soap", 100, 40.0f));
        stocklist.add(new stock(48, "Shampoo", 75, 120.0f));
        stocklist.add(new stock(49, "Toothpaste", 50, 70.0f));
        stocklist.add(new stock(50, "Handwash", 30, 80.0f));
        stocklist.add(new stock(51, "Mango", 40, 50.0f));
        stocklist.add(new stock(52, "Pineapple", 20, 100.0f));
        stocklist.add(new stock(53, "Guava", 25, 40.0f));
        stocklist.add(new stock(54, "Strawberries", 30, 200.0f));
        stocklist.add(new stock(55, "Blueberries", 20, 250.0f));
        stocklist.add(new stock(56, "Raisins", 30, 180.0f));
        stocklist.add(new stock(57, "Cashew", 25, 500.0f));
        stocklist.add(new stock(58, "Almonds", 20, 600.0f));
        stocklist.add(new stock(59, "Walnuts", 30, 450.0f));
        stocklist.add(new stock(60, "Pistachios", 25, 550.0f));
        stocklist.add(new stock(61, "Paneer", 40, 120.0f));
        stocklist.add(new stock(62, "Tofu", 30, 100.0f));
        stocklist.add(new stock(63, "Basmati Rice", 25, 200.0f));
        stocklist.add(new stock(64, "Brown Rice", 20, 250.0f));
        stocklist.add(new stock(65, "Lentils", 40, 150.0f));
        stocklist.add(new stock(66, "Chickpeas", 30, 140.0f));
        stocklist.add(new stock(67, "Kidney Beans", 25, 160.0f));
        stocklist.add(new stock(68, "Green Peas", 40, 80.0f));
        stocklist.add(new stock(69, "Corn", 30, 70.0f));
        stocklist.add(new stock(70, "Oats", 50, 90.0f));
        stocklist.add(new stock(71, "Cereal", 25, 150.0f));
        stocklist.add(new stock(72, "Energy Bars", 30, 100.0f));
        stocklist.add(new stock(73, "Ice Cubes", 20, 20.0f));
        stocklist.add(new stock(74, "Mineral Water", 50, 20.0f));
        stocklist.add(new stock(75, "Soy Milk", 30, 70.0f));
        stocklist.add(new stock(76, "Almond Milk", 25, 200.0f));
        stocklist.add(new stock(77, "Coconut Water", 30, 40.0f));
        stocklist.add(new stock(78, "Lassi", 40, 30.0f));
        stocklist.add(new stock(79, "Buttermilk", 50, 20.0f));
        stocklist.add(new stock(80, "Pizza", 20, 500.0f));
        stocklist.add(new stock(81, "Burger", 30, 150.0f));
        stocklist.add(new stock(82, "Fries", 25, 70.0f));
        stocklist.add(new stock(83, "Pav Bhaji", 20, 100.0f));
        stocklist.add(new stock(84, "Dosa Batter", 25, 50.0f));
        stocklist.add(new stock(85, "Idli Batter", 20, 40.0f));
        stocklist.add(new stock(86, "Curry Leaves", 30, 30.0f));
        stocklist.add(new stock(87, "Coriander", 40, 20.0f));
        stocklist.add(new stock(88, "Chilli Powder", 25, 60.0f));
        stocklist.add(new stock(89, "Turmeric", 30, 40.0f));
        stocklist.add(new stock(90, "Cumin Seeds", 40, 50.0f));
        stocklist.add(new stock(91, "Black Pepper", 20, 100.0f));
        stocklist.add(new stock(92, "Cardamom", 15, 200.0f));
        stocklist.add(new stock(93, "Cloves", 20, 300.0f));
        stocklist.add(new stock(94, "Cinnamon", 30, 150.0f));
        stocklist.add(new stock(95, "Bay Leaves", 40, 70.0f));
        stocklist.add(new stock(96, "Mustard Seeds", 50, 50.0f));
        stocklist.add(new stock(97, "Fenugreek Seeds", 30, 40.0f));
        stocklist.add(new stock(98, "Asafoetida", 20, 200.0f));
        stocklist.add(new stock(99, "Saffron", 10, 500.0f));
        stocklist.add(new stock(100, "Dry Fruits Mix", 20, 800.0f));
        des();
        des1();
        System.out.println("\t\t\t|\tGROCERY STORE MANAGEMENT\t|");
        des1();
        des();
        displaystocks(stocklist);
        while (true) {
            System.out.println("1.ADD STOCKS\n2.DELETE STOCKS\n3.DISPLAY STOCKS\n4.GENERATE BILL\n5.EDIT STOCKS\n6.EXIT");
            des();
            System.out.print("Enter your choice: ");
            int ch = scan.nextInt();
            des();
            switch (ch) {
                case 1:
                    addstocks(stocklist);
                    break;
                case 2:
                    deletestocks(stocklist);
                    break;
                case 3:
                    displaystocks(stocklist);
                    break;
                case 4:
                    billgenerator(stocklist);
                    break;
                case 5:
                    editstocks(stocklist);
                    break;
                case 6:
                    System.out.println("EXITING ...");
                    des();
                    scan.close();
                    return;
                default:
                    des1();
                    System.out.println("INVALID CHOICE");
                    des1();
            }
        }
    }
}