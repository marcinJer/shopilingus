package shopilingus;

import java.util.LinkedList;
import java.util.List;

public class Shop {
    private static int nextId = 0;

    public int id;
    public String name;
    private Location location;

    private List<String> types;
    private List<ProductDetails> products;
    public List<Service> services;
    private List<Employee> employees;


    public Shop(String name, int floor, int box) {
        this.id = Shop.nextId++;
        this.name = name;
        this.location = new Location(floor, box);
        this.types = types;
        this.products = new LinkedList<ProductDetails>();
        this.services = new LinkedList<Service>();
        this.employees = new LinkedList<Employee>();
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Shop.nextId = nextId;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public List<ProductDetails> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDetails> products) {
        this.products = products;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }


    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void fire(Employee employee) {
        employees.remove(employee);
    }

    public ProductDetails findProductById(int productId) {

        for (ProductDetails productDetails : products) {
            if (productDetails.product.id == productId) {
                return productDetails;
            }
        }
        return null;
    }

    public void addProduct(Product product, double quantity) {

        ProductDetails existingProduct = findProductById(product.id);

        if(existingProduct != null){
            existingProduct.quantity += quantity;
        }else{
            products.add(new ProductDetails(product, quantity));
        }

    }

    public Product getProduct(int productId){
        for(ProductDetails productDetails : products){
            if(productDetails.product.id == productId){
                return productDetails.product;
            }
        }
        return null;
    }

    public void deleteProduct(int productId){

        }
    }



