/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import java.time.LocalDateTime;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leyteris
 */
@Service
public class HomeService {

    
    public String getWelcomeMessage() {
        LocalDateTime time = LocalDateTime.now();
        String message = "Welcome to my app. Time is " + time;
        return message;
    }
    
    public String getApplicationName() {
        return "Application name: MySpringMVC";
    }
}
