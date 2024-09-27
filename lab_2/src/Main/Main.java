package Main;

import java.util.LinkedList;
import java.util.Scanner;

// Демонстрация программы
public class Main {
    public static void main(String[] args) {
    }

    public void load_to_platform(Train train, storages storages){
        int choise;
        int n = 0;
        do {
            LinkedList<String> products = new LinkedList<>();
            for (storage storage: storages.getStorages())
            {
                if (storage.getCapacity() > 0) {
                    for (String prd : storage.getType_cargo())
                        addIfNotPresent(products, prd);
                }
            }
            view("Доступные продукты: \n");
            for (String key: products)
                view(key + ", ");





        }while(choise!=5);
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
                    view("максимальный емкость платформы равна 1");
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
    public void view(String key){
        System.out.println(key);
    }

    public void view_type_platforms() {
        view("для нефть, дизельное топливо, мазут. . . . . . . . . . . 1");
        view("для зерно, уголь, песок, . . . . . . . . . . . . . . . . 2");
        view("для контейнеров. . . . . . . . . . . . . . . . . . . . . 3");
        view("для автомобилей. . . . . . . . . . . . . . . . . . . . . 4");
        view("Отменить . . . . . . . . . . . . . . . . . . . . . . . . 5\n\n");
    }

}


