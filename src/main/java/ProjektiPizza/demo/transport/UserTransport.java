package ProjektiPizza.demo.transport;

import ProjektiPizza.demo.entity.CreditCard;
import ProjektiPizza.demo.entity.Payment;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class UserTransport {
    private String fullName;
    private String username;

    @JsonIgnore
    private String password;
    @JsonIgnore
    private List<CreditCard> creditCard;
    @JsonIgnore
    private List<Payment> payment;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String name) {
        this.fullName = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
