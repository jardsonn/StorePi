package com.store.whitelabel.storePi.domain.product;

import com.store.whitelabel.storePi.domain.brand.BrandRequestDTO;
import com.store.whitelabel.storePi.domain.category.CategoryRequestDTO;
import com.store.whitelabel.storePi.domain.product.image.ProductImageDTO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public record ProductRequestDTO(
//        @NotBlank(message = "{product.NotBlank.message}")
//        UUID id,
        String name,
//        @Size(max = 255, message = "{product.Size.message}")
        String description,
//        @NotNull(message = "{product.NotNull.message}")
        UUID categoryId,
//        @NotNull(message = "{product.NotNull.message}")
        UUID brandId,
//        @DecimalMin(value = "0.01", message = "{product.DecimalMin.message}")
//        @NotNull(message = "{product.NotNull.message}")
        BigDecimal price,
//        @Min(value = 0, message = "{product.Min.message}")
//        @NotNull(message = "{product.NotNull.message}")
        Integer stock,
//        @Size(max = 20, message = "{product.Size.message}")
        String size,
//        @Size(max = 50, message = "{product.Size.message}")
        String color,

//        @PastOrPresent(message = "{product.PastOrPresent.message}")
        Date releaseDate
) {

}
