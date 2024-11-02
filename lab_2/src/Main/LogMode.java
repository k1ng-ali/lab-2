package Main;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class LogMode {
    public static void LogWrite(String key) throws IOException {
        FileWriter logWrite = new FileWriter("logProgramm.txt", true);
        logWrite.write(  new Date() +": " + key + "\n");
        logWrite.close();
    }
}
