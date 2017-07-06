package br.com.sonego.financas.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.sonego.financas.modelo.Conta;
import br.com.sonego.financas.modelo.TipoMovimentacao;
import br.com.sonego.financas.util.JPAUtil;

public class TesteFuncoesJPQL {
	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setId(2);

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		String jpql1 = "select sum(m.valor) from Movimentacao m where m.conta = :pConta and m.tipo = :pTipo ";
		Query query1 = em.createQuery(jpql1);
		query1.setParameter("pTipo", TipoMovimentacao.SAIDA);
		query1.setParameter("pConta", conta);

		BigDecimal soma = (BigDecimal) query1.getSingleResult();
		System.out.println(soma);

		String jpql2 = "select avg(m.valor) from Movimentacao m where m.conta = :pConta and m.tipo = :pTipo ";
		Query query2 = em.createQuery(jpql2);
		query2.setParameter("pConta", conta);
		query2.setParameter("pTipo", TipoMovimentacao.SAIDA);

		Double media = (Double) query2.getSingleResult();
		System.out.println(media);

		String jpql3 = "select distinct avg(m.valor) from Movimentacao m where m.conta = :pConta and m.tipo = :pTipo group by m.data";
		TypedQuery<Double> query3 = em.createQuery(jpql3, Double.class);
		query3.setParameter("pConta", conta);
		query3.setParameter("pTipo", TipoMovimentacao.SAIDA);

		List<Double> listMedia = query3.getResultList();

		for (Double valorMedia : listMedia) {
			System.out.println(valorMedia);
		}

		em.getTransaction().commit();
		em.close();

	}
}
