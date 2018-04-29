/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PhotoFile;
import java.io.File;
import java.util.ArrayList;
/**
 *
 * @author admin
 */
public class ListPhoto
{
    private ArrayList<File> files1 = new ArrayList<File>();  
    public ListPhoto()
    {
    }
    public ArrayList<File> getListFiles(Object obj) 
    {  
        File directory = null;
        if (obj instanceof File)
        {
            directory = (File) obj;
        }
        else 
        {  
            directory = new File(obj.toString());  
        }  
        ArrayList<File> files = new ArrayList<File>();  
        if (directory.isFile()) 
        {  
            //System.out.println(directory.getPath());
            files.add(directory);
            files1 = files;
            
            return files;  
        } 
        else if (directory.isDirectory()) 
        {  
            File[] fileArr = directory.listFiles();  
            for (int i = 0; i < fileArr.length; i++) 
            {  
                File fileOne = fileArr[i];  
                files.addAll(getListFiles(fileOne));  
            }  
        }
        files1 = files;
        return files;  
    }  
}
