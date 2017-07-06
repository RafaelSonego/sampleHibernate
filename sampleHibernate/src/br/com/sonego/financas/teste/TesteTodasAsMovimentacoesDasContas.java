package br.com.sonego.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.sonego.financas.modelo.Conta;
import br.com.sonego.financas.util.JPAUtil;

public class TesteTodasAsMovimentacoesDasContas {
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		String jpql = "select c from Conta c left join fetch c.movimentacoes";
		
		TypedQuery<Conta> query = em.createQuery(jpql, Conta.class);
		
		List<Conta> listContas = query.getResultList();
		for (Conta conta : listContas) {
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Movimentaçoes: ");
			System.out.println(conta.getMovimentacoes());
		}
		
		
		em.getTransaction().commit();
		em.close();
		

	}
}
