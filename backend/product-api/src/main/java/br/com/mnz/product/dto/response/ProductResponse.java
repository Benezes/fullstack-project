package br.com.mnz.product.dto.response;

import br.com.mnz.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.math.BigDecimal;

@Data
public class ProductResponse {

    private String name;
    private BigDecimal value;
    private String desc;

    public ProductResponse(Product product) {
        this.name = product.getName();
        this.value = product.getValue();
        this.desc = product.getDescription();
    }
}
