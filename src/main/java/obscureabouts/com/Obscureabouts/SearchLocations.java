package obscureabouts.com.Obscureabouts;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class SearchLocations extends Location
{
    private HashMap<String, Location> locationName = new HashMap<>();

    public SearchLocations()
    {

        //Initializes location HashTable with location objects
        locationName.put("Mushroom House", new Location("9036 La Jolla Shores Ln, La Jolla, " +
                "CA 92037", "Mushroom House", 27.5, "None", 90, Arrays.asList("Beach", "Ocean", "Abandoned", "La Jolla")));
        locationName.put("Hidden Swing", new Location ("2300 Expedition Way, La Jolla, CA 92037",
                "Hidden Swing", 27.5, "None", 30, Arrays.asList("La Jolla", "Hidden", "Beach", "Wildlife", "Hiking")));
        locationName.put("Rum Runners Cave", new Location ("Rum Runners Cave, San Diego, CA 92107",
                "Rum Runners Cave", 22.6, "None", 70, Arrays.asList("Beach", "Ocean", "Caves", "Sunset Cliffs")));
        locationName.put("Proctor Valley", new Location ("Proctor Valley Rd, California", "Proctor Valley", 11.0, "None", 50, Arrays.asList("Nature", "Dirt", "Wildlife", "Hiking", "Abandoned")));
        locationName.put("Classic Rotors Museum", new Location ("2690 Montecito Rd, Ramona, CA 92065", "Classic Rotors Museum",36.0, "10 AM - 6PM", 99, Arrays.asList("Helicopter", "Museum","Fun", "Free", "Educational")));
    }


    public Location findByName(String name)
    {
        if (name == null)
        {
           return null;
        }
        return locationName.get(name);
    }

    public void add(Location place)
    {
        locationName.put(place.getName(), place);
    }

    public List<Location> listAll()
    {
        return new ArrayList<>(locationName.values());
    }

}