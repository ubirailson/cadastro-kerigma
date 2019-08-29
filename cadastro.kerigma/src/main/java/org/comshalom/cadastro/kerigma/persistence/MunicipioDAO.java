package org.comshalom.cadastro.kerigma.persistence;

import java.util.List;

import org.comshalom.cadastro.kerigma.domain.Municipio;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class MunicipioDAO extends JPACrud<Municipio, Long> {
	
	private static final long serialVersionUID = 1L;

	public List<Municipio> findOrderByNome(){
		return super.findByJPQL("select this from Municipio this order by this.nome");
	}
}
