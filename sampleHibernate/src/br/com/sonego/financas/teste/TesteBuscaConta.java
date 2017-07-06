package br.com.sonego.financas.teste;

import br.com.sonego.financas.modelo.Conta;
import br.com.sonego.financas.util.JPAUtil;

import javax.persistence.EntityManager;

/**
 * Created by leonardocordeiro on 24/02/17.
 */
public class TesteBuscaConta {

    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = em.find(Conta.class, 1);
        conta.getAgencia();

        em.getTransaction().commit();
        em.close();
    }

}
