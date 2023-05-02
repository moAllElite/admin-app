package com.groupeisi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AppUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,length = 150)
    private String nom ;
    @Column(nullable = false,length = 200)
    private String prenom ;
    @Column(nullable = false,length = 200)
    private String email;
    @Column(nullable = false,length = 32)
    private String password;
    @ManyToMany
    private List<AppRoles> appRoles;
    @OneToMany(mappedBy = "appUser")
    private List<Produit> produits;
}
