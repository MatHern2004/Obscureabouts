package obscureabouts.com.Obscureabouts;

public class Node extends Location
{
    final private Location popularity;
    private Node left;
    private Node right;

    public Node(Location value)
    {
        this.popularity = value;
        this.left = null;
        this.right = null;

    }

    public Node getLeft()
    {
        return left;
    }

    public void setLeft(Node left)
    {
        this.left = left;
    }

    public Node getRight()
    {
        return right;
    }

    public void setRight(Node right)
    {
        this.right = right;
    }

    public Location getPopularity()
    {
        return popularity;
    }

}
