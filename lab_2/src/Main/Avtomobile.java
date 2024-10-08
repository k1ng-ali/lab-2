package Main;

public class Avtomobile {
    String name;
    int mass;

    public Avtomobile() {
        do {
            try {
                Main.view("Введите модел автомобиля: ");
                name = Main.controller();
                Main.view("Введите масса автомобиля: ");
                Main.get_int();
                break;
            }
            catch (Exception e) {
                Main.view("Ощибка! Повторите попытку!");
            }
        }while (true);
    }

    public Avtomobile(String name, int mass) {
        this.name = name;
        this.mass = mass;
    }

    public String getName() {return name;};
    public int getMass() {return mass;}
}
