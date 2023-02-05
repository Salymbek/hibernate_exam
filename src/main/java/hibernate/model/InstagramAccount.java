package hibernate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "instagram_accounts")
@Getter
@Setter
@NoArgsConstructor
@ToString

public class InstagramAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name")
    private String userName;
    private String login;
    private String password;
    @OneToOne(mappedBy = "instagramAccount")
    private User user;
    @OneToMany(mappedBy = "instagramAccount",
    cascade = {CascadeType.REMOVE,
    CascadeType.MERGE,
    CascadeType.REMOVE,
    CascadeType.PERSIST,
    CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private List<Post> posts;

    public InstagramAccount(String userName, String login, String password) {
        this.userName = userName;
        this.login = login;
        this.password = password;
    }
}
