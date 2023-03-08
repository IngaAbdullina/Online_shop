package com.itmo.onlineshop.controller;

import com.itmo.onlineshop.db.entity.Product;
import com.itmo.onlineshop.service.ProductService;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping(value = { "", "/" })
  public @NotNull List<Product> getProducts() {
    return productService.getAllProducts();
  }
}
