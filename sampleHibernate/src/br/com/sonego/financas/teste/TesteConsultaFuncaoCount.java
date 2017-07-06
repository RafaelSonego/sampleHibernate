package br.com.sonego.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.sonego.financas.modelo.Conta;

public class TesteConsultaFuncaoCount {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("financas");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		Conta conta = em.find(Conta.class, 2);

		Query query = em.createQuery("select count(m) from Movimentacao m where m.conta = :pConta ");
		query.setParameter("pConta", conta);
		Long contador = (Long) query.getSingleResult();

		System.out.println(contador);

		em.getTransaction().commit();
		em.close();
		factory.close();
	}

}
