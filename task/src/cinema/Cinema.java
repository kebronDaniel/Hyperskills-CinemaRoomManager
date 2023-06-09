package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        prompter();
    }

    private static void prompter() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();

        System.out.println();



        String[][] seatArrangement = new String[rows][seats];
        int[] emptySeat = new int[]{0,0};

        while (true){
            System.out.println(Arrays.deepToString(seatArrangement));
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();

            int rowNumber = 0;
            int seatNumber = 0;

            if (choice == 1){
                showSeats(rows,seats, seatArrangement);
                System.out.println();
            } else if (choice == 2) {
                System.out.println();
                System.out.println("Enter a row number:");
                rowNumber = scanner.nextInt();
                System.out.println("Enter a seat number in that row:");
                seatNumber = scanner.nextInt();

                seatArrangement[rowNumber - 1][seatNumber - 1] = " B";

                System.out.println(Arrays.deepToString(seatArrangement));

                System.out.println();
                calculateSeatPrice(rows, seats,rowNumber);
                System.out.println();
            } else if (choice == 0) {
                break;
            }
        }

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

    private static void showSeats(int rows, int seats, String[][]seatArrangement) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 0; i < seats; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();

        for (int i = 0; i < seatArrangement.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < seatArrangement[i].length; j++) {
                if (seatArrangement[i][j] == null){
                    System.out.print(" S");
                }else {
                    System.out.print(seatArrangement[i][j]);
                }
            }
            System.out.println();
        }

    }

}