package br.com.blog.modelo;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Calendar;

@Entity(name = "comentario")
public class Comentario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="txt",columnDefinition="TEXT",nullable=false)
	private String txt;

	@ManyToOne
	@JoinColumn(nullable = false,name = "idUsuario")
	private Usuario usuarioDonoComentario;

	@ManyToOne
	@JoinColumn(nullable = false,name = "idTopico" )
	private Topico topicoComentario;


	public Calendar dateEhora;

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public void setUsuarioDonoComentario(Usuario usuarioDonoComentario) {
		this.usuarioDonoComentario = usuarioDonoComentario;
	}

	public void setTopicoComentario(Topico topicoComentario) {
		this.topicoComentario = topicoComentario;
	}

	public void setDateEhora(Calendar dateEhora) {
		this.dateEhora = dateEhora;
	}
}