package persistence;

import modele.Post;
import modele.PostComment;
import modele.PostUser;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class PostDaoJPAH2 implements PostDao {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("examintra");

    @Override
    public <T> void save(T t) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(t);

        em.getTransaction().commit();
        em.close();
    }

    public long addUser(String posteur) {
        final PostUser user = new PostUser(posteur);
        save(user);
        return user.getId();
    }

    public long addPost(long posteurId, String postData) {
        final Post post = new Post(postData);
        post.setDate(LocalDateTime.now());
        save(post);
        return post.getId();
    }

    public long addComment(long commenteurId, long postId, String commentaire) {
        final PostComment comment = new PostComment(commentaire);
        save(comment);
        return comment.getId();
    }

    public Post getPost(long postId) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final Post post = em.find(Post.class, postId);

        em.getTransaction().commit();
        em.close();
        return post;
    }
}
