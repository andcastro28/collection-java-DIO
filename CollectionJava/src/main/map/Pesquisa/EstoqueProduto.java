package main.map.Pesquisa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EstoqueProduto
{
  private Map<Long, ProdutoMap> estoqueProdutosMap;

  public EstoqueProduto() {
    this.estoqueProdutosMap = new HashMap<>();
  }
  
  public void exibirNomes()
  {
	  //Map<Long, ProdutoMap> lista = new HashMap<>(estoqueProdutosMap);
	
	  List<HashMap<Long, ProdutoMap>> lista = new ArrayList<>();

      HashMap<Long, ProdutoMap> mapa = new HashMap<>(estoqueProdutosMap);
      lista.add(mapa);
	  
	// Ordenando a lista de HashMap pelo valor da chave "B"
     // Collections.sort(lista, new Comparator<HashMap<Long, ProdutoMap>>() {
    //	  @Override
    //	  public int compare(HashMap<Long, ProdutoMap> o1, HashMap<Long, ProdutoMap> o2)
    //      {
    //          return o1.getNome().compareTo(o2.getNome());
    //      }
    //  });

      // Imprimindo a lista ordenada
      for (Map<Long, ProdutoMap> mapax : lista) {
          System.out.println(mapax);
      }
	  
  }
  
   public void adicionarProduto(long cod, String nome, int quantidade, double preco) {
      System.out.println("Adicionando produto="+cod+"-"+nome);
	  estoqueProdutosMap.put(cod, new ProdutoMap(nome, preco, quantidade));
  }

  public void exibirProdutos() {
    System.out.println(estoqueProdutosMap);
  }

  public double calcularValorTotalEstoque() {
    double valorTotalEstoque = 0d;
    if (!estoqueProdutosMap.isEmpty()) {
      for (ProdutoMap p : estoqueProdutosMap.values()) {
        valorTotalEstoque += p.getQuantidade() * p.getPreco();
      }
    }
    return valorTotalEstoque;
  }

  public ProdutoMap obterProdutoMaisCaro() {
    ProdutoMap produtoMaisCaro = null;
    double maiorPreco = Double.MIN_VALUE;
    for (ProdutoMap p : estoqueProdutosMap.values()) {
      if (p.getPreco() > maiorPreco) {
        produtoMaisCaro = p;
        maiorPreco = p.getPreco();
      }
    }
    return produtoMaisCaro;
  }

  public ProdutoMap obterProdutoMaisBarato() {
    ProdutoMap produtoMaisBarato = null;
    double menorPreco = Double.MAX_VALUE;
    for (ProdutoMap p : estoqueProdutosMap.values()) {
      if (p.getPreco() < menorPreco) {
        produtoMaisBarato = p;
        menorPreco = p.getPreco();
      }
    }
    return produtoMaisBarato;
  }

  public ProdutoMap obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
    ProdutoMap produtoMaiorQuantidadeValorNoEstoque = null;
    double maiorValorTotalProdutoEstoque = 0d;
    if (!estoqueProdutosMap.isEmpty()) {
      for (Map.Entry<Long, ProdutoMap> entry : estoqueProdutosMap.entrySet()) {
        double valorProdutoEmEstoque = entry.getValue().getPreco() * entry.getValue().getQuantidade();
        if (valorProdutoEmEstoque > maiorValorTotalProdutoEstoque) {
          maiorValorTotalProdutoEstoque = valorProdutoEmEstoque;
          produtoMaiorQuantidadeValorNoEstoque = entry.getValue();
        }
      }
    }
    return produtoMaiorQuantidadeValorNoEstoque;
  }
  

  public static void main(String[] args) {
    EstoqueProduto estoque = new EstoqueProduto();

    System.out.println("hoje e :"+LocalDate.now());
    // Exibe o estoque vazio
    estoque.exibirProdutos();

    // Adiciona produtos ao estoque
    estoque.adicionarProduto(21L, "Zen Notebook", 1, 1500.0);
    estoque.adicionarProduto(12L, "Mouse", 5, 25.0);
    estoque.adicionarProduto(53L, "AOC Monitor", 10, 400.0);
    estoque.adicionarProduto(4L, "Boa Teclado", 2, 40.0);

    // Exibe os produtos no estoque
    System.out.println("Lista de produtos no MAP:");
    estoque.exibirProdutos();

    // Calcula e exibe o valor total do estoque
    System.out.println("Valor total do estoque: R$" + estoque.calcularValorTotalEstoque());

    // Obtém e exibe o produto mais caro
    ProdutoMap produtoMaisCaro = estoque.obterProdutoMaisCaro();
    System.out.println("Produto mais caro: " + produtoMaisCaro);

    // Obtém e exibe o produto mais barato
    ProdutoMap produtoMaisBarato = estoque.obterProdutoMaisBarato();
    System.out.println("Produto mais barato: " + produtoMaisBarato);

    // Obtém e exibe o produto com a maior quantidade em valor no estoque
    ProdutoMap produtoMaiorQuantidadeValorTotal = estoque.obterProdutoMaiorQuantidadeValorTotalNoEstoque();
    System.out.println("Produto com maior quantidade em valor no estoque: " + produtoMaiorQuantidadeValorTotal);
  
    estoque.exibirNomes();
  }
}
