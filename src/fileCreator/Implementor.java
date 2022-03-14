package fileCreator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

//AdapterClass
class Implementor extends DataProvider implements FileCreator {
    public void getNumberOfLinesInFile() {
        Scanner scannerObject = new Scanner(System.in);
        System.out.println("Enter the number of lines should present in the file: (Between 1 and 230)");
        int numberOfLines = 0;
        try {
            numberOfLines = scannerObject.nextInt();
            while (numberOfLines < 1 || numberOfLines > 230) {
                System.out.println("Disclaimer: Number must be within 1 and 230");
                numberOfLines = scannerObject.nextInt();
            }
        } catch (InputMismatchException exception) {
            System.out.println("Only Numbers are allowed.");
        }
        setNumberOfLines(numberOfLines);
    }

    public void createFilePathOfFile() {
        String userDirectory = System.getProperty("user.dir");
        String pathSeparator = System.getProperty("file.separator");
        setFilePath(userDirectory + pathSeparator + "src" + pathSeparator + "fileCreator" + pathSeparator + "files" + pathSeparator + "file.txt");
    }

    public void createFile() {
        if (getNumberOfLines() == 0) {
            System.out.println("Enter only number as input");
        } else {
            final int leftLimit = 97; // letter 'a'
            final int rightLimit = 122; // letter 'z'
            final int targetStringLength = 100;
            Random random = new Random();
            String[] randomStrings = new String[targetStringLength];
            System.out.println("Generating the file....");
            try {
                Writer pathOfFile = new FileWriter(getFilePath());
                BufferedWriter writerObject = new BufferedWriter(pathOfFile);
                for (int lineIndex = 0; lineIndex < getNumberOfLines(); lineIndex++) {
                    StringBuilder individualString = new StringBuilder(targetStringLength);
                    for (int index = 0; index < targetStringLength; index++) {
                        int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
                        individualString.append((char) randomLimitedInt);
                    }
                    randomStrings[lineIndex] = individualString.toString();
                    writerObject.write(randomStrings[lineIndex]);
                    writerObject.newLine();
                }
                writerObject.close();
                pathOfFile.close();
                System.out.println("File Generated Successfully.");
            } catch (IOException exception) {
                System.out.println("Check the file in the specified path.");
            }
        }
    }
}
