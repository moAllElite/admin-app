package com.groupeisi.property;

import com.groupeisi.property.entities.Property;
import com.groupeisi.property.entities.PropertyType;
import com.groupeisi.property.entities.Status;
import com.groupeisi.property.repository.PropertyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class PropertyApplication {

    public static void main(String[] args) {
        SpringApplication.run(PropertyApplication.class, args);
    }
 //   @Bean
    public CommandLineRunner commandLineRunner(PropertyRepository propertyRepository) {
        UUID uid = UUID.randomUUID();
        return args -> {
           Property app1 = Property.builder()
                   .id(uid.toString())
                   .propertyType(PropertyType.APARTMENT)
                   .superficie(50)
                   .numberOfpiece((short) 2)
                   .localisation("km")
                   .status(Status.RENT)
                   .build();
           Property villa = Property.builder()
                   .id(uid.toString())
                   .status(Status.SALE)
                   .localisation("Plateau")
                   .superficie(150)
                   .numberOfpiece((short) 3)
                   .propertyType(PropertyType.HOUSE)
                   .build();

           propertyRepository.save(villa);
           propertyRepository.save(app1);
        };
    }
}
