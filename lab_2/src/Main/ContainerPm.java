package Main;

public class ContainerPm extends Platform{
    Container container;

    public ContainerPm() {
        this.container = new Container();
        super.max_capacity = 1;
        super.capacity = 0;
        super.IsLoaded = false;
    }

    @Override
    public String GetTypeCargo() {
        return "Контейнер";
    }


    public Boolean load(Container container) {
        if (this.container.equals(container) && !super.IsLoaded){
            super.IsLoaded = true;
            super.capacity += container.GetMass();
            return true;
        }
        else return false;
    }

    public Boolean unload(Container container) {
        if (this.container.equals(container) && super.IsLoaded){
            super.IsLoaded = false;
            super.capacity -= container.GetMass();
            return true;
        }
        else return false;
    }

    @Override
    public void DisplayInfo() {
        Main.view("%-37s| %-33s| %-26s |%40s%n",
                super.num_platform,
                super.max_capacity,
                super.capacity,
                "Контейнер");
    }
}
