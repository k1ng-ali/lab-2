package Test.MainTests;
import Main.Config;
import Main.User;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class ConfigTest {
    private static final String TEST_CONFIGFILE = "ConfigTest.properties";
    private Config config;

    public ConfigTest() {}

    @BeforeEach
    void setup() throws IOException {
        config = new Config(TEST_CONFIGFILE);
    }

    @AfterEach
    void teardown() throws IOException {
        File file = new File(TEST_CONFIGFILE);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void TestLoadConfig() throws IOException {

        User testuser = new User("admintest", "admintest", "root");
        config.addUser(testuser);
        User user = config.getUser("admintest");


        assertNotNull(user, "Пользователь должен быть загружен");
        assertEquals("admintest", user.getUsername(), "Проверка имени пользователя");
        assertEquals("admintest", user.getPassword(), "Проверка пароля пользователя");
        assertEquals("root", user.getGroup(), "Проверка группы пользователя");

        config.deleteUser(user);

        User deletedUser = config.getUser("admintest");
        assertNull(deletedUser, "Пользователь должен быть удален");
    }
}
