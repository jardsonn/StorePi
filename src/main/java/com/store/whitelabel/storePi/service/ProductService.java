package com.store.whitelabel.storePi.service;


import com.store.whitelabel.storePi.domain.brand.Brand;
import com.store.whitelabel.storePi.domain.category.Category;
import com.store.whitelabel.storePi.domain.product.Product;
import com.store.whitelabel.storePi.domain.product.ProductRequestDTO;
import com.store.whitelabel.storePi.domain.product.ProductResponseDTO;
import com.store.whitelabel.storePi.exception.ErrorCode;
import com.store.whitelabel.storePi.exception.StoreException;
import com.store.whitelabel.storePi.repository.BrandRepository;
import com.store.whitelabel.storePi.repository.CategoryRepository;
import com.store.whitelabel.storePi.repository.ProductRepository;
import com.store.whitelabel.storePi.util.ValidatorUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements BaseService<ProductRequestDTO, ProductResponseDTO> {


    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, BrandRepository brandRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.brandRepository = brandRepository;
    }


    @Override
    public List<ProductResponseDTO> getAll() throws StoreException {
        return productRepository.findAll().stream().map(ProductResponseDTO::new).toList();
    }

    @Override
    public ProductResponseDTO create(@Valid ProductRequestDTO body) throws StoreException {
        Product product = getProduct(body);
        return new ProductResponseDTO(productRepository.save(product));
    }

    @Override
    public List<ProductResponseDTO> create(@Valid List<ProductRequestDTO> request) throws StoreException {
        List<Product> products = request.stream().map(this::getProduct).toList();
        var saved = productRepository.saveAll(products);
        return saved.stream().map(ProductResponseDTO::new).toList();
    }

    private Product getProduct(ProductRequestDTO productRequest) {
        Optional<Category> category = categoryRepository.findById(productRequest.categoryId());
        Optional<Brand> brand = brandRepository.findById(productRequest.brandId());

        if (category.isEmpty()) {
            throw new StoreException(ErrorCode.INVALID_CATEGORY_NAME, "A categoria fornecida não é válida ou não corresponde a uma categoria existente.");
        }
        if (brand.isEmpty()) {
            throw new StoreException(ErrorCode.INVALID_BRAND_NAME, "A marca fornecida não é válida ou não corresponde a uma marca existente.");
        }
        ValidatorUtil.validEmptyField(productRequest.name());
        ValidatorUtil.validEmptyField(productRequest.description());
        ValidatorUtil.validEmptyField(productRequest.size());
        ValidatorUtil.validEmptyField(productRequest.color());
        ValidatorUtil.validEmptyField(productRequest.stock());
        ValidatorUtil.validateDate(productRequest.releaseDate());

        return new Product(productRequest.name(), productRequest.description(), category.get(), brand.get(), productRequest.price(), productRequest.stock(), productRequest.size(), productRequest.color(), productRequest.releaseDate());
    }

}
