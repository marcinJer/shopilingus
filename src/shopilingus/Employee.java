package shopilingus;

public class Employee {
    private static int nextId = 0;

    public int id;
    private String name;
    private String[] skills;
    private boolean isAvailable;

    public Employee(String name, String[] skills, boolean isAvailable) {
        this.id = Employee.nextId++;
        this.name = name;
        this.skills = skills;
        this.isAvailable = isAvailable;
    }
    public Employee(String name) {
        this(name, new String[0], true);
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Employee.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }






}
