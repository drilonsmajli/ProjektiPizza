package ProjektiPizza.demo.controller;

import ProjektiPizza.demo.entity.User;
import ProjektiPizza.demo.exception.UserException;
import ProjektiPizza.demo.service.UserService;
import ProjektiPizza.demo.transport.UserTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public UserTransport update(@RequestBody User user) throws UserException {
         return userService.save(user);
    }

    @PostMapping
    public UserTransport save(@RequestBody User user) throws UserException{
         return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) throws UserException{
        userService.delete(id);
    }
}
