package Main;

import java.util.LinkedList;

public class ContainerStrg extends Storage implements Icargo{
    LinkedList<Container> containers=new LinkedList<Container>();

    public ContainerStrg() {
        View.view("Введите максимальный вместимость склада: ");
        super.max_capacity = Controller.get_int();
        super.capacity = 0;
    }

    @Override
    public String GetTypeCargo() {
        return "Контейнер";
    }


    public Boolean load(Container container) {
        if (this.containers.size() < super.max_capacity){
            containers.add(container);
            super.capacity += container.GetMass();
            return true;
        }
        else return false;
    }

    public Boolean unload(Container container) {
        if (this.containers.contains(container)){
            containers.remove(container);
            super.capacity -= container.GetMass();
            return true;
        }
        else return false;
    }

    @Override
    public void DisplayInfo() {
        View.view("%-37s| %-33s| %-26s |%40s%n",
                super.num_storage,
                super.max_capacity,
                super.capacity,
                "Контейнер");
    }
}
