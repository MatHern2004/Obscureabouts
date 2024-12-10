package obscureabouts.com.Obscureabouts;

import java.util.Arrays;
public class LocationTree extends Location
{
   private Node root;

   Location mush = new Location("9036 La Jolla Shores Ln, La Jolla, " +
           "CA 92037", "Mushroom House", 27.5, "None", 90, Arrays.asList("Beach", "Ocean", "Abandoned", "La Jolla"));
   Location hidden  = new Location ("2300 Expedition Way, La Jolla, CA 92037",
           "Hidden Swing", 27.5, "None", 30, Arrays.asList("La Jolla", "Hidden", "Beach", "Wildlife", "Hiking"));
   Location rum = new Location ("Rum Runners Cave, San Diego, CA 92107",
           "Rum Runners Cave", 22.6, "None", 70, Arrays.asList("Beach", "Ocean", "Caves", "Sunset Cliffs"));
   Location proctor = new Location ("Proctor Valley Rd, California", "Proctor Valley", 11.0, "None", 50, Arrays.asList("Nature", "Dirt", "Wildlife", "Hiking", "Abandoned"));
   Location rotors = new Location ("2690 Montecito Rd, Ramona, CA 92065", "Classic Rotors Museum",36.0, "10 AM - 6PM", 99, Arrays.asList("Helicopter", "Museum","Fun", "Free", "Educational"));

    public LocationTree()
    {
        root = null;
    }

    public void insert(Location place, int score)
    {
        root = insertRec(root, place, score);
    }

    public Node insertRec(Node node, Location place, int score)
    {
        if (node == null)
        {
            return new Node(place);

        }
        if (score < node.getPopularity().getScore())
        {
             node.setLeft(insertRec(node.getLeft(), place, score));
        }
        else
        {
             node.setRight(insertRec(node.getRight(), place, score));
        }
        return node;
    }

    public Location search(int score)
    {
        Node result = searchRec(root, score);

        if (result != null)
        {
            return result.getPopularity();
        }
        else
        {
            return null;
        }
    }

    public Node searchRec(Node node, int score)
    {
        if (node == null)
        {
            return null;
        }
        if (score == node.getPopularity().getScore())
        {
            return node;
        }

        if (score < node.getPopularity().getScore())
        {
            return searchRec(node.getLeft(), score);
        }
        else
        {
            return searchRec(node.getRight(), score);
        }
    }


    public void inOrderTraversal()
    {
           inOrderTraversalRec(root);
    }

    public void inOrderTraversalRec(Node node)
    {
        if (node == null)
        {
            return;
        }

        inOrderTraversalRec(node.getLeft());
        System.out.print(node.getPopularity().getScore() + " ");
        inOrderTraversalRec(node.getRight());
    }

    public void initializeTree()
    {
        insert(mush, mush.getScore());
        insert(hidden, hidden.getScore());
        insert(rum, rum.getScore());
        insert(proctor, proctor.getScore());
        insert(rotors, rotors.getScore());
    }

}