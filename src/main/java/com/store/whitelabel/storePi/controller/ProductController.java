package com.store.whitelabel.storePi.controller;

import ch.qos.logback.classic.Logger;
import com.store.whitelabel.storePi.domain.product.ProductRequestDTO;
import com.store.whitelabel.storePi.domain.product.ProductResponseDTO;
import com.store.whitelabel.storePi.exception.StoreException;
import com.store.whitelabel.storePi.service.ProductService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private static final Logger log = (Logger) LoggerFactory.getLogger(ProductController.class);
    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAll() throws StoreException {
        try {
            var response = service.getAll();
            log.info("Lista de produtos obtidas.");
            return ResponseEntity.ok(response);
        } finally {
            log.info("Obter lista de produtos finalizada!");
        }
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(@RequestBody ProductRequestDTO body) throws StoreException {
        try {
            var newProduct = service.create(body);
            log.info("Produto cadastrado com sucesso!");
            return ResponseEntity.ok(newProduct);
        } finally {
            log.info("Cadastrar produto finalizado!");
        }
    }

    @PostMapping("/list")
    public ResponseEntity<List<ProductResponseDTO>> create(@RequestBody List<ProductRequestDTO> body) {
        try {
            var newProducts = service.create(body);
            log.info("Todos os produto cadastrado com sucesso!");
            return ResponseEntity.ok(newProducts);
        } finally {
            log.info("Cadastrar produto finalizado!");
        }
    }
}
