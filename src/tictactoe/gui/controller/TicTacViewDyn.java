package tictactoe.gui.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventDispatchChain;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TicTacViewDyn implements Initializable {


    public VBox vBoxCenter;
    public BorderPane borderPane;
    int length=10;
    private int[][] handPlayed;
    private boolean notHandledYet;
    List<HBox> hBoxList = new ArrayList<>();
    public void handleButtonAction(ActionEvent actionEvent) {

        System.out.println(actionEvent.getSource());
    }
    private void initEventsUselessWay(Button btn) {

        System.out.println(btn);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handleButtonAction(actionEvent);
            }
        });
    }
    public void handleNewGame(ActionEvent actionEvent) {

    }
//    public Event dispatchEvent(Event event, EventDispatchChain tail) {
//        // capturing phase, can handle / modify / substitute / divert the event
//
//        if (notHandledYet) {
//            // forward the event to the rest of the chain
//            event = tail.dispatchEvent(event);
//
//            if (event != null) {
//                // bubbling phase, can handle / modify / substitute / divert
//                // the event
//            }
//        }
//
//        return notHandledYet ? event : null;
//
//    }
    private void createBoard(int length) {
        vBoxCenter.setAlignment(Pos.CENTER);
        vBoxCenter.prefHeight(400);
        vBoxCenter.setSpacing(5);

        //vBoxCenter.set
        for (int i = 0; i < length; i++) {
            HBox hb=new HBox();
            hb.setId("L_"+i+"_");
            hb.setSpacing(5);
            //hb.set
            hb.setAlignment(Pos.CENTER);
            for (int k = 0; k < length; k++) {
                Button btn = new Button();
                btn.setMinWidth(30);
                btn.setMinHeight(30);

                btn.setOnAction(e->initEventsUselessWay(btn));
                btn.setId(hb.getId()+"C_"+k);
                hb.getChildren().add(btn);

            }
            hBoxList.add(hb);
            //vBoxCenter
            vBoxCenter.getChildren().add(hb);
        }
        for (HBox hb: hBoxList) {
            System.out.println(hb.getChildren());
        }


    }

    public void changeButtonText(Button btn) {
        btn.getId();
        btn.setText("O");

    }
    public void setButtonText() {
        ObservableList vBox = vBoxCenter.getChildren();
        for (Object hb : vBox) {
            HBox hb2 = (HBox) hb;
            for (Node n : hb2.getChildren()) {

                Button btn = (Button) n;
                btn.setText("");
            }

           // System.out.println("HBOX = "+hb2.getChildren());
        }

      //  System.out.println(vBox);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createBoard(length);
        setButtonText();
        handPlayed = new int[length][length];
    }
}
