import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        while(true){
            System.out.println("Select the option below: ");
            System.out.println("1. Insert");
            System.out.println("2. Select");
            System.out.println("3. Search");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("6. Exit");

            Scanner obj = new Scanner(System.in);
            int choice = obj.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Insert the data");
                case 2:
                    System.out.println("Select the data");
                case 3:
                    System.out.println("Search the data");
                case 4:
                    System.out.println("Update the data");
                case 5:
                    System.out.println("Delete the data");
                case 6:
                    break;
            }
        }
    }

}
