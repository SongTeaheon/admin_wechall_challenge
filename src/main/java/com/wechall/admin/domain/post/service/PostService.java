package com.wechall.admin.domain.post.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.wechall.admin.domain.post.model.dto.NewPostDto;
import com.wechall.admin.domain.post.model.dto.PostDetailDto;
import com.wechall.admin.domain.post.model.entity.Post;
import com.wechall.admin.domain.post.model.entity.PostImg;
import com.wechall.admin.domain.post.repository.PostImgRepository;
import com.wechall.admin.domain.post.repository.PostRepository;
import com.wechall.admin.global.common.Constant;
import com.wechall.admin.global.common.ImgState;
import com.wechall.admin.global.util.ImageStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
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

    public Post createPost(NewPostDto newPost){
        if(newPost == null) {
            log.info("newPost is null");
        }
        if(newPost.getImages() == null) {
            log.info("이미지 목록이 null");
        }
        List<PostImg> imgList = null;
        Post post =  new Post(newPost.getChallengeNo(), newPost.getUserNo(), newPost.getContents());
        
        try{
            imgList = saveImgPosts(newPost.getImages(), post);
        }catch(IOException e){
            e.printStackTrace();
        }

        post.setImages(imgList);
        post = postRepository.save(post);
        for(PostImg img : imgList){
            img.setPost(post);
            postImgRepository.save(img);
        }

        return post;
    }

    public void deletePost(Long postId){
        postRepository.deleteById(postId);
    }

    public Post savePost(Post post){
        return postRepository.save(post);
    }

    public List<PostDetailDto> searchByConditions(Post post){
        return postRepository.findByDynamicCondition(post).stream()     
                                        .map(s -> new PostDetailDto(s))
                                        .collect(Collectors.toList());
    }

    public PostDetailDto getPostDetail(Long postId){
        Post post = postRepository.findByPostNo(postId);
        return new PostDetailDto(post);
    }

    private List<PostImg> saveImgPosts(List<String> pathList, Post post) throws IOException{

        List<PostImg> imgList = new ArrayList<>();
        for(String tempImgPath : pathList){
            //1. 이미지 카피
            File imgFile = imageStoreService.copyFile(tempImgPath, imageStoreService.getRealPath(Constant.IMG_PATH_POST));
            
            //2. 채번
            Long imgSeq = 1l;

            //3. 이미지 객체 생성
            PostImg postImg = PostImg.builder()
                                .imgPath(imgFile.getAbsolutePath())
                                .imgState(ImgState.OK.getImgState())
                                .seq(imgSeq)
                                .post(post)
                                .build();

            imgList.add(postImg);
        }
        return imgList;     
    }
}