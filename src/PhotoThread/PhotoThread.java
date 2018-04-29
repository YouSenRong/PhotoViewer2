/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PhotoThread;

import java.io.File;
import java.util.ListIterator;
import myPanel.PhotoPanel;
import myPhoto.Photo;

/**
 *
 * @author admin
 */
public class PhotoThread extends Thread {
    
    ListIterator<File> listIterator = null;
    Photo photo;
    PhotoPanel photoPanel1;
    public Boolean exit = true;
    public PhotoThread(ListIterator<File> listIterator, Photo photo, PhotoPanel photoPanel1)
    {
        this.listIterator = listIterator;
        this.photo = photo;
        this.photoPanel1 = photoPanel1;
    }
    @Override
    public void run()
    {
        while(listIterator.hasNext() && exit)
        {
            try{
                this.sleep(1000);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            String str = listIterator.next().getPath();
            //System.out.println(iterator.next().getPath().toString());
            //System.out.println(str);
            photo = new Photo(str);
            photoPanel1.show(photo);
            photo = null;
            System.gc();
            try{
                this.sleep(2000);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            
            //second1 = c.get(Calendar.SECOND);
            //System.out.println(second1);
            /*while((second2-second1) < 4)
            {
                second2 = c.get(Calendar.SECOND);
                System.out.println(second2-second1);
            }*/
            //photoPanel1.show(photo);
            /*try  
            {  
                Thread.sleep(1000);  
            }  
            catch (InterruptedException e)  
            {  
            } 
            photoPanel1.show(photo);*/
           //photo = new Photo("D:\\photo\\dream.jpg");
           //photoPanel1.show(photo);
           //System.out.println(running);
           //second2 = c.get(Calendar.SECOND);
           //System.out.println(second2);
           /*time1 = System.currentTimeMillis();
           System.out.println(time1);
           while((time2 - time1) < 5000)
           {
                time2 = System.currentTimeMillis() ;
           //System.out.println(time2);
           }
           System.out.println(time2);
           jButton3.doClick();
           this.repaint();
        System.out.println("play end");*/
        
        
        //dispose();
        /*photo = new Photo("D:\\photo\\dream.jpg");
        photoPanel1.show(photo);
        */
        /*photo = new Photo("D:\\photo\\IMG_0121.jpg");
        photoPanel1.show(photo);*/
            
        }
    }
    
    public ListIterator<File> getListIterator()
    {
        return this.listIterator;
    }
    
}
