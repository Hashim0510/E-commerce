package hashim.projects.ecommerce.productservice.DTOs;

import hashim.projects.ecommerce.productservice.Models.Category;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GenericProductDTO {

    private long id;
    private String title;
    private String description;
    private String category;
    private double price;
    private String image;

}
