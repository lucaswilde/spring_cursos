package br.com.alura.listavip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.listavip.model.Convidado;
import br.com.alura.listavip.repository.ConvidadoRepository;

@Service
public class ConvidadoService {
	
	@Autowired
	private ConvidadoRepository repository;
	
	public Iterable<Convidado> findAll(){
		return repository.findAll();
	}
	
	public void save(Convidado convidado) {
		repository.save(convidado);
	}
	
	public List<Convidado> findByNome(String nome){
		return repository.findByNome(nome);
	}
}
