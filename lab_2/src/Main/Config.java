package Main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Config{
    private Map<String, User> users = new HashMap<>();
    private boolean debugMode;
    private boolean autotestsMode;

    public Config(String filePath) throws IOException {
        Properties props = new Properties();
        FileInputStream input = new FileInputStream(filePath);
        props.load(input);

        // Загружаем пользователей
        for (int i = 1; i <= props.size() / 3; i++) {  // Если 3 свойства на пользователя (username, password, group)
            String usernameKey = "user" + i + ".username";
            String passwordKey = "user" + i + ".password";
            String groupKey = "user" + i + ".group";

            if (props.containsKey(usernameKey)) {
                String username = props.getProperty(usernameKey);
                String password = props.getProperty(passwordKey);
                String group = props.getProperty(groupKey);
                users.put(username, new User(username, password, group));
            }
        }

        // Загружаем глобальные настройки
        this.debugMode = Boolean.parseBoolean(props.getProperty("debug"));
        this.autotestsMode = Boolean.parseBoolean(props.getProperty("autotests"));
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public boolean isDebugMode() {
        return debugMode;
    }

    public boolean isAutotestsMode() {
        return autotestsMode;
    }

    // Класс пользователя
    public static class User {
        private String username;
        private String password;
        private String group;

        public User(String username, String password, String group) {
            this.username = username;
            this.password = password;
            this.group = group;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getGroup() {
            return group;
        }
    }
}

