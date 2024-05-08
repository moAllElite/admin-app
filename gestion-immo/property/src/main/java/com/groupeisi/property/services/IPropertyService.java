package com.groupeisi.property.services;

import com.groupeisi.property.dto.PropertyDTO;

public interface IPropertyService extends  AbstractService< PropertyDTO> {
    PropertyDTO findByIdPerson(Long personId);
}
