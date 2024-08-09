package hashim.projects.ecommerce.productservice.Services;

import hashim.projects.ecommerce.productservice.DTOs.FakeStoreProductDTO;
import hashim.projects.ecommerce.productservice.DTOs.GenericProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.CodeSigner;
import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreProductServiceImpl implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    private final String productUrl = "https://fakestoreapi.com/products/{id}";
    private final String productRequestUrl = "https://fakestoreapi.com/products";

    @Autowired
    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {

        this.restTemplateBuilder = restTemplateBuilder;

    }


    @Override
    public GenericProductDTO getProductById(long id) {

        /*
        RestTemplateBuilder --->>> used to build restTemplate class, becuase lots of attributes to be set manually
                                    therefore, taking help from restTemplateBuilder to build RestTemplate object

        RestTemplate        --->>> used to access the 3rd party APIs and collect the response and convert it into java objects

         */

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.getForEntity(
                productUrl,
                FakeStoreProductDTO.class,
                id
        );

        FakeStoreProductDTO fakeStoreProductDTO = response.getBody();

        GenericProductDTO genericProductDTO = new GenericProductDTO();
        genericProductDTO.setId(fakeStoreProductDTO.getId());
        genericProductDTO.setCategory(fakeStoreProductDTO.getCategory());
        genericProductDTO.setDescription(fakeStoreProductDTO.getDescription());
        genericProductDTO.setPrice(fakeStoreProductDTO.getPrice());
        genericProductDTO.setTitle(fakeStoreProductDTO.getTitle());
        genericProductDTO.setImage(fakeStoreProductDTO.getImage());
         
        return genericProductDTO;
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO genericProductDTO){

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.postForEntity(
                productRequestUrl,
                genericProductDTO,
                FakeStoreProductDTO.class

        );

        FakeStoreProductDTO fakeStoreProductDTO = response.getBody();

        GenericProductDTO genericProductResponseDTO = new GenericProductDTO();
        genericProductResponseDTO.setId(fakeStoreProductDTO.getId());
        genericProductResponseDTO.setCategory(fakeStoreProductDTO.getCategory());
        genericProductResponseDTO.setDescription(fakeStoreProductDTO.getDescription());
        genericProductResponseDTO.setPrice(fakeStoreProductDTO.getPrice());
        genericProductResponseDTO.setTitle(fakeStoreProductDTO.getTitle());
        genericProductResponseDTO.setImage(fakeStoreProductDTO.getImage());
        return genericProductResponseDTO;


    }

    @Override
    public List<GenericProductDTO> getAllProducts() {

        RestTemplate restTemplate = restTemplateBuilder.build();

        /*
        why are we not putting List<FakeStoreProductDTO> on getForEntity method  :
                FakeStoreProductDTO is a type in List generics, therefore at run time the type should have to
                be receiving will be erased on compile time during process of type erasure by java compiler.
                that's why we are using array which is non-generic class

         */

        ResponseEntity<FakeStoreProductDTO[]> response = restTemplate.getForEntity(
                productRequestUrl,
                FakeStoreProductDTO[].class
        );

        FakeStoreProductDTO[] fakeStoreProductDTOS = response.getBody();
        List<GenericProductDTO> genericProductDTOList = new ArrayList<>();

        for(FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOS){

            GenericProductDTO genericProductDTO = new GenericProductDTO();
            genericProductDTO.setId(fakeStoreProductDTO.getId());
            genericProductDTO.setCategory(fakeStoreProductDTO.getCategory());
            genericProductDTO.setDescription(fakeStoreProductDTO.getDescription());
            genericProductDTO.setPrice(fakeStoreProductDTO.getPrice());
            genericProductDTO.setTitle(fakeStoreProductDTO.getTitle());
            genericProductDTO.setImage(fakeStoreProductDTO.getImage());
            genericProductDTOList.add(genericProductDTO);

        }

        return genericProductDTOList;
    }

    @Override
    public GenericProductDTO deleteProduct(long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        /*

        exchange method is a generic method which will be used to do any kind of httpMethod calls.
        why are we using this ?
            for delete entity, we have a delete method, but it is not returning void, but wee need to return a
            entity which has been deleted, therefore we are exchange method which is actually returning.

         */
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.exchange(
          productUrl,
          HttpMethod.DELETE,
          null,
          FakeStoreProductDTO.class,
          id
        );

        FakeStoreProductDTO fakeStoreProductDTO = response.getBody();

        GenericProductDTO genericProductDTO = new GenericProductDTO();
        genericProductDTO.setId(fakeStoreProductDTO.getId());
        genericProductDTO.setCategory(fakeStoreProductDTO.getCategory());
        genericProductDTO.setDescription(fakeStoreProductDTO.getDescription());
        genericProductDTO.setPrice(fakeStoreProductDTO.getPrice());
        genericProductDTO.setTitle(fakeStoreProductDTO.getTitle());
        genericProductDTO.setImage(fakeStoreProductDTO.getImage());

        return genericProductDTO;

    }
}
