package com.store.whitelabel.storePi.domain.order.history;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.Setter;
import com.store.whitelabel.storePi.domain.product.Product;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HistoricOrderProduct")
public class HistoricOrderProduct {
    @Id
    @ManyToOne
    @JoinColumn(name = "historic_order_id")
    private OrderHistory historicOrder;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
