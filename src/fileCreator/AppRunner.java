package fileCreator;

//ClientClass
public class AppRunner {
    public static void main(String[] args) {
        FileCreator run = new Implementor();
        run.getNumberOfLinesInFile();
        run.createFilePathOfFile();
        run.createFile();
    }
}
