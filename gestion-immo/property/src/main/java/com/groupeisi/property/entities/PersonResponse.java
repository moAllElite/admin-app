package com.groupeisi.property.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("person")
public class PersonResponse {
    @Id
    private Long id;
    private String fullName;
    private String email;
    private LocalDate birthDate;

}
