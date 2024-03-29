package Assignment_2;

public class Main {

    public static void main(String[] args) {
        // Print column headers
        System.out.print("     ");
        for (int i = 1; i <= 9; i++) {
            System.out.printf("%-4d", i);
        }
        System.out.println();
        
        // Print horizontal line
        System.out.print("   ");
        for (int i = 1; i <= 9; i++) {
            System.out.print("____");
        }
        System.out.println();
        
        // Print multiplication table
        for (int i = 1; i <= 9; i++) {
            // Print row header
            System.out.printf("%2d | ", i);
            
            // Print row values
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%-4d", i * j);
            }
            System.out.println();
        }
    }
}