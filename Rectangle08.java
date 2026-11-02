import java.util.Scanner;
public class Rectangle08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows:");
        int rows = sc.nextInt();
        System.out.print("Enter the number of colums:");
        int colums = sc.nextInt();
        for (int i = 1; i <= rows; i++){
            for (int j = 1; j <= colums; j++){
            System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }
}
