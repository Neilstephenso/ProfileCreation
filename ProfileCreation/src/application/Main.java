package application;

import java.io.File;
import java.io.PrintWriter;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	Password pass;
	Stage window;
	Scene scene1;
	Profile profile;
	int numProfile = 0;
	TableView table = new TableView();
	@SuppressWarnings("unchecked")
	ObservableList<Object> profileList = FXCollections.observableArrayList();

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) {
		try {
			window = primaryStage;
			GridPane grid = new GridPane();

			Label lbl = new Label("Enter a username: ");
			Label lbl1 = new Label("Enter a password: ");
			Label lbl2 = new Label("Enter your email: ");
			TextField userField = new TextField();
			TextField passField = new TextField();
			TextField eField = new TextField();
			Button submit = new Button("Submit");
			Button add = new Button("Add");
			Button save = new Button("Save");

			grid.add(lbl, 0, 0);
			grid.add(lbl1, 0, 1);
			grid.add(lbl2, 0, 2);
			grid.add(userField, 1, 0);
			grid.add(passField, 1, 1);
			grid.add(eField, 1, 2);
			grid.add(submit, 1, 3);

			scene1 = new Scene(new Group());
			Label label = new Label("Profiles");
			TableColumn fName = new TableColumn("First Name");
			fName.setMinWidth(100);
			fName.setCellValueFactory(new PropertyValueFactory<Profile, String>("username"));
			TableColumn email = new TableColumn("Email");
			email.setMinWidth(100);
			email.setCellValueFactory(new PropertyValueFactory<Profile, String>("email"));

			TableColumn pWord = new TableColumn("Password");
			pWord.setMinWidth(100);
			pWord.setCellValueFactory(new PropertyValueFactory<Profile, String>("password"));
			
			VBox vbox = new VBox();
			vbox.setSpacing(5);
			vbox.setPadding(new Insets(10, 0, 0, 10));
			HBox hbox = new HBox();
			hbox.getChildren().addAll(add, save);
			vbox.getChildren().addAll(label, table, hbox);
			((Group) scene1.getRoot()).getChildren().add(vbox);

			table.getColumns().addAll(fName, email, pWord);

			add.setOnAction(e -> {
				GridPane grid1 = new GridPane();
				grid1.add(lbl, 0, 0);
				grid1.add(lbl1, 0, 1);
				grid1.add(lbl2, 0, 2);
				grid1.add(userField, 1, 0);
				grid1.add(passField, 1, 1);
				grid1.add(eField, 1, 2);
				grid1.add(submit, 1, 3);

				Scene scene2 = new Scene(grid1);

				window.setScene(scene2);
			});

			save.setOnAction(e -> {
				try { 
					PrintWriter write = new PrintWriter("Storage");
					for (int i = 0; i < numProfile; i ++) {
						write.println(profile.getUsername() + ", " + profile.getEmail() + ", " + profile.getPassword());
						System.out.println(profile.getUsername() + ", " + profile.getEmail() + ", " + profile.getPassword());
					}
					write.close();
					
					
				} catch (Exception e2) {
					e2.getMessage();
				}

			});

			submit.setOnAction(e -> {
					profile = new Profile(userField.getText(), eField.getText(), passField.getText());
				
				profileList.add(profile);

				table.setItems(profileList);
				primaryStage.setWidth(500);
				primaryStage.setHeight(500);
				numProfile++;

				window.setScene(scene1);
			});

			BorderPane root = new BorderPane(grid);
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}// does this work
}
