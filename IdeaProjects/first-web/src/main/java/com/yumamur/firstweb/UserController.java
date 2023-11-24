package com.yumamur.firstweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PutMapping("/update/{username}")
    private ResponseEntity<?> updateUser
            (@PathVariable String username, @RequestBody User userDetails) {
        int ctl = userService.updateUser(username, userDetails);
        if (ctl == UserService.SUCCESS)
            return new ResponseEntity<>("Successful", HttpStatus.OK);
        else if (ctl == UserService.NON_EXISTING_USER)
            return new ResponseEntity<>("User does not exists", HttpStatus.OK);
        else
            return new ResponseEntity<>("Failure", HttpStatus.OK);
    }

    @PutMapping("/add")
    private ResponseEntity<?> addUser(@RequestBody User userDetails) {
        int ctl = userService.addUser(userDetails);
        if (ctl == UserService.SUCCESS)
            return new ResponseEntity<>("Successful", HttpStatus.OK);
        else if (ctl == UserService.EXISTING_USER)
            return new ResponseEntity<>("User Exists", HttpStatus.OK);
        else
            return new ResponseEntity<>("Failure", HttpStatus.OK);
    }

    @GetMapping("/get")
    private ResponseEntity<?> getUser(
            @RequestParam(required = false) String username,
            HttpServletRequest request)
    {
        if (username == null ) {
            return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
        } else {
            User user = userService.getByUsername(username);
            if (user != null) {
                return new ResponseEntity<>(user.infoString(), HttpStatus.OK);
            } else {
                try {
                    return ImageController.getImage("images/not_existing.png");
                } catch (IOException e) {
                    return new ResponseEntity<>("User not found", HttpStatus.OK);
                }
            }
        }
    }
    @GetMapping("/status")
    private ResponseEntity<?> status(
            HttpServletRequest request) {

        String requestBody = "{\"param\":\"" + request.toString() + "\"}";

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, requestHeaders);

        RestTemplate template = new RestTemplate();

        ResponseEntity<String> responseEntity = template.postForEntity("http://localhost:8081/", requestEntity, String.class);

        System.out.println(responseEntity.getStatusCode());
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "text/plain")
                .body(responseEntity.getBody());
    }
}