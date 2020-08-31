package com.wechall.admin.domain.post.controller.api;

import com.wechall.admin.domain.post.model.dto.NewPostDto;
import com.wechall.admin.domain.post.model.dto.PostContentChangeDto;
import com.wechall.admin.domain.post.model.dto.PostDetailDto;
import com.wechall.admin.domain.post.model.entity.Post;
import com.wechall.admin.domain.post.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/post")
public class PostApiController {

    private final PostService postService;

    public PostApiController(final PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/all")
    public String getAllPosts() {
        return postService.getPostList().toString();
    }

    @GetMapping("/{postId}")
    public PostDetailDto getPostDetail(@PathVariable Long postId){
        return postService.getPostDetail(postId);
    }

    @PostMapping("/search")
    public String searchByDynamicCondition(@RequestBody Post post){
        return postService.searchByConditions(post).toString();
    }

    @PostMapping("/new")
    public String registPost(@RequestBody NewPostDto newPost) {
        log.info(newPost.toString());
        return postService.createPost(newPost).toString();
    }

    @DeleteMapping("/{postId}")
    public String deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return "deleted";
    }

    @PutMapping("/modify")
    public String modifyPostContents(@RequestBody PostContentChangeDto post){
        return postService.modifyContents(post).toString();
    }

    
}