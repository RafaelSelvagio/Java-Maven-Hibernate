package model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id_professor")
	private Integer id;
	@Column(name = "nome_professor")
	private String nome;
	@Column(name = "especialidade_professor")
	private String especialidade;
	@Column(name = "data_admissao_professor")
	private String dataDeAdmissao;
	
	public Professor() {
	}
	
	public Professor(String nome, String especialidade, String dataDeAdmissao) {
		this.id = null;
		this.nome = nome;
		this.especialidade = especialidade; 
		this.dataDeAdmissao = dataDeAdmissao;
	}

	//Getters and Setters
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

	public String getDataDeAdmissao() {
		return dataDeAdmissao;
	}

	public void setDataDeAdmissao(String dataDeAdmissao) {
		this.dataDeAdmissao = dataDeAdmissao;
	}

	public Integer getId() {
		return id;
	}

	//hashcode e equals
	@Override
	public int hashCode() {
		return Objects.hash(dataDeAdmissao, especialidade, nome);
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
		return Objects.equals(dataDeAdmissao, other.dataDeAdmissao)
				&& Objects.equals(especialidade, other.especialidade) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", nome=" + nome + ", especialidade=" + especialidade + ", dataDeAdmissao="
				+ dataDeAdmissao + "]";
	}
	
}
