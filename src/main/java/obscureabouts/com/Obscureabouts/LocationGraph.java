package obscureabouts.com.Obscureabouts;

import java.util.*;

public class LocationGraph
{

    final private Map<Location, List<Location>> adjacencyList = new HashMap<>();

    //Begins with initialized Location classes
    Location mush = new Location("Mushroom House", Arrays.asList("Beach", "Ocean", "Abandoned", "La Jolla"));
    Location hidden  = new Location ("Hidden Swing", Arrays.asList("La Jolla", "Hidden", "Beach", "Wildlife", "Hiking"));
    Location rum = new Location ("Rum Runners Cave", Arrays.asList("Beach", "Ocean", "Caves", "Sunset Cliffs"));
    Location proctor = new Location ("Proctor Valley", Arrays.asList("Nature", "Dirt", "Wildlife", "Hiking", "Abandoned"));
    Location rotors = new Location ("Rotors", Arrays.asList("Helicopter", "Museum","Fun", "Free", "Educational"));


    //Creates graph within constructor
    public LocationGraph()
    {
        List <Location> locations = Arrays.asList(mush, hidden, rum, proctor, rotors);
        initializeGraph(locations);
    }


    public void addVertex(Location place)
    {
        adjacencyList.putIfAbsent(place, new ArrayList<>());
    }

    public void addEdge(Location to, Location from)
    {
        if (!adjacencyList.containsKey(to))
        {
            addVertex(to);
        }
        if (!adjacencyList.containsKey(from))
        {
            addVertex(from);
        }

        //Checks to see if directed or not and moves on from there
        if (!adjacencyList.get(to).contains(from))
        {
            adjacencyList.get(to).add(from);
        }

        if (!adjacencyList.get(from).contains(to))
        {
            adjacencyList.get(from).add(to);
        }
    }

    public void initializeGraph(List<Location> places)
    {
        for (int i = 0; i < places.size(); i++)
        {
            for (int j = 0; j < places.size(); j++)
            {
                if(shareTags(places.get(i), places.get(j)))
                {
                    addEdge(places.get(i), places.get(j));
                }
            }
        }
    }

    //Identifies tags that are shared between two locations
    public boolean shareTags(Location to, Location from)
    {
        for (String tag : to.getTags())
        {
            if (from.getTags().contains(tag))
            {
                return true;
            }
        }
        return false;
    }

    //Prints out the relationships between the locations based on the graphs they have.
    public String displayGraph()
    {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Location, List<Location>> entry : adjacencyList.entrySet())
        {
            sb.append(entry.getKey().getName()).append(" -> ");
                for (Location connection : entry.getValue())
                {
                    sb.append(connection.getName()).append(", ");
                }
                sb.append("\n");
        }
        return sb.toString();
    }

}
