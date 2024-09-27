package Main;

import java.util.LinkedList;

public class avtomobile_strg extends storage implements Icargo{


    public avtomobile_strg() {
        super.Type_cargo.add("Автомобил");
    }

    public void add_Type_cargo(String type_cargo) {
        super.Type_cargo.add(type_cargo);
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
    public void setNum_storage(int num_storage) {
        super.num_storage = num_storage;
    }

    @Override
    public int getNum_storage() {
        return super.num_storage;
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
            return "На складе не хватает мест или на склад нельза грузить груз токого вида!";
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
            return "На складе недаостаточно груза или на складе нет груз такого вида!";
        }
    }
}
