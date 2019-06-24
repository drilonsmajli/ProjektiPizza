package ProjektiPizza.demo.controller;

import ProjektiPizza.demo.entity.Pizza;
import ProjektiPizza.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Drilon
 */
@RestController
@RequestMapping("/api/pizza")
public class PizzaOrderController {
    @Autowired
    private PizzaService pizzaService;

    @GetMapping
    public List<Pizza> getPizza() {
        return pizzaService.getPizza();
    }

    @PostMapping
    public Pizza addPizza(@RequestBody Pizza pizza) throws Exception {
        return pizzaService.addPizza(pizza);
    }

    @GetMapping("/price/{type}/{size}")
    public Pizza getPrice(@PathVariable String type, @PathVariable double size) throws Exception {
        return pizzaService.getPrice(type,size);
    }

}
