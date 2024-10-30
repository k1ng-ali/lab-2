package Main;

public class GritsPm extends Platform{
    Grits grits;


    public GritsPm() {
        this.grits = new Grits();
        View.view("Введите максимальный грузоподьемность платформы: ");
        super.max_capacity = Controller.get_int();
        super.capacity = 0;
    }

    @Override
    public String GetTypeCargo() {
        return grits.getName();
    }


    public Boolean load(Grits grits) {
        if (this.grits.getName().equalsIgnoreCase(grits.getName())&&
                super.max_capacity>=super.capacity + grits.getMass()) {
            this.grits.addMass(grits.getMass());
            super.capacity += grits.getMass();
            return true;
        }
        else return false;
    }

    public Boolean unload(Grits grits) {
        if (this.grits.getName().equalsIgnoreCase(grits.getName())&&
                0>=super.capacity - grits.getMass()) {
            this.grits.subMass(grits.getMass());
            super.capacity -= grits.getMass();
            return true;
        }
        else return false;
    }

    @Override
    public void DisplayInfo() {
        View.view("%-37s| %-33s| %-26s |%40s%n",
                super.num_platform,
                super.max_capacity,
                super.capacity,
                grits.getName());
    }
}
