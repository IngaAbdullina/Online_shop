package com.itmo.onlineshop.service.impl;

import com.itmo.onlineshop.db.entity.Product;
import com.itmo.onlineshop.exception.ApiException;
import com.itmo.onlineshop.exception.ErrorCode;
import com.itmo.onlineshop.repository.ProductRepository;
import com.itmo.onlineshop.service.ProductService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  @Override
  public Product getProduct(long id) throws ApiException {
    return productRepository
        .findById(id)
        .orElseThrow(() -> new ApiException(ErrorCode.NOT_FOUND, "Product not found"));
  }

  @Override
  public Product save(Product product) {
    return productRepository.save(product);
  }
}
