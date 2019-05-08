package ProjektiPizza.demo.transport;

import ProjektiPizza.demo.entity.CreditCard;
import ProjektiPizza.demo.entity.Payment;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class UserTransport {

    private String id;
    private String name;
    private String surname;

    @JsonIgnore
    private String password;
    @JsonIgnore
    private List<CreditCard> creditCard;
    @JsonIgnore
    private List<Payment> payment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<CreditCard> getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(List<CreditCard> creditCard) {
        this.creditCard = creditCard;
    }

    public List<Payment> getPayment() {
        return payment;
    }

    public void setPayment(List<Payment> payment) {
        this.payment = payment;
    }
}
