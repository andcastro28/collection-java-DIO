package main.set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Cadastro{
  //atributo
  private Set<Produto> produtoSet;

  public Cadastro() {
    this.produtoSet = new HashSet<>();
  }

  public void adicionarProduto(long cod, String nome, double preco, int quantidade) {
	  System.out.println("Adicionando="+cod+"-"+nome+"-"+preco);
	  produtoSet.add(new Produto(cod, nome, preco, quantidade));
  }

  public Set<Produto> exibirProdutosPorNome() {
    Set<Produto> produtosPorNome = new TreeSet<>(produtoSet);
    if (!produtoSet.isEmpty()) {
      return produtosPorNome;
    } else {
      throw new RuntimeException("O conjunto está vazio!");
    }
  }

  public Set<Produto> exibirProdutosPorPreco() {
    Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());
    if (!produtoSet.isEmpty()) {
      produtosPorPreco.addAll(produtoSet);
      return produtosPorPreco;
    } else {
      throw new RuntimeException("O conjunto está vazio!");
    }
  }

  public Set<Produto> exibirProdutosPorQtde() {
	    Set<Produto> produtosq = new TreeSet<>(new ComparatorPorQtde());
	    if (!produtoSet.isEmpty()) {
	      produtosq.addAll(produtoSet);
	      return produtosq;
	    } else {
	      throw new RuntimeException("O conjunto está vazio!");
	    }
	  }
  
  public static void main(String[] args) {
    // Criando uma instância do CadastroProdutos
    Cadastro cadastroProdutos = new Cadastro();

    // Adicionando produtos ao cadastro
    cadastroProdutos.adicionarProduto(1L, "Smartphone", 1000d, 10);
    cadastroProdutos.adicionarProduto(2L, "Notebook", 1500d, 5);
    cadastroProdutos.adicionarProduto(5L, "Wireless", 30d, 20);
    cadastroProdutos.adicionarProduto(4L, "Teclado", 50d, 15);

    // Exibindo todos os produtos no cadastro
    System.out.println("Exibindo produtos cadastrados:");
    System.out.println(cadastroProdutos.produtoSet);

    // Exibindo produtos ordenados por nome
    System.out.println("Exibindo produtos por nome:");
    System.out.println(cadastroProdutos.exibirProdutosPorNome());

    // Exibindo produtos ordenados por preço
    System.out.println("Exibindo produtos por preco:");
    System.out.println(cadastroProdutos.exibirProdutosPorPreco());
    
    
 // Exibindo produtos ordenados por qtde
    System.out.println("Exibindo produtos por qtde:");
    System.out.println(cadastroProdutos.exibirProdutosPorQtde());
    
    
  }
}