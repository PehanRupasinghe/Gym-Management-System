package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.lang.reflect.Member;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Integer.parseInt;

public class Main extends Application {
    Stage window;
    TableView<DefaultMember> defaulTable;
    TableView<StudentMember> studertTable;
    TableView<Over60Member> over60Table;


    public static void main(String[] args) {

        launch(args);
    }



    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("GYM SYSTEM");


        //Default Member
        Text dTitle = new Text("DEFAULT MEMBERS");
        dTitle.setStyle("-fx-font: normal bold 20px 'Arial' ");

        TableColumn<DefaultMember, String> dMemNoColumn = new TableColumn<>("MembershipNumber");
        dMemNoColumn.setMaxWidth(200);
        dMemNoColumn.setCellValueFactory(new PropertyValueFactory<>("membershipNumber"));

        TableColumn<DefaultMember, String> dNameColumn = new TableColumn<>("Name");
        dNameColumn.setMaxWidth(200);
        dNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<DefaultMember, String> dSexColumn = new TableColumn<>("Sex");
        dSexColumn.setMaxWidth(200);
        dSexColumn.setCellValueFactory(new PropertyValueFactory<>("sex"));

        TableColumn<DefaultMember, String> dDateColumn = new TableColumn<>("Date");
        dSexColumn.setMaxWidth(200);
        dSexColumn.setCellValueFactory(new PropertyValueFactory<>("dob"));

        FilteredList<DefaultMember> defaultMembersFl = new FilteredList(getDefaultMember(), p -> true);
        defaulTable = new TableView<>();
        defaulTable.setItems(defaultMembersFl);
        defaulTable.getColumns().addAll(dMemNoColumn, dNameColumn, dSexColumn,dDateColumn);


        //Student Member

        Text sTitle = new Text("STUDERT MEMBERS");
        sTitle.setStyle("-fx-font: normal bold 20px 'Arial' ");

        TableColumn<StudentMember, String> sMemNoColumn = new TableColumn<>("MembershipNumber");
        sMemNoColumn.setMaxWidth(200);
        sMemNoColumn.setCellValueFactory(new PropertyValueFactory<>("membershipNumber"));

        TableColumn<StudentMember, String> sNameColumn = new TableColumn<>("Name");
        sNameColumn.setMaxWidth(200);
        sNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<StudentMember, String> sSexColumn = new TableColumn<>("Sex");
        sSexColumn.setMaxWidth(200);
        sSexColumn.setCellValueFactory(new PropertyValueFactory<>("sex"));

        TableColumn<StudentMember, String> schoolNameColumn = new TableColumn<>("School Name");
        schoolNameColumn.setMaxWidth(200);
        schoolNameColumn.setCellValueFactory(new PropertyValueFactory<>("schoolName"));

        TableColumn<StudentMember, String> schoolDiscountColumn = new TableColumn<>("School Discount Available");
        schoolDiscountColumn.setMaxWidth(200);
        schoolDiscountColumn.setCellValueFactory(new PropertyValueFactory<>("schoolDiscount"));

