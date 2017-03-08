package demo.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by Chris on 6/28/14.
 */
public class BlogEntryListResource extends ResourceSupport {
    private String title;

    private List<BlogEntryResource> entries;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<BlogEntryResource> getEntries() {
        return entries;
    }

    public void setEntries(List<BlogEntryResource> entries) {
        this.entries = entries;
    }
}
