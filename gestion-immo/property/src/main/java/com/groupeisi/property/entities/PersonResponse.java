package com.groupeisi.property.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "person")
public class PersonResponse {
    @Id
    private Long id;
    private String fullName;
    private String email;
    private LocalDate birthDate;
    private Property  property;
}
