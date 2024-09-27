package Main;

import java.util.LinkedList;

public class storages {
    private LinkedList<storage> storages = new LinkedList<storage>();

    public storages() {}
    public storages(LinkedList<storage> storages) {
        this.storages = storages;
    }

    public LinkedList<storage> getStorages() {
        return storages;
    }

    public void add_storage(storage storage) {
        storages.add(storage);
    }

    public void remove_storage(storage storage) {
        storages.remove(storage);
    }
}
