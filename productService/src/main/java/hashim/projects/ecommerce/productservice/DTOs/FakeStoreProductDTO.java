package hashim.projects.ecommerce.productservice.DTOs;


import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class FakeStoreProductDTO {

    /*
    this dto class is used to receive a product details as a class which got from response
    of fakeStore API(third party API)
     */

    private long id;
    private String title;
    private String description;
    private String category;
    private double price;
    private String image;

}
