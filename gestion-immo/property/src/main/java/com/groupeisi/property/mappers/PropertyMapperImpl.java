package com.groupeisi.property.mappers;

import com.groupeisi.property.dto.PropertyDTO;
import com.groupeisi.property.entities.Property;
import org.springframework.stereotype.Component;

@Component
public class PropertyMapperImpl implements IMapper {
    @Override
    public PropertyDTO toDTO(Property property) {
        return PropertyDTO.builder()
                .id(property.getId())
                .localisation(property.getLocalisation())
                .numberOfpiece(property.getNumberOfpiece())
                .propertyType(property.getPropertyType())
                .status(property.getStatus())
                .superficie(property.getSuperficie())
                .personId(property.getPersonId())
                .build();
    }

    @Override
    public Property toEntity(PropertyDTO propertyDTO) {
        return Property.builder()
                .id(propertyDTO.id())
                .localisation(propertyDTO.localisation())
                .numberOfpiece(propertyDTO.numberOfpiece())
                .propertyType(propertyDTO.propertyType())
                .status(propertyDTO.status())
                .superficie(propertyDTO.superficie())
                .personId(propertyDTO.personId())
                .build();
    }
}
