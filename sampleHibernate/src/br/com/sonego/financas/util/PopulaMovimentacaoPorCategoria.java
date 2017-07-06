package br.com.sonego.financas.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.sonego.financas.modelo.Categoria;
import br.com.sonego.financas.modelo.Conta;
import br.com.sonego.financas.modelo.Movimentacao;
import br.com.sonego.financas.modelo.TipoMovimentacao;

public class PopulaMovimentacaoPorCategoria {
	public static void main(String[] args) {
		Categoria c1 = new Categoria("Viagem");
		c1.setId(1);
		Categoria c2 = new Categoria("Negocios");
		c2.setId(2);
		
		Conta conta = new Conta();
		conta.setId(2);

		Movimentacao m1 = new Movimentacao();
		m1.setData(Calendar.getInstance());
		m1.setDescricao("Viagem a SP");
		m1.setTipo(TipoMovimentacao.SAIDA);
		m1.setValor(new BigDecimal("200.0"));
		m1.setCategoria(Arrays.asList(c1, c2));
		m1.setConta(conta);

		Movimentacao m2 = new Movimentacao();

		Calendar amanha = Calendar.getInstance();
		amanha.add(Calendar.DAY_OF_MONTH, 1);

		m2.setData(amanha);
		m2.setDescricao("Viagem a RJ");
		m2.setTipo(TipoMovimentacao.SAIDA);
		m2.setValor(new BigDecimal("300.0"));
		m2.setCategoria(Arrays.asList(c1, c2));
		m2.setConta(conta);

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		em.persist(m1);
		em.persist(m2);

		em.getTransaction().commit();
		em.close();

	}
}
