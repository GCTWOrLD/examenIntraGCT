package modele;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String comment;
    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private Post post;
    @OneToOne
    @JoinColumn(name = "USER_ID")
    private PostUser user;

    public PostComment (String comment) {
        this.comment = comment;
    }
}
