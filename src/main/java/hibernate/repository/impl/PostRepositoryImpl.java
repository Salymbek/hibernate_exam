package hibernate.repository.impl;

import hibernate.cfg.HibernateConfiguration;
import hibernate.model.InstagramAccount;
import hibernate.model.Post;
import hibernate.repository.PostRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class PostRepositoryImpl implements PostRepository {
    private final EntityManager entityManager =  HibernateConfiguration.getEntityManagerFactory().createEntityManager();


    @Override
    public void savePost(Post post) {
        entityManager.getTransaction().begin();
        entityManager.persist(post);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Post getPostById(Long postId) {
        entityManager.getTransaction().begin();
        Post result = entityManager.createQuery(
                "select p from Post p where p.id = ?1", Post.class).setParameter(1, postId).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    @Override
    public String deletePost(Long postId) {
        entityManager.getTransaction().begin();
        Post post = entityManager.find(Post.class, postId);
        entityManager.remove(post);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "DELETE...";
    }

    @Override
    public Post updatePost(Long id, Post post) {
        entityManager.getTransaction().begin();
        Post post1 = entityManager.find(Post.class, id);
        post1.setImage(post1.getImage());
        entityManager.merge(post1);
        entityManager.getTransaction().commit();
        entityManager.close();
        return post1;
    }

    @Override
    public Post editDescription(Long id, String description) {
        entityManager.getTransaction().begin();
        Post post = entityManager.createQuery("""
                update 
                from Post p
                set p.description = description
                where p.id = id          
                """,Post.class).setParameter("id",id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();

        return post;
    }


}
