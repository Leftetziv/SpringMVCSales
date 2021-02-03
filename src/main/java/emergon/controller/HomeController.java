package emergon.controller;

import emergon.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")    //auto to url tha klironomithei apo oles tis methodous tou controller
public class HomeController {
    
    @Autowired
    private HomeService homeService;
    
    @RequestMapping("/")
    public String showHome(Model model){ //model: implecit antikemeno pou mou to dinei to spring gia na xeirizomai model

        String message = homeService.getWelcomeMessage();
        
        model.addAttribute("mymessage", message);
        
        return "home";//This method returns the name of the jsp page.
    }
    
    @RequestMapping("/appName") //to url pou akouei auti i methodos
    public String showNameOfApplication(Model model) {
        
        String message = homeService.getApplicationName();
        
        model.addAttribute("mymessage", message);
        
        return "home";
    }
}
