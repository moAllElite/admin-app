package com.groupeisi.property.controllers;

import com.groupeisi.property.dto.PropertyDTO;
import com.groupeisi.property.services.IPropertyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/properties")
public class PropertyController {
    private final IPropertyService propertyService;

    @PostMapping
    public ResponseEntity<Void> createProperty(@RequestBody PropertyDTO propertyDTO) {
        propertyService.save(propertyDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<PropertyDTO>> getAllProperties() {
        return ResponseEntity.ok(propertyService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyDTO> getProperty(@PathVariable String id) {
        return  ResponseEntity.ok(propertyService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropertyDTO> updateProperty(
            @PathVariable String id,
            @RequestBody PropertyDTO propertyDTO) {
        return  ResponseEntity.ok(propertyService.update(id, propertyDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable String id) {
        propertyService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
