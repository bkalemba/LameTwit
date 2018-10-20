package pl.bkalemba.lametwit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.bkalemba.lametwit.beans.TweetRepository;
import pl.bkalemba.lametwit.model.Tweet;
import pl.bkalemba.lametwit.model.User;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
public class TweetController {

    @Autowired
    private TweetRepository tweetRepository;

    @PostMapping("/")
    public String handleTweet(@Valid @ModelAttribute Tweet tweet, BindingResult result, HttpSession session){
        if(!result.hasErrors()) {
            tweet.setUser((User) session.getAttribute("currentUser"));
            tweet.setCreated(LocalDateTime.now().toString());
            tweetRepository.save(tweet);
        } else {
            return "homepage";
        }
        return "redirect:/";
    }
}
