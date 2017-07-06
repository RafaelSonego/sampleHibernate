package br.com.sonego.financas.teste;

import javax.persistence.EntityManager;

import br.com.sonego.financas.modelo.Cliente;
import br.com.sonego.financas.modelo.Conta;
import br.com.sonego.financas.util.JPAUtil;

public class TesteContaCliente {
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setNome("Jessica");
		cliente.setEndereco("rua teste");
		cliente.setProfissao("professor");

		Conta conta = new Conta();
		conta.setId(2);
		cliente.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		em.persist(cliente);
		em.getTransaction().commit();

		em.close();

	}
}
