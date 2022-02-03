import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CsvReaderExample {

    public static final String SAMPLE_CSV_FILE_PATH= "C:\\Users\\User\\IdeaProjects\\OpenCSV\\src\\main\\java\\user.csv";
    public static void main(String[] ar) {
        try {
            Reader rd = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CSVReader csvrd= new CSVReader(rd)  ;
            String[] nextRcd;
            while((nextRcd=csvrd.readNext())!=null)
            {
                System.out.println("Name: "+nextRcd[0]);
                System.out.println("Email: "+nextRcd[1]);
                System.out.println("Phone: "+nextRcd[2]);
                System.out.println("Country: "+nextRcd[3]);
                System.out.println("*****************************");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
