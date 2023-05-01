package application;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * opens window and runs program to be able to take in a username, email, and password to create an account. 
 * the account can then be saved along with others added to a file which can be used to populate a new 
 * table with accounts.
 * 
 * @author StephensonNeil, Blake Jordan
 * @version 4/30/23
 */
public class Main extends Application {

	Password pass;
	Stage window;
	Scene scene1;
	Profile profile;
	int numProfile = 0;
	TableView table = new TableView();
	File out = new File("storage.txt");
	@SuppressWarnings("unchecked")
	ObservableList<Object> profileList = FXCollections.observableArrayList();
	ArrayList<Profile> list = new ArrayList<Profile>();

	
	/**
	 * makes the windows and takes in the information from the text boxes to create new accounts.
	 * these accounts can be saved, removed, added to and can also be pulled from a file.
	 * 
	 * @param primaryStage is the primary stage to be used to show the entry fields
	 */
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
			Button remove = new Button("Remove");
			TextField remField = new TextField();
			Button pull = new Button("pull");

			grid.add(lbl, 0, 0);
			grid.add(lbl1, 0, 1);
			grid.add(lbl2, 0, 2);
			grid.add(userField, 1, 0);
			grid.add(passField, 1, 1);
			grid.add(eField, 1, 2);
			grid.add(submit, 1, 3);
			grid.add(pull, 3, 3);

			scene1 = new Scene(new Group(grid));
			Label label = new Label("Profiles");
			
			TableColumn num = new TableColumn("Number");
			num.setMinWidth(100);
			num.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<Number>(profileList.size()));
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
			hbox.getChildren().addAll(add, save, remove, remField);
			vbox.getChildren().addAll(label, table, hbox);
			((Group) scene1.getRoot()).getChildren().add(vbox);

			table.getColumns().addAll(num, fName, email, pWord);

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
					
					
					out.createNewFile();
					PrintWriter write = new PrintWriter(out);
					for (int i = 0; i < numProfile; i ++) {
						write.println(list.get(i).getUsername() + " " + list.get(i).getEmail() + " " + list.get(i).getPassword());
						System.out.println(list.get(i).getUsername() + ", " + list.get(i).getEmail() + ", " + list.get(i).getPassword());
						
					}
					write.close();
					
					
				} catch (Exception e2) {
					e2.getMessage();
				}

			});

			submit.setOnAction(e -> {
					profile = new Profile(userField.getText(), eField.getText(), passField.getText());
				
				profileList.add(profile);
				list.add(profile);

				table.setItems(profileList);
				primaryStage.setWidth(500);
				primaryStage.setHeight(500);
				numProfile++;

				window.setScene(scene1);
			});
			
			remove.setOnAction(e -> {
				profileList.remove(Integer.parseInt(remField.getText()) - 1);
			});
			
			pull.setOnAction(e -> {
				try {
					Scanner scan = new Scanner(out);
					String str = "";
					while(scan.hasNextLine()) {
						str = scan.nextLine();
						Scanner scan1 = new Scanner(str);
						String user1 = scan1.next();
						String email1 = scan1.next();
						String pass1 = scan1.next();
						Profile profile2 = new Profile(user1, email1, pass1);
						profileList.add(profile2);
						list.add(profile2);
						scan1.close();
					}
					scan.close();
				} catch(Exception e1) {
					e1.getMessage();
				}
				table.setItems(profileList);
				primaryStage.setWidth(500);
				primaryStage.setHeight(500);

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

	
	/**
	 * runs the program
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}// does this work
}
