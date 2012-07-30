/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author AyazAli
 */
import javax.print.DocFlavor.URL;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Class1{
    
    
    
	static JButton button[][]=new JButton[8][8];	
//	URL url= new URL(getClass().getResource("C:/Users/DELL/Desktop/project/project/images/black.gif"));
	ImageIcon red=new ImageIcon(getClass().getResource("images/gray.gif"));    
        JFrame frame=new JFrame("Chechkers");
        
   public static void main(String[] args){
   
       Class1 obj=new Class1();
       obj.init();
       
   }
       public void init(){
		   frame.setSize(800, 600);
                frame.setVisible(true);
		//GridLayout d=new GridLayout();
		frame.setLayout(new GridLayout(8,8));
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				button[i][j]=new JButton();
				if((i+j)%2==0)
				button[i][j].setBackground(Color.white);
				
				else{
				button[i][j].setBackground(Color.black);
				button[i][j].setIcon(red);
                                }
				
		}		
		}
		
		
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){		
				
				frame.add(button[i][j]);
		}}
   
		}

}
