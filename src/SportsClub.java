import java.util.*;
import java.util.stream.Collectors;

public class SportsClub {
    private String clubName;
    private List<Person> members = new ArrayList<>();
    private List<Sport> sports = new ArrayList<>();

    public SportsClub(String clubName) {
        this.clubName = clubName;
    }

    // encapsulation
    public void addMember(Person person) {
        members.add(person);
    }

    public void addSport(Sport sport) {
        sports.add(sport);
    }

    public List<Person> getMembers() {
        return members;
    }

    // filtering
    public List<Player> getPlayers() {
        return members.stream()
                .filter(p -> p instanceof Player)
                .map(p -> (Player) p)
                .collect(Collectors.toList());
    }

    // searching
    public Person findMemberById(int id) {
        return members.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // sorting
    public List<Person> sortMembersByName() {
        return members.stream()
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());
    }
}
