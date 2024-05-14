package com.groupeisi.property.entities;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import  java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "properties")
public class Property {
    @Id
    private String id;
    private  PropertyType propertyType;
    private double superficie;
    private short numberOfpiece;
    private String localisation;
    private Status status;
}
