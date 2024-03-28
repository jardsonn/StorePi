package com.store.whitelabel.storePi.domain.product.image;

import com.store.whitelabel.storePi.domain.product.Product;

import java.util.UUID;

public record ProductImageDTO(
//        UUID imageId,
//        Product product,
        String imageUrl
) {

//    public ProductImageDTO(String imageUrl){
//        this(null, null, imageUrl);
//    }
//
    public ProductImage toProductImage(Product product){
        return new ProductImage(null, product, imageUrl);
    }

}
