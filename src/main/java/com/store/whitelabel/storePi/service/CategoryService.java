package com.store.whitelabel.storePi.service;


import com.store.whitelabel.storePi.domain.brand.Brand;
import com.store.whitelabel.storePi.domain.category.Category;
import com.store.whitelabel.storePi.domain.category.CategoryRequestDTO;
import com.store.whitelabel.storePi.domain.category.CategoryResponseDTO;
import com.store.whitelabel.storePi.exception.ErrorCode;
import com.store.whitelabel.storePi.exception.StoreException;
import com.store.whitelabel.storePi.repository.CategoryRespository;
import com.store.whitelabel.storePi.util.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements BaseService<CategoryRequestDTO, CategoryResponseDTO> {

    private final CategoryRespository repo;

    @Autowired
    public CategoryService(CategoryRespository repo) {
        this.repo = repo;
    }

    @Override
    public List<CategoryResponseDTO> getAll() throws StoreException {
        return repo.findAll().stream().map(CategoryResponseDTO::new).toList();
    }

    @Override
    public CategoryResponseDTO create(CategoryRequestDTO categoryRequest) throws StoreException {
        ValidatorUtil.validEmptyField(categoryRequest.name());
        Category category = repo.save(new Category(categoryRequest.name()));
        return new CategoryResponseDTO(category);
    }

    @Override
    public List<CategoryResponseDTO> create(List<CategoryRequestDTO> categoryRequest) throws StoreException {
        var categories = categoryRequest.stream().map(categoryRequestDTO -> {
            ValidatorUtil.validEmptyField(categoryRequestDTO.name());
           return new Category(categoryRequestDTO.name());
        }).toList();
        var saved = repo.saveAll(categories);
        return saved.stream().map(CategoryResponseDTO::new).toList();
    }


}
