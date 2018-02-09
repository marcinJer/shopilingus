package shopilingus;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCenter {

    private static int nextId = 0;

    private int id;
    private String name;
    private String address;
    private List<Shop> shops;

    public ShoppingCenter(String name, String address) {
        this.id = ShoppingCenter.nextId++;
        this.name = name;
        this.address = address;
        this.shops = shops;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        ShoppingCenter.nextId = nextId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }



    public void addShop(Shop shop) {

        this.shops.add(shop);

    }

    public void deleteShop(int shopId) {

        for (Shop shop : shops) {
            if (shop.getId() == shopId) {
                shops.remove(shop);
            } else {
                System.out.println("Nie ma takiego sklepu!");
            }
        }

    }

    private Shop getShop(int shopId) {

        for (int i = 0; i < shops.size(); i++) {

            Shop shop = shops.get(i);

            if (shop.getId() == shopId) {
                return shop;
            }
        }
        return null;
    }

    private void updateShop(int shopId, Shop modifiedShop) {
        deleteShop(shopId);
        modifiedShop.id = shopId;
        addShop(modifiedShop);
    }

    private List<Shop> findShopByName(String name) {

        List<Shop> result = new LinkedList<Shop>();
        for (Shop shop : this.shops) {
            if (shop.getName().equals(name)) {
                result.add(shop);
            }
        }
        return null;

//    return shops.stream()
//            .filter(shop -> shop.name.equals(name))
//            .collect(Collectors.toList());
//
    }

    private Shop findShopById(int id) {
        return shops.stream()
                .filter(shop -> shop.getId() == id)
                .findFirst()
                .orElse(null);
    }

    private void printAllShops() {
        for (Shop shop : shops) {
            System.out.println(shop.getName());
        }
    }

    public List<Product> getAllProducts(){
        List<Product> result = new LinkedList<>();
        for(Shop shop : this.shops){
            for(ProductDetails productDetails : shop.getProducts()){
                result.add(productDetails.product);
            }
        }
        return null;
    }

    public List<Service> getAllServices(){
        List<Service> result = new LinkedList<>();
        for(Shop shop : this.shops){
            result.addAll(shop.services);
        }
        return result;
    }

    public List<String> getAllShopTypes(){
        List<String> result = new LinkedList<>();
        for(Shop shop : this.shops){
            result.addAll(shop.getTypes());
        }

        return result;
    }

    public List<String> getAllProductTypes(){
        List<String> result = new LinkedList<>();
        for(Product product : getAllProducts()){
            result.add(product.type);
        }
        return result;
}









}
