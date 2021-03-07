package br.com.caelum.livraria.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean //Aqui estamos indicando que a classe é gerenciada pelo JSF
public class LivroBean {
	
	private Livro livro = new Livro();
	
	public Livro getLivro() {
		return livro;
	}

	public void gravar() {
		System.out.println("Gravando Livro " + this.livro.getTitulo());
	}

}
