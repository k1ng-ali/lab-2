package Main;

import java.io.IOException;
import java.util.LinkedList;
public class AddObject {
    public static Storages add_storage(Storages storages){
        int choise;
        do {
            ViewInfo.view_type_platforms();
            View.view("Выберите тип склад для хранение:\n");
            choise = Controller.get_int();
            int num_strg;
            boolean f = true;

            switch (choise){
                case 1:
                    do {
                        f = true;
                        View.view("Введите номер склада: ");
                        num_strg = Controller.get_int();
                        for(Storage storage: storages.getStorages()){
                            if (storage.getNum_storage() == num_strg){
                                View.view("Склад с номером " + num_strg + "Уже существует!");
                                f = false;
                                break;
                            }
                        }
                        break;
                    }while (!f);
                    LiquidStrg liquid = new LiquidStrg();
                    liquid.setNum_storage(num_strg);
                    View.view("Введите общая масса груза на складе: ");
                    liquid.setCapacity(Controller.get_int());
                    View.view("Склад успещно создан!\n");
                    storages.add_storage(liquid);
                    break;
                case 2:
                    f = true;
                    do {
                        f = true;
                        View.view("Введите номер платформы: ");
                        num_strg = Controller.get_int();
                        for(Storage storage: storages.getStorages()){
                            if (storage.getNum_storage() == num_strg){
                                View.view("Склад с номером " + num_strg + "Уже существует!");
                                f = false;
                                break;
                            }
                        }
                        break;
                    }while (!f);
                    GritsStrg grits = new GritsStrg();
                    grits.setNum_storage(num_strg);
                    View.view("Введите общая масса груза на складе: ");
                    grits.setCapacity(Controller.get_int());
                    View.view("Склад успещно создан!\n");
                    storages.add_storage(grits);
                    break;
                case 3:
                    do {
                        f = true;
                        View.view("Введите номер платформы: ");
                        num_strg = Controller.get_int();
                        for(Storage storage: storages.getStorages()){
                            if (storage.getNum_storage() == num_strg){
                                View.view("Склад с номером " + num_strg + "Уже существует!");
                                f = false;
                                break;
                            }
                        }
                        break;
                    }while (!f);
                    ContainerStrg container = new ContainerStrg();
                    container.setNum_storage(num_strg);
                    View.view("Введите колчество контейнеров в складе: ");
                    container.setCapacity(Controller.get_int());
                    View.view("Склад успещно создан!");
                    storages.add_storage(container);
                    break;
                case 4:
                    do {
                        f = true;
                        View.view("Введите номер платформы: ");
                        num_strg = Controller.get_int();
                        for(Storage storage: storages.getStorages()){
                            if (storage.getNum_storage() == num_strg){
                                View.view("Склад с номером " + num_strg + "Уже существует!");
                                f = false;
                                break;
                            }
                        }
                        break;
                    }while (!f);
                    AvtomobileStrg avtomobile = new AvtomobileStrg();
                    avtomobile.setNum_storage(num_strg);
                    View.view("Склад успещно создан!\n");
                    storages.add_storage(avtomobile);
                    break;
                case 5:
                    break;
                default:
                    View.view("Введите от 1 до 5: ");
            }
        }while(choise !=5 );
        return storages;
    }

