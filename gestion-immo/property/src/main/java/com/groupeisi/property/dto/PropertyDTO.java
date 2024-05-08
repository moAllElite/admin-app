package com.groupeisi.property.dto;

import com.groupeisi.property.entities.PropertyType;
import com.groupeisi.property.entities.Status;
import lombok.Builder;

@Builder
public record PropertyDTO (
         String id,
         PropertyType propertyType,
         double superficie,
         short numberOfpiece,
         String localisation,
         Status status,
         Long personId
)
{
}
