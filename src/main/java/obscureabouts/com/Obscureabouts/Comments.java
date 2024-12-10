package obscureabouts.com.Obscureabouts;

import java.util.LinkedList;
import java.util.Queue;

public class Comments
{
    Queue<Comment> comments = new LinkedList<>();

    public Comments(Comment userComment)
    {
        comments.add(userComment);
    }

    public void enqueueReview(Comment userComment)
    {
        comments.add(userComment);
    }

    public void dequeueReview(Comment userComment)
    {
        comments.remove(userComment);
    }

}
