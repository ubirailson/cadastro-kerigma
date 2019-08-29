package org.comshalom.cadastro.kerigma.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@javax.persistence.Table(name="pessoa")
//@org.hibernate.annotations.Table(appliesTo = "pessoa", 
//	indexes = { @Index(name="nome_nascimento_unique_index", columnNames={"nome","nascimento"})}
//)
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoaGenerator")
	@SequenceGenerator(name = "pessoaGenerator", sequenceName = "SQ_PESSOA", allocationSize = 1)
	@Column(name="id_pessoa",nullable = false)
	private Long id;

	@NotBlank
	@Column(nullable = false, name="nome")
	private String nome;

	@Column(nullable = true, name="fone")
	private String fone;

	@Email(message="Formato de email inválido.")
	@Column(nullable = true, name="email")
	private String email;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_municipio", nullable = false)
    private Municipio municipio;

	@Column(nullable = true, name="bairro")
	private String bairro;

	@NotNull
	@Column(nullable = false, name="nascimento")
	@Temporal(TemporalType.DATE)
	private Date nascimento;

	@Column(nullable = false, name="sexo")
	private String sexo;

	@NotBlank
	@Column(nullable = false, name="comosoubedoevento")
	private String comoSoubeDoEvento;

	@Column(nullable = false, name="outromovimento")
	private Boolean outroMovimento;

	@Column(nullable = false, name="frequentamissa")
	private Boolean frequentaMissa;

	@Column(nullable = false, name="shalom")
	private Boolean shalom;

	@Column(nullable = false, name="outrareligiao")
	private Boolean outraReligiao;

	@Column(nullable = false, name="datacadastro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;
	
	public Pessoa() {
		super();
		nome = "";
		fone = "";
		email = "";
		bairro = "";
		comoSoubeDoEvento = "";
		
		municipio = new Municipio();
		dataCadastro = new Date();
	}

	public Pessoa(Long id, String nome, String fone, String email,
			Municipio municipio, String bairro, Date nascimento, String sexo,
			String comoSoubeDoEvento, Boolean outroMovimento,
			Boolean frequentaMissa, Boolean shalom, Boolean outraReligiao) {
		super();
		this.id = id;
		this.nome = nome;
		this.fone = fone;
		this.email = email;
		this.municipio = municipio;
		this.bairro = bairro;
		this.nascimento = nascimento;
		this.sexo = sexo;
		this.comoSoubeDoEvento = comoSoubeDoEvento;
		this.outroMovimento = outroMovimento;
		this.frequentaMissa = frequentaMissa;
		this.shalom = shalom;
		this.outraReligiao = outraReligiao;
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

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getComoSoubeDoEvento() {
		return comoSoubeDoEvento;
	}

	public void setComoSoubeDoEvento(String comoSoubeDoEvento) {
		this.comoSoubeDoEvento = comoSoubeDoEvento;
	}

	public Boolean getOutroMovimento() {
		return outroMovimento;
	}

	public void setOutroMovimento(Boolean outroMovimento) {
		this.outroMovimento = outroMovimento;
	}

	public Boolean getFrequentaMissa() {
		return frequentaMissa;
	}

	public void setFrequentaMissa(Boolean frequentaMissa) {
		this.frequentaMissa = frequentaMissa;
	}

	public Boolean getShalom() {
		return shalom;
	}

	public void setShalom(Boolean shalom) {
		this.shalom = shalom;
	}

	public Boolean getOutraReligiao() {
		return outraReligiao;
	}

	public void setOutraReligiao(Boolean outraReligiao) {
		this.outraReligiao = outraReligiao;
	}
	
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		if (nascimento != null) {
			result = prime * result + nascimento.hashCode();
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
			if (obj instanceof Pessoa) {
				Pessoa other = (Pessoa) obj;
				if (nascimento == null || nome == null
						|| other.nascimento == null || other.nome == null) {
					equal = false;
				} else {
					equal = nascimento.equals(other.nascimento)
							&& nome.equals(other.nome);
				}
			} else {
				equal = false;
			}
		}

		return equal;

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append(this.getClass().getSimpleName());
		builder.append(" {\n");
		builder.append(String.format("id: %s\n", id));
		builder.append(String.format("nome: %s\n", nome));
		builder.append(String.format("nascimento: %s\n", nascimento));
		builder.append(String.format("fone: %s\n", fone));
		builder.append(String.format("email: %s\n", email));
		builder.append(String.format("municipio: %s\n", municipio));
		builder.append(String.format("bairro: %s\n", bairro));
		builder.append(String.format("sexo: %s\n", sexo));
		builder.append(String.format("comoSoubeDoEvento: %s\n",
				comoSoubeDoEvento));
		builder.append(String.format("outroMovimento: %s\n", outroMovimento));
		builder.append(String.format("frequentaMissa: %s\n", frequentaMissa));
		builder.append(String.format("shalom: %s\n", shalom));
		builder.append(String.format("outraReligiao: %s\n", outraReligiao));
		builder.append("}");

		return builder.toString();

	}

}
