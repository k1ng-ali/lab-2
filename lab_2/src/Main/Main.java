package Main;

import java.util.LinkedList;
import java.util.Scanner;

// Демонстрация программы
public class Main {
    public void main(String[] args) {
        model();
    }

    public void model(){
        Train train = new Train();
        storages storage = new storages();
        navigation_main(train, storage);
        view("Выход из программы...");
    }

    public void navigation_main(Train train, storages strg){
        int choise;
        do {
            int num_pm, num_strg, capacity;
            String cargo;
            view("Вывести информацию платформ. . . . . . . . . . . . . . . . . 1\n");
            view("Вывести информацию складов . . . . . . . . . . . . . . . . . 2\n");
            view("Добавить платформу . . . . . . . . . . . . . . . . . . . . . 3\n");
            view("добавить склад . . . . . . . . . . . . . . . . . . . . . . . 4\n");
            view("Загрузить груз на платформу. . . . . . . . . . . . . . . . . 5\n");
            view("Разгрузить груз из платформы . . . . . . . . . . . . . . . . 6\n");
            view("Выход из программы . . . . . . . . . . . . . . . . . . . . . 7\n");
            view("\nВыберите действие: ");

            choise = get_int();
            switch (choise)
            {
                case 1:
                    info_platform(train);
                    break;
                case 2:
                    info_strg(strg);
                    break;
                case 3:
                    add_platform(train);
                    break;
                case 4:
                    add_storage(strg);
                    break;
                case 5:
                    view("Введите Номер склада: ");
                    num_strg = get_int();
                    view("Введите номер платформы: ");
                    num_pm = get_int();
                    view("Введите тип груза: ");
                    cargo = controller();
                    view("Введите масса груза: ");
                    capacity = get_int();
                    if (load_plt(train, strg, num_pm, num_strg, capacity, cargo))
                        view("Успещно загружено\n");
                    else view("Ощибка, Неправильный ввод данных или недостаточно мест на платформе или недостаточно грузов на складе\n");
                    break;
                case 6:
                    view("Введите Номер склада: ");
                    num_strg = get_int();
                    view("Введите номер платформы: ");
                    num_pm = get_int();
                    view("Введите тип груза: ");
                    cargo = controller();
                    view("Введите масса груза: ");
                    capacity = get_int();
                    if (unload_plt(train, strg, num_pm, num_strg, capacity, cargo))
                        view("Успещно загружено\n");
                    else view("Ощибка, Неправильный ввод данных или недостаточно мест на платформе или недостаточно грузов на складе\n");
                    break;
                default:
                    view("Ощибка ввода! Введите целое число от 1 до 7 включительно\n");

            }
        }while(choise != 7);
    }


    public boolean unload_plt(Train train, storages storages, int num_pm, int num_strg, int capacity, String cargo){
        boolean f = false;
        for (storage storage: storages.getStorages()){
            if (storage.getNum_storage() == num_strg) {
                for (Platform platform: train.getPlatforms())
                {
                    if (platform.getNum_platform() == num_pm) {
                        if (storage.getType_cargo().contains(cargo) && platform.getType_cargo().contains(cargo) &&
                                (storage.getMax_capacity() >= storage.getCapacity() + capacity ) &&
                                (platform.getCapacity() >= capacity))
                        {
                            storage.setCapacity(storage.getCapacity() + capacity);
                            platform.setCapacity(platform.getCapacity() - capacity);
                            f = true;
                        }
                    }
                }
            }
        }
        return f;
    }

    public boolean load_plt(Train train, storages storages, int num_pm, int num_strg, int capacity, String cargo)
    {
        boolean f = false;
        for (storage storage: storages.getStorages()){
            if (storage.getNum_storage() == num_strg) {
                for (Platform platform: train.getPlatforms())
                {
                    if (platform.getNum_platform() == num_pm) {
                        if (storage.getType_cargo().contains(cargo) && platform.getType_cargo().contains(cargo) &&
                                (storage.getCapacity() >= capacity ) &&
                                (platform.getMax_capacity() >= platform.getCapacity()+capacity))
                        {
                            storage.setCapacity(storage.getCapacity() - capacity);
                            platform.setCapacity(platform.getCapacity() + capacity);
                            f = true;
                        }
                    }
                }
            }
        }
        return f;
    }

    public void info_platform(Train train){
        view("%-37s| %-33s| %-26s |%40s%n",
                "Номер платформы", "Вместимость", "Масса/колчиство грузов", "Тип грузов");
        view("=========================================================================================================================%n");
        for(Platform platform: train.getPlatforms()){
            view("%-37s| %-33s| %-26s |%40s%n",
                    platform.getNum_platform(),
                    platform.getMax_capacity(),
                    platform.getCapacity(),
                    String.join(", ", platform.getType_cargo()));
        }
        view("=========================================================================================================================%n");
    }

    public void info_trains(LinkedList<Train> train){
        view("%-37s| %-37s%n", "Номер поезда", "количество платформ");
        view("===========================================================================%n");
        for (Train t: train){
            view("%-37s| %-37s%n", t.getNum_Train(), t.getPlatforms().size());
        }
        view("===========================================================================%n");
    }

    public void info_strg(storages storages){
        view("%-37s| %-33s| %-26s |%40s%n",
                "Номер склада", "Вместимость", "Масса/колчиство грузов", "Тип грузов");
        view("=========================================================================================================================%n");
        for (storage storage: storages.getStorages()){
            view("%-37s| %-33s| %-26s |%40s%n",
                    storage.getNum_storage(),
                    storage.getMax_capacity(),
                    storage.getCapacity(),
                    String.join(", ", storage.getType_cargo()));
        }
        view("=========================================================================================================================%n");

    }

