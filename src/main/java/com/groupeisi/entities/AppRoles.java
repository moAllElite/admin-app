package com.groupeisi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AppRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,length = 180,unique = true)
    private String nom;
    @ManyToMany(mappedBy = "appRoles")
    private List<AppUser> appUsers;

}
