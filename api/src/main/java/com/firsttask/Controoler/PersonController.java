package com.firsttask.Controoler;

import com.firsttask.entity.Person;
import com.firsttask.services.PersonServiceImpl;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/person")
public class PersonController {


    @Autowired
    private PersonServiceImpl personService;
    @GetMapping
    public List<Person> getPerson(){

     return personService.getAllPerson();
    }

    @GetMapping("/{personid}")
    public Optional<Person> gePerson(@PathVariable("personid") int personid) {

       return personService.getPerson(personid);
    }

    @PostMapping
    public Person addPerson(@Valid @RequestBody Person person) {
        Person person1 = personService.addPerson(person);
return person1;
    }
    @PutMapping
    public Person updateCourse(@Valid @RequestBody Person person) { // @valid for check validation that are mention in entity class
        return personService.updatPerson(person);
    }

    @DeleteMapping("/{personid}")
    public void deleteCourse(@PathVariable("personid") Person person) {

         personService.deletPerson(person);

    }
}
