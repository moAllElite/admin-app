package com.groupeisi.property.mappers;

import com.groupeisi.property.dto.PropertyDTO;
import com.groupeisi.property.entities.Property;

public interface AbstractMapper<T,O>{
    T toDTO(O o);
    O toEntity(T t);

}
