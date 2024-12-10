package obscureabouts.com.Obscureabouts;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
@PageTitle("Favorites")
@Route("favorites")
public class FavoritesDisplay extends VerticalLayout
{

    public FavoritesDisplay()
    {
        Button goBack = new Button("Go Back");
        goBack.addClickListener(click ->
                UI.getCurrent().navigate("main"));
        add(goBack);

        //Get information from the locations class
        var locations = Locations.getUserList();

        if (locations.isEmpty())
        {
            add(new Text("Hey inspector, you don't have any locations on your favorites yet!"));

        }
        else
        {
            locations.forEach(location -> add(new Text(location.getName() + ", ")));
        }

        Button sortButton = new Button("Sort Alphabetically");
        sortButton.addClickListener(click ->
        {
            ArrayList<String> displaySortedValues;
            displaySortedValues = Locations.sortLocationsAlphabetically();
            displaySortedValues.forEach(String-> add(new Text(String + ", ")));
            sortButton.setEnabled(false);

        });

        add(sortButton);
    }

}
