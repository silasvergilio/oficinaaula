package br.com.digitalhouse.oficina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digitalhouse.oficina.model.OrdemServico;
import br.com.digitalhouse.oficina.repository.OrdemServicoRepository;

@Service
public class OrdemServicoService {

	private final OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	public OrdemServicoService(OrdemServicoRepository ordemServicoRepository) {
		this.ordemServicoRepository = ordemServicoRepository;
	}
	
	public OrdemServico create(OrdemServico ordemServico) {
		ordemServico.setId(null);
		return this.ordemServicoRepository.save(ordemServico);
	}
	
	public OrdemServico update(OrdemServico novo) {
	
		OrdemServico antigo = this.findById(novo.getId());
		
		antigo.setDescricao(novo.getDescricao());
		antigo.setValor(novo.getValor());
		antigo.setCliente(novo.getCliente());
		antigo.setVeiculo(novo.getVeiculo());
		
		return this.ordemServicoRepository.save(antigo);
		
	}
	 
	
	public OrdemServico findById(Long id) {
		Optional
			.ofNullable(id)
			.orElseThrow( () -> new RuntimeException("O id não pode ser nulo"));  // todo: criar exceção personalizada para argumento ilegal
		
		return this.ordemServicoRepository.findById(id)
				.orElseThrow( () -> new RuntimeException("Não foi possivel encontrar um objeto com id " + id)); // todo: mudar pra object not found exception
	}
	
	public List<OrdemServico> findAll(){
		return this.ordemServicoRepository.findAll();
	}
	
	public void deleteById(Long id) {
		this.findById(id);
		
		this.ordemServicoRepository.deleteById(id);
	}
	
	
}
