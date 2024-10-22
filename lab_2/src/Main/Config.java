package Main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Config{
    private Map<String, User> users = new HashMap<>();
    private boolean debugMode;
    private boolean autotestsMode;
    private String filePath;

    public Config(String filePath) throws IOException {
        this.filePath = filePath;
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

    public void addUser(User user) throws IOException {
        if (users.containsKey(user.getUsername())) {
            throw new IllegalArgumentException("Пользователь с таким логином уже существует!");
        }

        User newUser = new User(user.getUsername(), user.getPassword(), user.getGroup());
        users.put(user.getUsername(), newUser);

        // Записываем нового пользователя в файл настроек
        Properties props = new Properties();
        FileInputStream input = new FileInputStream(filePath);
        props.load(input);
        input.close();

        int newUserIndex = users.size();
        props.setProperty("user" + newUserIndex + ".username", user.getUsername());
        props.setProperty("user" + newUserIndex + ".password", user.getPassword());
        props.setProperty("user" + newUserIndex + ".group", user.getGroup());

        FileOutputStream output = new FileOutputStream(filePath);
        props.store(output, null);
        output.close();
    }

}