        TableColumn<StudentMember, String> locationColumn = new TableColumn<>("School Location");
        locationColumn.setMaxWidth(200);
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));

        FilteredList<StudentMember> studertMembersFl = new FilteredList(getStudentMember(), p -> true);
        studertTable = new TableView<>();
        studertTable.setItems(studertMembersFl);
        studertTable.getColumns().addAll(sMemNoColumn, sNameColumn, sSexColumn, schoolNameColumn, schoolDiscountColumn, locationColumn);

        //OVER60 Member

        Text oTitle = new Text("OVER 60 MEMBERS");
        oTitle.setStyle("-fx-font: normal bold 20px 'Arial' ");

        TableColumn<Over60Member, String> oMemNoColumn = new TableColumn<>("MembershipNumber");
        oMemNoColumn.setMaxWidth(200);
        oMemNoColumn.setCellValueFactory(new PropertyValueFactory<>("membershipNumber"));

        TableColumn<Over60Member, String> oNameColumn = new TableColumn<>("Name");
        oNameColumn.setMaxWidth(10000);
        oNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Over60Member, String> oSexColumn = new TableColumn<>("Sex");
        oSexColumn.setMaxWidth(200);
        oSexColumn.setCellValueFactory(new PropertyValueFactory<>("sex"));

        TableColumn<Over60Member, Integer> ageColumn = new TableColumn<>("Age");
        ageColumn.setMaxWidth(200);
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Over60Member, String> lungDiseaseColumn = new TableColumn<>("Lung Disease ");
        lungDiseaseColumn.setMaxWidth(200);
        lungDiseaseColumn.setCellValueFactory(new PropertyValueFactory<>("lungDisease"));

        TableColumn<Over60Member, String> personalInstuctorColumn = new TableColumn<>("Personal Instuctor");
        personalInstuctorColumn.setMaxWidth(200);
        personalInstuctorColumn.setCellValueFactory(new PropertyValueFactory<>("personalInstuctor"));

        FilteredList<Over60Member> over60MembersFl = new FilteredList(getOver60Member(), p -> true);
        over60Table = new TableView<>();
        over60Table.setItems(over60MembersFl);
        over60Table.getColumns().addAll(oMemNoColumn, oNameColumn, oSexColumn, ageColumn, lungDiseaseColumn, personalInstuctorColumn);



        ChoiceBox<String> choiceBox = new ChoiceBox();
        choiceBox.getItems().addAll("Default Member Name", "Studert Member Name", "Over60 Member Name");
        choiceBox.setValue("Default Member Name");

        TextField seachtxt = new TextField();
        seachtxt.setPromptText("Search here!");
        seachtxt.setOnKeyReleased(keyEvent ->
        {
            switch (choiceBox.getValue())//Switch on choiceBox value
            {
                case "Default Member Name":
                    defaultMembersFl.setPredicate(p -> p.getName().contains(seachtxt.getText().trim()));
                    break;
                case "Studert Member Name":
                    studertMembersFl.setPredicate(p -> p.getName().contains(seachtxt.getText().trim()));
                    break;
                case "Over60 Member Name":
                    over60MembersFl.setPredicate(p -> p.getName().contains(seachtxt.getText().trim()));
                    break;

            }
        });

        choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) ->
        {
            if (newVal != null)
            {
                seachtxt.setText("");
                defaultMembersFl.setPredicate(null);
            }
        });
        HBox hBox = new HBox(choiceBox, seachtxt);
        hBox.setAlignment(Pos.TOP_RIGHT);


        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox, dTitle, defaulTable, sTitle,studertTable, oTitle, over60Table );

        Scene scene = new Scene(vBox,650,600);
        window.setScene(scene);
        window.show();



    }

    public ObservableList<DefaultMember> getDefaultMember(){
        ObservableList<DefaultMember> defaultMember = FXCollections.observableArrayList();
        File DefaultMemberFile = new File("DefaultMember.txt");

        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(DefaultMemberFile));

            String record;
            while ((record = br.readLine()) != null) {
                String[] fields = record.split(",", -1);


                DefaultMember defaultRecord = new DefaultMember(fields[0], fields[1], fields[2]);
                defaultMember.add(defaultRecord);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return defaultMember;
    }

    public ObservableList<StudentMember> getStudentMember(){
        ObservableList<StudentMember> studertMember = FXCollections.observableArrayList();
        File StudentMemberFile = new File("StudentMember.txt");
        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(StudentMemberFile));

            String record;
            while ((record = br.readLine()) != null) {
                String[] fields = record.split(",", -1);

                StudentMember studertRecord = new StudentMember(fields[0], fields[1], fields[2],fields[3], fields[4], fields[5] );
                studertMember.add(studertRecord);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return studertMember;
    }

    public ObservableList<Over60Member> getOver60Member(){
        ObservableList<Over60Member> over60Member = FXCollections.observableArrayList();
        File StudentMemberFile = new File("Over60Member.txt");
        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(StudentMemberFile));

            String record;
            while ((record = br.readLine()) != null) {
                String[] fields = record.split(",", -1);


                int age = Integer.parseInt(fields[3]);
                Over60Member over60Record = new Over60Member(fields[0], fields[1], fields[2], age, fields[4], fields[5]);
                over60Member.add(over60Record);

            }

        } catch (FileNotFoundException e) {
         e.printStackTrace();
        } catch (IOException e) {
         e.printStackTrace();
        }
        return over60Member;
    }


}
