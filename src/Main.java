public class Main {
  public static void main(String[] args) {
    Sport football = new Sport(1, "Football", "Team", 11, false);
    Sport boxing   = new Sport(2, "Boxing", "Individual", 1, true);

    Player p1 = new Player(1, "Ali", 19, football);
    Player p2 = new Player(2, "Dana", 20, boxing);
    SportsClub club = new SportsClub("Astana Club", "Astana");
    club.addSport(football);
    club.addSport(boxing);

    club.addPlayer(p1);
    club.addPlayer(p2);
    System.out.println("=== CLUB INFO ===");
    System.out.println(club);
    System.out.println("\n=== PLAYERS ===");
    System.out.println(p1);
    System.out.println(p2);

    Sport football2 = new Sport(1, "Football", "Team", 11, false);
    System.out.println("\n=== COMPARISON ===");
    System.out.println("football equals football2? " + football.equals(football2));
  }
}
