package course.domain;

import javax.persistence.*;

/**
 * Created by Артем Константинович on 02.10.2016.
 */

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    public User() {
    }

    @Column(name = "name", unique = true)
    private String name;


    public User(String name) {
        this.name = name;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
