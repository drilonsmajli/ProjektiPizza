package ProjektiPizza.demo.controller;

import ProjektiPizza.demo.exception.UserException;
import ProjektiPizza.demo.service.UserService;
import ProjektiPizza.demo.transport.UserTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserTransport> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserTransport get(@PathVariable String id) throws UserException {
        return userService.get(id);
    }

    @PutMapping
    public UserTransport update(@RequestBody UserTransport userTransport) throws UserException {
        return userService.save(userTransport);
    }

    @PostMapping
    public UserTransport save(@RequestBody UserTransport userTransport) throws UserException {
        return userService.save(userTransport);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) throws UserException{
        userService.delete(id);
    }
}
