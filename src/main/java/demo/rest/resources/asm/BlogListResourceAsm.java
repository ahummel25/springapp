package demo.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import demo.core.models.entities.Blog;
import demo.core.services.util.BlogList;
import demo.rest.mvc.BlogController;
import demo.rest.resources.BlogListResource;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * Created by Chris on 7/1/14.
 */
public class BlogListResourceAsm extends ResourceAssemblerSupport<BlogList, BlogListResource> {

    public BlogListResourceAsm()
    {
        super(BlogController.class, BlogListResource.class);
    }

    @Override
    public BlogListResource toResource(BlogList blogList) {
        BlogListResource res = new BlogListResource();
        res.setBlogs(new BlogResourceAsm().toResources(blogList.getBlogs()));
        return res;
    }
}
