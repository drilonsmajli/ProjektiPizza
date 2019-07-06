package ProjektiPizza.demo.service;

import ProjektiPizza.demo.entity.Pizza;
import ProjektiPizza.demo.exception.PizzaException;
import ProjektiPizza.demo.repository.PizzaRepository;
import ProjektiPizza.demo.transport.UserTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;
    @Autowired
    UserService userService;

    public List<Pizza> getPizza() {
        List<Pizza> pizzas = new ArrayList<>();
        pizzaRepository.findAll().forEach(pizzas::add);
        return pizzas;
    }

    public Pizza addPizza(Pizza pizza) throws PizzaException {
        for (UserTransport userTransport : userService.getAll()) {
            if (userService.getAll().isEmpty()) {
                throw new PizzaException("Create a user please");
            }
            if (userTransport.getRole().equals("ADMIN")) {
                if (pizza.getSize() != 30 && pizza.getSize() != 40 && pizza.getSize() != 60) {
                    throw new PizzaException("Size should be 30,40 or 60 cm");
                }
                return pizzaRepository.save(pizza);
            } else {
                throw new PizzaException("User not access");
            }
        }
        throw new PizzaException("You can't add pizza");
    }

    public Pizza getPrice(String type,double size) throws PizzaException {
        final Pizza pizza = pizzaRepository.findAllByTypeAndSize(type, size);
        if(pizza == null) {
            throw new PizzaException("No pizza found");
        }
        return pizza;
    }
}
