package obscureabouts.com.Obscureabouts;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Search Page")
@Route("search")
public class SearchDisplay extends VerticalLayout
{
    public SearchDisplay()
    {

        Button goBack = new Button("Go Back");
        goBack.addClickListener(click ->
                UI.getCurrent().navigate("main"));
        add(goBack);

        //Search by name GUI
        TextArea searchByNameExplanation = new TextArea();
        searchByNameExplanation.setValue("Input name of the place you'd like to search for below.");
        SearchLocations findAll = new SearchLocations();
        TextField searchField = new TextField();
        Button searchButton = new Button("Search");

        add(searchByNameExplanation);
        add(searchField);
        add(searchButton);

        searchButton.addClickListener(buttonClickEvent ->
        {
            String searchName = searchField.getValue();
            String displayResult = findAll.findByName(searchName).getName();
            System.out.println(displayResult);
            searchField.clear();

            switch (displayResult)
            {
                case "Mushroom House":
                    Dialog response = new Dialog();
                    response.setHeaderTitle("Heading to " + displayResult + " now!");
                    Button closeButton = new Button(new Icon("lumo", "cross"),
                            (e) -> response.close());
                    closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
                    Button areYouSure = new Button("Click here if you want to go to " + displayResult + ".");
                    response.add(areYouSure);
                    response.getHeader().add(closeButton);
                    add(response);
                    response.open();
                    searchField.clear();

                    areYouSure.addClickListener(buttonClickEvent1 ->
                            {
                                UI.getCurrent().navigate("mushroom");
                            });
                    break;
                case "Hidden Swing":
                    response = new Dialog();
                    response.setHeaderTitle("Heading to " + displayResult + " now!");
                    closeButton = new Button(new Icon("lumo", "cross"),
                            (e) -> response.close());
                    closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
                    areYouSure = new Button("Click here if you want to go to " + displayResult + ".");
                    response.add(areYouSure);
                    response.getHeader().add(closeButton);
                    add(response);
                    response.open();
                    searchField.clear();
                    areYouSure.addClickListener(buttonClickEvent1 ->
                    {
                        UI.getCurrent().navigate("swing");
                    });
                    break;
                case "Rum Runners Cave":
                    response = new Dialog();
                    response.setHeaderTitle("Heading to " + displayResult + " now!");
                    closeButton = new Button(new Icon("lumo", "cross"),
                            (e) -> response.close());
                    closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
                    areYouSure = new Button("Click here if you want to go to " + displayResult + ".");
                    response.add(areYouSure);
                    response.getHeader().add(closeButton);
                    add(response);
                    response.open();
                    searchField.clear();
                    areYouSure.addClickListener(buttonClickEvent1 ->
                    {
                        UI.getCurrent().navigate("rum");
                    });
                    break;
                case "Classic Rotors Museum":
                    response = new Dialog();
                    response.setHeaderTitle("Heading to " + displayResult + " now!");
                    closeButton = new Button(new Icon("lumo", "cross"),
                            (e) -> response.close());
                    closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
                    areYouSure = new Button("Click here if you want to go to " + displayResult + ".");
                    response.add(areYouSure);
                    response.getHeader().add(closeButton);
                    add(response);
                    response.open();
                    searchField.clear();
                    areYouSure.addClickListener(buttonClickEvent1 ->
                    {
                        UI.getCurrent().navigate("rotor");
                    });
                    break;
                case "Proctor Valley":
                    response = new Dialog();
                    response.setHeaderTitle("Heading to " + displayResult + " now!");
                    closeButton = new Button(new Icon("lumo", "cross"),
                            (e) -> response.close());
                    closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
                    areYouSure = new Button("Click here if you want to go to " + displayResult + ".");
                    response.add(areYouSure);
                    response.getHeader().add(closeButton);
                    add(response);
                    response.open();
                    searchField.clear();
                    areYouSure.addClickListener(buttonClickEvent1 ->
                    {
                        UI.getCurrent().navigate("proctor");
                    });
                    break;
                case null:
                    response = new Dialog();
                    response.setHeaderTitle("What you are typing does not exist in our system, please try again!");
                    closeButton = new Button(new Icon("lumo", "cross"),
                            (e) -> response.close());
                    closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
                    response.getHeader().add(closeButton);
                    add(response);
                    break;
                default:
            }

        });


        //Search by popularity GUI
        TextArea searchByPopularityExplanation = new TextArea();
        searchByPopularityExplanation.setValue("Input the score of the place you'd like to find below.");
        TextField searchByPopularity = new TextField();
        Button searchByPopularityButton = new Button("Search");

        add(searchByPopularityExplanation);
        add(searchByPopularity);
        add(searchByPopularityButton);


        LocationTree findPopular = new LocationTree();
        findPopular.initializeTree();
        findPopular.inOrderTraversal();

        searchByPopularityButton.addClickListener(buttonClickEvent ->
        {
            String searchPopValue = searchByPopularity.getValue();
            int userScore = Integer.parseInt(searchPopValue);
            String displayResult =  findPopular.search(userScore).getName();

            switch (displayResult)
            {
                case "Mushroom House":
                    Dialog response = new Dialog();
                    response.setHeaderTitle("Heading to " + displayResult + " now!");
                    Button closeButton = new Button(new Icon("lumo", "cross"),
                            (e) -> response.close());
                    closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
                    Button areYouSure = new Button("Click here if you want to go to " + displayResult + ".");
                    response.add(areYouSure);
                    response.getHeader().add(closeButton);
                    add(response);
                    response.open();
                    searchField.clear();

                    areYouSure.addClickListener(buttonClickEvent1 ->
                    {
                        UI.getCurrent().navigate("mushroom");
                    });
                    break;
                case "Hidden Swing":
                    response = new Dialog();
                    response.setHeaderTitle("Heading to " + displayResult + " now!");
                    closeButton = new Button(new Icon("lumo", "cross"),
                            (e) -> response.close());
                    closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
                    areYouSure = new Button("Click here if you want to go to " + displayResult + ".");
                    response.add(areYouSure);
                    response.getHeader().add(closeButton);
                    add(response);
                    response.open();
                    searchField.clear();
                    areYouSure.addClickListener(buttonClickEvent1 ->
                    {
                        UI.getCurrent().navigate("swing");
                    });
                    break;
                case "Rum Runners Cave":
                    response = new Dialog();
                    response.setHeaderTitle("Heading to " + displayResult + " now!");
                    closeButton = new Button(new Icon("lumo", "cross"),
                            (e) -> response.close());
                    closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
                    areYouSure = new Button("Click here if you want to go to " + displayResult + ".");
                    response.add(areYouSure);
                    response.getHeader().add(closeButton);
                    add(response);
                    response.open();
                    searchField.clear();
                    areYouSure.addClickListener(buttonClickEvent1 ->
                    {
                        UI.getCurrent().navigate("rum");
                    });
                    break;
                case "Classic Rotors Museum":
                    response = new Dialog();
                    response.setHeaderTitle("Heading to " + displayResult + " now!");
                    closeButton = new Button(new Icon("lumo", "cross"),
                            (e) -> response.close());
                    closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
                    areYouSure = new Button("Click here if you want to go to " + displayResult + ".");
                    response.add(areYouSure);
                    response.getHeader().add(closeButton);
                    add(response);
                    response.open();
                    searchField.clear();
                    areYouSure.addClickListener(buttonClickEvent1 ->
                    {
                        UI.getCurrent().navigate("rotor");
                    });
                    break;
                case "Proctor Valley":
                    response = new Dialog();
                    response.setHeaderTitle("Heading to " + displayResult + " now!");
                    closeButton = new Button(new Icon("lumo", "cross"),
                            (e) -> response.close());
                    closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
                    areYouSure = new Button("Click here if you want to go to " + displayResult + ".");
                    response.add(areYouSure);
                    response.getHeader().add(closeButton);
                    add(response);
                    response.open();
                    searchField.clear();
                    areYouSure.addClickListener(buttonClickEvent1 ->
                    {
                        UI.getCurrent().navigate("proctor");
                    });
                    break;
                case null:
                    response = new Dialog();
                    response.setHeaderTitle("What you are typing does not exist in our system, please try again!");
                    closeButton = new Button(new Icon("lumo", "cross"),
                            (e) -> response.close());
                    closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
                    response.getHeader().add(closeButton);
                    add(response);
                    break;
                default:
            }

            searchByPopularity.clear();

        });

        //Search by recommendation GUI
        TextArea searchRecommendationExplanation = new TextArea();
        searchRecommendationExplanation.setValue("Click below to see which locations are related to one another!");
        TextField searchRecommendations = new TextField();
        Button searchRecommendationsButton = new Button("Search");

        add(searchRecommendationExplanation);
        add(searchRecommendations);
        add(searchRecommendationsButton);

        searchRecommendationsButton.addClickListener(buttonClickEvent ->
        {
            String recommendationValue = searchRecommendations.getValue();
            LocationGraph locationGraph = new LocationGraph();
            TextArea showGraph = new TextArea();
            showGraph.setWidth("48%");
            showGraph.setValue(locationGraph.displayGraph());
            add(showGraph);
        });
    }

}
