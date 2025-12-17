import java.util.Objects;

public class Sport {
  private int id;
  private String name;
  private String category;
  private int teamSize;
  private boolean indoor;

  public Sport(int id, String name, String category, int teamSize, boolean indoor) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.teamSize = teamSize;
    this.indoor = indoor;
  }

  public Sport() {
  }

  public int getId() { return id; }
  public void setId(int id) { this.id = id; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public String getCategory() { return category; }
  public void setCategory(String category) { this.category = category; }

  public int getTeamSize() { return teamSize; }
  public void setTeamSize(int teamSize) { this.teamSize = teamSize; }

  public boolean isIndoor() { return indoor; }
  public void setIndoor(boolean indoor) { this.indoor = indoor; }

  public boolean isTeamSport() {
    return teamSize > 1;
  }

  @Override
  public String toString() {
    return "Sport{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", category='" + category + '\'' +
            ", teamSize=" + teamSize +
            ", indoor=" + indoor +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Sport)) return false;
    Sport sport = (Sport) o;
    return id == sport.id &&
            teamSize == sport.teamSize &&
            indoor == sport.indoor &&
            Objects.equals(name, sport.name) &&
            Objects.equals(category, sport.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, category, teamSize, indoor);
  }
}
