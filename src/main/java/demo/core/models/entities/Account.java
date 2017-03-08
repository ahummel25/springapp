package demo.core.models.entities;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "ACCOUNT", schema = "APPS")
@SequenceGenerator(name = "SEQ_Attribute", sequenceName = "WWT.HUMMELA_ACCOUNT_S", allocationSize = 1)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_Attribute")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PASSWORD")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
