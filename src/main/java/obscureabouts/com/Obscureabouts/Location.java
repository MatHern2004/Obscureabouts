package obscureabouts.com.Obscureabouts;

import java.util.ArrayList;
import java.util.List;

public class Location
{
   private String address;
   private String name;
   private Double distance;
   private String hours;
   private int score;
   private List<String> tags = new ArrayList<String>();

    public Location()
    {
        this.name = null;
        this.distance = null;
        this.hours = null;
        this.score = 0;
    }

    public Location(String name, List<String> tags)
    {
        this.name = name;
        this.tags = tags;
        this.distance = null;
        this.hours = null;
        this.score = 0;
    }


    public Location (String address, String name, Double distance, String hours, int score, List<String> tags)
    {
        this.address = address;
        this.name = name;
        this.distance = distance;
        this.hours = hours;
        this.tags = tags;
        this.score = score;
    }

    public List<String> getTags()
    {
        return tags;
    }

    public void setTags(List<String> tags)
    {
        this.tags = tags;
    }

    public String getHours()
    {
        return hours;
    }

    public void setHours(String hours)
    {
        this.hours = hours;
    }

    public Double getDistance()
    {
        return distance;
    }

    public void setDistance(Double distance)
    {
        this.distance = distance;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public int getScore()
    {
        return score;
    }

    @Override
    public String toString()
    {
        return "Location {" +
                "address = '" + address + '\'' +
                ", name = '" + name + '\'' +
                ", distance = " + distance +
                ", hours = " + hours +
                ", tags =' " + tags + '\'' +
                '}';
    }


}
