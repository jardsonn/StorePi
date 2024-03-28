package com.store.whitelabel.storePi.service;


import com.store.whitelabel.storePi.domain.brand.Brand;
import com.store.whitelabel.storePi.domain.brand.BrandRequestDTO;
import com.store.whitelabel.storePi.domain.brand.BrandResponseDTO;
import com.store.whitelabel.storePi.exception.StoreException;
import com.store.whitelabel.storePi.repository.BrandRepository;
import com.store.whitelabel.storePi.util.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService implements BaseService<BrandRequestDTO, BrandResponseDTO> {

    private final BrandRepository repo;

    @Autowired
    public BrandService(BrandRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<BrandResponseDTO> getAll() throws StoreException {
        return repo.findAll().stream().map(BrandResponseDTO::new).toList();
    }

    @Override
    public BrandResponseDTO create(BrandRequestDTO brandRequest) throws StoreException {
        ValidatorUtil.validEmptyField(brandRequest.name());
        Brand brand = repo.save(new Brand(brandRequest.name()));
        return new BrandResponseDTO(brand);
    }

    @Override
    public List<BrandResponseDTO> create(List<BrandRequestDTO> brandRequest) throws StoreException {
        var categories = brandRequest.stream().map(brandRequestDTO -> {
            ValidatorUtil.validEmptyField(brandRequestDTO.name());
           return new Brand(brandRequestDTO.name());
        }).toList();
        var saved = repo.saveAll(categories);
        return saved.stream().map(BrandResponseDTO::new).toList();
    }
    

}
