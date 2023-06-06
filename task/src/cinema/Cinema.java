package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();

        showSeats(rows,seats);

        System.out.println();
        System.out.println("Enter a row number:");
        int rowNumber = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = scanner.nextInt();

        System.out.println();
        calculateSeatPrice(rows, seats,rowNumber);

        System.out.println();
        showSeats(rows,seats,rowNumber,seatNumber);

    }

    private static void calculateSeatPrice(int rows, int seats,int rowNumber){
        int price = 0;
        if (rows * seats <= 60){
            price = 10;
        } else {
            if (rowNumber <= rows/2){
                price = 10;
            }else {
                price = 8;
            }
        }
        System.out.println("Ticket price: $" +price);
    }

    private static void showSeats(int rows, int seats, int... rowAndSeatNumber) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 0; i < seats; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();

        if (rowAndSeatNumber.length ==0){
            for (int i = 0; i < rows; i++) {
                System.out.print(i+1);
                for (int j = 0; j < seats; j++) {
                    System.out.print(" S");
                }
                System.out.println();
            }
        }else {
            for (int i = 0; i < rows; i++) {
                System.out.print(i+1);
                for (int j = 0; j < seats; j++) {
                    if (i == rowAndSeatNumber[0] - 1 && j == rowAndSeatNumber[1] - 1){
                        System.out.print(" B");
                    } else {
                        System.out.print(" S");
                    }
                }
                System.out.println();
            }
        }

    }

}