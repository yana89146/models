package com.example.projectModels.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "foodDeliveryMan")
@Table(name = "foodDeliveryMen")
public class FoodDeliveryMan {
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

    @Enumerated(EnumType.STRING)
    @Column
    private Role role;





//  список заказов (2 направленая связь)+
    @OneToMany
    @JoinTable(name = "order_foodDeliveryMen", joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "foodDeliveryMen_id"))
    private Set<Order> order=new HashSet<>();

//список заказчиков(2 направленая связь)+
    @ManyToMany(mappedBy="foodDeliveryMen")
    private Set<User> users = new HashSet<>();

//список ресторанов(2 направленая связь)+
    @ManyToMany(mappedBy = "foodDeliveryMen")
    private Set<Restaurant> restaurants = new HashSet<>();


}
