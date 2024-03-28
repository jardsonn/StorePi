package com.store.whitelabel.storePi.domain.brand;


import java.util.UUID;


public record BrandResponseDTO(
        UUID id,
        String name
) {
    public BrandResponseDTO(Brand brand) {
        this(brand.getId(), brand.getName());
    }
}
