package com.itmo.onlineshop.service.impl;

import com.itmo.onlineshop.db.entity.Product;
import com.itmo.onlineshop.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

  @Override
  public void addProduct(Product product) {

  }

  @Override
  public void removeProduct(Product product) {

  }

  @Override
  public void clearProducts() {

  }

  @Override
  public Object productsInCart() {
    return null;
  }

  @Override
  public Object totalPrice() {
    return null;
  }

  @Override
  public void cartCheckoutToOrder() {

  }
}
