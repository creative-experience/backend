package br.com.delivery.service;

import br.com.delivery.model.ProductModel;
import br.com.delivery.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public List<ProductModel> findAll(){
        return productRepository.findAll();
    }

    public void saveProduct(ProductModel productModel) {
        productRepository.save(productModel);
    }

    public ProductModel getById(UUID uuid) {
        return productRepository.getReferenceById(uuid);
    }

    public void deleteProduct(UUID uuid) {
        if (productRepository.existsById(uuid)){
            try {
                productRepository.deleteById(uuid);
            }
            catch (Exception e){
                throw new InternalError("Impossivel deletar o produto");
            }
        }
    }
}