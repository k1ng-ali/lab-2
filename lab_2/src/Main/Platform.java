package Main;

import java.util.LinkedList;

public abstract class Platform {
    protected LinkedList<String> Type_cargo = new LinkedList<>();
    protected int num_platform;
    protected int capacity;
    protected int max_capacity;

    public Platform(int num_platform, int capacity, int max_capacity) {
        this.num_platform = num_platform;
        this.capacity = capacity;
        this.max_capacity = max_capacity;
    }
    public Platform() {}

    public abstract LinkedList<String> getType_cargo();

    public abstract void setCapacity(int capacity);
    public abstract int getCapacity();

    public abstract void setMax_capacity(int max_capacity);
    public abstract int getMax_capacity();

    public abstract void setNum_platform(int num_platform);
    public abstract int getNum_platform();
}
