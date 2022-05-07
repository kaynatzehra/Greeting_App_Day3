package com.example.demo.service;
import com.example.demo.model.Greeting;
import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface IGreetingService
{
    Greeting addGreeting(User user);

    Optional<Greeting> findById(long id);

    List<Greeting> getAll();

    Optional<Greeting> editGreetingById(long id, String name);

    void delete(long id);

}
