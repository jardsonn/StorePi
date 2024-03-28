package com.store.whitelabel.storePi.domain.product;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Entity
@Table(name = "ProductVariant")
public class ProductVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NonNull
    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
    @NonNull
    @Column(name = "stock", nullable = false)
    private Integer stock;
    @NonNull
    @Column(name = "size", length = 20)
    private String size;
    @NonNull
    @Column(name = "color", length = 50)
    private String color;
}
