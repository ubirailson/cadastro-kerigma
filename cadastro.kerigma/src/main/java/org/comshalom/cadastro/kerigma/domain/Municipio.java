package org.comshalom.cadastro.kerigma.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="municipio")
public class Municipio implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_municipio",nullable = false)
	private Long id;
	
	@Column(nullable = false, name="nome")
	private String nome;

	public Municipio() {
		super();
		nome = "";
	}

	public Municipio(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
        int result = 1;
        if (id != null) {
            result = prime * result + id.hashCode();
        }

        if (nome != null) {
            result = prime * result + nome.hashCode();
        }
        return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean equal = true;

        if (this != obj) {
            if (obj instanceof Municipio) {
            	Municipio other = (Municipio) obj;
                if (id == null || nome == null || other.id == null || other.nome == null) {
                    equal = false;
                } else {
                    equal = id.equals(other.id) && nome.equals(other.nome);
                }
            } else {
                equal = false;
            }
        }

        return equal;
	}

	@Override
	public String toString() {
		return "Municipio [id=" + id + ", nome=" + nome + "]";
	}
	
	
}
