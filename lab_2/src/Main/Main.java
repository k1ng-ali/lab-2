package Main;
import java.io.IOException;

// 1 РАЗРАБОТАВАТЬ МЕТОД ДОБАВЛЕНИЕ АВТОМОЬИЛЯ НА СКЛАД

// Демонстрация программы
public class Main {
    public static void main(String[] args) throws IOException {
        model();
    }

    public static void model() throws IOException {
        Train train = new Train();
        Storages storage = new Storages();
        Config config = new Config("config.properties");
        User user;
        user = Navigation.main_login(config);
        if (user != null) {
            if (config.isDebugMode()) LogMode.LogWrite("Вход в программу пользователя: " + user.getUsername());
            Navigation.main_menu(train, storage, user, config);
            if (config.isDebugMode()) LogMode.LogWrite("Выход из пограммы пользователья: " + user.getUsername());
        }
        View.view("Выход из программы...");
    }
}


