import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static String currentTime = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy").format(LocalDateTime.now());
    public static StringBuilder log = new StringBuilder();

    public static void createDir(File file) {
        if (!file.exists()) {
            if (file.mkdir()) {
                log.append("[").append(currentTime).append("] Каталог ").append(file.getName()).append(" создан успешно.\n");
            }
        } else {
            log.append("[").append(currentTime).append("] ОШИБКА: Каталог ").append(file.getName()).append(" уже существует.\n");
        }
    }

    public static void createFile(File file) {
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    log.append("[").append(currentTime).append("] Файл ").append(file.getName()).append(" создан успешно.\n");
                }
            } catch (IOException ex) {
                log.append("[").append(currentTime).append("] Ошибка при создании файла ").append(file.getName()).append("\n");
            }
        } else {
            log.append("[").append(currentTime).append("] ОШИБКА: Файл ").append(file.getName()).append(" уже существует.\n");
        }
    }

    public static void main(String[] args) {
        File directory = new File("D:\\Games\\");

        //Games DIRECTORY
        File srcDir = new File(directory, "src");
        Main.createDir(srcDir);
        File resDir = new File(directory, "res");
        Main.createDir(resDir);
        File saveGamesDir = new File(directory, "savegames");
        Main.createDir(saveGamesDir);
        File tempDir = new File(directory, "temp");
        Main.createDir(tempDir);

        //src DIRECTORY
        File mainDir = new File(srcDir, "main");
        Main.createDir(mainDir);
        File testDir = new File(srcDir, "test");
        Main.createDir(testDir);

        //main DIRECTORY
        File javaMainFile = new File(mainDir, "Main.java");
        Main.createFile(javaMainFile);
        File javaUtilFile = new File(mainDir, "Util.java");
        Main.createFile(javaUtilFile);

        //res DIRECTORY
        File drawablesDir = new File(resDir, "drawables");
        Main.createDir(drawablesDir);
        File vectorsDir = new File(resDir, "vectors");
        Main.createDir(vectorsDir);
        File iconsDir = new File(resDir, "icons");
        Main.createDir(iconsDir);

        //temp DIRECTORY
        File tempFile = new File(tempDir, "temp.txt");
        Main.createFile(tempFile);

        try (FileWriter writer = new FileWriter(tempFile, false)) {
            writer.write(log.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}