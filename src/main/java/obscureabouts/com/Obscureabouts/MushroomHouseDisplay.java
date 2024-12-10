package obscureabouts.com.Obscureabouts;


import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;
import java.util.List;
import java.util.ArrayList;

@PageTitle("Mushroom House")
@Route("mushroom")
public class MushroomHouseDisplay extends VerticalLayout
{
    private String address = "9036 La Jolla Shores Ln, La Jolla, CA 92037";
    private String name = "Mushroom House";
    private Double distance = 27.5;
    private String hours = "None";
    private List <String> tags = new ArrayList<String>();
    private int score = 90;

    public MushroomHouseDisplay()
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

        //Beginning Tags for MushroomHouse
        tags.add("Beach");
        tags.add("Ocean");
        tags.add("Abandoned");
        tags.add("La Jolla");

        Location mushroomHouseInfo = new Location(address, name, distance, hours, score, tags);

        VerticalLayout locationDisplay = new VerticalLayout();

        locationDisplay.setAlignItems(FlexComponent.Alignment.CENTER);
        add(new H2("Mushroom House"));

        StreamResource mushroomResource = new StreamResource("mushroom-house-san-diego.jpg",
                () -> getClass().getResourceAsStream("/images/mushroom-house-san-diego.jpg"));

        Image mushroomHouse = new Image(mushroomResource, "Mushroom House");
        mushroomHouse.setWidth("37%");

        locationDisplay.setAlignSelf(Alignment.CENTER, mushroomHouse);
        add(mushroomHouse);

        //Description about the Mushroom House
        TextArea mushroomArea = new TextArea("La Jolla Mushroom House");
        mushroomArea.setReadOnly(true);
        mushroomArea.setWidth("50%");
        mushroomArea.setValue("The Mushroom House in La Jolla is an abandoned property well known " +
                "for its unusual architecture, which makes it stand out to its visitors. " +
                "Built by Sam Bell of Bell’s Potato Chips, he wished to create a spot where visitors " +
                "could enjoy beautiful ocean vistas in private. The bottom of a cliff and on Black's Beach " +
                "was the perfect place for it to be built! ");

        locationDisplay.setAlignSelf(Alignment.CENTER, mushroomArea);
        add(mushroomArea);

        TextArea mushRoomData = new TextArea();
        mushRoomData.setReadOnly(true);
        mushRoomData.setWidth("27%");
        mushRoomData.setValue("Name: " + name +
                "\nAddress: " + address +
                "\nDistance: " + distance +
                "\nHours: " + hours +
                "\nUser Score: " + score);
        locationDisplay.setAlignSelf(Alignment.CENTER, mushRoomData);
        add(mushRoomData);


        Button addLocation = new Button("Add Location To Favorites");
        locationDisplay.setAlignSelf(Alignment.CENTER, addLocation);
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
            new Locations(mushroomHouseInfo);
            response.open();
        });



        //Making a comment on a page
        MessageInput comment = new MessageInput();
        locationDisplay.setAlignSelf(Alignment.CENTER, comment);
        comment.addSubmitListener(submitEvent ->
        {

            //Dialog box that tells user that they've made a comment
            Dialog commentMade = new Dialog();
            locationDisplay.setAlignSelf(Alignment.CENTER, commentMade);
            commentMade.setHeaderTitle("Your comment has been submitted.");
            Button closeReminder = new Button(new Icon("lumo", "cross"),
                    (e) -> commentMade.close());
            closeReminder.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
            commentMade.getHeader().add(closeReminder);
            add(commentMade);

            commentMade.open();

            //Comment is created here.
            Comment userComment = new Comment(submitEvent.getValue());

            TextArea commentDisplay = new TextArea(userComment.getStoredUsername());
            commentDisplay.setValue(userComment.getCommentMessage());
            locationDisplay.setAlignSelf(Alignment.CENTER, commentDisplay);
            commentDisplay.setReadOnly(true);
            add(commentDisplay);

            //Remove comment is created here
            Button removeButton = new Button("Delete");
            removeButton.setWidth("6%");
            locationDisplay.setAlignSelf(Alignment.CENTER, removeButton);

            removeButton.addClickListener(buttonClickEvent ->
            {
                Comments newReview = new Comments(userComment);
                newReview.dequeueReview(userComment);
                remove(commentDisplay);
                remove(removeButton);
            });

            add(removeButton);

        });

        add(comment);



    }
}
