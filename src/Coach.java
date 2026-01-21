public class Coach extends Person {
    private int experienceYears;

    public Coach(int id, String name, int experienceYears) {
        super(id, name);
        this.experienceYears = experienceYears;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    @Override
    public String getRole() {
        return "Coach";
    }

    @Override
    public String toString() {
        return super.toString() + ", experienceYears=" + experienceYears + "}";
    }
}


