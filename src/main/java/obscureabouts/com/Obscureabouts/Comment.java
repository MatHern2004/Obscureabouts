package obscureabouts.com.Obscureabouts;

import java.time.LocalDate;

public class Comment extends User
{
    private String commentMessage;
    private LocalDate commentDate;
    private int likes;

    public Comment(String commentMessage)
    {
        this.commentMessage = commentMessage;


    }
    public String getCommentMessage()
    {
        return commentMessage;
    }

    public void setCommentMessage(String commentMessage)
    {
        this.commentMessage = commentMessage;
    }

    public LocalDate getCommentDate()
    {
        return commentDate;
    }

    public void setCommentDate(LocalDate commentDate)
    {
        this.commentDate = commentDate;
    }

    public int getLikes()
    {
        return likes;
    }

    public void setLikes(int likes)
    {
        this.likes = likes;
    }

}
