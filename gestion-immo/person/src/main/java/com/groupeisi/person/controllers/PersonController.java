package com.groupeisi.person.controllers;

import com.groupeisi.person.dto.PersonDTO;
import com.groupeisi.person.entities.Person;
import com.groupeisi.person.services.IPersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/schools")
@RestController
@CrossOrigin("*")
public class PersonController {
    private final IPersonService personService;

    public PersonController(IPersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPerson(PersonDTO personDTO) {
         personService.save(personDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PersonDTO> updatePerson(
            @PathVariable Long id,
            @RequestBody PersonDTO personDTO
    ) {
        return ResponseEntity.ok(personService.update(id,personDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
