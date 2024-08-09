package hashim.projects.ecommerce.productservice.Services;

import hashim.projects.ecommerce.productservice.DTOs.GenericProductDTO;

import java.util.List;

public interface ProductService {

    public GenericProductDTO getProductById(long id);

    public GenericProductDTO createProduct(GenericProductDTO genericProductDTO);

    public List<GenericProductDTO> getAllProducts();

    GenericProductDTO deleteProduct(long id);
}
