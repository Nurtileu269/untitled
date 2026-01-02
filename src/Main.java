import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    SportsClub club = new SportsClub("Astana Sports Club");

    while (true) {
      System.out.println("\n--- SPORTS CLUB MANAGEMENT ---");
      System.out.println("1. Add Player");
      System.out.println("2. Add Coach");
      System.out.println("3. View Members");
      System.out.println("4. Search Member by ID");
      System.out.println("5. Sort Members by Name");
      System.out.println("0. Exit");
      System.out.print("Choose: ");

      int choice = scanner.nextInt();
      scanner.nextLine(); // buffer clean

      switch (choice) {

        case 1 -> {
          System.out.print("Player ID: ");
          int id = scanner.nextInt();
          scanner.nextLine();

          System.out.print("Name: ");
          String name = scanner.nextLine();

          System.out.print("Age: ");
          int age = scanner.nextInt();

          club.addMember(new Player(id, name, age));
        }

        case 2 -> {
          System.out.print("Coach ID: ");
          int id = scanner.nextInt();
          scanner.nextLine();

          System.out.print("Name: ");
          String name = scanner.nextLine();

          System.out.print("Experience years: ");
          int years = scanner.nextInt();

          club.addMember(new Coach(id, name, years));
        }

        case 3 -> club.getMembers().forEach(System.out::println);

        case 4 -> {
          System.out.print("Enter ID: ");
          int id = scanner.nextInt();
          System.out.println(club.findMemberById(id));
        }

        case 5 -> club.sortMembersByName().forEach(System.out::println);

        case 0 -> {
          System.out.println("Bye!");
          return;
        }

        default -> System.out.println("Invalid choice");
      }
    }
  }
}
