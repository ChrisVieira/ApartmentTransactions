import java.io.*;

public class TextFileManager {

    public static void main(String[] args) {
        /**
         * Format for calculator file
         * Number of users
         * For loop representing the name of the users
         * For loop representing the number of users, each line has a total
         *
         *
         *
         *
         */
        /**
         * Format for transaction history file
         * Each line a transaction log
         * "Target - food" Amount $$$ Paid for by user1
         *
         *
         *
         *
         */
        // The name of the file to open.
        String fileName = "temp.txt";
        String fileNameVersion = "version.txt";
        String pastTextFile = "";
        String versionNumber = "";
        try {
            // Use this for reading the data.
            byte[] buffer = new byte[1000];
            byte[] bufferVersion = new byte[1000];

            FileInputStream inputStream =
                    new FileInputStream(fileName);
            FileInputStream inputStreamVersion =
                    new FileInputStream(fileNameVersion);

            // read fills buffer with data and returns
            // the number of bytes read (which of course
            // may be less than the buffer size, but
            // it will never be more).
            int total = 0;
            int nRead = 0;
            while ((nRead = inputStream.read(buffer)) != -1) {
                // Convert to String so we can display it.
                // Of course you wouldn't want to do this with
                // a 'real' binary file.
                System.out.println(new String(buffer));
                pastTextFile += (new String(buffer));
                total += nRead;
            }

            // Always close files.
            inputStream.close();
            /*
            Read the version number file
             */
            nRead = 0;
            while ((nRead = inputStreamVersion.read(bufferVersion)) != -1) {
                // Convert to String so we can display it.
                // Of course you wouldn't want to do this with
                // a 'real' binary file.
                System.out.println(new String(bufferVersion));
                versionNumber += (new String(bufferVersion));
            }

            inputStreamVersion.close();

            System.out.println("Read " + total + " bytes");
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }

        try {
            // Assume default encoding.
            FileWriter fileWriter =
                    new FileWriter(fileName);
            FileWriter fileWriterVersion =
                    new FileWriter(fileNameVersion);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);
            BufferedWriter bufferedWriterVersion =
                    new BufferedWriter(fileWriterVersion);

            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write(pastTextFile);
            bufferedWriter.write("Hello there,");
            bufferedWriter.write(" here is some text.");
            bufferedWriter.newLine();
            bufferedWriter.write("We are writing");
            bufferedWriter.write(" the text to the file.");

            // Always close files.
            bufferedWriter.close();
//            int version = Integer.getInteger(versionNumber);
//            int version = versionNumber.charAt(0) - 48;
            int version = Integer.parseInt(versionNumber.toString());
            version += 1;
            bufferedWriterVersion.write(Integer.toString(version));
            bufferedWriterVersion.close();
        } catch (IOException ex) {
            System.out.println(
                    "Error writing to file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }


        try {
            // Use this for reading the data.
            byte[] buffer = new byte[1000];

            FileInputStream inputStream =
                    new FileInputStream(fileName);

            // read fills buffer with data and returns
            // the number of bytes read (which of course
            // may be less than the buffer size, but
            // it will never be more).
            int total = 0;
            int nRead = 0;
            while ((nRead = inputStream.read(buffer)) != -1) {
                // Convert to String so we can display it.
                // Of course you wouldn't want to do this with
                // a 'real' binary file.
                System.out.println(new String(buffer));
                total += nRead;
            }

            // Always close files.
            inputStream.close();

            System.out.println("Read " + total + " bytes");
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        System.out.println("Hello there, here is some text.\nWe are writing the text to the file. ".length());
    }
}
