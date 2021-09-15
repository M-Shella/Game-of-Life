package gameoflife;

public class Model {
    private static Model single_instance = null;
    private boolean pole[][];

    public boolean[][] getPole() {
        return pole;
    }

    public void setPole(boolean[][] pole) {
        this.pole = pole;
    }
    
    public static Model getInstance(){ 
        if (single_instance == null) 
            single_instance = new Model(); 
  
        return single_instance; 
    }
}
