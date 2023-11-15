package com.firsttask.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    int id;
    @NotEmpty // for not null value
    @Size(min = 3 , max = 15, message = "name need to have only 10 characters") // for put size
    String name;
    @NotEmpty
    @Size(min = 3, max = 10, message = "city need to have only 10 characters")
    String city;
    @NotEmpty
    @Size(min = 5, max = 25, message = "email need to have max 25 characters")
    @Email(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"   //regexp means regular expression
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$" , message = "plz enter valid Email! ")
    String email ;

    @NotEmpty
    @Size(min  = 13 ,max = 13, message = "Phone No need to have max 13 characters")
    @Pattern(regexp = "^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" , message = "write number like this: +111 123 456 789")
    String phoneNo;
    @NotEmpty
    @Size(min = 5, max = 15, message = "country need to have only 15 characters")
    String country;
    @NotEmpty
    @Size(min = 2, max = 3, message = "job need to have only 2 to 3 characters")
    String job;




}
