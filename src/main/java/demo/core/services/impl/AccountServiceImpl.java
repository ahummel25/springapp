package demo.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import demo.core.models.entities.Account;
import demo.core.models.entities.Blog;
import demo.core.repositories.AccountRepo;
import demo.core.repositories.BlogRepo;
import demo.core.services.AccountService;
import demo.core.services.exceptions.AccountDoesNotExistException;
import demo.core.services.exceptions.AccountExistsException;
import demo.core.services.exceptions.BlogExistsException;
import demo.core.services.util.AccountList;
import demo.core.services.util.BlogList;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Chris on 7/10/14.
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private BlogRepo blogRepo;

    @Override
    public Account findAccount(Long id) {
        return accountRepo.findAccount(id);
    }

    @Override
    public Account createAccount(Account data){
        System.out.println("Dater => " + data);
        List<Account> account = accountRepo.findAccountByName(data.getName());
        if(account != null)
        {
            throw new AccountExistsException();
        }
        return accountRepo.createAccount(data);
    }

    @Override
    public Blog createBlog(Long accountId, Blog data) {
        Blog blogSameTitle = blogRepo.findBlogByTitle(data.getTitle());

        if(blogSameTitle != null)
        {
            throw new BlogExistsException();
        }

        Account account = accountRepo.findAccount(accountId);
        if(account == null)
        {
            throw new AccountDoesNotExistException();
        }

        Blog createdBlog = blogRepo.createBlog(data);

        createdBlog.setOwner(account);

        return createdBlog;
    }

    public BlogList findBlogsByAccount(Long accountId) {
        Account account = accountRepo.findAccount(accountId);
        if(account == null)
        {
            throw new AccountDoesNotExistException();
        }
        return new BlogList(blogRepo.findBlogsByAccount(accountId));
    }

    public AccountList findAllAccounts() {
        return new AccountList(accountRepo.findAllAccounts());
    }

    public List<Account> findByAccountName(String name){
        return accountRepo.findAccountByName(name);
    }
}
