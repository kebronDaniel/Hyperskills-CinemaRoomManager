package cinema;

import java.text.DecimalFormat;
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

        int current_income = 0;
        int numberOfSoldTickets = 0;

        while (true){
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();

            int rowNumber = 0;
            int seatNumber = 0;

            if (choice == 1){
                showSeats(rows,seats, seatArrangement);
                System.out.println();
            } else if (choice == 2) {

                while (true){
                    System.out.println();
                    System.out.println("Enter a row number:");
                    rowNumber = scanner.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    seatNumber = scanner.nextInt();

                    if (rowNumber > rows || seatNumber > seats){
                        System.out.println("Wrong input!");
                    }else {
                        if (seatArrangement[rowNumber - 1][seatNumber - 1] == " B"){
                            System.out.println();
                            System.out.println("That Ticket has already been purchased!");
                            System.out.println();

                        }else {
                            seatArrangement[rowNumber - 1][seatNumber - 1] = " B";
                            System.out.println();

                            int price = calculateSeatPrice(rows,seats,rowNumber);
                            current_income += price;

                            System.out.println("Ticket price: $" +price);
                            System.out.println();
                            numberOfSoldTickets++;
                            break;
                        }
                    }
                }

            } else if (choice == 3) {
                System.out.println("Number of purchased tickets: " + numberOfSoldTickets);

                double ticktes = numberOfSoldTickets;
                double totalTickets = rows * seats;
                double percentage = (ticktes / totalTickets) * 100; // The above two were made to have doubles than ints.

                System.out.println("total seats : " + rows * seats);
                System.out.println("Sold tickets : " + numberOfSoldTickets);
                DecimalFormat decimalFormat = new DecimalFormat("0.00");
                System.out.println("Percentage: " + decimalFormat.format(percentage) + "%");
                System.out.println("Current income: $" + current_income);
                System.out.println("Total income: $" + calculateTotalIncome(rows,seats));
                System.out.println();
            } else if (choice == 0) {
                break;
            }else {
                System.out.println();
                System.out.println("Wrong input!");
                System.out.println();
            }
        }

    }

    private static int calculateSeatPrice(int rows, int seats,int rowNumber){
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
        return price;
    }

    private static int calculateTotalIncome(int rows, int seats){
        int totalIncome = 0;
        int firstHalf = 0;
        int secondHalf = 0;
        if (rows * seats <= 60){
            totalIncome = (rows * seats) * 10;
            return totalIncome;
        } else {
            firstHalf = ((rows / 2) * seats) * 10;
            secondHalf = ((rows - (rows/2)) * seats) * 8;
            totalIncome = firstHalf + secondHalf;
            return totalIncome;
        }
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