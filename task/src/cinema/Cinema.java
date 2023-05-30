package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();

        int totalIncome = 0;
        if (rows * seats <= 60){
            totalIncome = (rows * seats) * 10;
        }
        else {
            int firstHalf = rows / 2;
            int secondHalf = rows - firstHalf;
            int firstHalfIncome  = (firstHalf * seats) * 10;
            int secondHalfIncome = (secondHalf * seats) * 8;
            totalIncome = firstHalfIncome + secondHalfIncome;

        }
        System.out.println("Total income:");
        System.out.println("$"+totalIncome);
    }
}