package Main;

public class cargo_train {
    protected String num_train;

    public cargo_train(){}
    public cargo_train(String num_train){
        this.num_train = num_train;
    }

//Setters
    public void setNum_train(String num_train){
        this.num_train = num_train;
    }

//Getters
    public String getNum_train() {
        return num_train;
    }

// SHOW ABOUT
    public void about_train()
    {
        String text = "Номер поезда: " + num_train + "\n ";
        Main.View(text);
    }
}
