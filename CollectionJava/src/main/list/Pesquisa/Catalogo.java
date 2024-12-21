package main.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class Catalogo
{
    private List<Livro> lista;

	public Catalogo() {
		lista=new ArrayList<>();
	}

	public void adicionarLivro(String titulo, String autor, int anopublicacao)
	{
		System.out.println("Adicionando um livro="+titulo);
		lista.add(new Livro(titulo,autor,anopublicacao));
	}

    public List<Livro> pesquisaAutor(String autor)
    {
    	List<Livro> livros=new ArrayList<>();
    	
    	if(!lista.isEmpty())
    	{
    		for(Livro l:lista)
    		{
    			if(l.getAutor().equalsIgnoreCase(autor))
    			{
    				livros.add(l);
    			}
    		}//for
    	}
    	return livros;
    }//pesquisa
    
    public List<Livro> pesquisaAno(int inicio, int fim)
    {
    	List<Livro> livros=new ArrayList<>();
    	
    	if(!lista.isEmpty())
    	{
    	    if(inicio<=fim)
    		for(Livro l:lista)
    		{
    			if(l.getAnopublicacao()>=inicio && l.getAnopublicacao()<=fim)
    			{
    				livros.add(l);
    			}
    		}//for
    	    else
    	    	System.out.println("Pesquisa incorreta ano de inicio > ano de fim");
    	}
    	return livros;
    }//pesquisa
    
    
    public Livro pesquisaTitulo(String nome)
    {
    	Livro livros=null;
    	
    	if(!lista.isEmpty())
    	{
    	    for(Livro l:lista)
    		{
    			if(l.getTitulo().equalsIgnoreCase(nome))
    			{
    				livros=l; break;
    			}
    		}//for
    	}
    	return livros;
    }//pesquisa
    
    
    public static void main(String[] x)
    {
   	 Catalogo lista = new Catalogo();
   	    lista.adicionarLivro("livro 1","autor 1",2020);
   	    lista.adicionarLivro("livro 2","autor 1",2021);
   	    lista.adicionarLivro("livro 3","autor 2",2022);
   	    lista.adicionarLivro("livro 4","autor 2",2023);
   	    lista.adicionarLivro("livro 5","autor 3",2024);
   	    lista.adicionarLivro("livro 6","autor 3",2025);
	    
   	 System.out.println(lista.pesquisaAutor("autor 1"));
   	 
   	System.out.println(lista.pesquisaAno(2021, 2023));
   	
   	System.out.println(lista.pesquisaTitulo("livro 5"));
  	    
    }
    
    
    
    
    
}//class
