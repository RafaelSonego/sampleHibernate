package br.com.sonego.financas.teste;

import javax.persistence.EntityManager;

import br.com.sonego.financas.modelo.Conta;
import br.com.sonego.financas.util.JPAUtil;

/**
 * Created by leonardocordeiro on 24/02/17.
 */
public class TesteConta {

    public static void main(String[] args) {

        Conta conta = new Conta();
        conta.setId(1);
        conta.setTitular("Danilo");
        conta.setBanco("Banco do Brasil");
        conta.setAgencia("123");
        conta.setNumero("456");

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

//        em.persist(conta);
//        conta.setBanco("Bradesco");

        conta = em.find(Conta.class, conta.getId());
        em.remove(conta);

        em.getTransaction().commit();
        em.close();

        EntityManager em2 = new JPAUtil().getEntityManager();
        em2.getTransaction().begin();

        conta.setTitular("Leonardo");
        em2.merge(conta);

        em2.getTransaction().commit();
        em2.close();
    }
}
