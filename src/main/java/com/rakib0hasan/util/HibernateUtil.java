package com.rakib0hasan.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.rakib0hasan.model.Course;
import com.rakib0hasan.model.Student;

public class HibernateUtil {
    
    private static SessionFactory sessionFactory;
    
    static {
        StandardServiceRegistry registry = null;
        try {
            // Create registry (Instead of hibernate.cfg.xml)
            registry = new StandardServiceRegistryBuilder()
                    .applySetting("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                    .applySetting("hibernate.connection.url", "jdbc:mysql://localhost:3306/scms")
                    .applySetting("hibernate.connection.username", "root")
                    .applySetting("hibernate.connection.password", "rakibhasan")
                    .applySetting("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect")
                    .applySetting("hibernate.hbm2ddl.auto", "update")
                    .applySetting("hibernate.show_sql", "true")
                    .applySetting("hibernate.format_sql", "true")
                    .build();
            
            // Register entity classes
            MetadataSources sources = new MetadataSources(registry);
            sources.addAnnotatedClass(Student.class);
            sources.addAnnotatedClass(Course.class);
            
            // Build SessionFactory
            Metadata metadata = sources.getMetadataBuilder().build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();
            
        } catch (Exception e) {
            e.printStackTrace();
            if (registry != null) {
                StandardServiceRegistryBuilder.destroy(registry);
            }
            throw new RuntimeException("Failed to initialize Hibernate SessionFactory", e);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
