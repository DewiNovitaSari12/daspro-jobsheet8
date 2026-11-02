***
> Name : Dewi Novita Sari
> 
> NIM	: 264107020002
> 
> Class : TI-1I
* * *
<h2 style="text-align: center"> JOBSHEET 8 - LOOPS 2 </h2>

***
<br>

## 2.1 Experiment 1: Review of Loops 1 
Code:
```
import java.util.Scanner;

public class Star08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n = ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("*");
        }
        System.out.println();
        sc.close();
    }
}

```
Result (n = 3, n = 5, n = 7):
```

Enter the value of n = 3
***
Enter the value of n = 5
*****
Enter the value of n = 7
*******
```
The program prints exactly n stars: 3 stars for n = 3, 5 stars for n = 5, and 7 stars for n = 7.

<font color=E11A45><b>Question:</b></font> 
1. If the initialization `i = 1` is changed to `i = 0` without changing the condition, how many 
* characters are printed when n = 5? Explain. 
2. If the condition `i <= n` is changed to `i < n`, how many times does the loop run when 
`n = 5`? Why is the result different? 
3. Predict the output of the following code fragment when n = 9, then verify it by replacing 
the FOR loop in your program and running it. 
```
for (int i = 2; i <= n; i += 2) { 
    System.out.print(i + " "); 
} 
```
Modify this code so that it prints the **odd** positive numbers that do not exceed n. 

4. Explain why changing the increment `i++` to `i--` (with the condition still `i <= n`) makes the loop run endlessly, so that it does not stop in a reasonable time for positive n. Do not 
run that version; if it has already started running, stop the program by pressing  **Ctrl + C** in the terminal.

<font color=FF9C4C><b>Answer:</b></font>
1. 6 stars are printed. The loop now runs for i = 0, 1, 2, 3, 4, 5. That is 6 values, not 5, because the counting starts one step earlier but still stops at 5. This is a common "off by one" mistake. If we start at 0, the condition should be i < n to get exactly n stars.
2. The loop runs 4 times (i = 1, 2, 3, 4), so only 4 stars are printed. When i reaches 5, the condition 5 < 5 is false, so the loop stops before printing the fifth star. With <=, the value 5 itself is included; with <, it is not.
3. Prediction: `2 4 6 8`. `i` starts at 2 and goes up by 2 each time (`i += 2`), so it only visits even numbers. After 8, i becomes 10, which is bigger than 9, so the loop stops. When I ran the code, the output matched the prediction.
```
Enter the value of n = 9
2 4 6 8
```

To print odd numbers, only the starting value changes from 2 to 1. Adding 2 to an odd number always gives the next odd number.

```
for (int i = 1; i <= n; i += 2) {
    System.out.print(i + " ");
}
```

Result:

```
Enter the value of n = 9
1 3 5 7 9
```
4. i starts at 1 and the loop only stops when i becomes bigger than n. But i-- makes i smaller every round: 1, 0, -1, -2, and so on. A number that keeps getting smaller will never become bigger than a positive n, so the condition i <= n stays true and the loop keeps printing stars. The counter moves away from the stopping point instead of toward it. (Technically, after about 2 billion steps the int value goes past its lowest limit and wraps around to a very large number, which finally stops the loop. That takes far too long, so in practice it is an endless loop and must be stopped with Ctrl + C.)

***
## 2.2 Experiment 2: Rectangle Star Pattern (Nested FOR)

Code:

```
import java.util.Scanner;

public class Rectangle08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = sc.nextInt();

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }
}

```
Result:
```

Enter the number of rows: 3
Enter the number of columns: 6
******
******
******
```
Comparing the inputs (3, 6), (4, 2), and (1, 5): the number of rows sets the height and the number of columns sets the width. (3, 6) is a wide rectangle, (4, 2) is a tall and thin rectangle, and (1, 5) is only one line of 5 stars, the same as Experiment 1.

