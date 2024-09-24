// Демонстрация программы
public class Main {
    public static void main(String[] args) {
        // Создаем состав с 8 вагонами
        Train train = new Train(8);

        // Добавляем вагоны разного типа
        train.addWagon(new TankForLiquids());
        train.addWagon(new TankForLiquids());
        train.addWagon(new TankForLiquids());
        train.addWagon(new WagonForBulkGoods());
        train.addWwagon(new WagonForBulkGoods());
        train.addWagon(new WagonForBulkGoods());
        train.addWagon(new PlatformForContainers());
        train.addWagon(new CarTransportPlatform());

        // Создаем склад
        Warehouse warehouse = new Warehouse();

        // Загружаем состав товарами
        warehouse.loadTrain(train);
    }
}// Классы вагонов
abstract class Wagon {
    protected String typeWagon;
    protected String cargo;

    public Wagon(String typeWagon) {
        this.typeWagon = typeWagon;
        this.cargo = null;
    }

    public void load(String cargo) {
        if (this.cargo == null) {
            this.cargo = cargo;
            System.out.println(cargo + " загружен в " + typeWagon);
        } else {
            System.out.println(typeWagon + " уже загружен товаром: " + this.cargo);
        }
    }
}

class PlatformForContainers extends Wagon {
    public PlatformForContainers() {
        super("Платформа для контейнеров");
    }
}

class TankForLiquids extends Wagon {
    public TankForLiquids() {
        super("Цистерна для жидкостей");
    }
}

class WagonForBulkGoods extends Wagon {
    public WagonForBulkGoods() {
        super("Вагон для сыпучих грузов");
    }
}

class CarTransportPlatform extends Wagon {
    public CarTransportPlatform() {
        super("Автомобильная платформа");
    }
}

// Классы продукции
abstract class Product {
    protected String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Container extends Product {
    public Container() {
        super("Контейнер");
    }
}

class Liquid extends Product {
    public Liquid(String name) {
        super(name);
    }
}

class BulkGoods extends Product {
    public BulkGoods(String name) {
        super(name);
    }
}

class Car extends Product {
    public Car() {
        super("Автомобиль");
    }
}

// Класс железнодорожного состава
class Train {
    private Wagon[] wagons;
    private int currentWagon;

    public Train(int numberOfWagons) {
        wagons = new Wagon[numberOfWagons];
        currentWagon = 0;
    }

    public void addWagon(Wagon wagon) {
        if (currentWagon < wagons.length) {
            wagons[currentWagon++] = wagon;
        } else {
            System.out.println("Все вагоны уже добавлены");
        }
    }

    public void loadWagon(int index, Product product) {
        if (index < wagons.length && wagons[index] != null) {
            wagons[index].load(product.getName());
        } else {
            System.out.println("Невозможно загрузить товар в вагон.");
        }
    }

    public void addWwagon(WagonForBulkGoods wagonForBulkGoods) {
    }
}

// Класс склада
class Warehouse {
    public void loadTrain(Train train) {
        // Пример загрузки товаров в вагоны
        train.loadWagon(0, new Liquid("Нефть"));
        train.loadWagon(1, new Liquid("Дизельное топливо"));
        train.loadWagon(2, new Liquid("Мазут"));
        train.loadWagon(3, new BulkGoods("Зерно"));
        train.loadWagon(4, new BulkGoods("Уголь"));
        train.loadWagon(5, new BulkGoods("Песок"));
        train.loadWagon(6, new Container());
        train.loadWagon(7, new Car());
    }
}


