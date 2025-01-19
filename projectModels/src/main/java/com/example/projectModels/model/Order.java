package com.example.projectModels.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity(name = "order")
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private StatusOfOrder statusOfOrder;

    @Column
    private boolean isDelivery;

    @Column
    private Date createdAt;

    @Column
    private Date completedAt;

    // ресторан (2 направленая связь)+
    @ManyToOne
    private Restaurant restaurant;


    //заказчик (2 направленая связь)+
    @ManyToOne
    private User user;


    //    доставщик для заказа (2 направленая связь)+
    @ManyToOne
    private FoodDeliveryMan foodDeliveryMan;

    //    список блюд (1 направленая связь)+
    @OneToMany
    @JoinTable(name = "order_item", joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Set<Item> items = new HashSet<>();


}
