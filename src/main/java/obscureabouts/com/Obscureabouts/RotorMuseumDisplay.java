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

@PageTitle("Classic Rotors Museum")
@Route("rotor")
public class RotorMuseumDisplay extends VerticalLayout
{
    private String address = "2690 Montecito Rd, Ramona, CA 92065";
    private String name = "Classic Rotors Museum";
    private Double distance = 36.0;
    private String hours = "10 AM - 6PM";
    private List<String> tags = new ArrayList<String>();
    private int score = 99;

    public RotorMuseumDisplay() {
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

        //Beginning Tags for RotorMuseum
        tags.add("Helicopter");
        tags.add("Museum");
        tags.add("Fun");
        tags.add("Free");
        tags.add("Educational");

        Location classicRotorsInfo = new Location(address, name, distance, hours, score, tags);

        VerticalLayout locationDisplay = new VerticalLayout();

        locationDisplay.setAlignItems(FlexComponent.Alignment.CENTER);
        add(new H2("Classic Rotors Museum"));

        StreamResource classicRotorsResource = new StreamResource("classic-rotors-museum.jpg",
                () -> getClass().getResourceAsStream("/images/classic-rotors-museum.jpg"));

        Image classicRotorsMuseum = new Image(classicRotorsResource, "Classic Rotors Museum");
        classicRotorsMuseum.setWidth("37%");

        locationDisplay.setAlignSelf(FlexComponent.Alignment.CENTER, classicRotorsMuseum);
        add(classicRotorsMuseum);

        //Description about Classic Rotors Museum
        TextArea classicRotorsArea = new TextArea("Classic Rotors Museum");
        classicRotorsArea.setReadOnly(true);
        classicRotorsArea.setWidth("50%");
        classicRotorsArea.setValue("The Classic Rotors Museum is a non-profit 501(c)3, all-volunteer organization, flying aviation museum that specializes " +
                "in helicopters and other rotorcrafts located at Romona Airport. This location is free " +
                "to enter, but does ask for donations. Free tours of the location are also offered by the generous " +
                "staff.");
        locationDisplay.setAlignSelf(FlexComponent.Alignment.CENTER, classicRotorsArea);
        add(classicRotorsArea);

        TextArea roctorMuseumData = new TextArea();
        roctorMuseumData.setReadOnly(true);
        roctorMuseumData.setWidth("27%");
        roctorMuseumData.setValue("Name: " + name +
                "\nAddress: " + address +
                "\nDistance: " + distance +
                "\nHours: " + hours +
                "\nUser Score: " + score);
        locationDisplay.setAlignSelf(Alignment.CENTER, roctorMuseumData);
        add(roctorMuseumData);


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
            new Locations(classicRotorsInfo);
            response.open();

        });
    }
}
