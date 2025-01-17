package com.example.projectModels.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String phoneNumber;

    @Column
    private String address;

    @Enumerated(EnumType.STRING)
    @Column
    private Role role;


    //список доставщиков (2 направленая связь)+
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_foodDeliveryMen",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "foodDeliveryMen_id", referencedColumnName = "id"))
    private Set<FoodDeliveryMan> foodDeliveryMen = new HashSet<>();

    //список ресторанов (2 направленая связь)+
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_restaurant",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "restaurant_id", referencedColumnName = "id"))
    private Set<Restaurant> restaurants = new HashSet<>();

    //    список заказов (2 направленая связь)+
    @OneToMany
    @JoinTable(name = "user_order", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private Set<Order> orders = new HashSet<>();


}


