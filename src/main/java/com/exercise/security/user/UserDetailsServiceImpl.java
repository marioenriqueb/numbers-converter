package com.exercise.security.user;

import com.exercise.dto.UserDto;
import com.exercise.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    private UserService userService;
    private BCryptPasswordEncoder encoder;

    @Autowired
    public UserDetailsServiceImpl(UserService userService, BCryptPasswordEncoder encoder) {
        this.userService = userService;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // hard coding the users. All passwords must be encoded.
        if (username != null && username.length() > 0) {
            UserDto appUser = userService.login(username);
            appUser.setPassword(this.encoder.encode(appUser.getPassword()));

            if(appUser.getNombre().equalsIgnoreCase(username)) {
                return UserDetailsUtils.convertToUserDetails(appUser);
            }
        }

        // If user not found. Throw this exception.
        throw new UsernameNotFoundException("Username: " + username + " not found");
    }

    @Autowired
    public UserService getUserService() {
        return userService;
    }
}