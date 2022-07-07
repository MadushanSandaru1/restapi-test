package com.example.restapitest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).get();
    }

    public void createUser(User user) {
        Optional<User> optionalUser = userRepository.findUserByEmail(user.getEmail());

        if (optionalUser.isPresent()) {
            throw new IllegalStateException("Email already exist");
        }

        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);

        if (!exists) {
            throw new IllegalStateException("User with id "+ userId+" does not exists");
        }

        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Long userId, User user) {
        User u = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("User with id "+ userId +" does not exists")
        );

        if (user.getName() != null && user.getName().length() > 0 && !Objects.equals(u.getName(), user.getName())) {
            u.setName(user.getName());
        }

        if (user.getEmail() != null && user.getEmail().length() > 0 && !Objects.equals(u.getEmail(), user.getEmail())) {
            Optional<User> optionalUser = userRepository.findUserByEmail(u.getEmail());

            if (optionalUser.isPresent()) {
                throw new IllegalStateException("Email already exist");
            }
            u.setEmail(user.getEmail());
        }

        if (user.getDob() != null && user.getDob().toString().length() > 0 && !Objects.equals(u.getDob(), user.getDob())) {
            u.setDob(user.getDob());
        }
    }
}
