package com.itmo.onlineshop.service;

import com.itmo.onlineshop.db.entity.Product;

public interface ShoppingCartService {

  void addProduct(Product product);

  void removeProduct(Product product);

  void clearProducts();

  Object productsInCart();

  Object totalPrice();

  void cartCheckoutToOrder();
}
