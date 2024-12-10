package obscureabouts.com.Obscureabouts;

import java.util.ArrayList;
import java.util.Collections;

public class Locations
{
    private static ArrayList<Location> userList = new ArrayList<>();

    public static ArrayList<Location> getUserList()
    {
        return userList;
    }

    public void setUserList(ArrayList<Location> userList)
    {
        Locations.userList = userList;
    }

    public Locations()
    {
        userList = new ArrayList<>();
    }
    public Locations(Location place)
    {
        userList.add(place);
    }
    public void addLocation(Location place)
    {
        userList.add(place);

    }

    public void removeLocation(Location place)
    {
        userList.remove(place);
    }

    public void setLocation(int index, Location place)
    {
        userList.set(index, place);
    }

    public static ArrayList<String> sortLocationsAlphabetically()
    {
        ArrayList <String> names = new ArrayList<>();
        for (Location place : userList)
        {
            names.add(place.getName());
        }
        Collections.sort(names);
        System.out.println(names);
        return names;
    }
}


