package com.techacademy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techacademy.entity.Authentication;
import com.techacademy.repository.AuthenticationRepository;

@Service
@Transactional(readOnly=true, rollbackFor=Exception.class)
public class UserDetailService implements UserDetailsService {
        @Autowired
        private AuthenticationRepository authenticationRepository;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                Optional<Authentication> authentication = authenticationRepository.findById(username);

                if (!authentication.isPresent()) {
                        throw new UsernameNotFoundException("Exception:Username Not Found");
                }
                return new UserDetail(authentication.get().getUser());
        }
}