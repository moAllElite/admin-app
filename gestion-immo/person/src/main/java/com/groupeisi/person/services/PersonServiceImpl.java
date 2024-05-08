package com.groupeisi.person.services;

import com.groupeisi.person.dto.PersonDTO;
import com.groupeisi.person.entities.Person;
import com.groupeisi.person.mappers.IMapper;
import com.groupeisi.person.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class PersonServiceImpl implements IPersonService {
    private final PersonRepository personRepository;
    private final IMapper mapper;
    @Override
    public PersonDTO save(PersonDTO personDTO) {
        Person person = mapper.toPersonEntity(personDTO);
        return mapper.toPersonDTO(
                personRepository.save(person)
        );
    }

    @Override
    public PersonDTO findById(Long id) {
        return mapper.toPersonDTO(
                personRepository.findById(id)
                        .orElseThrow(()->new EntityNotFoundException("Person not found"))
        );
    }

    @Override
    public List<PersonDTO> findAll() {
        return personRepository.findAll()
                .stream()
                .map(mapper::toPersonDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (!personRepository.existsById(id)) {
            throw new EntityNotFoundException("Person not found");
        }
        personRepository.deleteById(id);
    }

    @Override
    public PersonDTO update(Long id, PersonDTO personDTO) {
        if(!personRepository.existsById(id)) {
            throw new EntityNotFoundException("Person not found");
        }
        Person person = mapper.toPersonEntity(personDTO);
        person.setId(id);
        Person saved = personRepository.save(person);
        return mapper.toPersonDTO(saved);
    }
}
