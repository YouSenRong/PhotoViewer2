/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myPhoto;

import java.awt.*; 
import javax.swing.*; 
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.image.AffineTransformOp;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.lang.String;


/**
 *
 * @author admin
 */
public class Photo{
    private ImageIcon icon;
    private Image suitImage;
    private int Width = 0;
    private int Height = 0;
    private final int suitWidth = 1024;
    private final int suitHeight = 768;
    
    public Photo(String PhotoPath)
    {
    icon = new ImageIcon(PhotoPath);
    Width = icon.getIconWidth();
    Height = icon.getIconHeight();
    /*JLabel label = new JLabel(); 
    label.setIcon(icon); */
    }
    public Image getImage()
    {
        return icon.getImage();
    }
    public Image getSuitImage()
    {
        suitImage = icon.getImage();
        if( (Width > suitWidth) || (Height > suitHeight) )
        {
            suitImage = this.getImage().getScaledInstance(suitWidth, suitHeight,Image.SCALE_SMOOTH );
            Width = suitWidth;
            Height = suitHeight;
        }
        return suitImage;
    }
    public ImageIcon getPhoto()
    {
        return this.icon;
    }
    public int getPhotoWidth()
    {
        return Width;
    }
    public int getPhotoHeight()
    {
        return Height;
    }
    /*public void paint(Graphics g)
    {
        g.drawImage(suitImage,0,0,Width,Height, (ImageObserver) suitImage);
    }*/
}

/*class ImgUtils {
    /**
     * 缩放图片方法
     * @param srcImageFile 要缩放的图片路径
     * @param result 缩放后的图片路径
     * @param height 目标高度像素
     * @param width  目标宽度像素  
     * @param bb     是否补白
     */
     /*public final static Image scale(String srcImageFile, String result, int height, int width, boolean bb) {
         Image itemp = null;
         try {
                double ratio = 0.0; // 缩放比例
                File f = new File(srcImageFile);
                BufferedImage bi = ImageIO.read(f);
                itemp = bi.getScaledInstance(width, height, bi.SCALE_FAST);//bi.SCALE_SMOOTH  选择图像平滑度比缩放速度具有更高优先级的图像缩放算法。
                // 计算比例
               if ((bi.getHeight() > height) || (bi.getWidth() > width)) {
                   double   ratioHeight = (new Integer(height)).doubleValue()/ bi.getHeight();
                   double   ratioWhidth = (new Integer(width)).doubleValue()/ bi.getWidth();
                   if(ratioHeight>ratioWhidth){
                       ratio= ratioHeight;
                   }else{
                       ratio= ratioWhidth;
                   }
                    AffineTransformOp op = new AffineTransformOp(AffineTransform//仿射转换
                            .getScaleInstance(ratio, ratio), null);//返回表示剪切变换的变换
                    itemp = op.filter(bi, null);//转换源 BufferedImage 并将结果存储在目标 BufferedImage 中。
                }
                if (bb) {//补白
                   BufferedImage image = new BufferedImage(width, height,
                            BufferedImage.TYPE_INT_RGB);//构造一个类型为预定义图像类型之一的 BufferedImage。
                    Graphics2D g = image.createGraphics();//创建一个 Graphics2D，可以将它绘制到此 BufferedImage 中。
                    g.setColor(Color.white);//控制颜色
                    g.fillRect(0, 0, width, height);// 使用 Graphics2D 上下文的设置，填充 Shape 的内部区域。
                    if (width == itemp.getWidth(null))
                        g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2,
                                itemp.getWidth(null), itemp.getHeight(null),
                                Color.white, null);
                    else
                        g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0,
                                itemp.getWidth(null), itemp.getHeight(null),
                                Color.white, null);
                    g.dispose();
                    itemp = image;
                }
                return itemp;
                //ImageIO.write((BufferedImage) itemp, "JPEG", new File(result));      //输出压缩图片
            } catch (IOException e) {
                e.printStackTrace();
            }
            return itemp;
        }
     
}*/