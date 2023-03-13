package com.itmo.onlineshop.controller;

import com.itmo.onlineshop.db.entity.Product;
import com.itmo.onlineshop.exception.ApiException;
import com.itmo.onlineshop.service.ProductService;
import com.itmo.onlineshop.service.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final ShoppingCartService shoppingCartService;
    private final ProductService productService;

    @Autowired
    public CartController(ShoppingCartService shoppingCartService, ProductService productService) {
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
    }

    @GetMapping
    public String cart(Model model){
        model.addAttribute("products", shoppingCartService.productsInCart());
        model.addAttribute("totalPrice", shoppingCartService.totalPrice());
        return "cart";
    }

    @GetMapping("/add/{id}")
    public String addProductToCart(@PathVariable("id") long id) throws ApiException {
        Product product = productService.findById(id);
        if (product != null){
            shoppingCartService.addProduct(product);
            log.debug("Product [id={}] added to shopping cart", id);
        }
        return "redirect:/home";
    }

    @GetMapping("/remove/{id}")
    public String removeProductFromCart(@PathVariable("id") long id) throws ApiException {
        Product product = productService.findById(id);
        if (product != null){
            shoppingCartService.removeProduct(product);
            log.debug("Product [id={}] removed from shopping cart", id);
        }
        return "redirect:/cart";
    }

    @GetMapping("/clear")
    public String clearProductsInCart(){
        shoppingCartService.clearProducts();
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String cartCheckout(){
        shoppingCartService.cartCheckoutToOrder();
        return "redirect:/cart";
    }
}