    public storages add_storage(storages storages){
        int choise;
        do {
            view_type_platforms();
            view("Выберите склад для хранение:\n");
            choise = get_int();

            switch (choise){
                case 1:
                    liquid_strg liquid = new liquid_strg();
                    view("Введите номер склада: ");
                    liquid.setNum_storage(get_int());
                    view("Введите максимальный емкость склада: ");
                    liquid.setMax_capacity(get_int());
                    view("Введите общая масса груза на складе: ");
                    liquid.setCapacity(get_int());
                    view("Склад успещно создан!\n");
                    storages.add_storage(liquid);
                    break;
                case 2:
                    grits_strg grits = new grits_strg();
                    view("Введите номер склада: ");
                    grits.setNum_storage(get_int());
                    view("Введите максимальный емкость склада: ");
                    grits.setMax_capacity(get_int());
                    view("Введите общая масса груза на складе: ");
                    grits.setCapacity(get_int());
                    view("Склад успещно создан!\n");
                    storages.add_storage(grits);
                    break;
                case 3:
                    container_strg container = new container_strg();
                    view("Введите номер склада: ");
                    container.setNum_storage(get_int());
                    view("Введите максимальная вместимость склада \"колчество штук\": ");
                    container.setMax_capacity(get_int());
                    view("Введите колчество контейнеров в складе: ");
                    container.setCapacity(get_int());
                    view("Склад успещно создан!");
                    storages.add_storage(container);
                    break;
                case 4:
                    avtomobile_strg avtomobile = new avtomobile_strg();
                    view("Введите номер склада: ");
                    avtomobile.setNum_storage(get_int());
                    view("Введите максимальная вместимость склада \"Количество штук\": ");
                    avtomobile.setMax_capacity(get_int());
                    view("Введите количество автомобилей на складе: ");
                    avtomobile.setCapacity(get_int());
                    view("Склад успещно создан!\n");
                    storages.add_storage(avtomobile);
                    break;
                case 5:
                    break;
                default:
                    view("Введите от 1 до 5: ");
            }
        }while(choise !=5 );
        return storages;
    }

    public Train add_platform(Train train) {
        int choise;
        do {
            view_type_platforms();
            view("Выберите тип платформы: ");
            choise = get_int();

            switch (choise) {
                case 1:
                    liquid_pm liquid= new liquid_pm();
                    view("Введите номер платформы: ");
                    liquid.setNum_platform(get_int());
                    view("Введите максимальный емкость платформы: ");
                    liquid.setMax_capacity(get_int());
                    view("Успещно добавлено!\n");
                    train.add_platform(liquid);
                    break;
                case 2:
                    grits_pm grits = new grits_pm();
                    view("Введите номер платформы: ");
                    grits.setNum_platform(get_int());
                    view("Введите максимальный емкость платформы: ");
                    grits.setMax_capacity(get_int());
                    view("Успещно добавлено!\n");
                    train.add_platform(grits);
                    break;
                case 3:
                    container_pm container= new container_pm();
                    view("Введите номер платформы: ");
                    container.setNum_platform(get_int());
                    view("максимальный емкость платформы равна 1\n");
                    container.setMax_capacity(1);
                    view("Успещно добавлено!\n");
                    train.add_platform(container);
                    break;
                case 4:
                    avtomobile_pm avtomobile= new avtomobile_pm();
                    view("Введите номер платформы: ");
                    avtomobile.setNum_platform(get_int());
                    view("Платформа для автомобилей может веревозить от 10 - 20 шт\n");
                    view("Введите максимальный емкость платформы: ");
                    do {
                        int num = get_int();
                        if (num >= 0 && num <= 20){
                            avtomobile.setMax_capacity(num);
                            break;
                        }
                        else {
                            view("Платформа для автомобилей может веревозить от 10 - 20 шт\n");
                            view("Введите заново: ");
                        }
                    }while (true);
                    train.add_platform(avtomobile);
                    break;
                case 5:
                    break;
                default:
                    view("Введите от 1 до 5: ");
            }
        }while (choise!=5);
        return train;
    }

    public Train create_train(){
        Train train = new Train();
        int num_train;
        view("Введите номер поезда: ");
        do {
            try {
                num_train = Integer.parseInt(controller());
                break;
            }
            catch (NumberFormatException e) {
                view("Неправильнй ввод! введите заново: ");
            }
        }while (true);
        train.setNum_Train(num_train);
        return train;
    }

    //CONTROLLER
    static String controller(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static <T> void addIfNotPresent(LinkedList<T> list, T element) {
        if (!list.contains(element)) {
            list.add(element);
        }
    }

    public int get_int(){
        int input_int;
        do {
            try {
                input_int = Integer.parseInt(controller());
                break;
            }
            catch (NumberFormatException e) {
                view("Неправильный ввод! Введите заново: ");
            }
        }while (true);
        return input_int;
    }


    // VIEW
    public void view(String key, Object... args){
        System.out.printf(key, args);
    }

    public void view_type_platforms() {
        view("для нефть, дизельное топливо, мазут. . . . . . . . . . . 1\n");
        view("для зерно, уголь, песок, . . . . . . . . . . . . . . . . 2\n");
        view("для контейнеров. . . . . . . . . . . . . . . . . . . . . 3\n");
        view("для автомобилей. . . . . . . . . . . . . . . . . . . . . 4\n");
        view("Отменить . . . . . . . . . . . . . . . . . . . . . . . . 5\n\n");
    }

}


