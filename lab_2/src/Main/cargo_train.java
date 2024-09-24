package Main;

public class cargo_train {
    private int num_train;

    public cargo_train(){}
    public cargo_train(int num_train){
        this.num_train = num_train;
    }

//Setters
    public void setNum_train(int num_train){
        this.num_train = num_train;
    }

//Getters
    public int getNum_train() {
        return num_train;
    }

// SHOW ABOUT
    public void about_train()
    {
        String text = "Номер поезда: " + num_train + "\n ";
        Main.View(text);
    }
}
