package br.com.blog.modelo.dao;

import br.com.blog.modelo.Topico;
import br.com.blog.modelo.Usuario;

import java.util.Calendar;
import java.util.List;

public class TopicoDao extends ObjectDao {

    public boolean insertMergeUser(String txt, String titulo, Usuario usuario) {
        try {
            em.getTransaction().begin();
            Usuario user = (Usuario) em.createQuery("select u from usuario u where u.id = :id ").setParameter("id", usuario.getId()).getSingleResult();
            Topico topico = new Topico();
            if (selecionaPorTitulo(titulo) == null){
                topico.setUsuarioDono(user);
                topico.setTitulo(titulo);
                topico.setTxt(txt);
                topico.setDateEhora(Calendar.getInstance());
                em.persist(topico);
                em.getTransaction().commit();
                return true;
            }else {
                em.getTransaction().commit();
                return false;
            }

        }catch (Exception e){
            em.getTransaction().commit();
            System.out.println(e);
            return false;
        }
    }

    public List<Topico> selecionaTopicosPorIndex(int comeco) {
        try {
            em.getTransaction().begin();
            List<Topico> topicos = em.createQuery("select  t from  Topico t order by t.dateEhora desc ").setFirstResult(comeco).setMaxResults(2).getResultList();
            em.getTransaction().commit();
            return topicos;
        }catch (Exception e){
            return null;
        }

    }
    public void deletaPorTopico(int id){
       try {
           em.getTransaction().begin();
           Topico topico = em.find(Topico.class,id);
           em.remove(topico);
           em.getTransaction().commit();
       }catch (Exception e){
           System.out.println(e);
       }

    }

    public Topico selecionaTopicoPorId(int id) {
        try {
            em.getTransaction().begin();
            Topico topico = em.find(Topico.class,id);
            em.getTransaction().commit();
            return topico;
        }catch (Exception e){
            return null;
        }
    }

    public boolean updateTopico(int id, String titulo, String texto) {
        try {
            em.getTransaction().begin();
            Topico topico = em.find(Topico.class,id);
            if((topico.getTitulo().equals(titulo)) && (!topico.isComentado()) ){
                topico.setTxt(texto);
                em.merge(topico);
                em.getTransaction().commit();
                return true;
            }else if(selecionaPorTitulo(titulo) == null && (!topico.isComentado())){
                topico.setTitulo(titulo);
                topico.setTxt(texto);
                em.merge(topico);
                em.getTransaction().commit();
                return true;
            }else {
                em.getTransaction().commit();
                return false;
            }
        }catch (Exception e){
            em.getTransaction();
            System.out.println(e);
            return false;
        }

    }

    public Topico selecionaPorTitulo(String titulo){
      try {
          em.getTransaction().begin();

          Topico topico = (Topico) em.createQuery("SELECT t from Topico t where t.titulo = :titulo").setParameter("titulo",titulo).getSingleResult();

          em.getTransaction().commit();
          return topico;
      }catch (Exception e){
          return null;

      }
    }
}
