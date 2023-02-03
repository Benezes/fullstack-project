package br.com.mnz.product.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {

    private String name;
    private BigDecimal value;
    private String description;
}
