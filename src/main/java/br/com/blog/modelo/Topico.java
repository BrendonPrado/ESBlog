package br.com.blog.modelo;

import javax.persistence.*;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

@Entity
public class Topico  {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="txt",columnDefinition="Text",nullable=false)
	private String txt;


	public int getId() {
		return id;
	}

	public boolean isComentado() {
		return comentado;
	}

	@OneToMany()
	@JoinColumn(nullable = true)
	private List<Comentario> comentarios;

	@Column(name="titulo",nullable = false,unique=true)
	private String titulo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idUsuario",nullable = false)
	private Usuario usuarioDono;

	private Calendar dateEhora;

	//true = foi comentado, false = não comentado;
	private boolean comentado;
	public Topico(String txt, String titulo,  Calendar dateEhora) {
		this.txt = txt;
		this.titulo = titulo;
		this.dateEhora = dateEhora;
	}

	public Topico(String txt,String titulo) {
		this.txt = txt;
		this.titulo = titulo;
	}


	public void setUsuarioDono(Usuario usuarioDono) {
		this.usuarioDono = usuarioDono;
	}

	public void setDateEhora(Calendar dateEhora) {
		this.dateEhora = dateEhora;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Topico() {
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public Usuario getUsuarioDono() {
		return usuarioDono;
	}

	public Calendar getDateEhora() {
		return dateEhora;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public void setComentado(boolean comentado) {
		this.comentado = comentado;
	}
}