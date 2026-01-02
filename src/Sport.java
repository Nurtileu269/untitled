import java.util.Objects;

public class Sport {
  private String name;

  public Sport(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Sport{name='" + name + "'}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Sport)) return false;
    Sport sport = (Sport) o;
    return name.equalsIgnoreCase(sport.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name.toLowerCase());
  }
}
