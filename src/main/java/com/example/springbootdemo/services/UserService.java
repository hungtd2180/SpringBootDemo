package com.example.springbootdemo.services;

import com.example.springbootdemo.models.User;
import com.example.springbootdemo.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepository;

//    private IUserRepository userRepository;
//
//    public UserService(IUserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /*
     * Sử dụng annotation @Service để đánh dấu đây là một service.
     * inject repository vào service bằng annotation @Autowired hoặc sử dụng constructor.
     * sau đó sử dụng các phương thức tương ứng với chức năng của service.
     */
}
