package obscureabouts.com.Obscureabouts;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;

@PageTitle("Main")
@Route("main")
public class MainView extends HorizontalLayout
{
    public MainView()
    {
        Text welcome = new Text("Welcome, Mat!");
        add(welcome);

        StreamResource mushroomResource = new StreamResource("mushroom-house-san-diego.jpg",
                () -> getClass().getResourceAsStream("/images/mushroom-house-san-diego.jpg"));

        Image mushroomHouse = new Image(mushroomResource, "Mushroom House");
        mushroomHouse.setWidth("20%");

        mushroomHouse.addClickListener(click ->
        {
            UI.getCurrent().navigate("mushroom");
        });


        StreamResource rumRunnersResource = new StreamResource("rum-runners-cave.jpg",
                () -> getClass().getResourceAsStream("/images/rum-runners-cave.jpg"));

        Image rumRunners = new Image(rumRunnersResource, "Rum Runners");
        rumRunners.setWidth("20%");

        rumRunners.addClickListener(click ->
        {
            UI.getCurrent().navigate("rum");
        });



        StreamResource proctorValleyResource = new StreamResource("proctor-valley.jpg",
                () -> getClass().getResourceAsStream("/images/proctor-valley.jpg"));

        Image proctorValley = new Image(proctorValleyResource, "Proctor Valley");
        proctorValley.setWidth("20%");


        proctorValley.addClickListener(click ->
        {
            UI.getCurrent().navigate("proctor");
        });


        StreamResource hiddenSwingResource = new StreamResource("hidden-swing.jpg",
                () -> getClass().getResourceAsStream("/images/hidden-swing.jpg"));

        Image hiddenSwing = new Image(hiddenSwingResource, "Hidden Swing");
        hiddenSwing.setWidth("20%");

        hiddenSwing.addClickListener(click ->
        {
            UI.getCurrent().navigate("swing");
        });

        StreamResource classicRotorsResource = new StreamResource("classic-rotors-museum.jpg",
                () -> getClass().getResourceAsStream("/images/classic-rotors-museum.jpg"));

        Image classicRotors = new Image(classicRotorsResource, "Classic Rotors Museum");
        classicRotors.setWidth("20%");
        classicRotors.addClickListener(click ->
        {
            UI.getCurrent().navigate("rotor");
        });

        add(mushroomHouse);
        add(rumRunners);
        add(proctorValley);
        add(hiddenSwing);
        add(classicRotors);
    }

}
