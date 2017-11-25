import javafx.scene.control.Alert;

public class DialogMessage {

    public  static void keyError(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Попередження!");
        alert.setHeaderText("Відсутній ключ!");
        alert.setContentText("Перевірте правильність введення." + '\n'+ "Поле ключа є пустим.");
        alert.showAndWait();
    }

    public  static void successfullCript(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Операція пройшла успішно!");
        alert.setHeaderText(null);
        alert.setContentText("Ваш текст було спішно зашифровано та запсиано в файл.");
        alert.showAndWait();
    }

}
