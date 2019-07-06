package ProjektiPizza.demo.mapper;

import ProjektiPizza.demo.entity.User;
import ProjektiPizza.demo.transport.UserTransport;

public class UserMapper {
    public static UserTransport toTransport(User user) {
        if (user == null) {
            return null;
        }

        UserTransport userTransport = new UserTransport();
        userTransport.setFullName(user.getFullName());
        userTransport.setUsername(user.getUsername());
        userTransport.setCreditCard(user.getCreditCard());
        userTransport.setPayment(user.getPayment());
        userTransport.setPassword(user.getPassword());
        userTransport.setRole(user.getRole());

        return userTransport;
    }

    public static User toEntity(UserTransport userTransport) {
        if (userTransport == null) {
            return null;
        }

        User user = new User();
        user.setFullName(userTransport.getFullName());
        user.setUsername(userTransport.getUsername());
        user.setPassword(userTransport.getPassword());
        user.setCreditCard(userTransport.getCreditCard());
        user.setPayment(userTransport.getPayment());
        user.setRole(userTransport.getRole());
        return user;
    }
}
