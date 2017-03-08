package demo.rest.resources;

import org.springframework.hateoas.ResourceSupport;

public class BlogEntryResources extends ResourceSupport {

    private Long num;

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long id) {
        this.num = id;
    }
}
