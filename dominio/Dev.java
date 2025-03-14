package one.digitalinnivation.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Dev {
	private String nome;
	private List<Conteudo> conteudosInscritos = new ArrayList<>();
	private List<Conteudo> conteudosConcluidos = new ArrayList<>();
	

	
	/*public void inscrever(Bootcamp bootcamp) {
		if(bootcamp.getDevs().contains(this)) {
			System.err.println("Você ja esta inscrito neste bootcamp");
		}else {
			bootcamp.getDevs().add(this);
			System.out.println("Inscricao realizada com sucesso no bootcamp: " + bootcamp.getNome());
		}
	}*/
	
	public void inscrever(Bootcamp bootcamp) {
		for(Conteudo conteudo : bootcamp.getConteudos()) {
			inscrever(conteudo);
		}
		bootcamp.getDevs().add(this);
		System.out.println("Inscricao realizada com sucesso no bootcamp: " + bootcamp.getNome());
		System.out.println("O aluno " + this.getNome() + " esta inscrito nos conteudos do bootcamp");
	}
	//alternativa: 
	//bootcamp.getConteudos().forEach(this::inscrever);
	
	
	public void inscrever(Conteudo conteudo) {
		if(conteudosInscritos.contains(conteudo)) {
			System.err.println("Você ja esta inscrito neste conteudo: " + conteudo.getTitulo());
		}else {
			conteudosInscritos.add(conteudo);
			System.out.println("Inscricao realizada com sucesso no conteudo: " + conteudo.getTitulo());
		}
		
	}
	
	
	public void progredir() {
		Optional<Conteudo> conteudo = conteudosInscritos.stream().findFirst();
		if(conteudo.isPresent()) {
			conteudosConcluidos.add(conteudo.get());
			conteudosInscritos.remove(conteudo.get());
			System.out.println("O aluno " + this.getNome() + " progrediu no conteudo: " + conteudo.get().getTitulo());
		
		}else {
			System.err.println("Nao ha conteudos para progredir");
		}
	
	}
	
	public double calcularTotalXp() {
		return conteudosConcluidos.stream().mapToDouble(Conteudo::calcularXp).sum();
	//alternativa:
	  //return conteudosConcluidos.stream().mapToDouble(conteudo -> conteudo.calcularXp()).sum();
	}
	
	
 	
	//getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conteudo> getConteudosInscritos() {
		return conteudosInscritos;
	}

	public void setConteudosInscritos(List<Conteudo> conteudosInscritos) {
		this.conteudosInscritos = conteudosInscritos;
	}

	public List<Conteudo> getConteudosConcluidos() {
		return conteudosConcluidos;
	}

	public void setConteudosConcluidos(List<Conteudo> conteudosConcluidos) {
		this.conteudosConcluidos = conteudosConcluidos;
	}


	
}
