package oopexam;

import java.util.ArrayList;
import java.util.List;

class Cart{
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public void removeProduct(String productId){
        products.removeIf(p -> p.getId().equals(productId));
    }

    public double getTotalPrice(){
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public int getItemCount(){
        return products.size();
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }
}


class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

public class ShoppingDemo {
    public static void main(String[] args) {
        Cart cart = new Cart();
        Product laptop = new Product("P001", "laptop", 1200.00);
        Product mouse = new Product("P002", "mouse", 25.00);
        Product keyboard = new Product("P003", "keyboard", 75.00);

        cart.addProduct(laptop);
        cart.addProduct(mouse);
        cart.addProduct(keyboard);

        System.out.println("=====장바구니=====");
        for (Product p : cart.getProducts()) {
            System.out.println(p);
        }

        System.out.println("\n총 상품 개수: " + cart.getItemCount());
        System.out.println("총 금액: " + cart.getTotalPrice());

        cart.removeProduct("P002");
        System.out.println("\nMouse 제거 후 총 금액: " + cart.getTotalPrice());
    }
}

