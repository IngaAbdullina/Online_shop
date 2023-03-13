package com.itmo.onlineshop.service;

import com.itmo.onlineshop.db.entity.Product;
import com.itmo.onlineshop.exception.ApiException;
import java.util.List;

public interface ProductService {

  Product findById(long id) throws ApiException;

  List<Product> getAllProducts();

  Product save(Product product);
}
