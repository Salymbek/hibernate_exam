package hibernate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Entity
@Table(name = "posts")
@Setter
@Getter
@NoArgsConstructor
@ToString

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String description;
    @Column(name = "publication_date")
    private LocalDate publicationDate;
    @ManyToOne(cascade = CascadeType.ALL)
    private InstagramAccount instagramAccount;

    public Post(String image, String description, LocalDate publicationDate) {
        this.image = image;
        this.description = description;
        this.publicationDate = publicationDate;
    }
}
