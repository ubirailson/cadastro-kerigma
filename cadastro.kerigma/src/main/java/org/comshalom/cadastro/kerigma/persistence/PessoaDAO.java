package org.comshalom.cadastro.kerigma.persistence;

import java.util.List;

import javax.persistence.Query;

import org.comshalom.cadastro.kerigma.domain.Pessoa;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class PessoaDAO extends JPACrud<Pessoa, Long> {
	
	private static final long serialVersionUID = 1L;
	
	public boolean estaRepetindoNomeNascimento(Pessoa obj){
		boolean retorno = false;
		Query query = createQuery("select this from Pessoa this where this.nome = :nome and this.nascimento = :nascimento ");
		query.setParameter("nome",obj.getNome());
		query.setParameter("nascimento",obj.getNascimento());
		List<Pessoa> lista = query.getResultList();
		if(lista!=null && lista.size()>0){
			retorno = true;
		}
		
		return retorno;
	}
}
