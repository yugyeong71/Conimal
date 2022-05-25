package com.example.api_conimal.post.model;

import com.example.api_conimal.user.model.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Builder
@AllArgsConstructor @NoArgsConstructor
public class PostLike {
    @Id @GeneratedValue
    private Integer postLike;

    @ManyToOne
    @JoinColumn(name = "postId")
    private Post postId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User userId;

    private LocalDate date;

}
