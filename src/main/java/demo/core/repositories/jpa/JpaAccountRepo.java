package demo.core.repositories.jpa;

import org.springframework.stereotype.Repository;
import demo.core.models.entities.Account;
import demo.core.models.entities.Blog;
import demo.core.repositories.AccountRepo;
import demo.core.services.util.AccountList;
import demo.core.services.util.BlogList;
import demo.core.repositories.jpa.SqlConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;

@Repository
public class JpaAccountRepo implements AccountRepo {

    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Account> findAllAccounts() {
        Query query = em.createQuery("SELECT a FROM Account a");
        return query.getResultList();
    }

    @Override
    public Account findAccount(Long id) {
        return em.find(Account.class, id);
    }

    @Override
    public List<Account> findAccountByName(String name) {
        Account account = null;
        Query query = em.createNativeQuery(SqlConstants.queryString);
        query.setParameter("name", name);
        List<Account> accounts = query.getResultList();

        System.out.println("HERE");
        System.out.println(accounts);
        if(accounts.size() == 0) {
            return null;
        } else {
            return accounts;
        }
    }

    @Override
    public Account createAccount(Account data) {
        System.out.println("Data => " + data);
        em.persist(data);
        return data;
    }
}
