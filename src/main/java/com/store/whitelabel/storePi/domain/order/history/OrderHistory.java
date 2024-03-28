package com.store.whitelabel.storePi.domain.order.history;

import com.store.whitelabel.storePi.domain.customer.Customer;
import com.store.whitelabel.storePi.domain.order.Order;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OrderHistory")
public class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "purchase_date")
    private Date purchaseDate;

    @Column(name = "order_status")
    private String orderStatus;

    @Column
    private String products;

}
