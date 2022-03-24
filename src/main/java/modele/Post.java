package modele;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String postData;
    private LocalDateTime date;
    @OneToOne
    @JoinColumn(name = "USER_ID")
    private PostUser user;
    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
    private List<PostComment> comments = new ArrayList<>();

    public Post (String postData) {
        this.postData = postData;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", postData='" + postData + '\'' +
                ", date=" + date +
                ", user=" + user +
                ", comments=" + comments +
                '}';
    }
}
