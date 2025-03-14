package one.digitalinnivation.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bootcamp {
	private String nome;
	private LocalDate inicio;
	private LocalDate fim;
	private List<Dev> devs = new ArrayList<>();
	private List<Conteudo> conteudos = new ArrayList<>();
	
	//getters e setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Dev> getDevs() {
		return devs;
	}
	public void setDevs(List<Dev> devs) {
		this.devs = devs;
	}
	public List<Conteudo> getConteudos() {
		return conteudos;
	}
	public void setConteudos(List<Conteudo> conteudos) {
		this.conteudos = conteudos;
	}

	public LocalDate getInicio() {
		return inicio;
	}
	public void setInicio(LocalDate localDate) {
		this.inicio = localDate;
	}
	public LocalDate getFim() {
		return fim;
	}
	public void setFim(LocalDate localDate) {
		this.fim = localDate;
	}
}
