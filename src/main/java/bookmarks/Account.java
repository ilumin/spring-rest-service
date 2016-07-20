package bookmarks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    public String username;
    public String password;

    @OneToMany( mappedBy = "accounts" )
    private Set<Bookmark> bookmarks = new HashSet<>();

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    Account() { }

    public Long getId() {
        return id;
    }

    public Set<Bookmark> getBookmarks() {
        return bookmarks;
    }
}
