package com.example.bullcow.controllers;

import com.example.bullcow.entities.Games;
import com.example.bullcow.entities.User;
import com.example.bullcow.services.GamesService;
import com.example.bullcow.services.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Controller
public class MainController {
    @Autowired
    private UserService userService;
    @Autowired
    private GamesService gamesService;

    @Autowired
    public MainController(UserService userService, GamesService gamesService) {
        this.userService = userService;
        this.gamesService = gamesService;
    }

    @GetMapping("/profile")
    public String pageProfile(Model model){
        //парсинг игр текущего пользователя
        List<Games> games = gamesService.findUserGames();
        model.addAttribute("games", games);
        //парсинг игр всех пользователей
        List<Games> allGames = gamesService.findAll();
        //Создание списка польсзователей с сумой ходов
        Map<String, Double> stepUser = new HashMap<String, Double>();
        Map<String, Integer> amountGame = new HashMap<String, Integer>();

        for (Games rating : allGames) {
            if(stepUser.containsKey(rating.getUser().getUsername())){
                stepUser.put(rating.getUser().getUsername(),stepUser.get(rating.getUser().getUsername())+rating.getScore());
                amountGame.put(rating.getUser().getUsername(),amountGame.get(rating.getUser().getUsername())+1);
            }
            else{
                stepUser.put(rating.getUser().getUsername(), Double.valueOf(rating.getScore()));
                amountGame.put(rating.getUser().getUsername(),1);
            }
        }
        for (Map.Entry<String, Double> entry : stepUser.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            entry.setValue(entry.getValue()/amountGame.get(key));
        }

        model.addAttribute("rating", stepUser);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());
        model.addAttribute("user", user);
        return "pageProfile";
    }

    @GetMapping("/admin")
    public String pageAdmin(){
        return "pageAdmin";
    }

    @GetMapping("/game")
    public String pageGame(){
        return "pageGame";
    }

    @GetMapping("/history")
    public String pageHistory(){
        return "pageHistory";
    }

    @PostMapping("/saveGame")
    public String createUser(@RequestBody Games game) throws JSONException {
        System.out.println("Сохранение игры");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());
        gamesService.saveGame(user,game);
        return "redirect:/profile";
    }
}
