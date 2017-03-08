package demo.core.repositories;

import demo.core.models.entities.Account;
import demo.core.models.entities.Blog;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by hummela on 2/27/2017.
 */
public interface AccountRepo {
    public List<Account> findAllAccounts();
    public Account findAccount(Long id);
    public List<Account> findAccountByName(String name);
    public Account createAccount(Account data);
}
