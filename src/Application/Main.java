package Application;
	
/*TODO:
 *
 * 2 - System should treaten date is inserted by users . Ex.: Input coma or dot (English Numbers)
 * 3 - The System should be opened with products show in the list
 * 4 - Change list from text to some kind would be possible user select each line
 * 5 - Implement remotion of products
 * 6 - Implement Modify of products
 * 7 - Buttom to RemoveAll
 * 8 - System should not let users input more than one product with the same name!
 * 9 - Tool to send the Grocery List to the email.
 */


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.entities.Product;


public class Main extends Application {
	
	public void start(Stage stage) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/GUI/Products.fxml"));
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.setTitle("Grocey List");
			stage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
