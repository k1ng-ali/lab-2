package Main;

import java.util.LinkedList;

public class container_pm extends platform implements iLoad{
    private boolean is_Loaded = false;
    private LinkedList<String> type = new LinkedList<>();

    public container_pm(){}
    public container_pm(boolean is_Loaded, int capacity, String type, int max_capacity){
        this.is_Loaded = is_Loaded;
        super.capacity = capacity;
        super.max_capacity = max_capacity;
        this.type = type;
    }

    public container_pm(boolean is_Loaded, int capacity, int num_train){
        this.is_Loaded = is_Loaded;
        super.capacity = capacity;
        super.setNum_train(num_train);
    }

//GETTERS
    @Override
    public int getCapacity() {
        return super.capacity;
    }

    @Override
    public int getMaxCapacity() {
        return super.max_capacity;
    }

    public boolean GetIs_Loaded() {
        return is_Loaded;
    }

//SETTERS
    @Override
    public void setCapacity(int capacity) {
        super.capacity = capacity;
    }

    @Override
    public void setMaxCapacity(int max_capcity) {
        super.max_capacity = max_capcity;
    }

    public void setIs_Loaded(boolean is_Loaded) {
        this.is_Loaded = is_Loaded;
    }




    public void info(){
        String isloaded;
        if (this.is_Loaded){
            isloaded = "Загруженa";
        }
        else {
            isloaded = "Не Загруженa";
        }
        String text = "Платформа" + isloaded  + "\n" +
                "Вес платформы: " + this.getCapacity() + " кг\n" +
                "платформа в составе поезда: " + this.getNum_train() + "\n";
        Main.View(text);
    }
//METHODS
    @Override
    public void load(String type, int mass) {
        if(super.)
    }

    @Override
    public void unload(String type, int mass) {

    }
}
