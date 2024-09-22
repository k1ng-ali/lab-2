package Main;

public class liquid_pm extends cargo_train{
    String type_liquid;
    int capacity;
    int max_capacity;

    public liquid_pm() {}
    public liquid_pm(int capacity, int max_capacity) {
        this.capacity = capacity;
        this.max_capacity = max_capacity;
    }

//METHODS
    public String load_liquid(String type_liquid, int mass){
        if (this.type_liquid.equals(type_liquid) &&
                ((this.capacity + mass) <= this.max_capacity)){
            this.capacity += mass;
            return "Успещно загружено";
        }
        else {
            return "Тип жидкости не совпадают или на платформе не хватает мест!";
        }
    }

    public String unload_liquid(String type_liquid, int mass){
        if (this.type_liquid.equals(type_liquid) &&
                ((this.capacity - mass) >= 0)){
            this.capacity -= mass;
            return "Успещно разгружено";
        }
        else {
            return "Тип жидкости не совпадают или на платформе недостаточно жидкостей!";
        }
    }

//SETTERS
    public void setType_liquid(String type_liquid){
        this.type_liquid = type_liquid;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setMaxCapacity(int max_capacity) {
        this.max_capacity = max_capacity;
    }

//GETTERS
    public String getType_liquid() {
        return type_liquid;
    }
    public int getCapacity() {
        return capacity;
    }
    public int getMaxCapacity() {
        return max_capacity;
    }
}
