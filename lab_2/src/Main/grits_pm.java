package Main;

public class grits_pm {
    String type_grits;
    int capacity;
    int max_capacity;

    public grits_pm() {}

    public grits_pm(String type_grits, int capacity, int max_capacity) {
        this.type_grits = type_grits;
        this.capacity = capacity;
        this.max_capacity = max_capacity;
    }

//METHODS
    public String load(String type_grits, int mass) {
        if (this.type_grits.equals(type_grits) &&
                (this.capacity + mass <= this.max_capacity)) {
            this.capacity += mass;
            return "Успещно загружено!";
        }
        else {
            return "Тип грузов не совпадают или на платформе не хватает мест!";
        }
    }
    public String unload(String type_grits, int mass) {
        if (this.type_grits.equals(type_grits) &&
                (this.capacity - mass >= 0)) {
            this.capacity -= mass;
            return "Успещно разгружено!";
        }
        else {
            return "Тип грузов не совпадают или на платформе недостаточно груза!";
        }
    }

//SETTERS
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setType_grits(String type_grits) {
        this.type_grits = type_grits;
    }
    public void setMaxCapacity(int max_capacity) {
        this.max_capacity = max_capacity;
    }

//GETTERS
    public String getType_grits() {
        return type_grits;
    }
    public int getCapacity() {
        return capacity;
    }
    public int getMaxCapacity() {
        return max_capacity;
    }
}
