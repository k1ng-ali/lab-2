package Main;

public class LiquidPm extends Platform{
    Liquid liquid;

    public LiquidPm() {
        this.liquid = new Liquid();
        Main.view("Введите максимальный грузоподьемность платформы: ");
        super.max_capacity = Main.get_int();
        super.capacity = 0;
    }

    @Override
    public String GetTypeCargo() {
        return liquid.getName();
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
        Main.view("%-37s| %-33s| %-26s |%40s%n",
                super.num_platform,
                super.max_capacity,
                super.capacity,
                liquid.getName());
    }
}
