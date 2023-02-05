package hibernate.repository.impl;

import hibernate.cfg.HibernateConfiguration;
import hibernate.model.InstagramAccount;
import hibernate.repository.InstagramAccountsRepository;
import jakarta.persistence.EntityManager;

public class InstagramAccountRepositoryImpl implements InstagramAccountsRepository {
    private final EntityManager entityManager =  HibernateConfiguration.getEntityManagerFactory().createEntityManager();

    @Override
    public void saveInstagramAkk(InstagramAccount instagramAccount) {
        entityManager.getTransaction().begin();
        entityManager.persist(instagramAccount);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public InstagramAccount getInstagramById(Long instagramId) {
        entityManager.getTransaction().begin();
        InstagramAccount result = entityManager.createQuery(
                "select p from InstagramAccount p where p.id = ?1",InstagramAccount.class).setParameter(1, instagramId).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    @Override
    public String deleteInstagramAkk(Long instagramId) {
        entityManager.getTransaction().begin();
        InstagramAccount instagramAccount = entityManager.find(InstagramAccount.class,instagramId);
        entityManager.remove(instagramAccount);
        entityManager.getTransaction().commit();
        entityManager.close();
        return instagramAccount.getUserName()+" has been deleted...";
    }

    @Override
    public InstagramAccount updateInstagramAkk(Long id, InstagramAccount instagramAccount) {
        entityManager.getTransaction().begin();
        InstagramAccount instagramAccount1 = entityManager.find(InstagramAccount.class,id);
        instagramAccount1.setUserName(instagramAccount1.getUserName());
        entityManager.merge(instagramAccount1);
        entityManager.getTransaction().commit();
        entityManager.close();
        return instagramAccount1;
    }

    @Override
    public Boolean existByEmail(String email) {
        entityManager.getTransaction().begin();
        Boolean trueOrFalse = entityManager.createQuery("""
                select 
                case when count (p) > 0 
                then  true 
                else false 
                end 
                from InstagramAccount p 
                where p.login = :newEmail     
                """, Boolean.class).setParameter("newEmail",email)
                .getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return trueOrFalse;
    }

    @Override
    public InstagramAccount changePassword(Long id, String password) {
        entityManager.getTransaction().begin();
        InstagramAccount insta = entityManager.createQuery("""
                        select p  
                        from InstagramAccount p
                                    
                        where p.id = :id
                        """, InstagramAccount.class).setParameter("id", id)
                .getSingleResult();

        insta.setPassword(password);

        entityManager.getTransaction().commit();
        entityManager.close();
        return insta;
    }


}