<font color=E11A45><b>Question:</b></font> 
1. Explain the function of the variables `i` and `j` in the program. 
2. How  many  times  are  the  outer  loop,  the  inner  loop,  and  the  statement  `print("*")` 
executed for rows = 4 and columns = 7? 
3. What happens if the bounds of the outer and inner loops are swapped (the outer loop 
uses `columns` and the inner loop uses `rows`)? Use rows = 3 and columns = 6 to explain. 
4. Explain the effect of removing `System.out.println();` after the inner loop. 
5. Modify the program so that the printed character is `#`, then commit and push the changes 
to GitHub.

<font color=FF9C4C><b>Answer:</b></font>
1. `i` is the counter of the outer loop. It counts the rows (lines) and goes from 1 to rows. j is the counter of the inner loop. It counts the columns (stars in one line) and goes from 1 to columns, starting again from 1 at every new row. Think of a cupboard with shelves: i picks which shelf we are on, and j moves along the boxes on that shelf.
2. The rows = 4 and columns = 7, how many times are the outer loop, the inner loop and `print("*")` executed?
- Outer loop: runs 4 times, once for each row.
- Inner loop: is started 4 times, and each time its body runs 7 times, so 4 × 7 = 28 times in total.
- print("*"): runs 28 times, because it is inside the inner loop (rows × columns).
  
3. The rectangle turns sideways. The outer loop now runs 6 times (6 lines) and the inner loop prints 3 stars each time, so we get 6 rows of 3 stars instead of 3 rows of 6 stars. The total number of stars is still 18, but the shape is wrong, because the outer loop always decides the number of lines.
```
***
***
***
***
***
***
```
The total number of stars is stilll 18, but the shape is wrong, because the outer loop always decides the number of lines.
4. Without it, the cursor never moves to a new line, so all the stars are printed side by side on one long line. For rows = 3 and columns = 6, the output becomes 18 stars in one line `(******************)` instead of a rectangle. The `println()` is what "breaks" the line at the end of each row.
5. Only the character inside print changes from "*" to "#":
```
import java.util.Scanner;

public class Rectangle08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = sc.nextInt();

```
```
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
        sc.close();
    }
}`
```
Result:
```

Enter the number of rows: 3
Enter the number of columns: 6
######
######
######

```
***
## 2.3 Experiment 3: Debugging a Star Triangle – Nested WHILE 

<font color=E11A45><b>Question:</b></font> 
1. Identify the mismatches in the initial output, and at least two fixes needed to produce a nested triangle pattern. 
2. Explain the roles of the variables `i` and `j`. Why must the value of `j` be reset to 0 in every 
iteration of the outer loop? What happens if `j` is not reset? 
3. Explain the changes to the initialization, the condition, and the update of the outer loop 
that are needed to form the inverted triangle.
<font color=FF9C4C><b>Answer:</b></font>
Result of the starter code:
```

Enter the value of n = 3
******
Enter the value of n = 5
***************

```
The target is a triangle (1, 2, 3, ... stars on separate lines), but the starter code prints all the stars on one line: 6 stars for n = 3 and 15 stars for n = 5.
```

Result with the debug line, n = 5:

[i=0] [i=1] *[i=2] **[i=3] ***[i=4] ****[i=5] *****

```
a. The outer loop runs 6 times (i = 0 to 5). This is not the same as the target, which needs 5 rows.

b. When `i = 0`, no stars are printed, because the inner condition `j < i` becomes `0 < 0`, which is false right away.

c. Everything is on one line because there is no `System.out.println();` after the inner loop. Nothing tells the program to move to the next line.

Fixing step by step:

a. After adding `System.out.println();` after the inner loop, the stars appear on separate lines, but the first line is still empty. The round with `i = 0` prints no stars, only a line break.

b. Changing the outer loop's start from `int i = 0`; to `int i = 1`; (condition stays `i <= n`) makes the loop run exactly n times, from 1 to n. The empty line is gone.

Code after fixing, with the inverted triangle added (debug line removed):
``` 
import java.util.Scanner;

