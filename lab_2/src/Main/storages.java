package Main;

import java.util.LinkedList;

public class storages {
    private LinkedList<Storage> storages = new LinkedList<Storage>();

    public storages() {}
    public storages(LinkedList<Storage> storages) {
        this.storages = storages;
    }

    public LinkedList<Storage> getStorages() {
        return storages;
    }

    public void add_storage(Storage storage) {
        storages.add(storage);
    }

    public void remove_storage(Storage storage) {
        storages.remove(storage);
    }
}
