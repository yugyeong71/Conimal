package com.example.api_conimal.post.controller;

import com.example.api_conimal.common.SuccessResponse;
import com.example.api_conimal.post.model.Post;
import com.example.api_conimal.post.model.PostLike;
import com.example.api_conimal.post.repository.PostLikeRepository;
import com.example.api_conimal.user.model.User;
import com.example.api_conimal.user.model.dto.SignUpForm;
import com.example.api_conimal.post.repository.PostRepository;
import com.example.api_conimal.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDate;


@RestController
@RequiredArgsConstructor
public class PostLikeController {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PostLikeRepository postLikeRepository;

    @PostMapping("/post/like/{postId}") // 게시글 좋아요
    @Transactional
    public SuccessResponse postLike(@RequestParam("userId") Integer userId, @PathVariable Integer postId){

        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("aaa"));
        Post post = postRepository.findById(postId).orElseThrow(()->new RuntimeException("bbb"));

        PostLike postLike = PostLike.builder()
                .userId(user)
                .postId(post)
                .date(LocalDate.now())
                .build();
        post.postLikeAdd1();
        postLikeRepository.save(postLike);

        SuccessResponse<PostLike> successResponse = new SuccessResponse<PostLike>("좋아요 눌림");

        return successResponse;
    }
}
