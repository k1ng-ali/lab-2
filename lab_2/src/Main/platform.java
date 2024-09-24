package Main;

public abstract class platform extends cargo_train{
    protected int capacity;
    protected int max_capacity;

    public platform() {}
    public platform(int capacity, int max_capacity) {
        this.capacity = capacity;
    }

    abstract public int getCapacity();
    abstract public int getMaxCapacity();
    abstract public void setCapacity(int capacity);
    abstract public void setMaxCapacity(int max_capcity);
}
