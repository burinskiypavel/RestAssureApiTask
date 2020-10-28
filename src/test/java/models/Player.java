package models;

public class Player {

    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Player withId(int id) {
        this.id = id;
        return this;
    }

    public Player withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Player withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Player withAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
