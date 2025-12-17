import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SportsClub {
    private String name;
    private String city;
    private final List<Sport> sportsOffered;
    private final List<Player> players;

    public SportsClub(String name, String city) {
        this.name = name;
        this.city = city;
        this.sportsOffered = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    public SportsClub() {
        this.sportsOffered = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public List<Sport> getSportsOffered() { return sportsOffered; }
    public List<Player> getPlayers() { return players; }

    public void addSport(Sport sport) {
        if (sport == null) return;
        if (!sportsOffered.contains(sport)) {
            sportsOffered.add(sport);
        }
    }

    public void addPlayer(Player player) {
        if (player == null) return;
        if (!players.contains(player)) {
            players.add(player);
        }
    }

    public int totalPlayers() {
        return players.size();
    }

    @Override
    public String toString() {
        return "SportsClub{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", sportsOffered=" + sportsOffered +
                ", players=" + players +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SportsClub)) return false;
        SportsClub that = (SportsClub) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(city, that.city) &&
                Objects.equals(sportsOffered, that.sportsOffered) &&
                Objects.equals(players, that.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city, sportsOffered, players);
    }
}
