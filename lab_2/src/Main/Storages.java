package Main;

import java.util.LinkedList;

public abstract class Storages{
    private LinkedList<SerializableEntity> storages = new LinkedList<>();

    public Storages() {}
    public Storages(LinkedList<SerializableEntity> storages) {
        this.storages = storages;
    }

    public LinkedList<SerializableEntity> getStorages() {
        return storages;
    }

    public void add_storage(Storage storage) {
        storages.add(storage);
    }

    public void remove_storage(Storage storage) {
        storages.remove(storage);
    }

}
