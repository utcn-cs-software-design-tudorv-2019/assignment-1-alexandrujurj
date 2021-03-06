package presentation;

import com.sun.prism.Image;

import business.LoginBusiness;
import business.Validation;
import data_access.StudentProfile;
import data_access.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
//import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Login {

	Stage window;
	TextField userName;
	PasswordField password;

	public Login() {

		window = new Stage();
		window.initStyle(StageStyle.TRANSPARENT);
		window.setTitle("LOGIN");

		BorderPane layout = new BorderPane();
		layout.setId("root");
		VBox topPane = new VBox(40);
		topPane.setAlignment(Pos.CENTER);
		topPane.setPadding(new Insets(100, 20, 20, 20));
		// ImageView img = new ImageView(new
		// Image("https://www.amigio.ro/wp-content/uploads/2012/03/angajam-programator-web-joburi.png"));
		// img.setFitHeight(300);
		// img.setFitWidth(300);
		// topPane.getChildren().add(img);

		VBox leftPane = new VBox(30);
		leftPane.setAlignment(Pos.CENTER);
		leftPane.setPadding(new Insets(20, 20, 20, 400));
		Label label1 = new Label("Username");
		Label label2 = new Label("Password");
		leftPane.getChildren().addAll(label1, label2);

		VBox rightPane = new VBox(30);
		rightPane.setAlignment(Pos.CENTER);
		rightPane.setPadding(new Insets(20, 400, 20, 20));
		userName = new TextField();
		userName.setMinWidth(300);
		password = new PasswordField();
		password.setMinWidth(300);
		rightPane.getChildren().addAll(userName, password);

		VBox bottomPane = new VBox(40);
		bottomPane.setAlignment(Pos.CENTER);
		bottomPane.setPadding(new Insets(20, 20, 100, 20));
		Button login = new Button("Login");
		login.setOnAction(e -> handleButtonEvent());
		Button close = new Button("Close Application");
		close.setOnAction(e -> {
			window.close();
			// exit(0);
		});
		bottomPane.getChildren().addAll(login, close);

		layout.setTop(topPane);
		layout.setLeft(leftPane);
		layout.setRight(rightPane);
		layout.setBottom(bottomPane);
		Scene scene = new Scene(layout, 1200, 800);
		// scene.getStylesheets().add("DarkTheme.css");
		window.setScene(scene);
		window.show();

	}

	private void handleButtonEvent() {
		String userNameStr = userName.getText();
		String passwordStr = password.getText();

		LoginBusiness loginBLL = new LoginBusiness();
		User user = loginBLL.loginOperation(userNameStr, passwordStr);
		System.out.println(user);
		String userType = "";
		if (user != null)
			userType = user.getType();

		switch (userType) {
		case "user": {

			System.out.println("trying to login as student");
			StudentProfile student = loginBLL.loginAsStudent(user.getId());

			if (student != null) {
				StudentView sc = new StudentView(student);
				window.close();
			}
		}
			break;
		case "admin": {
			System.out.println("login as admin");// AdminController ac = new AdminController();window.close();
		}
			break;
		default: {
			userName.clear();
			password.clear();
		}
			break;
		}
	}

}
