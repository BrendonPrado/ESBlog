package br.com.blog.modelo.dao;

import br.com.blog.modelo.TipoDeUsuario;
import br.com.blog.modelo.Usuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class UsuarioDao  extends ObjectDao {
    public Usuario SelecionaPorNome(String nome) {
        try {
            Usuario user = (Usuario) this.em.createQuery("SELECT u from usuario u where u.nome = :nome")
                    .setParameter("nome", nome)
                    .getSingleResult();

            return user;
        } catch (Exception e) {
            return null;
        }

    }

    public Usuario SelecionaPorEmail(String email) {
        try {
            Usuario user = (Usuario) this.em.createQuery("SELECT u from usuario u where u.email = :email")
                    .setParameter("email", email)
                    .getSingleResult();


            return user;
        } catch (Exception e) {
            return null;
        }

    }


    public Usuario SelecionaPorApelido(String apelido) {
        try {
            Usuario user = (Usuario) em.createQuery("SELECT u from usuario u where u.apelido = :apelido")
                    .setParameter("apelido", apelido)
                    .getSingleResult();
            return user;
        } catch (Exception e) {
            return null;
        }

    }

    public Usuario SelecionaPorId(int id) {
        try {
            Usuario user = em.find(Usuario.class, id);
            return user;
        } catch (Exception e) {
            return null;
        }
    }
    public List<Usuario> SelecionaTodosUsuariosNaoDono() {
        try {
			@SuppressWarnings("unchecked")
			List<Usuario> user = (List<Usuario>) em.createQuery("SELECT u from usuario u where u.tipoDeUsuario = :tipoDeUsuario")
                    .setParameter("tipoDeUsuario", TipoDeUsuario.Cadastrado).getResultList();
                    
            return user;
        } catch (Exception e) {
            return null;
        }

    }

    public void DeletaPorIDUsuario(int id){
        try {
            this.em.getTransaction().begin();

            Usuario usuario = this.em.find(Usuario.class,id);
            this.em.remove(usuario);
            this.em.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e);
        }
    }

}


