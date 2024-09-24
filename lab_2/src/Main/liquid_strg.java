package Main;

public class liquid_strg {
    private String type_liquid;
    private int capacity;
    private int max_capacity;

    public liquid_strg(){}
    public liquid_strg(String type_liquid, int capacity, int max_capacity) {
        this.type_liquid = type_liquid;
        this.capacity = capacity;
        this.max_capacity = max_capacity;
    }

//METHODS
    public String load(String type_liquid, int mass){
        if (this.type_liquid.equals(type_liquid) &&
                (this.capacity + mass) <= this.max_capacity){
            this.capacity += mass;
            return "Успешно загружено";
        }
        else {
            return "Тип жидкости не совпадают или на складе не хватает мест!";
        }
    }
    public String unload(String type_liquid, int mass){
        if (this.type_liquid.equals(type_liquid) &&
        (this.capacity - mass) >= 0){
            this.capacity -= mass;
            return "Успещно разгружено";
        }
        else {
            return "Тип жидкости не совпадают или на складе недостаточно жидкостей!";
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
