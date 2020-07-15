package br.com.project.model.classes;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.envers.Audited;

@Audited // cria uma cópia da tabela original entidade_aud
@Entity
public class Entidade implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long entidade_id;

	private String entidade_login = null;
	
	private String entidade_senha = null;
	
	private boolean entidade_inativo = false;
	
	public boolean getEntidade_inativo() {
		return entidade_inativo;
	}
	
	public void setEntidade_inativo(boolean entidade_inativo) {
		this.entidade_inativo = entidade_inativo;
	}

	public Long getEntidade_id() {
		return entidade_id;
	}

	public void setEntidade_id(Long entidade_id) {
		this.entidade_id = entidade_id;
	}

	public String getEntidade_login() {
		return entidade_login;
	}

	public void setEntidade_login(String entidade_login) {
		this.entidade_login = entidade_login;
	}

	public String getEntidade_senha() {
		return entidade_senha;
	}

	public void setEntidade_senha(String entidade_senha) {
		this.entidade_senha = entidade_senha;
	}

}
