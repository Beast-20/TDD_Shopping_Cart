package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import org.junit.Test;
public class ItemTest 
{
    
    @Test
    public void test_creating_item(){
        
        Item item = new Item(1,"Soap",25.0);
        assertNotNull(item);
    }

    @Test
    public void test_getting_item_id(){
        Item item = new Item(1,"Soap",25.0);
        assertEquals(1,item.get_id());
    }

    @Test
    public void test_getting_item_name(){
        Item item = new Item(1,"Soap",25.0);
        assertEquals("Soap",item.get_name());
    }

    @Test
    public void test_getting_item_price(){
        Item item = new Item(1,"Soap",25.0);
        assertEquals(25.0,item.get_price(),0.1);
    }
}
