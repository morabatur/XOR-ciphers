
import javafx.stage.FileChooser;
import javax.swing.*;
import java.io.*;


public class FileController {

    public static String fileChoos() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Виберіть файл");
        File file = chooser.showOpenDialog(null);
        if (file != null) {
            String string = file.getAbsolutePath().toString();
            System.out.println("Метод fileChoos(Button button) повертає значення для обраного файлу - " + string);
            return string;
        } else {
            JOptionPane.showMessageDialog(null, "Не вибрано файл");
        }

        return null;
    }


    public static String pathOfSave() {
        FileChooser fileChooser = new FileChooser();//Класс работы с диалогом выборки и сохранения
        fileChooser.setTitle("Зберегти документ");//Заголовок диалога
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("No formats", "*.*"),
                new FileChooser.ExtensionFilter("TXT file", "*.txt"),
                new FileChooser.ExtensionFilter("MS Word", "*.doc")
        );
        File file = null;
        try {
            file = fileChooser.showSaveDialog(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file.getAbsolutePath();
    }

    public static void recordFile(String path, byte[] info) {
        System.out.println("Метод recordFile(String path, byte[] info) за аргумент path має - " + path);
        try (FileOutputStream fos = new FileOutputStream(new File(path))) {
            fos.write(info);
        } catch (java.io.IOException e) {
            System.err.println("Запис файлу не вдався");
            e.printStackTrace();
        }
    }


    public static String readFile(String path) {
        String line = "";
        try (FileReader reader = new FileReader(path)) {
            int c;
            while ((c = reader.read()) != -1) {
                line += (char) c;
            }
        } catch (Exception e) {

        }
        return line;
    }


}

