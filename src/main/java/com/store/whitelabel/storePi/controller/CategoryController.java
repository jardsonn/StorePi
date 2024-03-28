package com.store.whitelabel.storePi.controller;


import ch.qos.logback.classic.Logger;
import com.store.whitelabel.storePi.domain.category.CategoryRequestDTO;
import com.store.whitelabel.storePi.domain.category.CategoryResponseDTO;
import com.store.whitelabel.storePi.exception.StoreException;
import com.store.whitelabel.storePi.service.CategoryService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private static final Logger log = (Logger) LoggerFactory.getLogger(CategoryController.class);
    
    private final CategoryService service;


    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAll() throws StoreException {
        try {
            var response = service.getAll();
            log.info("Lista de categorias obtidas.");
            return ResponseEntity.ok(response);
        } finally {
            log.info("Obter lista de categorias finalizada");
        }
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> create(@RequestBody CategoryRequestDTO body) throws StoreException {
        try {
            var newCategory = service.create(body);
            log.info("Categoria cadastrada com sucesso!");
            return ResponseEntity.ok(newCategory);
        } finally {
            log.info("Cadastrar categorias finalizadas!");
        }
    }

    @PostMapping("/list")
    public ResponseEntity<List<CategoryResponseDTO>> create(@RequestBody List<CategoryRequestDTO> body) {
        try {
            var newCategorys = service.create(body);
            log.info("Todos as categorias cadastrado com sucesso!");
            return ResponseEntity.ok(newCategorys);
        } finally {
            log.info("Cadastrar categorias finalizadas!");
        }
    }
}
