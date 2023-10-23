package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Professor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "especialidade")
	private String especialidade;
	
	@Column(name = "data_admissao")
	private Date dataAdmissao;
	
	
	public Professor() {}

	public Professor(Integer id, String nome, String especialidade, Date dataAdmissao) {
		this.id = id;
		this.nome = nome;
		this.especialidade = especialidade;
		this.dataAdmissao = dataAdmissao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataAdmissao, especialidade, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		return Objects.equals(dataAdmissao, other.dataAdmissao) && Objects.equals(especialidade, other.especialidade)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", nome=" + nome + ", especialidade=" + especialidade + ", dataAdmissao="
				+ dataAdmissao + "]";
	}
}
