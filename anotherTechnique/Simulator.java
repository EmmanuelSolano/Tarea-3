package anotherTechnique;

import java.awt.*;
import javax.swing.ImageIcon;
import java.lang.String;
import javax.swing.JPanel;

public class Simulator
{

    private DisplayFrame myDisplayer;  //JFrame
    private Circle myCircle;
    private Rectangle myRectangle;
    int x;
    int y;
    int x0;
    int y0;
    boolean limitFrame=false;
    int f1;
    int f2;
    
    //constructor
    public Simulator(DisplayFrame myDisplayer_)
    {
        this.setMyDisplayer(myDisplayer_);
        this.setMyCircle(new Circle());
        this.setMyRectangle(new Rectangle());

        //valores de las figuras
        myCircle.setHeight(60);
        myCircle.setWidth(70);
        myRectangle.setHeight(75);
        myRectangle.setWidth(100);
      
    }

    
    //ciclo infinito para mover las figuras
    public void startSimulation(int waitingTime) throws InterruptedException 
    {
        //ciclo infinito

        x=0+(int) (Math.random() * (350));
        y=0+(int) (Math.random() * (350));
        x0=0+(int) (Math.random() * (350));
        y0=0+(int) (Math.random() * (350));
        while (true){
            this.moveShapes();
            this.createImages();
            //pone en espera el flujo del programa
            Thread.sleep(15);
        }
        
    }//end method

    public boolean verificaFrame(){
        if(x==310 || y==1 || x0==310 || y0==1){
            limitFrame=true;
            f1=0+(int)(Math.random()*3);
            f2=0+(int)(Math.random()*3);
        }
        return limitFrame;
    }

    public boolean verificaFrame2(){
        if(x==1 || x0==1 || y==myDisplayer.getBounds().height-90 || y0==myDisplayer.getBounds().height-90){
            limitFrame=false;
            f1=0+(int)(Math.random()*3);
            f2=0+(int)(Math.random()*3);
        }
        return limitFrame;
    }
    //cambio los valores de las variables de las figuras que tengo
    public void moveShapes() {
        
        if(!limitFrame){
            
            if(f1==0){
                if(!verificaFrame()){
                    x++;
                    y--;
                }
                
            }else if(f1==1){
                if(!verificaFrame()){
                    x--;
                    y++;
                }
                
            }else if(f1==3){
                if(!verificaFrame()){
                    x--;
                    y--;
                }
                
            }
            else{
                if(!verificaFrame()){
                    x++;
                    y++;
                }
            }
            if(f2==0){
                if(!verificaFrame()){
                    x0++;
                    y0--;
                }
                
            }else if(f2==1){
                if(!verificaFrame()){
                    x0--;
                    y0++;
                }
            }else if(f2==3){
                
                if(!verificaFrame()){
                    x0++;
                    y0++;
                }
            }else{
                if(!verificaFrame()){
                    x0--;
                    y0--;
                }
            }
            verificaFrame();
            getMyCircle().setColumn(x);
            getMyCircle().setRow(y);
            getMyRectangle().setColumn(x0);
            getMyRectangle().setRow(y0);
            
            
        }else{
            
            if(f1==0){
                if(verificaFrame2()){
                    x--;
                    y++;
                }
                
            }else if(f1==1){
                if(verificaFrame2()){
                    x++;
                    y--;
                }
                
            }else if(f1==3){
                if(verificaFrame2()){
                    x++;
                    y++;
                }
                
            }else{
                if(verificaFrame2()){
                    x--;
                    y--;
                }
            }
            if(f2==0){
                if(verificaFrame2()){
                    x0--;
                    y0++;
                }
                
            }else if(f2==1){
                if(verificaFrame2()){
                    x0++;
                    y0--;
                }
                
            }else if(f2==3){
                if(verificaFrame2()){
                    x0--;
                    y0--;
                }
                
            }else{
                if(verificaFrame2()){
                    x0++;
                    y0++;
                }
            }
            verificaFrame2();
            getMyCircle().setColumn(x);
            getMyCircle().setRow(y);
            getMyRectangle().setColumn(x0);
            getMyRectangle().setRow(y0);
           
        }
        if(limitFrame){
            
            if(f1==0){
                if(!verificaFrame()){
                    x++;
                    y--;
                }
                
            }else if(f1==1){
                if(!verificaFrame()){
                    x--;
                    y++;
                }
                
            }else if(f1==3){
                if(!verificaFrame()){
                    x--;
                    y--;
                }
                
            }
            else{
                if(!verificaFrame()){
                    x++;
                    y++;
                }
            }
            if(f2==0){
                if(!verificaFrame()){
                    x0++;
                    y0--;
                }
                
            }else if(f2==1){
                if(!verificaFrame()){
                    x0--;
                    y0++;
                }
            }else if(f2==3){
                
                if(!verificaFrame()){
                    x0++;
                    y0++;
                }
            }else{
                if(!verificaFrame()){
                    x0--;
                    y0--;
                }
            }
            verificaFrame();
            getMyCircle().setColumn(x);
            getMyCircle().setRow(y);
            getMyRectangle().setColumn(x0);
            getMyRectangle().setRow(y0);
            
            
        }else{
            
            if(f1==0){
                if(verificaFrame2()){
                    x--;
                    y++;
                }
                
            }else if(f1==1){
                if(verificaFrame2()){
                    x++;
                    y--;
                }
                
            }else if(f1==3){
                if(verificaFrame2()){
                    x++;
                    y++;
                }
                
            }else{
                if(verificaFrame2()){
                    x--;
                    y--;
                }
            }
            if(f2==0){
                if(verificaFrame2()){
                    x0--;
                    y0++;
                }
                
            }else if(f2==1){
                if(verificaFrame2()){
                    x0++;
                    y0--;
                }
                
            }else if(f2==3){
                if(verificaFrame2()){
                    x0--;
                    y0--;
                }
                
            }else{
                if(verificaFrame2()){
                    x0++;
                    y0++;
                }
            }
            verificaFrame2();
            getMyCircle().setColumn(x);
            getMyCircle().setRow(y);
            getMyRectangle().setColumn(x0);
            getMyRectangle().setRow(y0);
           
        }
        
        
        
    }

    //coloca nuevos valores aleatorios en las figuras
    public void createImages()
    {
        myDisplayer.initImage();
        Graphics graphic = myDisplayer.getGraphicsImage();

        graphic.setColor(Color.BLUE);
        graphic.fillOval(getMyCircle().getColumn(),
                getMyCircle().getRow(),
                getMyCircle().getWidth(),
                getMyCircle().getHeight());

        graphic.setColor(Color.RED);
        graphic.fillRect(getMyRectangle().getColumn(),
                getMyRectangle().getRow(),
                getMyRectangle().getWidth(),
                getMyRectangle().getHeight());

        myDisplayer.paintAgain();
    }



    //**************************************************************************
    /*     metodos accesores      */

    public Circle getMyCircle() {
        return myCircle;
    }

    public void setMyCircle(Circle myCircle) {
        this.myCircle = myCircle;
    }

    public DisplayFrame getMyDisplayer() {
        return myDisplayer;
    }

    public void setMyDisplayer(DisplayFrame myDisplayer) {
        this.myDisplayer = myDisplayer;
    }

    public anotherTechnique.Rectangle getMyRectangle() {
        return myRectangle;
    }

    public void setMyRectangle(anotherTechnique.Rectangle myRectangle) {
        this.myRectangle = myRectangle;
    }

}
