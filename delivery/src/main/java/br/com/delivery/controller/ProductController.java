package br.com.delivery.controller;

import br.com.delivery.model.ProductModel;
import br.com.delivery.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping
    public List<ProductModel> getAllProducts(){
        List<ProductModel> products =  productService.findAll();
        return products;
    }

    @GetMapping("/{product_id}")
    public ProductModel getByProductId(@PathVariable UUID uuid){
        ProductModel product = productService.getById(uuid);
        return product;
    }

    @PostMapping("/save")
    public void saveProduct(@RequestBody ProductModel productModel){
        try {
            productService.saveProduct(productModel);
        }
        catch (Exception e){
            throw new InternalError("Deu ruim o save");
        }
    }

    @DeleteMapping
    public void deleteProduct(@RequestParam UUID uuid){
        productService.deleteProduct(uuid);
    }
}
