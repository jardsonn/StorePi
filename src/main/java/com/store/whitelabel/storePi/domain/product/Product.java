package com.store.whitelabel.storePi.domain.product;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.store.whitelabel.storePi.domain.brand.Brand;
import com.store.whitelabel.storePi.domain.category.Category;
import com.store.whitelabel.storePi.domain.product.image.ProductImage;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NonNull
    @Column(name = "name", nullable = false)
    private String name;
    @NonNull
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;
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

    @NonNull
    @Column(name = "release_date")
    private Date releaseDate;

}
