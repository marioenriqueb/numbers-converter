package com.exercise.security.filter;

import com.exercise.security.user.DummyUser;
import com.exercise.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authManager;
    private UserService userService;

    /**
     * Listen for auth path on url
     * @param authManager
     */
    public AuthenticationFilter(AuthenticationManager authManager,
                                UserService userService) {
        this.authManager = authManager;
        this.userService = userService;
    }

    @Override
    protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
        return true;
    }

    /**
     *  Get credentials from request
     *  Create auth object (contains credentials) which will be used by auth manager
     *  Authentication manager authenticate the user, and use UserDetialsServiceImpl::loadUserByUsername() method to load the user
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        DummyUser creds = readBasicAuthorization(request);
        String username = creds.getUsername();
        String password = creds.getPassword();
        Authentication authToken = new UsernamePasswordAuthenticationToken(username, password, Collections.EMPTY_LIST);
        try {
            return authManager.authenticate(authToken);
        } catch (AuthenticationException ex) {
            throw ex;
        }
    }

    /**
     * Generate token if success auth
     * @param request
     * @param response
     * @param chain
     * @param auth
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication auth)
            throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(auth);
        chain.doFilter(request, response);
    }

    private DummyUser readBasicAuthorization(HttpServletRequest request) {
        final String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        DummyUser creds = new DummyUser();

        if (authorization != null && authorization.toLowerCase().startsWith("basic")) {
            // Authorization: Basic base64credentials
            String base64Credentials = authorization.substring("Basic".length()).trim();
            byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(credDecoded, StandardCharsets.UTF_8);
            // credentials = username:password
            final String[] values = credentials.split(":", 2);
            if (values.length > 1) {
                creds.setUsername(values[0]);
                creds.setPassword(values[1]);
            }
        }

        return creds;
    }
}
