package gameoflife;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class Platno extends JPanel{
    private Model model;
    private Metody metody;
    private boolean[][] pole;
    
    public Platno() {
        model = Model.getInstance();
        metody = new Metody();
        this.setBackground(Color.gray);
        metody.naplnPoleBlank();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        pole = model.getPole();
        for(int i = 0; i < pole.length; i++){
            for(int j = 0; j < pole[0].length; j++){
                if(pole[i][j])g.setColor(Color.black);
                else g.setColor(Color.white);
                g.fillRect(i+(i*metody.bunka), j+(j*metody.bunka), metody.bunka, metody.bunka);
                System.out.println(i+i*metody.bunka);
                System.out.println(j+j*metody.bunka);
            }
        }
    }
    
}
