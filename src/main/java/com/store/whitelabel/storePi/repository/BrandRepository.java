package com.store.whitelabel.storePi.repository;

import com.store.whitelabel.storePi.domain.brand.Brand;
import com.store.whitelabel.storePi.domain.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BrandRepository extends JpaRepository<Brand, UUID> {
    Brand findBrandByName(String name);

}
