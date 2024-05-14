package com.groupeisi.property.services;

import com.groupeisi.property.dto.PropertyDTO;
import com.groupeisi.property.entities.Property;
import com.groupeisi.property.mappers.IMapper;
import com.groupeisi.property.repository.PropertyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PropertyServiceImpl implements IPropertyService {
    private final IMapper mapper ;
    private final PropertyRepository propertyRepository;

    public PropertyServiceImpl(PropertyRepository propertyRepository, IMapper mapper) {
        this.propertyRepository = propertyRepository;
        this.mapper = mapper;
    }


    @Override
    public PropertyDTO save(PropertyDTO propertyDTO) {
        Property property = mapper.toEntity(propertyDTO);
        return mapper.toDTO(
                propertyRepository.save(property)
        );
    }

    @Override
    public PropertyDTO findById(String id) {
        return propertyRepository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(()-> new EntityNotFoundException("Property not found"))
        ;
    }

    @Override
    public List<PropertyDTO> findAll() {
        return propertyRepository.findAll()
                .stream().map(mapper::toDTO)
                .toList();
    }

    @Override
    public void delete(String id) {
        if(!propertyRepository.existsById(id)) {
            throw new EntityNotFoundException("Property not found");
        }
            propertyRepository.deleteById(id);
    }

    @Override
    public PropertyDTO update(String id, PropertyDTO propertyDTO) {
        if(!propertyRepository.existsById(id)) {
            throw new EntityNotFoundException("Property not found");
        }
        Property property = mapper.toEntity(propertyDTO);
        property.setId(id);
        Property savedProperty = propertyRepository.save(property);
        return mapper.toDTO(
                savedProperty
        );
    }


}
