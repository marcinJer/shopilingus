import java.util.List;

public class Shop {
    private String name;
    private String address;
    private List<ProductDetails> products;
    private String[] type;
    private List<Service> services;
    private List<Employee> employees;

    public void hire(Employee employee){
        employees.add(employee);
    }

    public void fire(Employee employee){
        employees.remove(employee);
    }

    

}
