package test;

import java.util.ArrayList;
import java.util.List;

    public class Cart{
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
