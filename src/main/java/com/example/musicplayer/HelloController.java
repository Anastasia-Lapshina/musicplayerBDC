package com.example.musicplayer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.File;


public class HelloController implements Initializable {


    @FXML
    private TreeView<String> treeView;

    @FXML
    private String[] filter = {"name", "newness", "weight"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TreeItem<String> rootItem = new TreeItem<>("Library");
        this.treeView.setRoot(rootItem);
        String libraryRoot = "C:\\Users\\Oleg\\IdeaProjects\\musicplayer\\Library";
        TreeItem<String>[] fileList = new TreeItem[directoryLister(libraryRoot).length];
        for (int i = 0; i < directoryLister(libraryRoot).length; i++) {
            fileList[i] = new TreeItem<>(directoryLister(libraryRoot)[i].getName());
            rootItem.getChildren().addAll(fileList[i]);
        }

    }

    private File[] directoryLister(String root) {
        File rootDir = new File(root);
        File[] fileList = rootDir.listFiles();
        return fileList;
    }

    public void selectItem() {
        TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();
        if(item != null) {
            System.out.println(item.getValue());
        }
    }

}