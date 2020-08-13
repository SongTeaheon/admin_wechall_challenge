package com.wechall.admin.domain.post.controller.api;

import com.wechall.admin.domain.post.model.entity.Post;
import com.wechall.admin.domain.post.service.PostService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/new")
    public String registPost(@RequestBody Post post) {
        return postService.createPost(post).toString();
    }

    @DeleteMapping("/{postId}")
    public String deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return "deleted";
    }

    @PutMapping("/{postId}")
    public String modifyPost(@PathVariable Long postId, @RequestBody Post post){
        post.setPostNo(postId);
        return postService.savePost(post).toString();
    }
}