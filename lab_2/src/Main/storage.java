package Main;

import java.util.LinkedList;

public abstract class storage {
    protected LinkedList<String> Type_cargo = new LinkedList<>();
    protected int num_storage;
    protected int capacity;
    protected int max_capacity;

    public storage(int num_storage, int capacity, int max_capacity) {
        this.num_storage = num_storage;
        this.capacity = capacity;
        this.max_capacity = max_capacity;
    }
    public storage() {}

    public abstract LinkedList<String> getType_cargo();

    public abstract void setCapacity(int capacity);
    public abstract int getCapacity();

    public abstract void setMax_capacity(int max_capacity);
    public abstract int getMax_capacity();

    public abstract void setNum_storage(int num_storage);
    public abstract int getNum_storage();

}
