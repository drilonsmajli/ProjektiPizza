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

        return userTransport;
    }

    public static User toEntity(User user) {
        if (user == null) {
            return null;
        }

        User user1 = new User();
        user1.setFullName(user.getFullName());
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setCreditCard(user.getCreditCard());
        user1.setPayment(user.getPayment());
        return user1;
    }
}
