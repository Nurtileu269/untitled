import java.util.*;

public class SportsClub {
    private String name;
    private List<Person> members = new ArrayList<>();

    public SportsClub(String name) {
        this.name = name;
    }

    public void addMember(Person person) {
        members.add(person);
    }

    public List<Person> getMembers() {
        return members;
    }

    public Person findMemberById(int id) {
        for (Person p : members) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public List<Person> sortMembersByName() {
        members.sort(Comparator.comparing(Person::getName));
        return members;
    }

    @Override
    public String toString() {
        return "SportsClub{name='" + name + "', members=" + members + "}";
    }
}
