package com.store.whitelabel.storePi.domain.brand;

public record BrandRequestDTO(
//        @NotBlank(message = "{brand.name.required}")
//        @Size(max = 45, message = "{brand.name.max}")
        String name
) {
}
