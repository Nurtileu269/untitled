import java.sql.*;
import java.util.*;

public class SportsClub {
    private final String name;

    public SportsClub(String name) { this.name = name; }

    // WRITE (INSERT)
    public void addMember(Person person) {
        String sql = "INSERT INTO member(id, role, name, age, experience_years) VALUES (?, ?, ?, ?, ?)";
        try (var con = DB.getConnection(); var ps = con.prepareStatement(sql)) {

            ps.setInt(1, person.getId());
            ps.setString(2, person.getRole());
            ps.setString(3, person.getName());

            if (person instanceof Player p) {
                ps.setInt(4, p.getAge());
                ps.setNull(5, Types.INTEGER);
            } else { // Coach
                Coach c = (Coach) person;
                ps.setNull(4, Types.INTEGER);
                ps.setInt(5, c.getExperienceYears());
            }

            ps.executeUpdate();
            System.out.println("Saved to DB!");
        } catch (SQLException e) {
            System.out.println("DB error (addMember): " + e.getMessage());
        }
    }

    // READ (ALL)
    public List<Person> getMembers() {
        return selectMembers("SELECT * FROM member", null);
    }

    // READ (BY ID)
    public Person findMemberById(int id) {
        var list = selectMembers("SELECT * FROM member WHERE id = ?", id);
        return list.isEmpty() ? null : list.get(0);
    }

    // UPDATE (change name by id)
    public boolean updateName(int id, String newName) {
        String sql = "UPDATE member SET name = ? WHERE id = ?";
        try (var con = DB.getConnection(); var ps = con.prepareStatement(sql)) {
            ps.setString(1, newName);
            ps.setInt(2, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("DB error (update): " + e.getMessage());
            return false;
        }
    }

    // DELETE (by id)
    public boolean deleteById(int id) {
        String sql = "DELETE FROM member WHERE id = ?";
        try (var con = DB.getConnection(); var ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("DB error (delete): " + e.getMessage());
            return false;
        }
    }

    // helper (SELECT)
    private List<Person> selectMembers(String sql, Integer id) {
        List<Person> list = new ArrayList<>();
        try (var con = DB.getConnection(); var ps = con.prepareStatement(sql)) {

            if (id != null) ps.setInt(1, id);

            try (var rs = ps.executeQuery()) {
                while (rs.next()) {
                    int mid = rs.getInt("id");
                    String role = rs.getString("role");
                    String mname = rs.getString("name");

                    if ("Player".equalsIgnoreCase(role))
                        list.add(new Player(mid, mname, rs.getInt("age")));
                    else
                        list.add(new Coach(mid, mname, rs.getInt("experience_years")));
                }
            }
        } catch (SQLException e) {
            System.out.println("DB error (select): " + e.getMessage());
        }
        return list;
    }
}
