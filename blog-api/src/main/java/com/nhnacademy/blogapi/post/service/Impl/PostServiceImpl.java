package com.nhnacademy.blogapi.post.service.Impl;

import com.nhnacademy.blogapi.blog.domain.Blog;
import com.nhnacademy.blogapi.blog.exception.BlogNotFoundException;
import com.nhnacademy.blogapi.blog.repository.BlogRepository;
import com.nhnacademy.blogapi.post.domain.Post;
import com.nhnacademy.blogapi.post.dto.CommonListResult;
import com.nhnacademy.blogapi.post.dto.PostCreateRequest;
import com.nhnacademy.blogapi.post.dto.PostResponse;
import com.nhnacademy.blogapi.post.dto.PostUpdateRequest;
import com.nhnacademy.blogapi.post.exception.PostNotFoundException;
import com.nhnacademy.blogapi.post.repository.PostRepostiory;
import com.nhnacademy.blogapi.post.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class PostServiceImpl implements PostService {

    private final PostRepostiory postRepostiory;
    private final BlogRepository blogRepository;

    public PostServiceImpl(PostRepostiory postRepostiory, BlogRepository blogRepository) {
        this.postRepostiory = postRepostiory;
        this.blogRepository = blogRepository;
    }

    @Override
    public PostResponse createPost(long blogId, PostCreateRequest postCreateRequest) {

        Blog blog = blogRepository.findById(blogId).orElseThrow(()-> new BlogNotFoundException(blogId));

        Post post = new Post(
                blog,
                postCreateRequest.getTitle(),
                postCreateRequest.getContent()
        );
        Post savedPost = postRepostiory.save(post);

        return postResponseMapper(savedPost);
    }

    @Override
    @Transactional(readOnly = true) // nono dirty checking
    public PostResponse getPost(long postId) {

        Post post = postRepostiory.findById(postId).orElseThrow(()-> new PostNotFoundException(postId));

        return postResponseMapper(post);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PostResponse> getPostList(long blogId, Pageable pageable) {

        Page<Post> postPage = postRepostiory.findAllByBlog_BlogIdOrderByCreatedAtDesc(blogId, pageable);

        List<PostResponse> postResponseList = new ArrayList<>();
        for(Post post : postPage.getContent()){
            postResponseList.add(postResponseMapper(post));
        }

        /*
        postPage = select * from posts where blog_id=1 order by created_at desc limit 1,10

        postPage.getTotalElements() = select count(*) from posts where blog_id=1
        */

        return new PageImpl<>(postResponseList, pageable, postPage.getTotalElements());
    }

    @Override
    public PostResponse updatePost(long postId, PostUpdateRequest postUpdateRequest) {

        Post post = postRepostiory.findById(postId).orElseThrow(()->new PostNotFoundException(postId));

        post.update(
                postUpdateRequest.getTitle(),
                postUpdateRequest.getContent()
        );

        return postResponseMapper(post);
    }

    @Override
    public void deletePost(long postId) {
        // 권한 체크, 등...
        if(!postRepostiory.existsById(postId)){
            throw new PostNotFoundException(postId);
        }

        postRepostiory.deleteById(postId);

    }

    private PostResponse postResponseMapper(Post post){
        return new PostResponse(
                post.getPostId(),
                post.getPostTitle(),
                post.getPostContent(),
                post.getCreatedAt(),
                post.getUpdatedAt()
        );
    }

    @Override
    public CommonListResult<PostResponse> getCommonResultList(long blogId, Pageable pageable) {
        Page<Post> postPage = postRepostiory.findAllByBlog_BlogIdOrderByCreatedAtDesc(blogId, pageable);

        List<PostResponse> postResponseList = new ArrayList<>();
        for(Post post : postPage.getContent()){
            postResponseList.add(postResponseMapper(post));
        }

        /*
        postPage = select * from posts where blog_id=1 order by created_at desc limit 1,10

        postPage.getTotalElements() = select count(*) from posts where blog_id=1
        */

        return new CommonListResult<>(postResponseList, postPage.getTotalElements(), postPage.getTotalPages());
    }
}










