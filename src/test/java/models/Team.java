package models;

public class Team {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Team withId(int id) {
        this.id = id;
        return this;
    }

    public Team withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
