package com.furkan.productdemo.controller;

import com.furkan.productdemo.model.Product;
import com.furkan.productdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    @GetMapping()
    public String index() {
        return "index";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("productList", productList);
        return "list";
    }

    @GetMapping("/add")
    public String showAddProductFrom(Model model) {
         Product theProduct = new Product();
         model.addAttribute("product", theProduct);
        
         //for html tag which is SELECT>OPTİON
         List<String> categoryList = Arrays.asList("Mobile Phone", "Tablet", "Laptop","Television","Headphone","Mouse","Keyboard","Monitor");
         model.addAttribute("categories", categoryList);
         return "add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/update")
    public String showUpdateForm(@RequestParam("productID") int productID,Model model) {
        List<String> categoryList = Arrays.asList("Mobile Phone", "Tablet", "Laptop","Television","Headphone","Mouse","Keyboard","Monitor");
        model.addAttribute("categories", categoryList);
        Product theProduct = productService.getProductById(productID);
        model.addAttribute("product", theProduct);
        return "add";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("productID") int productID) {
        productService.deleteProduct(productID);
        return "redirect:/products/list";
    }
}
