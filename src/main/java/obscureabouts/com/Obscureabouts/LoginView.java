package obscureabouts.com.Obscureabouts;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;

@PageTitle("Login")
@Route("")
public class LoginView extends VerticalLayout
{
    String passwordInput;
    String usernameInput;
    public LoginView()
    {
        TextField username = new TextField("Username");
        PasswordField password = new PasswordField("Password");
        Button loginButton = new Button("Login");

        add(new H3("Login Page"));
        add(username);
        add(password);
        add(loginButton);
        loginButton.addClickListener(buttonClickEvent ->
        {

                usernameInput = username.getValue();
                passwordInput = password.getValue();
                User user = new User("Mathew", "523 Bruma Court", "awesomematt04@gmail.com", usernameInput, passwordInput);

                if (user.getStoredUsername().equals(usernameInput) && !user.checkPassword(passwordInput))
                {
                    password.clear();
                    password.setPlaceholder("incorrect password");
                }

                else if (user.checkPassword(passwordInput) && !user.getStoredUsername().equals(usernameInput))
                {
                    username.clear();
                    username.setPlaceholder("incorrect username");
                }

                else if (!user.getStoredUsername().equals(usernameInput) && !user.checkPassword(passwordInput))
                {
                    username.clear();
                    password.clear();
                    username.setPlaceholder("incorrect username");
                    password.setPlaceholder("incorrect password");
                }

                else
                {
                    Dialog loginDialog = new Dialog();
                    loginDialog.setHeaderTitle("Now Logging In");
                    username.clear();
                    password.clear();
                    add(loginDialog);
                    loginDialog.open();
                    UI.getCurrent().navigate("main");
                }
        });

        loginButton.addClickShortcut(Key.ENTER);

        StreamResource logoResource = new StreamResource("obscureabouts-logo.png",
                () -> getClass().getResourceAsStream("/images/obscureabouts-logo.png"));

        Image logo = new Image(logoResource, "Obscureabouts Logo");

        add(logo);
    }

}
