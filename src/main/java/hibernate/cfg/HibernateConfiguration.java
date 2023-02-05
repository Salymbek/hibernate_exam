package hibernate.cfg;

import hibernate.model.InstagramAccount;
import hibernate.model.Post;
import hibernate.model.User;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateConfiguration {
    public static SessionFactory getSessionFactory() {
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/examen");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "postgres");

        properties.put(Environment.HBM2DDL_AUTO, "update");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.SHOW_SQL, "true");

        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(InstagramAccount.class);
        configuration.addAnnotatedClass(Post.class);
        configuration.addAnnotatedClass(User.class);

        return configuration.buildSessionFactory();
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        final SessionFactory sessionFactory = getSessionFactory();
        return sessionFactory.unwrap(EntityManagerFactory.class);
    }
}
