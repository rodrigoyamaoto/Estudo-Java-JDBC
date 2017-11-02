package br.com.caelum.jdbc.modelo;

public class Produto {
	private Integer id;
	private String name;
	private String descricao;

	public Produto(Integer id, String name, String descricao) {
		this.id = id;
		this.name = name;
		this.descricao = descricao;
	}
	
	public Produto(String name, String descricao) {
		this.name = name;
		this.descricao = descricao;
	}
			
	public Integer getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescricao() {
		return descricao;
	}
	
	@Override
	public String toString() {
		return String.format("[Produto: %d %s - %s]", id, name, descricao);
	}
}
