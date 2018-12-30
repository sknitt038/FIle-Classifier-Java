/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileclassifier;

import com.restfb.BinaryAttachment;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import com.restfb.types.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

/**
 *
 * @author viranjan
 */
public class Facebook {
      public void shareonWall(String file,String status) throws FileNotFoundException{
          
         File oldfile =new File(file);
                   int index=file.lastIndexOf("\\");
                   int l_index=file.lastIndexOf("."); 
                   String extention=file.substring(l_index+1,file.length());
                   String filename=file.substring(index+1,file.length()); 
          int size= (int)new File(file).length()/(1024*1024);
          if(!(extention.equals("jpeg")||(extention.equals("jpg"))||(extention.equals("png"))||extention.equals("mp3")||(extention.equals("mp4")))){
              JOptionPane.showMessageDialog(null,"only Image and Video can be shared");
              return ;
          }
              
           
         String accessToken="EAACEdEose0cBAI2U8RPW9yLy7htZB3QCuhO1NTxb6plWtPzdxZCMXwgRPEEVZA5YeOKadUZCNbVjJuTmTT6ubLkCSckje7B9S05ezLb2CDTX9p81FXTgcGusULLY0ruy2p5NtbpGpos1SGN7mTgIkeyQzQFvjIIJovnbh79q3wCD14xNZBqCSGs3SIXnElTRwND3p3RjXBwZDZD";
        FacebookClient fbClient=  new DefaultFacebookClient(accessToken);
        User me=fbClient.fetchObject("me",User.class);
           //write some msg on walll
         //FacebookType response= fbClient.publish("me/feed",FacebookType.class,Parameter.with("message","java"));
       FacebookType response1;
        //post image with masg
        FileInputStream fs= new FileInputStream( new File(file));
        if(extention.equals("jpeg")||extention.equals("jpg")||extention.equals("png"))
         response1= fbClient.publish("me/photos",FacebookType.class,BinaryAttachment.with(filename,fs),Parameter.with("message",status));
        else if(extention.equals(".mp3")||extention.equals(".mp4")){
                if(size>100)
                       JOptionPane.showMessageDialog(null,"File size is too large");
                  else
                //post video
///   FileInputStream fs= new FileInputStream( new File("F:\\me\\viranjan\\140.Core Java With OCJP_SCJP-Concurrent Collections Part-16--ArrayList vs CopyOnWriteArrayList.mp4"));
              response1= fbClient.publish("me/videos",FacebookType.class,BinaryAttachment.with(filename,fs),Parameter.with("message",status));
    
        }
        
    }
}
