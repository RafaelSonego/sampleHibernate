package br.com.sonego.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.sonego.financas.modelo.Conta;

public class TesteConsultaFuncaoMax {
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("financas");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 2);
		
		String jpql = "Select max(m.valor) from Movimentacao m where m.conta = :pConta";
		
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		
		BigDecimal maxResult = (BigDecimal) query.getSingleResult();
		System.out.println(maxResult);

		em.getTransaction().commit();
		em.close();
		factory.close();
		
		
		
		
	}
}
