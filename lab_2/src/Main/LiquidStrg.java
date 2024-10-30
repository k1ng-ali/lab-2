package Main;


public class LiquidStrg extends Storage{
    Liquid liquid;

    public LiquidStrg() {
        this.liquid = new Liquid();
        View.view("Введите максимальный вместимость склада: ");
        super.max_capacity = Controller.get_int();
        super.capacity = 0;
    }

    @Override
    public String GetTypeCargo() {
        return liquid.getName();
    }

    public String GetTypeLiquid()
    {
        return this.liquid.getName();
    }


    public Boolean load(Liquid liquid) {
        if (this.liquid.getName().equalsIgnoreCase(liquid.getName())&&
                super.max_capacity>=super.capacity + liquid.getMass()) {
            this.liquid.addMass(liquid.getMass());
            super.capacity += liquid.getMass();
            return true;
        }
        else return false;
    }

    public Boolean unload(Liquid liquid) {
        if (this.liquid.getName().equalsIgnoreCase(liquid.getName())&&
                super.capacity - liquid.getMass()>=0) {
            this.liquid.subMass(liquid.getMass());
            super.capacity -= liquid.getMass();
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
                liquid.getName());
    }
}
