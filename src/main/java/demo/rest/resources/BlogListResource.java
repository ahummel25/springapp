package demo.rest.resources;

import org.springframework.hateoas.ResourceSupport;
import demo.core.models.entities.Blog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 7/1/14.
 */
public class BlogListResource extends ResourceSupport {
    private List<BlogResource> blogs = new ArrayList<BlogResource>();

    public List<BlogResource> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<BlogResource> blogs) {
        this.blogs = blogs;
    }
}
