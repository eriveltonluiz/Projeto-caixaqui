package br.com.project.util.all;

import org.springframework.stereotype.Component;

@Component
public abstract class BeanViewAbstract implements ActionViewPadrao {

	private static final long serialVersionUID = 1L;

	@Override
	public void limparLista() throws Exception {

	}

	@Override
	public String save() throws Exception {
		return null;
	}

	@Override
	public void saveNotReturn() throws Exception {

	}

	@Override
	public void saveEdit() throws Exception {

	}

	@Override
	public void excluir() throws Exception {

	}

	@Override
	public String ativar() throws Exception {
		return null;
	}

	@Override
	public String novo() throws Exception {
		return null;
	}

	@Override
	public String editar() throws Exception {
		return null;
	}

	@Override
	public void setarVariaveisNulas() throws Exception {

	}

	@Override
	public void consultarEntidades() throws Exception {

	}

	@Override
	public void statusOperaton(StatusPersistencia s) throws Exception {
		Mensagens.responseOperacao(s);
	}
	
	protected void sucesso() throws Exception{
		statusOperaton(StatusPersistencia.SUCESSO);
	}
	
	protected void erro() throws Exception{
		statusOperaton(StatusPersistencia.ERRO);
	}

	@Override
	public String redirecionarNewEntidade() throws Exception {
		return null;
	}

	@Override
	public String redirecionarFindEntidade() throws Exception {
		return null;
	}
	
	@Override
	public void addMsg(String msg) {
		Mensagens.msg(msg);
	}

}
