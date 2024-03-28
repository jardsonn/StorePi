package com.store.whitelabel.storePi.controller;


import ch.qos.logback.classic.Logger;
import com.store.whitelabel.storePi.domain.brand.BrandRequestDTO;
import com.store.whitelabel.storePi.domain.brand.BrandResponseDTO;
import com.store.whitelabel.storePi.exception.StoreException;
import com.store.whitelabel.storePi.service.BrandService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/brands")
public class BrandController {

    private static final Logger log = (Logger) LoggerFactory.getLogger(BrandController.class);
    
    private final BrandService service;


    @Autowired
    public BrandController(BrandService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<BrandResponseDTO>> getAll() throws StoreException {
        try {
            var response = service.getAll();
            log.info("Lista de marcas obtidas.");
            return ResponseEntity.ok(response);
        } finally {
            log.info("Obter marcas finalizado!");
        }
    }

    @PostMapping
    public ResponseEntity<BrandResponseDTO> create(@RequestBody BrandRequestDTO body) throws StoreException {
        try {
            var newBrand = service.create(body);
            log.info("Marca cadastrado com sucesso!");
            return ResponseEntity.ok(newBrand);
        } finally {
            log.info("Cadastrar marcas finalizado!");
        }
    }

    @PostMapping("/list")
    public ResponseEntity<List<BrandResponseDTO>> create(@RequestBody List<BrandRequestDTO> body) {
        try {
            var newBrands = service.create(body);
            log.info("Todos as marcas cadastrada com sucesso!");
            return ResponseEntity.ok(newBrands);
        } finally {
            log.info("Cadastrar marcas finalizado!");
        }
    }
}
