package gameoflife;

import java.util.Random;

public class Metody {
    
    private Model model;
    private Platno platno;
    public boolean pole[][];
    private Random rd;
    private int velikostX;
    private int velikostY;
    public int bunka;
    public int mezera;
    
    public Metody() {
        model = Model.getInstance();
        rd = new Random();
        velikostX = 20;
        velikostY = 20;
        bunka = 20;
        mezera = 1;
        pole = new boolean[velikostX][velikostY];
    }
    public void naplnPole(){
        for (boolean[] pole1 : pole) {
            for (int j = 0; j < pole[0].length; j++) {
                pole1[j] = rd.nextBoolean();
            }
        }
        model.setPole(pole);
    }
    public void naplnPoleBlank(){
        for (boolean[] pole1 : pole) {
            for (int j = 0; j < pole[0].length; j++) {
                pole1[j] = false;
            }
        }
        model.setPole(pole);
    }
    public boolean zjistiNad(int x,int y){
        if(x > 0)return pole[x-1][y];
        return false;
    }
    public boolean zjistiPod(int x,int y){
        if(x < pole.length-1)return pole[x+1][y];
        return false;
    }
    public boolean zjistiLevo(int x,int y){
        if(y>0) return pole[x][y-1];
        return false;
    }
    public boolean zjistiPravo(int x,int y){
        if(y < pole[0].length-1)return pole[x][y+1];
        return false;
    }
    public boolean zjistiPravoNad(int x,int y){
        if(x > 0 && y < pole[0].length-1)return pole[x-1][y+1];
        return false;
    }
    public boolean zjistiLevoNad(int x,int y){
        if(y > 0 && x > 0)return pole[x-1][y-1];
        return false;
    }
    public boolean zjistiLevoPod(int x,int y){
        if(y > 0 && x < pole.length-1)return pole[x+1][y-1];
        return false;
    }
    public boolean zjistiPravoPod(int x,int y){
        if(y < pole[0].length-1 && x < pole.length-1)return pole[x+1][y+1];
        return false;
    }
    
    public boolean zjistiZivot(int x,int y){
        int z = 0;
        if(zjistiLevo(x, y))z++;
        if(zjistiPravo(x, y))z++;
        if(zjistiNad(x, y))z++;
        if(zjistiLevoNad(x, y))z++;
        if(zjistiPravoNad(x, y))z++;
        if(zjistiPod(x, y))z++;
        if(zjistiLevoPod(x, y))z++;
        if(zjistiPravoPod(x, y))z++;
        
        if(pole[x][y]){
            if(z==3 || z==2) return true;
        }else{
            if(z==3)return true;
        }
        
        return false;
    }
    
    public void zmenPole(){
        boolean[][] pole2 = new boolean[velikostX][velikostY];
        for(int i = 0; i < pole.length; i++){
            for(int j = 0; j < pole[0].length; j++){
                pole2[i][j]= zjistiZivot(i,j);
            }
        }
        pole = pole2;
        model.setPole(pole);
    }
    
    public void upravPole(int x, int y, boolean help){
        if (pole[x][y])pole[x][y]=!help;
        else pole[x][y]=help;
        model.setPole(pole);
    }
    
    public void nastavVelikost(int x, int y){
        naplnPoleBlank();
        velikostX = x;
        velikostY = y;
        pole = new boolean[velikostX][velikostY];
        model.setPole(pole);
        naplnPoleBlank();
    }
}
