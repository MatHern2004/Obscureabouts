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

@PageTitle("Proctor Valley")
@Route("proctor")
public class ProctorValleyDisplay extends VerticalLayout
{
    private String address = "Proctor Valley Rd, California";
    private String name = "Proctor Valley";
    private Double distance = 11.0;
    private String hours = "None";
    private List<String> tags = new ArrayList<String>();
    private int score = 50;

    public ProctorValleyDisplay()
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


        //Beginning Tags for ProctorValley
        tags.add("Nature");
        tags.add("Dirt");
        tags.add("Abandoned");
        tags.add("Wildlife");
        tags.add("Hiking");

        Location proctorValleyInfo = new Location(address, name, distance, hours, score, tags);

        VerticalLayout locationDisplay = new VerticalLayout();

        locationDisplay.setAlignItems(FlexComponent.Alignment.CENTER);
        add(new H2("Proctor Valley"));

        StreamResource proctorValleyResource = new StreamResource("proctor-valley.jpg",
                () -> getClass().getResourceAsStream("/images/proctor-valley.jpg"));

        Image proctorValley = new Image(proctorValleyResource, "Proctor Valley");
        proctorValley.setWidth("37%");

        locationDisplay.setAlignSelf(FlexComponent.Alignment.CENTER, proctorValley);
        add(proctorValley);

        //Description about Proctor Valley
        TextArea proctorValleyArea = new TextArea("Proctor Valley");
        proctorValleyArea.setReadOnly(true);
        proctorValleyArea.setWidth("50%");
        proctorValleyArea.setValue("Proctor Valley is an abandoned dirt road that lasts 5 miles going from Jamul " +
                "to Chula Vista. It contains numerous unique forms of plant and animal life, but is slowly " +
                "being consumed by urban development. The road itself is considered haunted and sightings of " +
                "ghost cars, women, and animals have been sighted. Not only that, but you may bear witness to animal " +
                "carcasses near an abandoned barn in the area.");
        locationDisplay.setAlignSelf(FlexComponent.Alignment.CENTER, proctorValleyArea);
        add(proctorValleyArea);

        TextArea proctorValleyData = new TextArea();
        proctorValleyData.setReadOnly(true);
        proctorValleyData.setWidth("27%");
        proctorValleyData.setValue("Name: " + name +
                "\nAddress: " + address +
                "\nDistance: " + distance +
                "\nHours: " + hours +
                "\nUser Score: " + score);
        locationDisplay.setAlignSelf(Alignment.CENTER, proctorValleyData);
        add(proctorValleyData);

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
            new Locations(proctorValleyInfo);
            response.open();
        });

    }
}
