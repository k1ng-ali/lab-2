package Main;

public class Avtomobile {
    private ID id;
    private String name;
    private int mass;

    public Avtomobile() {
        id = new ID("av");
        View.view("Введите модел автомобиля: ");
        name = Controller.getString();
        View.view("Введите масса автомобиля: ");
        mass = Controller.get_int();
    }

    public Avtomobile(String name, int mass) {
        this.name = name;
        this.mass = mass;
    }

    public String getName() {return name;};
    public int getMass() {return mass;}
    public ID getID() {return id;}
}
