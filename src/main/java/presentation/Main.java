package presentation;

import modele.Post;
import persistence.PostDaoJPAH2;
import service.PostService;

public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService(new PostDaoJPAH2());

        var posteurId = postService.addUser("Posteur1");
        var commenteurId = postService.addUser("Commentateur1");
        var postId = postService.addPost(posteurId, "Mon 1er post");
        postService.addComment(commenteurId, postId, "Mon commentaire");

        final Post post = postService.getPost(postId);
        System.out.println(post);
    }
}
