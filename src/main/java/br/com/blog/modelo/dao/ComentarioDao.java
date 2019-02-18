package br.com.blog.modelo.dao;

import br.com.blog.modelo.Comentario;
import br.com.blog.modelo.Topico;
import br.com.blog.modelo.Usuario;

import java.util.Calendar;
import java.util.List;

public class ComentarioDao extends ObjectDao {
    public void insertCarregaTopico(int id, String txt, Usuario usuarioSession) {
        try {
            em.getTransaction().begin();
            Comentario comentario = new Comentario();

            Topico topico = em.find(Topico.class, id);
            comentario.setTopicoComentario(topico);

            Usuario usuario = em.find(Usuario.class, usuarioSession.getId());
            if(!topico.isComentado()){
                topico.setComentado(true);
            }
            comentario.setUsuarioDonoComentario(usuario);
            comentario.setDateEhora(Calendar.getInstance());
            comentario.setTxt(txt);
            em.persist(comentario);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public List<Comentario> CarregaComentariosPorIDTopico(int id) {
        try {
            em.getTransaction().begin();

            List comentarios;
            comentarios =  em.createQuery("select c from comentario c where c.topicoComentario.id = :id").setParameter("id", id).getResultList();

            em.getTransaction().commit();
            return comentarios;
        } catch (Exception e) {
            return null;
        }
    }

    public void deletaPorId(int id) {
        em.getTransaction().begin();
        Comentario topico = em.find(Comentario.class,id);
        em.remove(topico);
        em.getTransaction().commit();
    }
}
