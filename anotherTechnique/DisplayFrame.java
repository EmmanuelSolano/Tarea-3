package anotherTechnique;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class DisplayFrame extends JFrame implements Runnable {

    private int windowWidth;
    private int windowHeight;
    private Image image;
    Thread hilo;
    int x=0;
    boolean limitFrame=false;

    //construtor
    public DisplayFrame(int posX, int posY, int windowWidth_, int windowHeight_) {

        this.windowHeight = windowHeight_;
        this.windowWidth = windowWidth_;
        this.setLocation(posX, posY);
        this.setSize(this.windowWidth, this.windowHeight);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		this.addMouseListener(this);
        hilo = new Thread(this);
        hilo.start();
    }

    //inicializa la image
    public void initImage() {
        this.image = this.createImage(this.windowWidth, this.windowHeight);
    }

    //metodo que llama a repaint que es del JFrame.
    //este metodo pinta la image actual
    public void paintAgain() {
        repaint();
    }

    //solo funciona
    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, this);
        
    }
    
    @Override
    public void run() {
        while(hilo.isAlive()){
            if(!limitFrame){
                x++;
                //y--;
                if(x==getBounds().width-100){
                    limitFrame=true;
                }
                
                //getMyCircle().setColumn(x);
                //getMyCircle().setRow(y);
            }else{
                x--;
                //y++;
                if(x==0){
                    limitFrame=false;
                }
                //getMyCircle().setColumn(x);
                //getMyCircle().setRow(y);
            }
            repaint();
        }
        try {
            Thread.sleep(10);
        } catch (Exception e) {
        }
    }

//        /*                    clase que se deben implementar ya que se esta heredando de una clase abstract                        */
//	public void mouseClicked(MouseEvent evento){}
//	public void mousePressed(MouseEvent evento){}
//	public void mouseReleased(MouseEvent evento){}
//	public void mouseEntered(MouseEvent evento){}
//	public void mouseExited(MouseEvent evento){}
    
    /**
     * ********************* metodos accesores *************************
     */
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getWindowHeight() {
        return windowHeight;
    }

    public void setWindowHeight(int windowHeight) {
        this.windowHeight = windowHeight;
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public void setWindowWidth(int windowWidth) {
        this.windowWidth = windowWidth;
    }

    //para que otros manipulen mi image.getGraphics
    public Graphics getGraphicsImage() {
        return this.image.getGraphics();
    }
}
