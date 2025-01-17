package com.example.projectModels.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String phoneNumber;

    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    @Column
    private Role role;


    //    список заказов (2 направленая связь)+
    @OneToMany
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    private Set<Order> orders = new HashSet<>();

    //    список блюд (1 направленая связь)+
    @OneToMany
    @JoinTable(name = "restaurant_item", joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Set<Item> items = new HashSet<>();



    //    список заказчиков (2 направленая связь)+
    @ManyToMany(mappedBy = "restaurants")
    private Set<User> users = new HashSet<>();


    //    список доставщиков еды (2 направленая связь)+
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "restaurant_foodDeliveryMan",
            joinColumns = @JoinColumn(name = "restaurant_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "foodDeliveryMan_id", referencedColumnName = "id"))
    private Set<FoodDeliveryMan> foodDeliveryMen = new HashSet<>();


}
