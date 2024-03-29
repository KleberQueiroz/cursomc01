package com.klebercruz.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.klebercruz.cursomc.domain.Categoria;
import com.klebercruz.cursomc.domain.Cidade;
import com.klebercruz.cursomc.domain.Cliente;
import com.klebercruz.cursomc.domain.Endereco;
import com.klebercruz.cursomc.domain.Estado;
import com.klebercruz.cursomc.domain.Produto;
import com.klebercruz.cursomc.domain.enums.TipoCliente;
import com.klebercruz.cursomc.repositories.CategoriaRepository;
import com.klebercruz.cursomc.repositories.CidadeRepository;
import com.klebercruz.cursomc.repositories.ClienteRepository;
import com.klebercruz.cursomc.repositories.EnderecoRepository;
import com.klebercruz.cursomc.repositories.EstadoRepository;
import com.klebercruz.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository EnderecoRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria (null, "Informatica");
		Categoria cat2 = new Categoria (null, "Escritorio");
		
		Produto p1 =new Produto (null, "Computador", 2000.00);
		Produto p2 =new Produto (null, "Impressora", 800.00);
		Produto p3 =new Produto (null, "Mouse", 80.00);
		Produto p4 =new Produto (null, "teste", 2.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2,p4));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		
		
		categoriaRepository.save(Arrays.asList(cat1,cat2));
		produtoRepository.save(Arrays.asList(p1,p2,p3,p4));
		
		Estado est1 = new Estado (null,"Minas Gerais");
		Estado est2 = new Estado (null, "São Paulo");
		Estado est3 = new Estado (null, "Pará");
		
		Cidade c1 =new Cidade (null, "uberlãndia", est1);
		Cidade c2 =new Cidade (null, "São Paulo", est2);
		Cidade c3 =new Cidade (null, "Campinas", est2);
		Cidade c4 =new Cidade (null, "Belém,", est3);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		est3.getCidades().addAll(Arrays.asList(c4));
		
		estadoRepository.save(Arrays.asList(est1,est2,est3));
		cidadeRepository.save(Arrays.asList(c1,c2,c3,c4));
		
		Cliente cli1 = new Cliente (null, "Maria Silva", "Maria@gmail.com", "235235254-3232",TipoCliente.PESSOAFISICA);
		
		cli1.getTelefone().addAll(Arrays.asList("23542525", "2342353252"));
		
		Endereco e1 =new Endereco (null, "Rua Flores", "300", "Apto 303", "34536336", cli1,c1);
		Endereco e2 =new Endereco (null, "Avenida Matos", "105", "Apto 103", "345334563336", cli1,c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.save(Arrays.asList(cli1));
		EnderecoRepository.save(Arrays.asList(e1,e2));
		
		
		
		
		
		
		
		
	}
}
