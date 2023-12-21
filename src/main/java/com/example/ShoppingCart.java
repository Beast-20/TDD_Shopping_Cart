package com.example;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    private LinkedHashMap<Item,Integer> cart;

    public ShoppingCart(){
        this.cart = new LinkedHashMap<>();
    }

    public void add_to_cart(Item item){
        if(cart.containsKey(item)){
            cart.put(item,cart.get(item)+1);
        }
        else{
            cart.put(item,1);
        }
    }

    public void remove_from_cart(Item item) throws NotInCartException{
        if(!cart.containsKey(item)){
            throw new NotInCartException("Item not present in cart");
        }
        else{
            int qty = cart.get(item);
            if(qty-1==0){
                cart.remove(item);
            }
            else{
                cart.put(item, cart.get(item)-1);
            }
        }
    }

    public double caluclate_cart_price(){
        double price = 0;
        for (Map.Entry<Item, Integer> entry : cart.entrySet()) {
            Item curr_item = entry.getKey();
            price+=(curr_item.get_price()*entry.getValue());
        }
        return price;
    }

    public List<String> view_cart(){
       List<String> viewer = new ArrayList<>();
       for (Map.Entry<Item, Integer> entry : cart.entrySet()) {
            viewer.add(entry.getKey().get_name()+","+(entry.getValue()+""));
        }
       return viewer;
    }

    public LinkedHashMap<Item,Integer> get_cart(){
        return cart;
    }
}
