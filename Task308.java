import java.util.Scanner;

public class Task308 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numStores;
        do {
            System.out.print("Enter the number of stores: ");
            numStores = sc.nextInt();
            if (numStores < 1) {
                System.out.println("The number of stores must be at least 1. Try again!");
            }
        } while (numStores < 1);

        int grandTotal = 0;
        int mostItems = -1;
        int bestStore = 0;

        for (int s = 1; s <= numStores; s++) {
            System.out.println("Store " + s);
            int customers;
            do {
                System.out.print("  Number of customers: ");
                customers = sc.nextInt();
                if (customers < 0) {
                    System.out.println("  Cannot be negative. Try again!");
                }
            } while (customers < 0);

            int storeItems = 0;
            for (int c = 1; c <= customers; c++) {
                int items;
                do {
                    System.out.print("  Items bought by customer " + c + ": ");
                    items = sc.nextInt();
                    if (items < 0) {
                        System.out.println("  Cannot be negative. Try again!");
                    }
                } while (items < 0);
                storeItems += items;
            }

            System.out.println("Store " + s + " - customers: " + customers + ", total items: " + storeItems);
            grandTotal += storeItems;

            if (storeItems > mostItems) {
                mostItems = storeItems;
                bestStore = s;
            }
        }

        System.out.println("==============================");
        System.out.println("Total items across all stores: " + grandTotal);
        System.out.println("Store with the most items: " + bestStore);
        sc.close();
    }
}