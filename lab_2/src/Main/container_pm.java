package Main;

import java.util.LinkedList;

public class container_pm extends Platform implements Icargo{

    public container_pm() {
        super.Type_cargo.add("Контейнер");
    }

    @Override
    public LinkedList<String> getType_cargo() {
        return super.Type_cargo;
    }

    @Override
    public void setCapacity(int capacity) {
        super.capacity = capacity;
    }

    @Override
    public int getCapacity() {
        return super.capacity;
    }

    @Override
    public void setNum_platform(int num_platform) {
        super.num_platform = num_platform;
    }

    @Override
    public int getNum_platform() {
        return super.num_platform;
    }

    @Override
    public void setMax_capacity(int max_capacity) {
        super.max_capacity = max_capacity;
    }

    @Override
    public int getMax_capacity() {
        return super.max_capacity;
    }


    @Override
    public String load(String Type_cargo, int mass) {
        if ((super.capacity + mass) <= super.max_capacity &&
                super.Type_cargo.contains(Type_cargo)) {
            super.capacity += mass;
            return "Успещно загружено!";
        }
        else {
            return "На платформе не хватает мест или на платформу нельза грузить груз токого вида!";
        }
    }

    @Override
    public String unload(String Type_cargo, int mass) {
        if ((super.capacity - mass) >=0 &&
                super.Type_cargo.contains(Type_cargo)) {
            super.capacity -= mass;
            return "Успещно разгружено!";
        }
        else {
            return "На платорме недаостаточно груза или на платформе нет груз такого вида!";
        }
    }
}
