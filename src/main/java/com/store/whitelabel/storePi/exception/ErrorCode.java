package com.store.whitelabel.storePi.exception;

/**
 * Enumeração que define códigos de erro relacionados a operações com produtos.
 * Cada código de erro representa uma situação específica de erro.
 */
public enum ErrorCode {
    /**
     * Indica que o produto solicitado não foi encontrado no sistema.
     */
    PRODUCT_NOT_FOUND,

    /**
     * Indica que o categoryId fornecido não é válido ou não corresponde a uma categoria existente.
     */
    INVALID_CATEGORY_ID,

    /**
     * Indica que o brandId fornecido não é válido ou não corresponde a uma marca existente.
     */
    INVALID_BRAND_ID,

    /**
     * Indica que o nome da category fornecido não é válido ou não corresponde a uma categoria existente.
     */
    INVALID_CATEGORY_NAME,

    /**
     * Indica que o nome da brand fornecido não é válido ou não corresponde a uma marca existente.
     */
    INVALID_BRAND_NAME,

    /**
     * Indica que o preço (price) fornecido não atende aos requisitos de validação, como o valor mínimo.
     */
    INVALID_PRICE,

    /**
     * Indica que o estoque (stock) fornecido não atende aos requisitos de validação, como o valor mínimo.
     */
    INVALID_STOCK, EMPTY_FIELD, INVALID_DATE,
}
