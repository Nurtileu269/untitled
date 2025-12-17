import java.util.Objects;

public class Player {
    private int id;
    private String name;
    private int age;
    private Sport sport;

    public Player(int id, String name, int age, Sport sport) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sport = sport;
    }

    public Player() {
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public Sport getSport() { return sport; }
    public void setSport(Sport sport) { this.sport = sport; }

    public boolean isAdult() {
        return age >= 18;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sport=" + (sport == null ? "none" : sport.getName()) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return id == player.id &&
                age == player.age &&
                Objects.equals(name, player.name) &&
                Objects.equals(sport, player.sport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, sport);
    }
}
