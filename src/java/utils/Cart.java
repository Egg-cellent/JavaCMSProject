/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.HashMap;
import java.util.Map;
import product.Product;

/**
 *
 * @author user
 */
public class Cart {

    private Map<String, Product> cart;

    public Cart() {
    }

    public Cart(Map<String, Product> cart) {
        this.cart = cart;
    }

    public Map<String, Product> getCart() {
        return cart;
    }

    public void setCart(Map<String, Product> cart) {
        this.cart = cart;
    }

    public boolean add(Product p) {
        boolean check = false;
        try {
            if (this.cart == null) {
                this.cart = new HashMap<>();
            }
            if (this.cart.containsKey(p.getMasp())) {
                int currentQuantity = this.cart.get(p.getMasp()).getSoluong();
                p.setSoluong(currentQuantity + p.getSoluong());
            }
            this.cart.put(p.getMasp(), p);
            check = true;
        } catch (Exception e) {
        }

        return check;
    }

    public boolean update(String masp, Product p) {
        boolean check = false;
        if (this.cart != null) {
            if (this.cart.containsKey(masp)) {
                this.cart.replace(masp, p);
                check = true;
            }
        }
        return check;
    }

    public boolean remove(String masp) {
        boolean check = false;
        if (this.cart != null) {
            if (this.cart.containsKey(masp)) {
                this.cart.remove(masp);
                check = true;
            }
        }
        return check;
    }
}
