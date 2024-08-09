package hashim.projects.ecommerce.productservice.Services;

import hashim.projects.ecommerce.productservice.DTOs.GenericProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("SelfProductService")
public class SelfProductServiceImpl implements ProductService{


    @Override
    public GenericProductDTO getProductById(long id) {
        return null;
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO genericProductDTO) {
        return null;
    }

    @Override
    public List<GenericProductDTO> getAllProducts() {
        return List.of();
    }

    @Override
    public GenericProductDTO deleteProduct(long id) {
        return null;
    }
}
