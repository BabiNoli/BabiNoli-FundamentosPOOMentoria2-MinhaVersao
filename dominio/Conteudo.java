package one.digitalinnivation.dominio;

public abstract class Conteudo {
	
	protected static final double XP_PADRAO = 10;
	
	private String titulo;
	private String descricao;
	
	//metodo para calcular pontos 
	public abstract double calcularXp();
	
	
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
	
	
}
