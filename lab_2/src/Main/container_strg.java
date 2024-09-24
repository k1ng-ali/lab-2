package Main;

public class container_strg extends storage{
    private boolean is_loaded = false;
    private int capacity;

    public container_strg() {}
    public container_strg(boolean is_loaded, int capacity, String storage_num) {
        this.is_loaded = is_loaded;
        this.capacity = capacity;
        super.setStorage_num(storage_num);
    }

//SETTERS
    public void setis_loaded(boolean is_loaded) {
        this.is_loaded = is_loaded;
    }
    public void setcapacity(int capacity) {
        this.capacity = capacity;
    }
    public void GetStorage_num(String storage_num) {
        super.setStorage_num(storage_num);
    }

//GETTERS
    public int getcapacity() {
        return capacity;
    }
    public boolean GetIs_loaded() {
        return is_loaded;
    }
    public String GetStorage_num() {
        return super.getStorage_num();
    }
}
