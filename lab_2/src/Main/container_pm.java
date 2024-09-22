package Main;

public class container_pm extends cargo_train{
    protected boolean is_Loaded = false;
    int capacity;

    container_pm(){}
    container_pm(boolean is_Loaded, int capacity){
        this.is_Loaded = is_Loaded;
        this.capacity = capacity;
    }

    container_pm(boolean is_Loaded, int capacity, String num_train){
        this.is_Loaded = is_Loaded;
        this.capacity = capacity;
        super.num_train = num_train;
    }

//SETTERS
    public void setIs_Loaded(boolean is_Loaded){
        this.is_Loaded = is_Loaded;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

//GETTERS
    public boolean isIs_Loaded(){
        return this.is_Loaded;
    }
    public int getCapacity(){
        return this.capacity;
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
                "Вес платформы: " + this.capacity + " кг\n" +
                "платформа в составе поезда: " + this.num_train + "\n";
        Main.View(text);
    }
}
