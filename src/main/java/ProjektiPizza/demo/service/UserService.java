package ProjektiPizza.demo.service;

import ProjektiPizza.demo.entity.User;
import ProjektiPizza.demo.exception.UserException;
import ProjektiPizza.demo.mapper.UserMapper;
import ProjektiPizza.demo.repository.UserRepository;
import ProjektiPizza.demo.transport.UserTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UserTransport> getAll() {
        return userRepository.findAll().stream().map(UserMapper::toTransport).collect(Collectors.toList());
    }

    public UserTransport get(String id) throws UserException {
        if(id==null || id.trim().isEmpty()){
            throw new UserException("Id null");
        }
        final Optional<User> byId = userRepository.findById(id);
        return UserMapper.toTransport(byId.orElseThrow(() -> new UserException("None user found")));
    }

    public UserTransport update(UserTransport userTransport) throws UserException {
        if (userTransport == null) {
            throw new UserException("User null");
        }
        userTransport.setPassword(passwordEncoder.encode(userTransport.getPassword()));
        return UserMapper.toTransport(userRepository.save(UserMapper.toEntity(userTransport)));
    }

    public UserTransport save(UserTransport userTransport) throws UserException {
        if (userTransport == null) {
            throw new UserException("User null");
        }
        if (userTransport.getRole().equals("ADMIN")) {
            return UserMapper.toTransport(userRepository.save(UserMapper.toEntity(userTransport)));
        } else {
            throw new UserException("You don't have access to create user");
        }
    }

    public void delete(String id) throws UserException{
        if(id==null || id.trim().isEmpty()){
            throw new UserException("Id null");
        }
        userRepository.deleteById(id);
    }
}
