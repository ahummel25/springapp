package demo.core.services;

import demo.core.models.entities.Account;
import demo.core.models.entities.Blog;
import demo.core.services.util.AccountList;
import demo.core.services.util.BlogList;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Chris on 6/28/14.
 */
public interface AccountService {
    public Account findAccount(Long id);
    public Account createAccount(Account data);
    public Blog createBlog(Long accountId, Blog data);
    public BlogList findBlogsByAccount(Long accountId);
    public AccountList findAllAccounts();
    public List<Account> findByAccountName(String name);
}
