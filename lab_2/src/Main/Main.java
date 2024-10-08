package Main;

import java.util.LinkedList;
import java.util.Scanner;

// 1 РАЗРАБОТАВАТЬ МЕТОД ДОБАВЛЕНИЕ АВТОМОЬИЛЯ НА СКЛАД
// 2 ПЕРЕСМОТРЕТЬ МЕТОДЫ ЗАГРУЗКИ И ВЫГРУЗКИ ТОАВРОВ.

// Демонстрация программы
public class Main {
    public static void main(String[] args) {
        model();
    }

    public static void model(){
        Train train = new Train();
        storages storage = new storages();
        navigation_main(train, storage);
        view("Выход из программы...");
    }

    public static void navigation_main(Train train, storages strg){
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
                    if (load_plt(train, strg))
                        view("Успещно загружено\n");
                    else view("Ощибка, Неправильный ввод данных или недостаточно мест на платформе или недостаточно грузов на складе\n");
                    break;
                case 6:
                    if (unload_plt(train, strg))
                        view("Успещно загружено\n");
                    else view("Ощибка, Неправильный ввод данных или недостаточно мест на платформе или недостаточно грузов на складе\n");
                    break;
                default:
                    view("Ощибка ввода! Введите целое число от 1 до 7 включительно\n");

            }
        }while(choise != 7);
    }


    public static boolean unload_plt(Train train, storages storages){
        boolean f = false;
        int choise;
        do {
            view_type_platforms();
            view("Выберите тип груза: ");
            choise = get_int();
            int numPm, numStrg;

            switch (choise){
                case 1:
                    Liquid liquid = new Liquid();
                    view("\nДоступные склады: \n");
                    for (Storage storage: storages.getStorages()){
                        if (liquid.getName().equalsIgnoreCase(storage.GetTypeCargo())){
                            storage.DisplayInfo();
                        }
                    }

                    view("\nДоступные платформы: \n");
                    for (Platform platform: train.getPlatforms()){
                        if (liquid.getName().equalsIgnoreCase(platform.GetTypeCargo())){
                            platform.DisplayInfo();
                        }
                    }

                    do {
                        view("Введите номер платформы: ");
                        numPm = get_int();
                        view("Введите номер склада: ");
                        numStrg = get_int();
                        view("Введите масса груза: ");
                        liquid.setMass(get_int());
                        try {
                            for (Platform platform : train.getPlatforms()) {
                                if (platform.getNum_platform() == numPm) {
                                    if (platform instanceof LiquidPm) {
                                        ((LiquidPm) platform).unload(liquid);
                                    }
                                }
                            }
                            for (Storage storage: storages.getStorages()){
                                if (storage.getNum_storage() == numStrg) {
                                    if (storage instanceof LiquidStrg){
                                        ((LiquidStrg) storage).load(liquid);
                                    }
                                }
                            }
                            break;
                        }
                        catch (Exception e){
                            view("Ощибка! Повторите попытку!");
                        }
                    }while (true);
                    break;
                case 2:
                    Grits grits = new Grits();
                    view("\nДоступные склады: \n");
                    for (Storage storage: storages.getStorages()){
                        if (grits.getName().equalsIgnoreCase(storage.GetTypeCargo())){
                            storage.DisplayInfo();
                        }
                    }

                    view("\nДоступные платформы: \n");
                    for (Platform platform: train.getPlatforms()){
                        if (grits.getName().equalsIgnoreCase(platform.GetTypeCargo())){
                            platform.DisplayInfo();
                        }
                    }

                    do {
                        view("Введите номер платформы: ");
                        numPm = get_int();
                        view("Введите номер склада: ");
                        numStrg = get_int();
                        view("Введите масса груза: ");
                        grits.setMass(get_int());
                        try
                        {
                            for (Platform platform : train.getPlatforms()) {
                                if (platform.getNum_platform() == numPm) {
                                    if (platform instanceof GritsPm) {
                                        ((GritsPm) platform).unload(grits);
                                    }
                                }
                            }
                            for (Storage storage: storages.getStorages()){
                                if (storage.getNum_storage() == numStrg) {
                                    if (storage instanceof GritsStrg) {
                                        ((GritsStrg) storage).load(grits);
                                    }
                                }
                            }
                            break;
                        }
                        catch (Exception e) {
                            view("Ощибка! повторите попытку!");
                        }
                    }while (true);
                    break;
                case 3:
                    Container container = new Container();
                    String typeCargo = "Контейнер";
                    view("\nДоступные склады: \n");
                    for (Storage storage: storages.getStorages()){
                        if (typeCargo.equalsIgnoreCase(storage.GetTypeCargo())){
                            storage.DisplayInfo();
                        }
                    }

                    view("\nДоступные платформы: \n");
                    for (Platform platform: train.getPlatforms()){
                        if (typeCargo.equalsIgnoreCase(platform.GetTypeCargo())){
                            platform.DisplayInfo();
                        }
                    }

                    do {
                        view("Введите номер платформы: ");
                        numPm = get_int();
                        view("Введите номер склада: ");
                        numStrg = get_int();
                        try
                        {
                            for (Platform platform : train.getPlatforms()) {
                                if (platform.getNum_platform() == numPm) {
                                    if (platform instanceof ContainerPm) {
                                        ((ContainerPm) platform).unload(container);
                                    }
                                }
                            }
                            for (Storage storage: storages.getStorages()){
                                if (storage.getNum_storage() == numStrg) {
                                    if (storage instanceof ContainerStrg) {
                                        ((ContainerStrg) storage).load(container);
                                    }
                                }
                            }
                            break;
                        }
                        catch (Exception e) {
                            view("Ощибка! повторите попытку!");
                        }
                    }while (true);
                    break;
                case 4:
                    view("\nДоступные склады: \n");
                    for (Storage storage: storages.getStorages()){
                        if (storage instanceof AvtomobileStrg){
                            storage.DisplayInfo();
                        }
                    }

                    view("\nДоступные платформы: \n");
                    for (Platform platform: train.getPlatforms()){
                        if (platform instanceof AvtomobilePm){
                            platform.DisplayInfo();
                        }
                    }
                    Avtomobile avtomobile = new Avtomobile();
                    String typeCargo1 = "Автомобиль";

                    do {
                        boolean flag = false;
                        view("Введите номер платформы: ");
                        numPm = get_int();
                        view("Введите номер склада: ");
                        numStrg = get_int();
                        for (Platform platform: train.getPlatforms()){
                            if (platform.getNum_platform() == numPm) {
                                if (platform instanceof AvtomobilePm) {
                                    AvtomobilePm avtomobilePm = (AvtomobilePm) platform;
                                    view("\nДоступные автомобили: \n");
                                    avtomobilePm.ShowAvtomobiles();
                                    view("\"Введите номер автомобиля\"");
                                    int num_avto = get_int();
                                    Avtomobile avtomobile1 = avtomobilePm.getAvtomobiles().get(num_avto-1);
                                    try {
                                        avtomobilePm.unload(avtomobile1);
                                        for (Storage storage: storages.getStorages()){
                                            if (storage.getNum_storage() == numStrg) {
                                                if (storage instanceof AvtomobileStrg) {
                                                    AvtomobileStrg avtomobileStrg = (AvtomobileStrg) storage;
                                                    try{
                                                        avtomobileStrg.unload(avtomobile1);
                                                        flag = true;
                                                    }
                                                    catch (Exception e) {
                                                        flag = false;
                                                        view("Ощибка! автомабил не загружено на склад!");
                                                    }
                                                }
                                            }
                                        }
                                        flag = true;
                                    }
                                    catch (Exception e) {
                                        flag = false;
                                        view("Ощибка автомобил не нащлось!");
                                    }
                                    
                                }
                            }
                        }
                        if (flag){break;};
                    }while (true);
                    break;
                case 5:
                    view("Выход в меню...");
                    break;
                default:
                    view("Введите пожалуйста целое число от 1 до 5 включительно");
            }
        }while (choise != 5);
        return f;
    }

    public static boolean load_plt(Train train, storages storages)
    {
        boolean f = false;
        int choise;
        do {
            view_type_platforms();
            view("Выберите тип груза: ");
            choise = get_int();
            int numPm, numStrg;

            switch (choise){
                case 1:
                    Liquid liquid = new Liquid();
                    view("\nДоступные склады: \n");
                    for (Storage storage: storages.getStorages()){
                        if (liquid.getName().equalsIgnoreCase(storage.GetTypeCargo())){
                            storage.DisplayInfo();
                        }
                    }

                    view("\nДоступные платформы: \n");
                    for (Platform platform: train.getPlatforms()){
                        if (liquid.getName().equalsIgnoreCase(platform.GetTypeCargo())){
                            platform.DisplayInfo();
                        }
                    }

                    do {
                        view("Введите номер платформы: ");
                        numPm = get_int();
                        view("Введите номер склада: ");
                        numStrg = get_int();
                        view("Введите масса груза: ");
                        liquid.setMass(get_int());
                        try {
                            for (Platform platform : train.getPlatforms()) {
                                if (platform.getNum_platform() == numPm) {
                                    if (platform instanceof LiquidPm) {
                                        ((LiquidPm) platform).load(liquid);
                                    }
                                }
                            }
                            for (Storage storage: storages.getStorages()){
                                if (storage.getNum_storage() == numStrg) {
                                    if (storage instanceof LiquidStrg){
                                        ((LiquidStrg) storage).unload(liquid);
                                    }
                                }
                            }
                            break;
                        }
                        catch (Exception e){
                            view("Ощибка! Повторите попытку!");
                        }
                    }while (true);
                    break;
                case 2:
                    Grits grits = new Grits();
                    view("\nДоступные склады: \n");
                    for (Storage storage: storages.getStorages()){
                        if (grits.getName().equalsIgnoreCase(storage.GetTypeCargo())){
                            storage.DisplayInfo();
                        }
                    }

                    view("\nДоступные платформы: \n");
                    for (Platform platform: train.getPlatforms()){
                        if (grits.getName().equalsIgnoreCase(platform.GetTypeCargo())){
                            platform.DisplayInfo();
                        }
                    }

                    do {
                        view("Введите номер платформы: ");
                        numPm = get_int();
                        view("Введите номер склада: ");
                        numStrg = get_int();
                        view("Введите масса груза: ");
                        grits.setMass(get_int());
                        try
                        {
                            for (Platform platform : train.getPlatforms()) {
                                if (platform.getNum_platform() == numPm) {
                                    if (platform instanceof GritsPm) {
                                        ((GritsPm) platform).load(grits);
                                    }
                                }
                            }
                            for (Storage storage: storages.getStorages()){
                                if (storage.getNum_storage() == numStrg) {
                                    if (storage instanceof GritsStrg) {
                                        ((GritsStrg) storage).unload(grits);
                                    }
                                }
                            }
                            break;
                        }
                        catch (Exception e) {
                            view("Ощибка! повторите попытку!");
                        }
                    }while (true);
                    break;
                case 3:
                    Container container = new Container();
                    String typeCargo = "Контейнер";
                    view("\nДоступные склады: \n");
                    for (Storage storage: storages.getStorages()){
                        if (typeCargo.equalsIgnoreCase(storage.GetTypeCargo())){
                            storage.DisplayInfo();
                        }
                    }

                    view("\nДоступные платформы: \n");
                    for (Platform platform: train.getPlatforms()){
                        if (typeCargo.equalsIgnoreCase(platform.GetTypeCargo())){
                            platform.DisplayInfo();
                        }
                    }

                    do {
                        view("Введите номер платформы: ");
                        numPm = get_int();
                        view("Введите номер склада: ");
                        numStrg = get_int();
                        try
                        {
                            for (Platform platform : train.getPlatforms()) {
                                if (platform.getNum_platform() == numPm) {
                                    if (platform instanceof ContainerPm) {
                                        ((ContainerPm) platform).load(container);
                                    }
                                }
                            }
                            for (Storage storage: storages.getStorages()){
                                if (storage.getNum_storage() == numStrg) {
                                    if (storage instanceof ContainerStrg) {
                                        ((ContainerStrg) storage).unload(container);
                                    }
                                }
                            }
                            break;
                        }
                        catch (Exception e) {
                            view("Ощибка! повторите попытку!");
                        }
                    }while (true);
                    break;
                case 4:
                    boolean flag = false;
                    view("\nДоступные склады: \n");
                    for (Storage storage: storages.getStorages()){
                        if (storage instanceof AvtomobileStrg){
                            storage.DisplayInfo();
                        }
                    }

                    view("\nДоступные платформы: \n");
                    for (Platform platform: train.getPlatforms()){
                        if (platform instanceof AvtomobilePm){
                            platform.DisplayInfo();
                        }
                    }
                    Avtomobile avtomobile = new Avtomobile();
                    String typeCargo1 = "Автомобиль";


                    do {
                        view("Введите номер платформы: ");
                        numPm = get_int();
                        view("Введите номер склада: ");
                        numStrg = get_int();
                        for (Storage storage: storages.getStorages()){
                            if (storage.getNum_storage() == numPm) {
                                if (storage instanceof AvtomobileStrg) {
                                    AvtomobileStrg avtomobileStrg = (AvtomobileStrg) storage;
                                    view("\nДоступные автомобили: \n");
                                    avtomobileStrg.ShowAvtomobiles();
                                    view("\"Введите номер автомобиля\"");
                                    int num_avto = get_int();
                                    Avtomobile avtomobile1 = avtomobileStrg.getAvtomobiles().get(num_avto - 1);
                                    try {
                                        avtomobileStrg.unload(avtomobile1);
                                        for (Platform platform: train.getPlatforms()){
                                            if (platform.getNum_platform() == numPm) {
                                                if (platform instanceof AvtomobilePm) {
                                                    AvtomobilePm avtomobilePm = (AvtomobilePm) platform;
                                                    try {
                                                        avtomobilePm.load(avtomobile1);
                                                        flag = true;
                                                    }
                                                    catch (Exception e) {
                                                        flag = false;
                                                        view("Ощибка! автомабил не загружено на платформу!");
                                                    }
                                                }
                                            }
                                        }
                                        flag = true;
                                    }
                                    catch (Exception e) {
                                        flag = false;
                                        view("Ощибка автомобил не нащлось!");
                                    }
                                }
                            }
                        }
                        if(flag){break;}
                    }while (true);
                    break;
                case 5:
                    view("Выход в меню...");
                    break;
                default:
                    view("Введите пожалуйста целое число от 1 до 5 включительно");
            }
        }while (choise != 5);
        return f;
    }

    public static void info_platform(Train train){
        view("%-37s| %-33s| %-26s |%40s%n",
                "Номер платформы", "Вместимость (кг/шт)", "Масса (кг/шт)", "Груз");
        view("=========================================================================================================================%n");
        for(Platform platform: train.getPlatforms()){
            platform.DisplayInfo();
        }
        view("=========================================================================================================================%n");
    }

    public static void info_trains(LinkedList<Train> train){
        view("%-37s| %-37s%n", "Номер поезда", "количество платформ");
        view("===========================================================================%n");
        for (Train t: train){
            view("%-37s| %-37s%n", t.getNum_Train(), t.getPlatforms().size());
        }
        view("===========================================================================%n");
    }

    public static void info_strg(storages storages){
        view("%-37s| %-33s| %-26s |%40s%n",
                "Номер склада",  "Вместимость (кг/шт)", "Масса (кг/шт)", "Груз");
        view("=========================================================================================================================%n");
        for (Storage storage: storages.getStorages()){
            storage.DisplayInfo();
        }
        view("=========================================================================================================================%n");

    }

    public static storages add_storage(storages storages){
        int choise;
        do {
            view_type_platforms();
            view("Выберите тип склад для хранение:\n");
            choise = get_int();
            int num_strg;

            switch (choise){
                case 1:
                    do {
                        view("Введите номер склада: ");
                        num_strg = get_int();
                        for(Storage storage: storages.getStorages()){
                            if (storage.getNum_storage() == num_strg){
                                view("Склад с номером " + num_strg + "Уже существует!");
                                continue;
                            }
                        }
                        break;
                    }while (true);
                    LiquidStrg liquid = new LiquidStrg();
                    liquid.setNum_storage(num_strg);
                    view("Введите общая масса груза на складе: ");
                    liquid.setCapacity(get_int());
                    view("Склад успещно создан!\n");
                    storages.add_storage(liquid);
                    break;
                case 2:
                    do {
                        view("Введите номер платформы: ");
                        num_strg = get_int();
                        for(Storage storage: storages.getStorages()){
                            if (storage.getNum_storage() == num_strg){
                                view("Склад с номером " + num_strg + "Уже существует!");
                                continue;
                            }
                        }
                        break;
                    }while (true);
                    GritsStrg grits = new GritsStrg();
                    grits.setNum_storage(num_strg);
                    view("Введите общая масса груза на складе: ");
                    grits.setCapacity(get_int());
                    view("Склад успещно создан!\n");
                    storages.add_storage(grits);
                    break;
                case 3:
                    do {
                        view("Введите номер платформы: ");
                        num_strg = get_int();
                        for(Storage storage: storages.getStorages()){
                            if (storage.getNum_storage() == num_strg){
                                view("Склад с номером " + num_strg + "Уже существует!");
                                continue;
                            }
                        }
                        break;
                    }while (true);
                    ContainerStrg container = new ContainerStrg();
                    container.setNum_storage(num_strg);
                    view("Введите колчество контейнеров в складе: ");
                    container.setCapacity(get_int());
                    view("Склад успещно создан!");
                    storages.add_storage(container);
                    break;
                case 4:
                    do {
                        view("Введите номер платформы: ");
                        num_strg = get_int();
                        for(Storage storage: storages.getStorages()){
                            if (storage.getNum_storage() == num_strg){
                                view("Склад с номером " + num_strg + "Уже существует!");
                                continue;
                            }
                        }
                        break;
                    }while (true);
                    AvtomobileStrg avtomobile = new AvtomobileStrg();
                    avtomobile.setNum_storage(num_strg);
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

    public static Train add_platform(Train train) {
        int choise;
        do {
            view_type_platforms();
            view("Выберите тип платформы: ");
            choise = get_int();
            int num_plt;

            switch (choise) {
                case 1:
                    do {
                        view("Введите номер платформы: ");
                        num_plt = get_int();
                        for(Platform platform: train.getPlatforms()){
                            if (platform.getNum_platform() == num_plt){
                                view("Платформа с номером " + num_plt + "Уже существует!");
                                continue;
                            }
                        }
                        break;
                    }while (true);
                    LiquidPm liquid = new LiquidPm();
                    liquid.setNum_platform(num_plt);
                    view("Успещно добавлено!\n");
                    train.add_platform(liquid);
                    break;
                case 2:
                    do {
                        view("Введите номер платформы: ");
                        num_plt = get_int();
                        for(Platform platform: train.getPlatforms()){
                            if (platform.getNum_platform() == num_plt){
                                view("Платформа с номером " + num_plt + "Уже существует!");
                                continue;
                            }
                        }
                        break;
                    }while (true);
                    GritsPm grits = new GritsPm();
                    grits.setNum_platform(num_plt);
                    view("Успещно добавлено!\n");
                    train.add_platform(grits);
                    break;
                case 3:
                    do {
                        view("Введите номер платформы: ");
                        num_plt = get_int();
                        for(Platform platform: train.getPlatforms()){
                            if (platform.getNum_platform() == num_plt){
                                view("Платформа с номером " + num_plt + "Уже существует!");
                                continue;
                            }
                        }
                        break;
                    }while (true);
                    ContainerPm container = new ContainerPm();
                    container.setNum_platform(num_plt);
                    view("Успещно добавлено!\n");
                    train.add_platform(container);
                    break;
                case 4:
                    do {
                        view("Введите номер платформы: ");
                        num_plt = get_int();
                        for(Platform platform: train.getPlatforms()){
                            if (platform.getNum_platform() == num_plt){
                                view("Платформа с номером " + num_plt + "Уже существует!");
                                continue;
                            }
                        }
                        break;
                    }while (true);
                    AvtomobilePm avtomobile = new AvtomobilePm();
                    avtomobile.setNum_platform(num_plt);
                    view("Успещно добавлено!\n");
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

    public static Train create_train(){
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
    public static String controller(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static <T> void addIfNotPresent(LinkedList<T> list, T element) {
        if (!list.contains(element)) {
            list.add(element);
        }
    }

    public static int get_int(){
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
    public static void view(String key, Object... args){
        System.out.printf(key, args);
    }

    public static void view_type_platforms() {
        view("для нефть, дизельное топливо, мазут. . . . . . . . . . . 1\n");
        view("для зерно, уголь, песок, . . . . . . . . . . . . . . . . 2\n");
        view("для контейнеров. . . . . . . . . . . . . . . . . . . . . 3\n");
        view("для автомобилей. . . . . . . . . . . . . . . . . . . . . 4\n");
        view("Выход в меню . . . . . . . . . . . . . . . . . . . . . . 5\n\n");
    }

    public static void view_type_cargos() {
        view("Нефть. . . . . . . . . . . . . . . . . . . . . . . . . . 1\n\n");
        view("Дизельное топливо. . . . . . . . . . . . . . . . . . . . 2\n\n");
        view("Мазут. . . . . . . . . . . . . . . . . . . . . . . . . . 3\n\n");
        view("Зерно. . . . . . . . . . . . . . . . . . . . . . . . . . 4\n\n");
        view("Уголь. . . . . . . . . . . . . . . . . . . . . . . . . . 5\n\n");
        view("Песок. . . . . . . . . . . . . . . . . . . . . . . . . . 6\n\n");
        view("Контейнер. . . . . . . . . . . . . . . . . . . . . . . . 7\n\n");
        view("Автомобиль . . . . . . . . . . . . . . . . . . . . . . . 8\n\n");
        view("Отменить . . . . . . . . . . . . . . . . . . . . . . . . 9\n\n");
    }

}