public class Triangle08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n = ");
        int n = sc.nextInt();

        // Triangle
        int i = 1;
        while (i <= n) {
            int j = 0;
            while (j < i) {
                System.out.print("*");
                j++;
            }
            System.out.println();
            i++;
        }```

        ```
        // Inverted triangle
        i = n;
        while (i >= 1) {
            int j = 0;
            while (j < i) {
                System.out.print("*");
                j++;
            }
            System.out.println();
            i--;
        }
        sc.close();
    }
}
```
 
Result:

Enter the value of n = 5
```
*
**
***
****
*****
*****
****
***
**
*
```
1. Identify the mismatches in the initial output and at least two fixes.
Mismatches:
• All the stars are on one line instead of forming rows.
• The outer loop runs n + 1 times (i = 0 to n), and the first round (i = 0) prints nothing. With a line break added, this shows up as an extra empty line.
Fixes:
- Add `System.out.println();` after the inner loop, before `i++`, so each row ends with a new line.
- Start the outer loop at `i = 1` instead of `i = 0`, so it runs exactly n times and the first row has 1 star.
(Another correct option for fix 2 is to keep `i = 0`, change the condition to `i < n`, and change the inner condition to `j <= i`.)
2. Explain the roles of `i` and `j`. Why must `j` be reset to 0 in every outer round? What if it is not?
• `i` is the row number. It also tells how many stars that row should have (row 3 has 3 stars).
•` j` counts the stars printed in the current row. The inner loop keeps printing until `j` reaches `i`.
`j` must start from 0 at every new row because each row counts its stars from the beginning. If `j` is not reset (for example, declared once before the outer loop), it keeps the value from the previous row. After row 1, `j` is already 1; in row 2 it only needs one more step to reach 2, so it prints just 1 star. The same happens in every row, so the output becomes one star per line (a straight vertical line) instead of a triangle.
3. - Initialization i =1 (normal triangle), i =n (inverted triangle) because the first row now has the most stars (n)
  - Condition i <= n (normal triangle), i >= 1 (inverted triangle) keep going while there is at least 1 star to print.
  - Update i++ (normal triangle), i-- (inverted triangle) each row has one star fewer than the row above.

The inner loop does not change. It still prints i stars, but now i goes down (5, 4, 3, 2, 1) instead of up. i = n; is written without int because i was already declared for the first triangle.
***
## 2.4 Experiment 4: Case Study of Group Project Scores 

<font color=E11A45><b>Question:</b></font> 
1. Why must `totalScore` be reset inside the outer loop, but `highestAverage` must not 
be reset for each group?
2. For 3 groups and 2 graders (without any invalid input), how many times is the body of the 
FOR loop executed in total? 
3. What happens if `totalScore` is declared as `int` and the average i[Programming Fundamentals - 6st WEEK ](../undefined)s calculated using 
integer division? Give an example of values. 
4. Why is `highestAverage` given the initial value -1 rather than 0? Give an example of 
input that produces a wrong result if the initial value were 0. 
5. This program has three levels of loops. Name each type of loop and its role.
   
<font color=FF9C4C><b>Answer:</b></font>
1. `totalScore` holds the scores of one group only. Each group needs to start counting from 0, or the scores of the previous groups would be added in and its average would be far too high. For example, Group 2 would get (80 + 90 + 75 + 85) / 2 = 165 instead of 80.
`highestAverage` has to remember the best result across all groups. If it were reset for every group, the program would forget the earlier record, and the last group would always look like the best one.
2. 6 times. The FOR loop runs 2 times (once per grader) for each group, and there are 3 groups: 3 × 2 = 6.
3. When an `int` is divided by an `int`, Java throws away the decimal part. The average is cut down to a whole number, so it can be wrong.
Example: Grader 1 gives 80 and Grader 2 gives 85. The total is 165. The real average is 165 / 2 = 82.5, but integer division gives 82. This can even pick the wrong best group: a group with 82.5 and a group with 82.0 would both show 82, and the program could not tell that the first one is higher.
4. A group's average can be as low as 0 (all graders give 0). The starting value must be lower than any possible average, so the first group is always recorded. -1 is safe because no score can be negative.
Example with a starting value of 0: 1 group, 2 graders, both give a score of 0. The average is 0.0, and `0.0 > 0` is false, so the IF block never runs. The program then prints Best group: 0, a group that does not exist. With -1, `0.0 > -1` is true, so it correctly prints Best group: 1.
5. Name each of the three loops and its role.
- Outer(while): Goes through the groups one by one (Group 1, 2, 3, ...).
- Middle(for): Goes through the graders of the current group and adds each score to totalScore.
- Inner(do-while): Asks for the same score again while it is outside 0–100. It runs at least once because the score must be entered before it can be checked.
***
## Assignment
<font color=9564DD><b>Task:</b></font>
1. Assignment 1: Nested Number Pattern 
Write a program that prints a number pattern from 1 up to the row number. Enter an integer 
n (n is at least 1). The first row prints 1, the second row prints 1 2, and so on up to row n. After 
the pattern is complete, display the total number of digits that have been printed. Save the 
file with the name: Task1StudentNo.java. 
For n = 5: 
```
Enter the value of n = 5 
1 
1 2 
1 2 3 
1 2 3 4 
1 2 3 4 5 
Total numbers printed: 15 
```
2. Assignment 2: Multiplication Table 
Write a program that displays a multiplication table of size n × n using nested FOR or WHILE 
loops. The value of n is at least 3. Each position displays the product of its row number and 
column number. Arrange the spacing so that the output is neat, then display the sum of all 
the numbers in the table. Save the program with the file name: Task2StudentNo.java. 
For n = 4: 
```
Enter the value of n = 4 
   1   2   3   4 
   2   4   6   8 
   3   6   9  12 
   4   8  12  16 
