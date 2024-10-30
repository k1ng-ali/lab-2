package Main;

import java.util.LinkedList;

public class AvtomobilePm extends Platform{
    LinkedList<Avtomobile> avtomobiles = new LinkedList<Avtomobile>();

    public AvtomobilePm() {
        View.view("Введите максимальный вместимость платформы: ");
        super.max_capacity = Controller.get_int();
        super.capacity = 0;
    }

    @Override
    public String GetTypeCargo() {
        return "Автомобиль";
    }


    public LinkedList<Avtomobile> getAvtomobiles() {
        return avtomobiles;
    }


    public Boolean load(Avtomobile avtomobile) {
        if (this.avtomobiles.size() < super.max_capacity) {
            this.avtomobiles.add(avtomobile);
            super.capacity += 1;
            return true;
        }
        return false;
    }


    public Boolean unload(Avtomobile avtomobile) {
        if (this.avtomobiles.contains(avtomobile)) {
            this.avtomobiles.remove(avtomobile);
            super.capacity -= 1;
            return true;
        }
        else return false;
    }

    @Override
    public void DisplayInfo() {
        View.view("%-37s| %-33s| %-26s |%40s%n",
                super.num_platform,
                super.max_capacity,
                super.capacity,
                "Автомобиль");
    }

    public void ShowAvtomobiles() {
        View.view("%-15s| %-37s |%40s%n",
                "№",
                "Модель автомобилья",
                "Масса автомобился");
        int i = 1;
        for (Avtomobile avtomobile : avtomobiles) {
            View.view("%-15s| %-37s |%40s%n",
                    i, avtomobile.getName(),
                    avtomobile.getMass());
            i++;
        }
    }
}
