package com.groupeisi.person.mappers;

import com.groupeisi.person.dto.PersonDTO;
import com.groupeisi.person.entities.Person;

public interface IMapper {
    PersonDTO toPersonDTO(Person person);
    Person toPersonEntity(PersonDTO personDTO);
}
