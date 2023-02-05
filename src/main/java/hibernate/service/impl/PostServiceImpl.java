package hibernate.service.impl;

import hibernate.model.InstagramAccount;
import hibernate.model.Post;
import hibernate.repository.PostRepository;
import hibernate.repository.impl.PostRepositoryImpl;
import hibernate.service.PostService;

public class PostServiceImpl implements PostService {

    PostRepository repository = new PostRepositoryImpl();


    @Override
    public void savePost(Post post) {
        repository.savePost(post);
    }

    @Override
    public Post getPostById(Long postId) {
        return repository.getPostById(postId);
    }

    @Override
    public String deletePost(Long postId) {
        return repository.deletePost(postId);
    }

    @Override
    public Post updatePost(Long id, Post post) {
        return repository.updatePost(id,post);
    }
}
