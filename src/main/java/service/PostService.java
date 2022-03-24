package service;

import modele.Post;
import persistence.PostDao;

public class PostService {
    private PostDao dao;

    public PostService(PostDao dao) {
        this.dao = dao;
    }

    public long addUser(String posteur) {
        return dao.addUser(posteur);
    }

    public long addPost(long posteurId, String postData) {
        return dao.addPost(posteurId, postData);
    }

    public long addComment(long commenteurId, long postId, String commentaire) {
        return dao.addComment(commenteurId, postId, commentaire);
    }

    public Post getPost(long postId) {
        return dao.getPost(postId);
    }
}
