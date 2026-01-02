public class Player extends Person {
    private int age;

    public Player(int id, String name, int age) {
        super(id, name);
        this.age = age;
    }

    @Override
    public String getRole() {
        return "Player";
    }

    @Override
    public String toString() {
        return super.toString() + ", age=" + age + "}";
    }
}
