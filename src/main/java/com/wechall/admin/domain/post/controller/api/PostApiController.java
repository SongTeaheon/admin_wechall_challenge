package com.wechall.admin.domain.post.controller.api;

import com.wechall.admin.domain.post.model.entity.Post;
import com.wechall.admin.domain.post.service.PostService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/post")
public class PostApiController {

    private static final Logger log = LoggerFactory.getLogger(PostApiController.class);
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
        log.info(post.toString());
        return postService.createPost(post).toString();
    }
}