package com.itmo.onlineshop.service;

import com.itmo.onlineshop.db.entity.Product;
import com.itmo.onlineshop.exception.ApiException;
import java.util.List;

public interface ProductService {

  List<Product> getAllProducts();

  Product getProduct(long id) throws ApiException;

  Product save(Product product);
}
