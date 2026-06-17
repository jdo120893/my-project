package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CartTest {
    private Cart cart;
    private Product laptop;
    private Product mouse;

        @BeforeEach
    public void setUp(){
            cart = new Cart();
            laptop = new Product("P001", "Laptop",1200.00);
            mouse = new Product("P002","Mouse",25.00);
        }



        @Test
    public void testAddProduct() {
            cart.addProduct(laptop);
            assertEquals(1,cart.getItemCount());
        }

        @Test
    public void testRemoveProduct(){
            cart.addProduct(laptop);
            cart.addProduct(mouse);
            cart.removeProduct("P001");
            assertEquals(1,cart.getItemCount());
        }

        @Test
    public void testGetTotalPrice(){
            cart.addProduct(laptop);
            cart.addProduct(mouse);
            assertEquals(1225.00,cart.getTotalPrice(),0.01);
        }

        @Test
    public void tsetEmptyCart(){
            assertEquals(0,cart.getItemCount());
            assertEquals(0.0,cart.getTotalPrice());
        }

}
