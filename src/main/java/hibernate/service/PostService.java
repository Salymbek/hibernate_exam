package hibernate.service;

import hibernate.model.InstagramAccount;
import hibernate.model.Post;

public interface PostService {
    void savePost(Post post);
    Post getPostById (Long postId);
    String deletePost(Long postId);
    Post updatePost(Long id , Post post);

}
