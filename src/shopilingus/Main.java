package shopilingus;

public class Main {
    public static void main(String[] args) {

        ShoppingCenter galeriaRzeszów = new ShoppingCenter("Galeria Rzeszów", "ul.Józefa Piłsudskiego");
        Shop sklep1 = new Shop("McDonalds", 3,2);
        galeriaRzeszów.addShop(sklep1);

        Product bread = new Product("Chleb",1.80, "food", "2", 0.5, 20);
        sklep1.addProduct(bread, 50);





    }
}
