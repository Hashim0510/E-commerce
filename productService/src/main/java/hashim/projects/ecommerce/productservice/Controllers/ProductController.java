package hashim.projects.ecommerce.productservice.Controllers;

import hashim.projects.ecommerce.productservice.DTOs.GenericProductDTO;
import hashim.projects.ecommerce.productservice.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(@Qualifier("FakeStoreProductService") ProductService productService) {

        this.productService = productService;

    }

    @GetMapping("{id}")
    public GenericProductDTO getProductById(@PathVariable("id") long id){

        return productService.getProductById(id);
    }

    @GetMapping
    public List<GenericProductDTO> getAllProducts(){

        return productService.getAllProducts();


    }

    @PostMapping
    public GenericProductDTO createProduct(@RequestBody GenericProductDTO genericProductDTO){

        return productService.createProduct(genericProductDTO);

    }

    @DeleteMapping("{id}")
    public GenericProductDTO deleteProduct(@PathVariable long id){

        return productService.deleteProduct(id);

    }
}
