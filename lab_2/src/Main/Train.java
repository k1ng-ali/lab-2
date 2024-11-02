package Main;

import java.util.LinkedList;

public class Train {
    private LinkedList<SerializableEntity> platforms = new LinkedList<>();
    private int num_Train;

    public Train() {}
    public Train(int num_Train) {
        this.num_Train = num_Train;
    }

    public LinkedList<SerializableEntity> getPlatforms() {
        return platforms;
    }

    public void setNum_Train(int num_Train) {
        this.num_Train = num_Train;
    }
    public int getNum_Train() {
        return num_Train;
    }

    public void add_platform(Platform platform) {
        platforms.add(platform);
    }

    public void remove_platform(Platform platform) {
        platforms.remove(platform);
    }

}
