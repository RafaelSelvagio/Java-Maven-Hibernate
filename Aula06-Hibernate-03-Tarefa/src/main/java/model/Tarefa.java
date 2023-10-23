package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tarefa")
public class Tarefa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tarefa")
	private Integer idTarefa;

	@Column(name = "titulo", nullable = false)
	private String titulo;

	@Column(name = "descricao", nullable = false, columnDefinition = "text")
	private String descricao;

	@Column(name = "data_criacao", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	@Column(name = "data_vencimento", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataVencimento;

	@Enumerated(EnumType.STRING)
	@Column(name = "prioridade", nullable = false)
	private Prioridade prioridade;

	@Enumerated(EnumType.STRING)
	@Column(name = "estado", nullable = false)
	private Estado estado;

	public Tarefa() {
	}

	public Tarefa(String titulo, String descricao, Date dataCriacao, Date dataVencimento, Prioridade prioridade,
			Estado estado) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.dataVencimento = dataVencimento;
		this.prioridade = prioridade;
		this.estado = estado;
	}

	public Tarefa(Integer id_tarefa, String titulo, String descricao, Date dataCriacao, Date dataVencimento,
			Prioridade prioridade, Estado estado) {
		this.idTarefa = id_tarefa;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.dataVencimento = dataVencimento;
		this.prioridade = prioridade;
		this.estado = estado;
	}

	public Integer getId_tarefa() {
		return idTarefa;
	}

	public void setId_tarefa(Integer id_tarefa) {
		this.idTarefa = id_tarefa;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Tarefa{" + "id_tarefa=" + idTarefa + ", titulo='" + titulo + '\'' + ", descricao='" + descricao + '\''
				+ ", dataCriacao=" + dataCriacao + ", dataVencimento=" + dataVencimento + ", prioridade=" + prioridade
				+ ", estado=" + estado + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Tarefa tarefa = (Tarefa) o;

		if (idTarefa != null ? !idTarefa.equals(tarefa.idTarefa) : tarefa.idTarefa != null)
			return false;
		if (titulo != null ? !titulo.equals(tarefa.titulo) : tarefa.titulo != null)
			return false;
		if (descricao != null ? !descricao.equals(tarefa.descricao) : tarefa.descricao != null)
			return false;
		if (dataCriacao != null ? !dataCriacao.equals(tarefa.dataCriacao) : tarefa.dataCriacao != null)
			return false;
		if (dataVencimento != null ? !dataVencimento.equals(tarefa.dataVencimento) : tarefa.dataVencimento != null)
			return false;
		if (prioridade != tarefa.prioridade)
			return false;
		return estado == tarefa.estado;
	}

	@Override
	public int hashCode() {
		int result = idTarefa != null ? idTarefa.hashCode() : 0;
		result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
		result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
		result = 31 * result + (dataCriacao != null ? dataCriacao.hashCode() : 0);
		result = 31 * result + (dataVencimento != null ? dataVencimento.hashCode() : 0);
		result = 31 * result + (prioridade != null ? prioridade.hashCode() : 0);
		result = 31 * result + (estado != null ? estado.hashCode() : 0);
		return result;
	}
}
