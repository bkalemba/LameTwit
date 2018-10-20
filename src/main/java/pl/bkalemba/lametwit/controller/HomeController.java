package pl.bkalemba.lametwit.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.bkalemba.lametwit.beans.TweetRepository;
import pl.bkalemba.lametwit.beans.UserRepository;
import pl.bkalemba.lametwit.model.Tweet;
import pl.bkalemba.lametwit.model.User;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TweetRepository tweetRepository;

    private Boolean verifyUser(HttpSession session){
        return session.getAttribute("currentUser") == null;
    }

    @ModelAttribute("tweets")
    public List<Tweet> tweets(){
        return tweetRepository.loadAllDesc();
    }

    @GetMapping({"","/"})
    public String home(Model model, HttpSession session){
        if(verifyUser(session)){
            return "redirect:/login";
        } else {
            model.addAttribute("tweet",new Tweet());
            return "homepage";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("currentUser");
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user",new User());
        return "/login/login";
    }

    @PostMapping("/login")
    public String handleLogin(@ModelAttribute User user, HttpSession session){
        User currentUser = userRepository.findByEmail(user.getEmail());
        if((currentUser != null) && BCrypt.checkpw(user.getPassword(), currentUser.getPassword())){
            session.setAttribute("currentUser",currentUser);
            return "redirect:/";
        } else {
            return "/login/login";
        }

    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user",new User());
        return "/login/register";
    }

    @PostMapping("/register")
    public String handleRegister(@Valid @ModelAttribute User user, BindingResult result, HttpSession session){
        if(result.hasErrors()){
            return "/login/register";
        } else {
            user.setEnabled(true);
            user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
            userRepository.save(user);

            return "redirect:/";
        }
    }

}
