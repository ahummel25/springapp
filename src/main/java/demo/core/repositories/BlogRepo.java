package demo.core.repositories;

import demo.core.models.entities.Blog;
import demo.core.models.entities.BlogEntry;
import demo.core.services.util.BlogEntryList;
import demo.core.services.util.BlogList;

import java.util.List;

/**
 * Created by Chris on 7/10/14.
 */
public interface BlogRepo {
    public Blog createBlog(Blog data);
    public List<Blog> findAllBlogs();
    public Blog findBlog(Long id);
    public Blog findBlogByTitle(String title);
    public List<Blog> findBlogsByAccount(Long accountId);
}
