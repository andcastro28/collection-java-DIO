package main.list.Ordenacao;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ordenacao
{
	 private List<Pessoa> lista;
	 
	 public Ordenacao() {
			lista=new ArrayList<>();
	}
	 
	 public void adicionarPessoa(String nome, int id, double alt)
	 {
	 	System.out.println("Adicionando pessoa="+nome);
	 	lista.add(new Pessoa(nome,id,alt));
	 }
	 
	 public void ordenarAltura()
	 {
		 
	 }
	 
	 public void obterPessoas()
	 {
	 	if(lista.size()!=0)
	 	{   System.out.println("Lista de Pessoas:");
	 	    System.out.println(lista);
	 	}
	 	else
	 		System.out.println("Lista de Pessoas vazia!!!!");
	 }////////////////////////
	 
	 
	 
	 public List<Pessoa> ordenaIdade()
	    {
	    	List<Pessoa> idades=new ArrayList<>(lista);
	    	if(!lista.isEmpty())
	    	{
	    		Collections.sort(idades);
	    	}
	    	return idades;
	    }//ordena por idade
	 
	
	 public List<Pessoa> ordenaAltura()
	    {
	    	List<Pessoa> alturas=new ArrayList<>(lista);
	    	if(!lista.isEmpty())
	    	{
	    		Collections.sort(alturas, new CompararAltura());
	    	}
	    	return alturas;
	    }//ordena por idade
	
	 
	 
	 public static void main(String[] x)
	 {
		 Ordenacao lista = new Ordenacao(); 
		 lista.adicionarPessoa("joao", 51, 1.95);
		 lista.adicionarPessoa("maria", 71, 1.6);
		 lista.adicionarPessoa("jose", 41, 1.85);
		 lista.adicionarPessoa("betao", 35, 1.75);
		 
		 lista.obterPessoas();
		 System.out.println("lista pode idade:");
		 System.out.println(lista.ordenaIdade());
		 
		 System.out.println("lista pode altura:");
		 System.out.println(lista.ordenaAltura());
	 }////main

	 
}///classs
