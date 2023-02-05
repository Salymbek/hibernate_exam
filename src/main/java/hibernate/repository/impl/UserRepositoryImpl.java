package hibernate.repository.impl;

import hibernate.cfg.HibernateConfiguration;
import hibernate.model.InstagramAccount;
import hibernate.model.Post;
import hibernate.model.User;
import hibernate.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class UserRepositoryImpl implements UserRepository {
    private final EntityManager entityManager =  HibernateConfiguration.getEntityManagerFactory().createEntityManager();


    @Override
    public void saveUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public User getUserById(Long id) {
        entityManager.getTransaction().begin();
        User result = entityManager.createQuery(
                "select p from User p where p.id = ?1",User.class).setParameter(1, id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    @Override
    public String deleteUser(Long userId) {
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class,userId);
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        entityManager.close();
        return user.getFullName()+" has been deleted...";
    }

    @Override
    public User updateUser(Long id, User user) {
        entityManager.getTransaction().begin();
        User user1 = entityManager.find(User.class, id);
        user1.setFullName(user1.getFullName());
        entityManager.merge(user1);
        entityManager.getTransaction().commit();
        entityManager.close();
        return user1;
    }
}
