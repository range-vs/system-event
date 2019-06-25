package view;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class View {

    @FXML
    private VBox detectDevices;

    public void changeStatus(ArrayList<Boolean> data) {
        for(int i = 0; i< data.size(); i++){
            final int j = i;
            //System.out.println(data.get(j));
            Platform.runLater(() -> {
                String style;
                if(data.get(j)) {
                    style = "-fx-background-color: #DAA520; -fx-border-width: 4; -fx-border-color: #FFD700;";
                }else{
                    style = "-fx-background-color: #DAA520; -fx-border-width: 4; -fx-border-color: #4C3D00;";
                }
                detectDevices.getChildren().get(j).setStyle(style);
            });
        }
    }

    public void changeStatus() {
        for(int i = 0; i< detectDevices.getChildren().size(); i++){
            detectDevices.getChildren().get(i).setStyle("-fx-background-color: #DAA520; -fx-border-width: 4; -fx-border-color: #FFD700;");
        }
    }

}