package com.example.springsecurityapp.services;

import com.example.springsecurityapp.models.Person;
import com.example.springsecurityapp.repositories.PeopleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PeopleRepository peopleRepository;

    public Optional<Person> findPersonByUsername(String username){
        return peopleRepository.findByUsername(username);
    }
}
