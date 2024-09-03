import java.util.Scanner;

class ShoppingCart {
    // Constants
    private static final int MAX_ITEMS = 100;
    
    // Cart items and their quantities
    private String[] items = new String[MAX_ITEMS];
    private int[] quantities = new int[MAX_ITEMS];
    private int itemCount = 0;
    
    // Method to add an item to the cart
    public void addItem(String item, int quantity) {
        if (itemCount < MAX_ITEMS) {
            items[itemCount] = item;
            quantities[itemCount] = quantity;
            itemCount++;
            System.out.println("Item added: " + item + ", Quantity: " + quantity);
        } else {
            System.out.println("Cart is full!");
        }
    }
    
    // Method to remove an item from the cart
    public void removeItem(String item) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].equals(item)) {
                // Shift items to remove the item
                for (int j = i; j < itemCount - 1; j++) {
                    items[j] = items[j + 1];
                    quantities[j] = quantities[j + 1];
                }
                itemCount--;
                System.out.println("Item removed: " + item);
                return;
            }
        }
        System.out.println("Item not found: " + item);
    }
    
    // Method to view items in the cart
    public void viewItems() {
        if (itemCount == 0) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.println("Items in cart:");
        for (int i = 0; i < itemCount; i++) {
            System.out.println(items[i] + " - Quantity: " + quantities[i]);
        }
    }
    
    // Method to calculate total cost (assuming fixed price per item for simplicity)
    public void calculateTotalCost() {
        int totalCost = itemCount * 10; // Assuming each item costs 10 units
        System.out.println("Total cost: " + totalCost);
    }
    
    // Method to apply a discount
    public void applyDiscount(double discountPercentage) {
        int totalCost = itemCount * 10;
        double discount = totalCost * (discountPercentage / 100);
        double finalCost = totalCost - discount;
        System.out.println("Discount applied: " + discountPercentage + "%");
        System.out.println("Final cost after discount: " + finalCost);
    }
}

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);
        String command;
        
        while (true) {
            System.out.println("\nCommands: add, remove, view, total, discount, exit");
            System.out.print("Enter command: ");
            command = scanner.nextLine();
            
            if (command.equals("exit")) {
                break;
            }
            
            switch (command) {
                case "add":
                    System.out.print("Enter item name: ");
                    String addItem = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    cart.addItem(addItem, quantity);
                    break;
                    
                case "remove":
                    System.out.print("Enter item name to remove: ");
                    String removeItem = scanner.nextLine();
                    cart.removeItem(removeItem);
                    break;
                    
                case "view":
                    cart.viewItems();
                    break;
                    
                case "total":
                    cart.calculateTotalCost();
                    break;
                    
                case "discount":
                    System.out.print("Enter discount percentage: ");
                    double discountPercentage = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    cart.applyDiscount(discountPercentage);
                    break;
                    
                default:
                    System.out.println("Invalid command!");
            }
        }
        
        scanner.close();
    }
}
