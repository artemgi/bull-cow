package com.example.bullcow.entities;




import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Data
@Table(name = "games")
public class Games {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long game_id;
//    @Column(name = "user_id")
//    private Long user_id;

    private String hidden_number;

    private Long score;

    private String date;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


}

