package obscureabouts.com.Obscureabouts;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;

import java.util.ArrayList;
import java.util.List;

@PageTitle("RumRunners")
@Route("rum")
public class RumRunnersDisplay extends VerticalLayout
{

        private String address = "Rum Runners Cave, San Diego, CA 92107";
        private String name = "Rum Runners Cave";
        private Double distance = 22.6;
        private String hours = "None";
        private List<String> tags = new ArrayList<String>();
        private int score = 70;

    public RumRunnersDisplay()
        {
            Button goBack = new Button("Go Back");
            goBack.addClickListener(click ->
                    UI.getCurrent().navigate("main"));
            add(goBack);

            Button checkFavorites = new Button("Check Favorites");
            add(checkFavorites);
            HorizontalLayout buttons = new HorizontalLayout(checkFavorites);

            checkFavorites.addClickListener(click ->
                    UI.getCurrent().navigate("favorites"));
            add(buttons);

            Button seeSearch = new Button("See Search");
            seeSearch.addClickListener(click ->
                    UI.getCurrent().navigate("search"));
            add(seeSearch);

            //Beginning Tags for RumRunnersCave
            tags.add("Beach");
            tags.add("Ocean");
            tags.add("Caves");
            tags.add("Sunset Cliffs");

            Location rumRunnersInfo = new Location(address, name, distance, hours, score, tags);

            VerticalLayout locationDisplay = new VerticalLayout();

            locationDisplay.setAlignItems(FlexComponent.Alignment.CENTER);
            add(new H2("Rum Runners Cave"));

            StreamResource rumRunnersResource = new StreamResource("rum-runners-cave.jpg",
                    () -> getClass().getResourceAsStream("/images/rum-runners-cave.jpg"));

            Image rumRunners = new Image(rumRunnersResource, "Rum Runners");
            rumRunners.setWidth("37%");

            locationDisplay.setAlignSelf(FlexComponent.Alignment.CENTER, rumRunners);
            add(rumRunners);

            //Description about Rum Runners Cave
            TextArea rumRunnersArea = new TextArea("Rum Runners Cave");
            rumRunnersArea.setReadOnly(true);
            rumRunnersArea.setWidth("50%");
            rumRunnersArea.setValue("The Rum Runners Cave is a tunnel that's been dug through in " +
                    "Sunset Cliffs. Older photos show that the area used to contain houses along the cliff side, but " +
                    "they were removed and what's left are the holes that would take guests there. " +
                    "There is also a concrete stairways provide access to the passageway, which several off-shoots and " +
                    "one longer passageway at sea level.");
            locationDisplay.setAlignSelf(FlexComponent.Alignment.CENTER, rumRunnersArea);
            add(rumRunnersArea);


            TextArea rumRunnersData = new TextArea();
            rumRunnersData.setReadOnly(true);
            rumRunnersData.setWidth("27%");
            rumRunnersData.setValue("Name: " + name +
                    "\nAddress: " + address +
                    "\nDistance: " + distance +
                    "\nHours: " + hours +
                    "\nUser Score: " + score);
            locationDisplay.setAlignSelf(Alignment.CENTER, rumRunnersData);
            add(rumRunnersData);


            Button addLocation = new Button("Add Location To Favorites");
            locationDisplay.setAlignSelf(FlexComponent.Alignment.CENTER, addLocation);
            add(addLocation);


            //Popup box that tells the user that the location has been added to their favorites!
            Dialog response = new Dialog();
            response.setHeaderTitle(name + " has been added to your list!");
            Button closeButton = new Button(new Icon("lumo", "cross"),
                    (e) -> response.close());
            closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
            response.getHeader().add(closeButton);
            add(response);

            addLocation.setDisableOnClick(true);
            addLocation.addClickListener(buttonClickEvent ->
            {
                new Locations(rumRunnersInfo);
                response.open();
            });

        }
    }