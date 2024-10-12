package Main;

public class Avtomobile {
    private ID id;
    private String name;
    private int mass;

    public Avtomobile() {
        id = new ID("av");
        Main.view("Введите модел автомобиля: ");
        name = Main.controller();
        Main.view("Введите масса автомобиля: ");
        mass = Main.get_int();
    }

    public Avtomobile(String name, int mass) {
        this.name = name;
        this.mass = mass;
    }

    public String getName() {return name;};
    public int getMass() {return mass;}
    public ID getID() {return id;}
}
