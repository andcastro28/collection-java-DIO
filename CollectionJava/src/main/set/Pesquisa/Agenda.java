package main.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class Agenda
{
  //atributo
  private Set<Contato> contatosSet;

  public Agenda() {
    this.contatosSet = new HashSet<>();
  }

  public void adicionarContato(String nome, int numero) {
	  System.out.println("Adicionando="+nome+"-"+numero);
	  contatosSet.add(new Contato(nome, numero));
  }

  public void exibirContatos() {
    if (!contatosSet.isEmpty()) {
      System.out.println(contatosSet);
    } else {
      System.out.println("O conjunto está vazio!");
    }
  }

  public Set<Contato> pesquisarPorNome(String nome) {
	  System.out.println("Pesquisando="+nome);
    Set<Contato> contatosPorNome = new HashSet<>();
    if (!contatosSet.isEmpty()) {
      for (Contato c : contatosSet) {
        if (c.getNome().startsWith(nome)) {
          contatosPorNome.add(c);
        }
      }
      return contatosPorNome;
    } else {
      throw new RuntimeException("O conjunto está vazio!");
    }
  }

  public Contato atualizarNumeroContato(String nome, int novoNumero)
  {
  
	System.out.println("Atualizando agenda="+nome+" com novo numero="+novoNumero);  
	Contato contatoAtualizado = null;
    if (!contatosSet.isEmpty()) {
      for (Contato c : contatosSet) {
        if (c.getNome().equalsIgnoreCase(nome))
        {
          System.out.println("Atualizando ="+c.getNumero()+" com novo numero="+novoNumero);  
          c.setNumero(novoNumero);
          contatoAtualizado = c;
          break;
        }
      }
      return contatoAtualizado;
    } else {
      throw new RuntimeException("O conjunto está vazio!");
    }
  }

  public static void main(String[] args) {
    // Criando uma instância da classe AgendaContatos
    Agenda agendaContatos = new Agenda();

    // Exibindo os contatos no conjunto (deve estar vazio)
    agendaContatos.exibirContatos();

    // Adicionando contatos à agenda
    agendaContatos.adicionarContato("João", 123456789);
    agendaContatos.adicionarContato("Maria", 987654321);
    agendaContatos.adicionarContato("Maria Fernandes", 55555555);
    agendaContatos.adicionarContato("Ana", 88889999);
    agendaContatos.adicionarContato("Fernando", 77778888);
    agendaContatos.adicionarContato("Carolina", 55555555);

    // Exibindo os contatos na agenda
    agendaContatos.exibirContatos();

    // Pesquisando contatos pelo nome
    System.out.println(agendaContatos.pesquisarPorNome("Fer"));

    // Atualizando o número de um contato
    Contato contatoAtualizado = agendaContatos.atualizarNumeroContato("Carolina", 44443333);
    System.out.println("Contato atualizado: " + contatoAtualizado);

    // Exibindo os contatos atualizados na agenda
    System.out.println("Contatos na agenda após atualização:");
    agendaContatos.exibirContatos();
  }
}
