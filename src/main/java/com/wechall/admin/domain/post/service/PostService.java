package com.wechall.admin.domain.post.service;

import java.util.List;

import com.wechall.admin.domain.post.model.dto.PostDetailDto;
import com.wechall.admin.domain.post.model.entity.Post;
import com.wechall.admin.domain.post.model.entity.PostImg;
import com.wechall.admin.domain.post.repository.PostImgRepository;
import com.wechall.admin.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PostService {


    private final PostRepository postRepository;
    private final PostImgRepository postImgRepository;
    private final ImageStoreService imageStoreService;

    public PostService(PostRepository postRepository, PostImgRepository postImgRepository, ImageStoreService imageStoreService){
        this.postRepository = postRepository;
        this.postImgRepository = postImgRepository;
        this.imageStoreService = imageStoreService;
    }

    public List<Post> getPostList(){
        return postRepository.findAll();
    }

    public Post createPost(Post post, MultipartFile[] images){

        List<PostImg> postImages = imageStoreService.saveFiles(images, post);
        post.setImages(postImages);

        Post savedPost = postRepository.save(post);
        for(PostImg img : postImages){
            postImgRepository.save(img);
        }

        return savedPost;
    }

    public void deletePost(Long postId){
        postRepository.deleteById(postId);
    }

    public Post savePost(Post post){
        return postRepository.save(post);
    }

    public List<Post> searchByConditions(Post post){
        return postRepository.findByDynamicCondition(post);
    }

    public PostDetailDto getPostDetail(Long postId){
        Post post = postRepository.findByPostNo(postId);
        return new PostDetailDto(post);
    }
}