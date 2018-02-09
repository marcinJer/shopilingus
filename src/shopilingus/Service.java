package shopilingus;

public class Service {

    private static int nextId = 0;

    public int id;
    private String name;
    private double price;
    private int durationInMinutes;


    public Service(int id, String name, double price, int durationInMinutes) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.durationInMinutes = durationInMinutes;
    }
}
