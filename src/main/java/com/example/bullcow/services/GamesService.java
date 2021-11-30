package com.example.bullcow.services;

import com.example.bullcow.entities.Games;
import com.example.bullcow.entities.Role;
import com.example.bullcow.entities.User;
import com.example.bullcow.repositories.GamesRepository;
import com.example.bullcow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
@Component("gamesDetailsService")
public class GamesService {
    @Autowired
    private GamesRepository gamesRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Games> findAll(){
        return gamesRepository.findAll();
    }
    public List<Games> findUserGames(){
       Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       User user = userRepository.findByUsername(auth.getName());
       return gamesRepository.findByUser_id(user.getId());
    }


    public boolean saveGame(User user, Games game) {
        game.setScore(game.getScore());
        game.setUser(user);
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        game.setDate(format.format(date));
        gamesRepository.save(game);
        return true;
    }
}