Total of all numbers: 100 
```
 
>Hint: to align the numbers to the right, use System.out.printf("%4d", result);, which prints 
a number with a width of 4 characters, or use the tab character "\t" as a separator.

3. Assignment 3: Sales Recap for Several Stores 
A shopping center has several stores. Each store serves a number of customers on the same day, and each customer buys several items. The program asks for the number of stores, then the number of customers at each store, and the number of items bought by each customer. 
Calculate and display the total number of customers and the total number of items for each 
store, the total number of items across all stores, and the number of the store with the most 
items. If several stores share the highest value, display the store with the smallest number. 
Save the program with the file name: Task3StudentNo.java. 
Requirements: the number of stores is at least 1. The number of customers and the number 
of items per customer may be 0, but must not be negative. Use nested loops. The data does 
not need to be stored one by one; it is sufficient to accumulate it into the total variables. 
Example: Store 1 has 2 customers who bought 3 and 2 items; Store 2 has 3 customers who 
bought 1, 4, and 2 items. The expected summary is: 
```
Store 1 - customers: 2, total items: 5 
Store 2 - customers: 3, total items: 7 
Total items across all stores: 12 
Store with the most items: 2 
```
<font color=427AB5><b>Code: </b></font> 
1. Assignment 1: Nested Number Pattern 
```
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

```
Output
```Enter the value of n = 0
n must be at least 1. Try again!
Enter the value of n = 5
1 
1 2 
1 2 3 
1 2 3 4 
1 2 3 4 5 
Total numbers printed: 15```
2. Assignment 2: Multiplication Table 
```
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
```
Output:
```
Enter the value of n = 4
   1   2   3   4
   2   4   6   8
   3   6   9  12
   4   8  12  16
Total of all numbers: 100
```
3. Assignment 3: Sales Recap for Several Stores
```
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
```
```
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


```
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
```

Output:
```
Enter the number of stores: 2
Store 1
  Number of customers: 2
  Items bought by customer 1: 3
  Items bought by customer 2: 2
Store 1 - customers: 2, total items: 5
Store 2
  Number of customers: 3
  Items bought by customer 1: 1
  Items bought by customer 2: -4
  Cannot be negative. Try again!
  Items bought by customer 2: 4
  Items bought by customer 3: 2
Store 2 - customers: 3, total items: 7
==============================
Total items across all stores: 12
Store with the most items: 2

```