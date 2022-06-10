package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class fileToBlobConverter {

    public static byte[] convertFileContentToBlob(String filePath) throws IOException {
        byte[] fileContent = null;
        // initialize string buffer to hold contents of file
        StringBuffer fileContentStr = new StringBuffer("");
        BufferedReader reader = null;
        try {
            // initialize buffered reader
            reader = new BufferedReader(new FileReader(filePath));
            String line = null;
            // read lines of file
            while ((line = reader.readLine()) != null) {
                //append line to string buffer
                fileContentStr.append(line).append("\n");
            }
            // convert string to byte array
            fileContent = fileContentStr.toString().trim().getBytes();
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("Unable to convert file to byte array. " +
                    e.getMessage());
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return fileContent;
    }
}
