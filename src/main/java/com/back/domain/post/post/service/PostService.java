package com.back.domain.post.post.service;

import com.back.domain.post.post.document.Post;
import com.back.domain.post.post.repository.PostRepository;
import com.back.global.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
  private final PostRepository postRepository;

  public long count() {
    return postRepository.count();
  }

  public Post create(String title, String content, String author) {
    Post post = new Post(title, content, author);

    return postRepository.save(post);
  }

  // 조회
  public List<Post> findAll() {
    return postRepository.findAll();
  }

  public Post findById(String id) {
    return postRepository.findById(id).orElseThrow(()->new NotFoundException("Post not found with id: " + id));
  }

  // 페이지네이션
  public Page<Post> findAll(Pageable pageable) {
    return postRepository.findAll(pageable);
  }

  // 수정
  public Post update(String id, String title, String content) {
    Post post = findById(id);
    if (title != null){
      post.setTitle(title);
    }
    if (content != null){
      post.setContent(content);
    }
    return postRepository.save(post);
  }

  // 삭제
  public void delete(String id) {
    Post post = findById(id);
    postRepository.delete(post);
  }
}
