package br.com.blog.modelo.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ObjectDao {
    protected static EntityManager em;
    private static  final EntityManagerFactory  emf = Persistence.createEntityManagerFactory("blog");;

    public ObjectDao(){
        this.em = emf.createEntityManager();
    }

    public void Insert(Object object){

        em.getTransaction().begin();

        em.persist(object);

        em.getTransaction().commit();

    }

    public void fechaConexao(){
        em.close();
        emf.close();
    }


}
