package Main;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class LogMode {
    static User user;

    public LogMode(User user) {
        this.user = user;
    }

    public static void LogWrite(String key) throws IOException {
        FileWriter logWrite = new FileWriter("logProgramm.txt", true);
        logWrite.write(STR."""
            \{user.getUsername()}  \{new Date()}: \{key}
            """);
        logWrite.close();
    }
}
