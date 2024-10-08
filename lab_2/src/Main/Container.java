package Main;

public class Container {
    private int size;
    private int mass;

    public Container()
    {
        int choise;
        do {
            Main.view("Размер: 20 фут, Вес: 30 тонн . . . . . . . . . . 1\n");
            Main.view("Размер: 40 фут, Вес: 40 тонн . . . . . . . . . . 2\n");
            Main.view("\nВыберите размер контейнера: ");
            choise = Main.get_int();

            switch (choise) {
                case 1:
                    this.size = 20;
                    this.mass = 30000;
                    break;
                case 2:
                    this.size = 40;
                    this.mass = 40000;
                    break;
                default:
                    Main.view("Введите целое число от 1 до 2 включительно!");
            }
        }while (choise != 1 && choise != 2);
    }
    public int GetMass(){
        return this.mass;
    }
    public int GetSize(){
        return this.size;
    }
}
