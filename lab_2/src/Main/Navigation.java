package Main;

public class Navigation {
    public static User main_login(Config config){
        User user;
        int choice;
        do {
            View.view("Войти . . . . . . . . . . . . . . . . . . . 1\n");
            View.view("Зарегистрироваться. . . . . . . . . . . . . 2\n");
            View.view("Выход . . . . . . . . . . . . . . . . . . . 3\n");
            choice = Controller.get_int();

            switch (choice)
            {
                case 1:
                    user = LogIn.login(config);
                    if (user != null) {return user;};
                    break;
                case 2:
                    user = LogIn.register(config);
                    if (user != null){return user;};
                    break;
                case 3:
                    return null;
            }
        }while (true);
    }
    public static void main_menu(Train train, Storages strg){
        int choise;
        do {
            int num_pm, num_strg, capacity;
            String cargo;
            View.view("Вывести информацию платформ. . . . . . . . . . . . . . . . . 1\n");
            View.view("Вывести информацию складов . . . . . . . . . . . . . . . . . 2\n");
            View.view("Добавить платформу . . . . . . . . . . . . . . . . . . . . . 3\n");
            View.view("добавить склад . . . . . . . . . . . . . . . . . . . . . . . 4\n");
            View.view("Добавить автомобилья на склад. . . . . . . . . . . . . . . . 5\n");
            View.view("Загрузить груз на платформу. . . . . . . . . . . . . . . . . 6\n");
            View.view("Разгрузить груз из платформы . . . . . . . . . . . . . . . . 7\n");
            View.view("Выход из программы . . . . . . . . . . . . . . . . . . . . . 8\n");
            View.view("\nВыберите действие: ");

            choise = Controller.get_int();
            switch (choise)
            {
                case 1:
                    ViewInfo.info_platform(train);
                    break;
                case 2:
                    ViewInfo.info_strg(strg);
                    break;
                case 3:
                    AddObject.add_platform(train);
                    break;
                case 4:
                    AddObject.add_storage(strg);
                    break;
                case 5:
                    try {
                        AddObject.add_avto(strg);
                    }
                    catch (Exception e)
                    {View.view(e.getMessage());}
                    break;
                case 6:
                    try {
                        LoadUnload.load_plt(train, strg);
                    }
                    catch (Exception e)
                    {View.view(e.getMessage());}
                    break;
                case 7:
                    try{
                        LoadUnload.unload_plt(train, strg);
                    }
                    catch (Exception e)
                    {View.view(e.getMessage());}
                    break;
                default:
                    View.view("Ощибка ввода! Введите целое число от 1 до 7 включительно\n");

            }
        }while(choise != 8);
    }
}
