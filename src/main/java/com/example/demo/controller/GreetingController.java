package com.example.demo.controller;
import com.example.demo.model.Greeting;
import com.example.demo.model.User;
import com.example.demo.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("")
public class GreetingController
{
    private static final String template = "%s!";
    //private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingService iGreetingService;

    @GetMapping(value = {"/home"})
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name)
    {
        User user = new User();
        user.setFirstName(name);
        return iGreetingService.addGreeting(user);
    }

    @PostMapping("/fullName")
    public Greeting sayWow(@RequestBody User user) {
        return iGreetingService.addGreeting(user);
    }

    @GetMapping("/find/{id}")
    public Optional<Greeting> greeting(@PathVariable(value = "id") long id)
    {
        return iGreetingService.findById(id);
    }

    @GetMapping("/all")
    public List<Greeting> getAll(){
        return iGreetingService.getAll();
    }

    @PutMapping("/editGreeting/{id}")
    public Optional<Greeting> editGreetingById(@PathVariable("id") long id, @RequestParam(value = "name") String name) {
        return iGreetingService.editGreetingById(id, name);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteByID(@PathVariable("id") long id) {
        iGreetingService.delete(id);
    }
}