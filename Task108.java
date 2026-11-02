import java.util.Scanner;

public class Task108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.print("Enter the value of n = ");
            n = sc.nextInt();
            if (n < 1) {
                System.out.println("n must be at least 1. Try again!");
            }
        } while (n < 1);

        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
                count++;
            }
            System.out.println();
        }
        System.out.println("Total numbers printed: " + count);
        sc.close();
    }
}