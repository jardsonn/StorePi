package com.store.whitelabel.storePi.service;

import com.store.whitelabel.storePi.exception.StoreException;

import java.util.List;

public interface BaseService<Request, Response>{

    List<Response> getAll() throws StoreException;

    Response create(Request categoryRequest) throws StoreException;

    List<Response> create(List<Request> categoryRequest) throws StoreException;

}
