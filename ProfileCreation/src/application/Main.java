package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;




public class Main extends Application {
	
	
	Password pass;
	Stage window;
	Scene scene1;
	Profile profile;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			window = primaryStage;
			GridPane grid = new GridPane();
			
			Label lbl = new Label("Enter a username: ");
			Label lbl1 = new Label("Enter a password: ");
			TextField userField = new TextField();
			TextField passField = new TextField();
			Button submit = new Button("Submit");
			
			grid.add(lbl, 0, 0);
			grid.add(lbl1, 0, 1);
			grid.add(userField, 1, 0);
			grid.add(passField, 1, 1);
			grid.add(submit, 1, 2);
			
			
			GridPane grid2 = new GridPane();
			
			
			BorderPane root1 = new BorderPane(grid2);
			scene1 = new Scene(root1, 500, 500);
			
			
			
			submit.setOnAction(e -> {
				pass = new Password(passField.getText(), passField.getText().length());
				profile = new Profile(userField.getText(), pass);
				grid2.add(new Label(profile.getUsername()), 0, 0);
				grid2.add(new Label(profile.getPassword().encrypt()), 0, 1);
				
				window.setScene(scene1);
			});
			
			
			
			BorderPane root = new BorderPane(grid);
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}//does this work
}
