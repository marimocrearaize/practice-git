package com.techacademy.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techacademy.entity.User;
import com.techacademy.repository.UserRepository;

@Service
@Transactional(readOnly=true)
public class UserService {
        @Autowired
        private UserRepository userRepository;

        public List<User> getUserList() {
                return userRepository.findAll();
        }

        public User getUser(Integer id) {
                return userRepository.findById(id).get();
        }

        @Transactional(readOnly=false)
        public User saveUser(User user) {
                return userRepository.save(user);
        }

        @Transactional(readOnly=false)
        public void deleteUser(Set<Integer> id) {
                userRepository.deleteInBatch(userRepository.findAllById(id));
        }
}