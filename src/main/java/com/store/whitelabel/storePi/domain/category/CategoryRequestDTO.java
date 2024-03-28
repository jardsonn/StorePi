package com.store.whitelabel.storePi.domain.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryRequestDTO(
//        @NotBlank(message = "{category.name.required}")
//        @Size(max = 45, message = "{category.name.max}")
        String name
) {
}
