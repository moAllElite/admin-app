package com.groupeisi.person.mappers;

import com.groupeisi.person.dto.PersonDTO;
import com.groupeisi.person.entities.Person;
import org.springframework.stereotype.Component;

@Component
public class MapperImpl implements IMapper {
    @Override
    public PersonDTO toPersonDTO(Person person) {
        return PersonDTO.builder()
                .id(person.getId())
                .email(person.getEmail())
                .birthDate(person.getBirthDate())
                .fullName(person.getFullName())
                .personType(person.getType())
                .build();
    }

    @Override
    public Person toPersonEntity(PersonDTO personDTO) {
        return Person.builder()
                .id(personDTO.id())
                .email(personDTO.email())
                .birthDate(personDTO.birthDate())
                .fullName(personDTO.fullName())
                .type(personDTO.personType())
                .build();
    }
}
