package Main;

import java.util.LinkedList;
import java.util.Scanner;

// 1 РАЗРАБОТАВАТЬ МЕТОД ДОБАВЛЕНИЕ АВТОМОЬИЛЯ НА СКЛАД

// Демонстрация программы
public class Main {
    public static void main(String[] args) {
        model();
    }

    public static void model(){
        Train train = new Train();
        Storages storage = new Storages();
        Navigation.navigation_main(train, storage);
        View.view("Выход из программы...");
    }
}


