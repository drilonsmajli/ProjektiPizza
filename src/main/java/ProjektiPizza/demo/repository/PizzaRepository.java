package ProjektiPizza.demo.repository;
import ProjektiPizza.demo.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Drilon
 */
@Repository
public interface PizzaRepository extends JpaRepository<Pizza,String> {
    Pizza findAllByTypeAndSize(String type, double size);
}
