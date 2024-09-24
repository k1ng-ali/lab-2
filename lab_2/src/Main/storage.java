package Main;

public class storage {
    private String storage_num;

    public storage(){}
    public storage(String storage_num) {
        this.storage_num = storage_num;
    }

//GETTERS
    public void setStorage_num(String storage_num) {
        this.storage_num = storage_num;
    }

//SETTERS
    public String getStorage_num() {
        return this.storage_num;
    }
}
