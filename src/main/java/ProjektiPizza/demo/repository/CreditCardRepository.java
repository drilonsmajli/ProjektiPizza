package ProjektiPizza.demo.repository;

import ProjektiPizza.demo.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Drilon
 */
@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, String>{
}
