module TruthOrDare {
	requires javafx.controls;
	requires javafx.fxml;
	requires jdk.compiler;
	requires java.desktop;
	
	opens application to javafx.graphics, javafx.fxml;
	opens org to javafx.graphics, javafx.fxml;
}
