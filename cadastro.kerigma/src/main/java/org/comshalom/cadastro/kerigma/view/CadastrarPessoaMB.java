package org.comshalom.cadastro.kerigma.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.comshalom.cadastro.kerigma.domain.Municipio;
import org.comshalom.cadastro.kerigma.domain.Pessoa;
import org.comshalom.cadastro.kerigma.persistence.MunicipioDAO;
import org.comshalom.cadastro.kerigma.persistence.PessoaDAO;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
public class CadastrarPessoaMB  {

	private static final long serialVersionUID = 1L;
	
	private Pessoa pessoa;
	
	private List<Municipio> municipios;
	
	@Inject
    private FacesContext contexto;
	
	@Inject
	PessoaDAO daoPessoa;
	
	@Inject
	MunicipioDAO daoMunicipio;
	
	public CadastrarPessoaMB(){
		
	}

	@PostConstruct
	public void iniciar(){
		municipios = daoMunicipio.findOrderByNome();
		pessoa = new Pessoa();
	}
		
	@Transactional
	public void cadastrar() {
		try{
			pessoa.setNome(pessoa.getNome().toUpperCase());
			pessoa.setBairro(pessoa.getBairro().toUpperCase());
			if(daoPessoa.estaRepetindoNomeNascimento(pessoa)){
				addMensagemErro("Já existe alguém com este nome e data de nascimento no sistema.");
			}else{
				daoPessoa.insert(pessoa);
				addMensagemSucesso("Dados de "+pessoa.getNome()+" cadastrados com sucesso!");
				pessoa  = new Pessoa();
			}
		}catch (Exception e) {
			addMensagemErro("Erro na inserção dos dados");
			System.out.println(e);
		}
	}


	protected void addMensagemSucesso(String msg) {

        FacesMessage facesMessage = new FacesMessage(msg);
        addMensagem(facesMessage);
    }
	
	/**
     * Adiciona uma mensagem de erro de acordo com o texto passado.
     * 
     * @param msg
     *            Mensagem a ser exibida
     */
    protected void addMensagemErro(String msg) {

        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        addMensagem(facesMessage);
    }

	
	/**
     * Adiciona a mensagem passada no contexto. Não adiciona mensagens já inseridas na lista.
     * 
     * @param facesMessage
     *            mensagem a ser adicionada
     */
    private void addMensagem(FacesMessage facesMessage) {

        List<FacesMessage> messageList = contexto.getMessageList();

        boolean existe = false;

        if (messageList != null && !messageList.isEmpty()) {
            for (FacesMessage m : messageList) {
                if (m.getDetail().equals(facesMessage.getDetail())
                    && m.getSummary().equals(facesMessage.getSummary())
                    && m.getSeverity().equals(facesMessage.getSeverity())) {
                    existe = true;
                    break;
                }
            }
        }

        if (!existe) {
            contexto.addMessage(null, facesMessage);
        }
    }
	
	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public List<Municipio> getMunicipios() {
		return municipios;
	}


	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}


}
