package hashim.projects.ecommerce.productservice.Models;

import hashim.projects.ecommerce.productservice.Enums.CategoryType;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Category extends BaseModel{

    private CategoryType categoryType;

}
