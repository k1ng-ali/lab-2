package Main;

import java.util.LinkedList;

public class avtomobile_pm {
    LinkedList<String> cars = new LinkedList<>();
    int capacity;
    int max_capacity;

    public avtomobile_pm(int capacity, int max_capacity) {
        this.capacity = capacity;
        this.max_capacity = max_capacity;
    }

//METHODS
    public String load(String car_name){
        if (this.capacity < this.max_capacity){
            this.cars.add(car_name);
            return "Успещно загружено!";
        }
        else {
            return "На платформе не хватает мест!";
        }
    }
    public String unload(String car_name){
        if (this.cars.contains(car_name)){
            this.cars.remove(car_name);
            return "Успещно разружена";
        }
        else {
            return "На платформе нет такого автомобиля";
        }
    } 


//SETTERS
    public void set_capacity(int capacity) {
        this.capacity = capacity;
    }
    public void setMaxCapacity(int max_capacity) {
        this.max_capacity = max_capacity;
    }

//GETTERS
    public int get_capacity() {
        return capacity;
    }
    public int getMaxCapacity() {
        return max_capacity;
    }
}