    public static Train add_platform(Train train) {
        int choise;
        do {
            ViewInfo.view_type_platforms();
            View.view("Выберите тип платформы: ");
            choise = Controller.get_int();
            int num_plt;
            boolean f = true;

            switch (choise) {
                case 1:
                    do {
                        f = true;
                        View.view("Введите номер платформы: ");
                        num_plt = Controller.get_int();
                        for(Platform platform: train.getPlatforms()){
                            if (platform.getNum_platform() == num_plt){
                                View.view("Платформа с номером " + num_plt + "Уже существует!");
                                f = false;
                                break;
                            }
                        }
                        break;
                    }while (!f);
                    LiquidPm liquid = new LiquidPm();
                    liquid.setNum_platform(num_plt);
                    View.view("Успещно добавлено!\n");
                    train.add_platform(liquid);
                    break;
                case 2:
                    do {
                        f = true;
                        View.view("Введите номер платформы: ");
                        num_plt = Controller.get_int();
                        for(Platform platform: train.getPlatforms()){
                            if (platform.getNum_platform() == num_plt){
                                View.view("Платформа с номером " + num_plt + "Уже существует!");
                                f = false;
                                break;
                            }
                        }
                        break;
                    }while (!f);
                    GritsPm grits = new GritsPm();
                    grits.setNum_platform(num_plt);
                    View.view("Успещно добавлено!\n");
                    train.add_platform(grits);
                    break;
                case 3:
                    do {
                        f = true;
                        View.view("Введите номер платформы: ");
                        num_plt = Controller.get_int();
                        for(Platform platform: train.getPlatforms()){
                            if (platform.getNum_platform() == num_plt){
                                View.view("Платформа с номером " + num_plt + "Уже существует!");
                                f = false;
                                break;
                            }
                        }
                        break;
                    }while (!f);
                    ContainerPm container = new ContainerPm();
                    container.setNum_platform(num_plt);
                    View.view("Успещно добавлено!\n");
                    train.add_platform(container);
                    break;
                case 4:
                    do {
                        f = true;
                        View.view("Введите номер платформы: ");
                        num_plt = Controller.get_int();
                        for(Platform platform: train.getPlatforms()){
                            if (platform.getNum_platform() == num_plt){
                                View.view("Платформа с номером " + num_plt + "Уже существует!");
                                f = false;
                                break;
                            }
                        }
                        break;
                    }while (!f);
                    AvtomobilePm avtomobile = new AvtomobilePm();
                    avtomobile.setNum_platform(num_plt);
                    View.view("Успещно добавлено!\n");
                    train.add_platform(avtomobile);
                    break;
                case 5:
                    break;
                default:
                    View.view("Введите от 1 до 5: ");
            }
        }while (choise!=5);
        return train;
    }

    public static Storages add_avto(Storages storage) {
        int choise;
        boolean f = false;
        do {
            View.view("Добавить авто. . . . . . . . . . . . . . . . . . . 1\n");
            View.view("Добавить несколько авто одного моделя. . . . . . . 2\n");
            View.view("Выход в меню . . . . . . . . . . . . . . . . . . . 3\n");
            choise = Controller.get_int();
            int num_strg;
            switch (choise) {
                case 1:
                    View.view("Доступные склады: ");
                    for (Storage storage1: storage.getStorages()){
                        if (storage1 instanceof AvtomobileStrg){
                            storage1.DisplayInfo();
                        }
                    }
                    f = false;

                    View.view("Введите номер склада: ");
                    num_strg = Controller.get_int();
                    for (Storage storage2: storage.getStorages()){
                        if (storage2.getNum_storage() == num_strg &&
                                storage2 instanceof AvtomobileStrg){
                            Avtomobile avtomobile = new Avtomobile();
                            ((AvtomobileStrg) storage2).load(avtomobile);
                            f = true;
                            break;
                        }
                    }
                    if(!f){
                        View.view("Склад по номеру "+num_strg + " не найден!");
                    }
                    break;
                case 2:
                    View.view("Доступные склады: ");
                    for (Storage storage1: storage.getStorages()){
                        if (storage1 instanceof AvtomobileStrg){
                            storage1.DisplayInfo();
                        }
                    }

                    f = false;
                    View.view("Введите номер склада: ");
                    num_strg = Controller.get_int();
                    String car_name;
                    int car_mass, cout;
                    View.view("Введите модел автомобиля: ");
                    car_name = Controller.getString();
                    View.view("Введите масса автомобиля: ");
                    car_mass = Controller.get_int();
                    View.view("Введите количества автомобиля: ");
                    cout = Controller.get_int();
                    for (Storage storage2: storage.getStorages()){
                        if (storage2.getNum_storage() == num_strg &&
                                storage2 instanceof AvtomobileStrg){
                            for (int i = 0; i < cout+1; i++){
                                Avtomobile avtomobile = new Avtomobile(car_name, car_mass);
                                ((AvtomobileStrg) storage2).load(avtomobile);
                            }
                            f = true;
                            break;
                        }
                    }
                    if(!f){
                        View.view("Склад по номеру "+num_strg + " не найден!");
                    }
                    break;
                default:
                    View.view("Введите целое число от 1 до 3 включительно!");
            }
            break;
        }while(choise != 3);

        return storage;
    }

    public static Train create_train(){
        Train train = new Train();
        int num_train;
        View.view("Введите номер поезда: ");
        do {
            try {
                num_train = Integer.parseInt(Controller.getString());
                break;
            }
            catch (NumberFormatException e) {
                View.view("Неправильнй ввод! введите заново: ");
            }
        }while (true);
        train.setNum_Train(num_train);
        return train;
    }

    public static <T> void addIfNotPresent(LinkedList<T> list, T element) {
        if (!list.contains(element)) {
            list.add(element);
        }
    }


}
