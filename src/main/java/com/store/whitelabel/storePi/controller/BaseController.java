package com.store.whitelabel.storePi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface BaseController<Request, Response>{


    @GetMapping
    ResponseEntity<List<Response>> getAll();

    @PostMapping
    ResponseEntity<Response> create(Request body);

    @PostMapping("/list")
    ResponseEntity<Response> create(List<Request> body);

}
