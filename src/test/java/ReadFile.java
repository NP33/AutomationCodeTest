
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    public static void main(String args[]) {
        String fileName = "src/test/resources/data.txt";
        printFileData(fileName);
    }


    /**
     * To print file data
     *
     * @param fileName
     */
    public static void printFileData(String fileName) {
        BufferedReader br = null;
        FileReader fr = null;

        if (doesFileExist(fileName)) {
            try {
                fr = new FileReader(fileName);
                br = new BufferedReader(fr);
                String sCurrentLine;
                while ((sCurrentLine = br.readLine()) != null) {
                    printData(sCurrentLine);
                }

            } catch (IOException e) {
                System.out.println("Error: unexpected failure :" + e.getMessage());
            } finally {
                try {
                    br.close();
                    fr.close();
                } catch (IOException e) {
                    System.out.println("Error: unexpected failure :" + e.getMessage());
                }

            }
        } else {
            System.out.println("Unable to read file contents as given file is not available");
        }
    }


    public static void printData(String line) {
        String[] dataSplit = line.split("-");
        System.out.println(dataSplit[0]);
        String[] valueData = dataSplit[1].split(",");
        for (int i = 0; i < valueData.length; i++)
            System.out.println(valueData[i]);
    }

    public static boolean doesFileExist(String path) {
        boolean result = false;
        try {
            File f = new File(path);
            if (f.exists()) {
                result = true;
                System.out.println("File exist");
            } else {
                System.out.println("File does not exist");
            }
        } catch (Exception e) {
            System.out.println("Error: Unable to verify file exist :" + e.getMessage());
        }
        return result;
    }
}
