public class Product {

    private double price;
    private String type;
    private String name;
    private String size;
    private double weight;
    private double tax;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public Product(double price, String type, String name, String size, double weight, double tax) {
        this.price = price;
        this.type = type;
        this.name = name;
        this.size = size;
        this.weight = weight;
        this.tax = tax;
    }
}
