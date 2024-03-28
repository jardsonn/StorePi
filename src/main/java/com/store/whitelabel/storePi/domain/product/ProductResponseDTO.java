package com.store.whitelabel.storePi.domain.product;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public record ProductResponseDTO(
        UUID id,
        String name,
        String description,
        String category,
        String brand,
        BigDecimal price,
        Integer stock,
        String size,
        String color,
        Date releaseDate
) {

    public ProductResponseDTO(Product product) {
        this(product.getId(), product.getName(), product.getDescription(), product.getCategory().getName(), product.getBrand().getName(), product.getPrice(), product.getStock(), product.getSize(), product.getColor(), product.getReleaseDate());
    }

}
