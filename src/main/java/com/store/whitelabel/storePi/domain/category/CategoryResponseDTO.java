package com.store.whitelabel.storePi.domain.category;

import java.util.UUID;

public record CategoryResponseDTO(
        UUID id,
        String name
) {

    public CategoryResponseDTO(Category category) {
        this(category.getId(), category.getName());
    }

}
