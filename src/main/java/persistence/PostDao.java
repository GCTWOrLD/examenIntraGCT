package persistence;

import modele.Post;

public interface PostDao {
    <T> void save(T t);
    long addUser(String posteur);
    long addPost(long posteurId, String post);
    long addComment(long commenteurId, long postId, String commentaire);
    Post getPost(long postId);
}
