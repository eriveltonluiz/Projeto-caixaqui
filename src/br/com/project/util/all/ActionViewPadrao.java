package br.com.project.util.all;

import java.io.Serializable;

import javax.annotation.PostConstruct;

public interface ActionViewPadrao extends Serializable{
	
	abstract void limparLista() throws Exception;
	
	String save() throws Exception;
	
	void saveNotReturn() throws Exception;
	
	void saveEdit() throws Exception;
	
	void excluir() throws Exception;

	String ativar() throws Exception;
	
	@PostConstruct
	String novo() throws Exception;
	
	String editar() throws Exception;

	void setarVariaveisNulas() throws Exception;
	
	void consultarEntidades() throws Exception;
	
	void statusOperaton(StatusPersistencia s) throws Exception;
	
	String redirecionarNewEntidade() throws Exception;
	
	String redirecionarFindEntidade() throws Exception;
	
	void addMsg(String msg) throws Exception;
}
