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

@PageTitle("Hidden Swing")
@Route("swing")
public class HiddenSwingDisplay extends VerticalLayout {
    private String address = "2300 Expedition Way, La Jolla, CA 92037";
    private String name = "Hidden Swing";
    private Double distance = 27.5;
    private String hours = "None";
    private List<String> tags = new ArrayList<String>();
    private int score = 30;

    public HiddenSwingDisplay()
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


        //Beginning Tags for Hidden Swing
        tags.add("La Jolla");
        tags.add("Hidden");
        tags.add("Beach");
        tags.add("Wildlife");
        tags.add("Hiking");

        Location hiddenSwingInfo = new Location(address, name, distance, hours, score, tags);

        VerticalLayout locationDisplay = new VerticalLayout();

        locationDisplay.setAlignItems(FlexComponent.Alignment.CENTER);
        add(new H2("Hidden Swing"));

        StreamResource hiddenSwingResource = new StreamResource("hidden-swing.jpg",
                () -> getClass().getResourceAsStream("/images/hidden-swing.jpg"));

        Image hiddenSwing = new Image(hiddenSwingResource, "Hidden Swing");
        hiddenSwing.setWidth("37%");

        locationDisplay.setAlignSelf(FlexComponent.Alignment.CENTER, hiddenSwing);
        add(hiddenSwing);

        //Description about the Hidden Swing
        TextArea hiddenSwingArea = new TextArea("Hidden Swing");
        hiddenSwingArea.setReadOnly(true);
        hiddenSwingArea.setWidth("50%");
        hiddenSwingArea.setValue("Located on the far end of the Birch Aquarium at Scripps Institution of " +
                "Oceanography parking lot resides an open path that leads to a steep hill. If one were to " +
                "climb up the hill, they would be met with a rope swing tied to a large tree. The swing " +
                "may be used by anyone and allows for a beautiful panoramic view of the Ocean.");
        locationDisplay.setAlignSelf(FlexComponent.Alignment.CENTER, hiddenSwingArea);
        add(hiddenSwingArea);

        TextArea hiddenSwingData = new TextArea();
        hiddenSwingData.setReadOnly(true);
        hiddenSwingData.setWidth("27%");
        hiddenSwingData.setValue("Name: " + name +
                "\nAddress: " + address +
                "\nDistance: " + distance +
                "\nHours: " + hours +
                "\nUser Score: " + score);
        locationDisplay.setAlignSelf(Alignment.CENTER, hiddenSwingData);
        add(hiddenSwingData);


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
            new Locations(hiddenSwingInfo);
            response.open();
        });
    }
}
