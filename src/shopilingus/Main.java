package shopilingus;

public class Main {
    public static void main(String[] args) {

        ShoppingCenter galeriaRzeszow = new ShoppingCenter("Galeria Rzeszów", "ul.Józefa Piłsudskiego");
        Shop sklep1 = new Shop("McDonalds", 3,2);
        galeriaRzeszow.addShop(sklep1);

        Product bread = new Product("Chleb",1.80, "food", "2", 0.5, 20);
        sklep1.addProduct(bread, 50);

        System.out.println(galeriaRzeszow.getAllProductTypes());



    }
}
