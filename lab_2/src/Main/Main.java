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
        if (user == null) {
            Navigation.main_menu(train, storage);
            View.view("Выход из программы...");
        }
        View.view("Выход из программы...");
    }
}


