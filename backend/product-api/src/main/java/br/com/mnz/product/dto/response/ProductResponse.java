package br.com.mnz.product.dto.response;

import br.com.mnz.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.math.BigDecimal;

@Data
public class ProductResponse {


    private Long id;
    private String name;
    private BigDecimal value;
    private String description;

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.value = product.getValue();
        this.description = product.getDescription();
    }
}
