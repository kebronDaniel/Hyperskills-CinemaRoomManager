package cinema;
public class Cinema {

    public static void main(String[] args) {
        int rows = 7;
        int seats = 8;
        System.out.println("Cinema:");
        for (int i = 0; i <= seats; i++) {
            if (i == 0){
                System.out.print("  ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        for (int i = 1; i <= rows; i++) {
            System.out.print(i + " ");
            for (int j = 1; j <= seats; j++) {
                System.out.print("S ");
            }
            System.out.println();
        }
    }
}