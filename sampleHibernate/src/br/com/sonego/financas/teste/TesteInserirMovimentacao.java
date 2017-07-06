package br.com.sonego.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.sonego.financas.modelo.Conta;
import br.com.sonego.financas.modelo.Movimentacao;
import br.com.sonego.financas.util.JPAUtil;

public class TesteInserirMovimentacao {
	
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 1);
		System.out.println(conta.getTitular());
		
		
		List<Movimentacao> listMovimentacoes = conta.getMovimentacoes();
		
		for (Movimentacao movimentacao : listMovimentacoes) {
			System.out.println(movimentacao.getConta());
		}
		em.close();		
		em.getTransaction().commit();
	}

}
