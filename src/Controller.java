import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class Controller {
    @FXML
    public MenuItem menu_author;
    @FXML
    private TextField textField_filePath;
    @FXML
    private TextArea textArea_encrypt;
    @FXML
    private TextField textFieldKey_encrypt;
    @FXML
    private TextField textFieldKey_dencrypt;
    @FXML
    private TextArea textArea_dencrypt;

    private String pathOfFile;

    public void initialize() {

        textField_filePath.setEditable(false);
        textArea_dencrypt.setWrapText(true);
        textArea_encrypt.setWrapText(true);

    }

    @FXML
    public void encryptText() {
        if (textFieldKey_encrypt.getText().equals(null) || textFieldKey_encrypt.getText().equals("")) {
            DialogMessage.keyError();
        } else {
            String text = textArea_encrypt.getText();
            String key = textFieldKey_encrypt.getText();
            byte[] arr = new byte[0];
            try {
                arr = CipherXOR.xorЕncrypt(text, key.getBytes());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            FileController.recordFile(FileController.pathOfSave(), arr);
            DialogMessage.successfullCript();
        }
    }

    @FXML
    public void dencryptText() {
        if (textFieldKey_dencrypt.getText().equals(null) || textFieldKey_dencrypt.getText().equals("")) {
            DialogMessage.keyError();
        } else {
            String textDecrypt = null;
            String key = textFieldKey_dencrypt.getText();

            try {
                textDecrypt = CipherXOR.xorDecrypt(FileController.readFile(pathOfFile), key.getBytes());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            textArea_dencrypt.setText(textDecrypt);
        }
    }

    @FXML
    public void FileChoos() {
        textField_filePath.setText("");
        pathOfFile = FileController.fileChoos();
        textField_filePath.setText(pathOfFile);
    }


    @FXML
    public void visbleAuthor() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AuthorFrame.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Автор");
        stage.setScene(new Scene(root1));
        stage.show();

    }


    @FXML
    public void saveRecsult() {
        String path = FileController.pathOfSave();
        FileController.recordFile(path, textArea_dencrypt.getText().getBytes());
    }

    @FXML
    public void getInstruction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InstructionFrame.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Інструкція");
        stage.setScene(new Scene(root1));
        stage.setMinWidth(600);
        stage.setMinHeight(503);
        stage.show();
    }
}
