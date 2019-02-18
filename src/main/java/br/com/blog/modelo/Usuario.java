package br.com.blog.modelo;

import javax.persistence.*;


@Entity(name="usuario")
public class Usuario{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name="nome",nullable=false,unique=true)
	private String nome;
	
	@Column(name="senha",nullable=false,unique=true)
	private String senha;

	@Column(name="email",nullable = false,unique=true)
	private String email;
	
	@Column(name="apelido",nullable=false,unique=true)
	private String apelido;

	@Enumerated(EnumType.STRING)
	private TipoDeUsuario tipoDeUsuario;


	public Usuario(String nome, String senha, String email, String apelido) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.apelido = apelido;
		this.tipoDeUsuario = TipoDeUsuario.Cadastrado;
	}

	public Usuario(){
	    super();
    }


    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public String getApelido() {
        return apelido;
    }


	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoDeUsuario getTipoDeUsuario() {
		return tipoDeUsuario;
	}

	public void setTipoDeUsuario(TipoDeUsuario tipoDeUsuario) {
		this.tipoDeUsuario = tipoDeUsuario;
	}
}
