package hibernate.repository;

import hibernate.model.InstagramAccount;
import hibernate.model.Post;

public interface PostRepository {
    void savePost(Post post);
    Post getPostById (Long postId);
    String deletePost(Long postId);
    Post updatePost(Long id , Post post);
    Post editDescription (Long id, String description);


}
