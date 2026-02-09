package LibrarySystem;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n---- Library Menu ----");
            System.out.println("1. Add Member");
            System.out.println("2. Search Member");
            System.out.println("3. Remove Member");
            System.out.println("4. Show All Members");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Member ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();

                    library.addMember(new Member(id, name, address));
                    break;

                case 2:
                    System.out.print("Enter Member ID: ");
                    library.searchMember(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter Member ID: ");
                    library.removeMember(sc.nextInt());
                    break;

                case 4:
                    library.showAllMembers();
                    break;

                case 5:
                    System.out.println("Thank You 🙏");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice ❌");
            }
        }
    }
}
