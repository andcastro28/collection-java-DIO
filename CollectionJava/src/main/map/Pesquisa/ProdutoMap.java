package main.map.Pesquisa;

import java.util.Comparator;

public class ProdutoMap
{
	  //atributos
	  private String nome;
	  private double preco;
	  private int quantidade;

	  public ProdutoMap(String nome, double preco, int quantidade) {
	    this.nome = nome;
	    this.preco = preco;
	    this.quantidade = quantidade;
	  }

	  public String getNome() {
	    return nome;
	  }

	  public double getPreco() {
	    return preco;
	  }

	  public int getQuantidade() {
	    return quantidade;
	  }

	  @Override
	  public String toString() {
	    return "Produto{" +
	        "nome='" + nome + '\'' +
	        ", preco=" + preco +
	        ", quantidade=" + quantidade +
	        "}\n";
	  }
	  
	  
}//////classss

class ComparatorPorNome implements Comparator<ProdutoMap>
{
  @Override
  public int compare(ProdutoMap p1, ProdutoMap p2)
  {
    return p1.getNome().compareToIgnoreCase(p2.getNome());
  }
}///class 
