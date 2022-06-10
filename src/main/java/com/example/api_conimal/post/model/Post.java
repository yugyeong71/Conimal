package com.example.api_conimal.post.model;

import com.example.api_conimal.image.model.Image;
import com.example.api_conimal.user.model.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Builder
@AllArgsConstructor @NoArgsConstructor
public class Post {
    @Id @GeneratedValue
    private Integer postId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "imageId")
    private Image imageId;
    
    private Integer likeNum;

    private LocalDate createDate;

    private LocalDate editDate;

    @Column(columnDefinition = "TINYINT", length=11)
    private int isDel;

    public void postUpdate(Image imageId){
        this.imageId = imageId;
        this.editDate = LocalDate.now();
    }

    public void postLikeAdd1(){
        this.likeNum = this.likeNum + 1;
    }

    public interface PostLists{
        Integer getPostId();
        Integer getLikeNum();
    }
}
