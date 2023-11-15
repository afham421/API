package com.firsttask.security;


import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component // ta k hm is ko kahin bhi @Autowired ker pain
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override// yeh method tb chaly ga k jab koi unauthorized person authorized api ko call kry ga
    public void commence(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, javax.servlet.ServletException {
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED , "Access is denied!!!!");

    }
}
