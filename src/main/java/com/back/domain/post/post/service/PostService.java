package com.back.domain.post.post.service;

import com.back.domain.post.post.document.Post;
import com.back.domain.post.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

  // 전체 조회
  public List<Post> findAll() {
    return postRepository.findAll();
  }

  // 단건 조회
  public Optional<Post> findById(String id) {
    return postRepository.findById(id);
  }
}
