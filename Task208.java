import java.util.Scanner;

public class Task208 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.print("Enter the value of n = ");
            n = sc.nextInt();
            if (n < 3) {
                System.out.println("n must be at least 3. Try again!");
            }
        } while (n < 3);

        int total = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int result = i * j;
                System.out.printf("%4d", result);
                total += result;
            }
            System.out.println();
        }
        System.out.println("Total of all numbers: " + total);
        sc.close();
    }
}