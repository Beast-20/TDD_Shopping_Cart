package com.example;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;



public class ShoppingcartTest {
    
    @Test
    public void test_add_to_cart(){
        Item soap = new Item(1, "Soap", 25.0);

        ShoppingCart cart1 = new ShoppingCart();
        cart1.add_to_cart(soap);

        assertTrue(cart1.get_cart().containsKey(soap));

    }

    @Test 
    public void test_remove_from_cart(){
        Item soap = new Item(1, "Soap", 25.0);
        Item brush = new Item(2, "Brush", 60.0);

        ShoppingCart cart1 = new ShoppingCart();
        cart1.add_to_cart(soap);
        cart1.add_to_cart(brush);

        try{
        cart1.remove_from_cart(brush);
        assertFalse(cart1.get_cart().containsKey(brush));
        }
        catch(NotInCartException e){
            fail("Exception was not expected here");
        }

        try{
        cart1.remove_from_cart(brush);
        cart1.get_cart().containsKey(brush);
        fail("Exception was expexted here");
        }
        catch(NotInCartException e){
            assertEquals("Item not present in cart",e.getMessage());
        }

    }

    @Test
    public void test_view_cart(){
        Item soap = new Item(1, "Soap", 25.0);
        Item brush = new Item(2, "Brush", 60.0);
        Item rice = new Item(3,"Rice",210.0);

        ShoppingCart cart1 = new ShoppingCart();
        cart1.add_to_cart(soap);
        cart1.add_to_cart(soap);
        cart1.add_to_cart(brush);
        cart1.add_to_cart(rice);

        List<String> expected_cart = new ArrayList<>();
        expected_cart.add("Soap,2");
        expected_cart.add("Brush,1");
        expected_cart.add("Rice,1");

        assertIterableEquals(expected_cart,cart1.view_cart());

    }

    @Test
    public void test_calucate_cart_price(){
        Item soap = new Item(1, "Soap", 25.0);
        Item brush = new Item(2, "Brush", 60.0);
        Item rice = new Item(3,"Rice",210.0);
        Item tomato = new Item(4,"Tomato",20.0);

        ShoppingCart cart1 = new ShoppingCart();
        cart1.add_to_cart(soap);
        cart1.add_to_cart(soap);
        cart1.add_to_cart(brush);
        cart1.add_to_cart(rice);
        cart1.add_to_cart(tomato);

        assertEquals(340.0,cart1.caluclate_cart_price(),0.1);
    }
}
