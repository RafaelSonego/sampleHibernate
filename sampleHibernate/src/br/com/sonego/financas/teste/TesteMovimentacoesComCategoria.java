package br.com.sonego.financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.sonego.financas.modelo.Categoria;
import br.com.sonego.financas.modelo.Conta;
import br.com.sonego.financas.modelo.Movimentacao;
import br.com.sonego.financas.modelo.TipoMovimentacao;
import br.com.sonego.financas.util.JPAUtil;

public class TesteMovimentacoesComCategoria {

	public static void main(String[] args) {
		Categoria c1 = new Categoria("Viagem");
		Categoria c2 = new Categoria("Negocios");

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
		m2.setData(Calendar.getInstance());
		m2.setDescricao("Viagem a RJ");
		m2.setTipo(TipoMovimentacao.SAIDA);
		m2.setValor(new BigDecimal("300.0"));
		m2.setCategoria(Arrays.asList(c1, c2));
		m2.setConta(conta);

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		em.persist(c1);
		em.persist(c2);

		em.persist(m1);
		em.persist(m2);

		em.getTransaction().commit();
		em.close();

	}

}
