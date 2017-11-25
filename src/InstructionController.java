import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class InstructionController {
    @FXML
    public TextArea textArea_encrypt;
    @FXML
    public TextArea textArea_dencrypt;

    public void initialize() {
        textArea_encrypt.setEditable(false);
        textArea_dencrypt.setEditable(false);
        textArea_encrypt.setWrapText(true);
        textArea_dencrypt.setWrapText(true);
    }
}
