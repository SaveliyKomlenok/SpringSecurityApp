package com.example.springsecurityapp.util;

import com.example.springsecurityapp.models.Person;
import com.example.springsecurityapp.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class PersonValidator implements Validator {
    private final PersonService personService;
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        if(personService.findPersonByUsername(person.getUsername()).isPresent()){
            errors.rejectValue("username", "", "Человек с таким именем пользователя уже существует");
        }
    }
}
