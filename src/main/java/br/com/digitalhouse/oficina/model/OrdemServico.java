package br.com.digitalhouse.oficina.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ordemservico")
public class OrdemServico {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length = 60, nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private Double valor;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="veiculo_id")
	private Veiculo veiculo;

	
	
	public OrdemServico() {}
	
	public OrdemServico(Long id, String descricao, Double valor, Cliente cliente, Veiculo veiculo) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.cliente = cliente;
		this.veiculo = veiculo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	

	
}
