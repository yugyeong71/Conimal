package com.example.api_conimal.post.controller;

import com.example.api_conimal.common.SuccessResponse;
import com.example.api_conimal.post.model.Post;
import com.example.api_conimal.post.model.dto.PostForm;
import com.example.api_conimal.user.model.User;
import com.example.api_conimal.user.model.dto.SignUpForm;
import com.example.api_conimal.post.repository.PostRepository;
import com.example.api_conimal.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @PostMapping("/post/{userId}") // 게시글 등록
    @Transactional
    public SuccessResponse postUpload(@PathVariable Integer userId, @RequestBody PostForm postForm){

        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("aaa"));

        Post post = Post.builder()
                .userId(user)
                .imageId(postForm.getImg())
                .likeNum(5)
                .createDate(LocalDate.now())
                .editDate(LocalDate.now())
                .isDel(0)
                .build();
        postRepository.save(post);

        SuccessResponse<Post> successResponse = new SuccessResponse<Post>("업로드 성공");

        return successResponse;
    }

    @GetMapping("/post/list") //  게시글 목록 조회
    public List<Post.PostLists> postList(){
        // postId, userId, like num ???

        return postRepository.findAllBy();
    }

    @DeleteMapping("/post/{postId}") // 게시글 삭제
    public SuccessResponse deletePost(@PathVariable Integer postId){
        postRepository.deleteById(postId);

        SuccessResponse<Post> successResponse = new SuccessResponse<Post>("삭제 성공");

        return successResponse;
    }

    @PostMapping("/post/update/{postId}") // 게시글 수정
    @Transactional
    public SuccessResponse updatePost(@PathVariable Integer postId, @RequestBody PostForm postForm){
        Post post = postRepository.findById(postId).orElseThrow(()->new RuntimeException("aaa"));

        post.postUpdate(postForm.getImg());

        SuccessResponse<Post> successResponse = new SuccessResponse<>("게시글 수정 성공");

        return successResponse;
    }
}
