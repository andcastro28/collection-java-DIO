package main.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa
{
 private List<Tarefa> tarefaList;

public ListaTarefa() {
	this.tarefaList = new ArrayList<>();
}

public void adicionarTarefa(String des)
{
	System.out.println("Adicionando a tarefa="+des);
	tarefaList.add(new Tarefa(des));
}

public void removerTarefa(String des)
{
	System.out.println("Removendo a tarefa="+des);
	List<Tarefa> remover = new ArrayList<>();
	for(Tarefa t:tarefaList)
	{
		if(t.getDescricao().equalsIgnoreCase(des))
		{
		   remover.add(t);	
		}
	}//for
	
	tarefaList.removeAll(remover);
}//remover

public int obterNumeroTarefas(){
	return tarefaList.size();
	
}//numero

public void obterDescricoesTarefas()
{
    
	if(tarefaList.size()!=0)
	{   System.out.println("Lista de tarefas:");
	    System.out.println(tarefaList);
	}
	else
		System.out.println("Lista vazia!!!!");
}
 
 public static void main(String[] x)
 {
	 ListaTarefa lista = new ListaTarefa();
	 lista.obterDescricoesTarefas();
	 System.out.println("Numero de tarefas="+lista.obterNumeroTarefas());
     lista.adicionarTarefa("tarefa1");
     lista.adicionarTarefa("tarefa1");
     lista.adicionarTarefa("tarefa2");
     lista.adicionarTarefa("tarefa3");
     System.out.println("Numero de tarefas="+lista.obterNumeroTarefas());
     lista.obterDescricoesTarefas();
     
     lista.removerTarefa("tarefa1");
     System.out.println("Numero de tarefas="+lista.obterNumeroTarefas());
     lista.obterDescricoesTarefas();
     
     
 }

}//class