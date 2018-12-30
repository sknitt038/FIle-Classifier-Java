/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileclassifier;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import twitter4j.TwitterException;

/**
 *
 * @author viranjan
 */

class Test {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        boolean fb,twt;
          // Process p;
        JPanel contentPane = new JPanel(null);
        private JButton b1=new JButton("Rename");
        private JButton b2=new JButton("Delete");
        private JButton b3=new JButton("Open");
        private JButton b4=new JButton("Share");
        private JButton b5=new JButton("Search");
        private JButton b6= new JButton("<---");
        private JButton b7= new JButton("-R-");
        private JButton b8= new JButton("OK");// to rename
        private JButton b9= new JButton("Facebook");
        private JButton b10= new JButton("Twitter");
       // private JButton b11= new JButton("Gmail");
        private JButton b12= new JButton("Post");
        private JButton b13= new JButton("Properties");
        private JLabel j1= new JLabel("Search File :");
        private JLabel j2= new JLabel("Write Your Status :");// for status
        private JTextField t1=new JTextField();
        private JTextField t2= new JTextField(); //rename
        private JTextArea t3= new JTextArea();// for status
      public Test() throws IOException {
        b1.setBounds(510,100,150,50);
        b2.setBounds(510,151,150,50);
        b3.setBounds(510,202,150,50);
        b4.setBounds(510,253,150,50);
        b5.setBounds(520,60,100,30);
        b13.setBounds(510,304,150,50);
        b6.setBounds(10,10,80,30);
        b7.setBounds(610,10,80,30);
        b8.setBounds(685,151,60,30);
        b9.setBounds(510,100,150,50);
        b10.setBounds(510,151,150,50);
      //  b11.setBounds(510,202,150,50);
        b12.setBounds(650,200,80,40);
        j1.setBounds(10,50,200,50);
        j2.setBounds(500,40,150,200);
        t1.setBounds(215, 60, 300, 30);
        t2.setBounds(500,151,180,30);
        t3.setBounds(500,151,150,130);
        contentPane.add(b1);
        contentPane.add(b2);
        contentPane.add(b3);
        contentPane.add(b4);
        contentPane.add(b5);
        contentPane.add(b6);
        contentPane.add(b7);
        contentPane.add(b8);
        contentPane.add(b9);
        contentPane.add(b10);
     //   contentPane.add(b11);
        contentPane.add(b12);
        contentPane.add(b13);
        contentPane.add(j1);
        contentPane.add(j2);
        contentPane.add(t1);
        contentPane.add(t2);
        contentPane.add(t3);
        
        b1.setVisible(!true);
        b2.setVisible(!true);
        b3.setVisible(!true);
        b4.setVisible(!true);
        b8.setVisible(!true);
        b9.setVisible(!true);
        b10.setVisible(!true);
     //   b11.setVisible(!true);
        b12.setVisible(!true);
        b13.setVisible(!true);
        j1.setVisible(true);
        j2.setVisible(false);
        t1.setVisible(true);
        t2.setVisible(false);
        t3.setVisible(false);
          
}
  
 
public void Displaybutton(String file){
       fb=false;
       twt=false;
    // System.out.println(file);
        b1.setVisible(true);
        b2.setVisible(true);
        b3.setVisible(true);
        b4.setVisible(true);
        b13.setVisible(true);
        b1.addActionListener(new java.awt.event.ActionListener() {
                    @Override
             public void actionPerformed(java.awt.event.ActionEvent e) {
                    b1.setVisible(false);
                    b2.setVisible(false);
                    b3.setVisible(false);
                    b4.setVisible(false);
                    b13.setVisible(false);
                    t2.setVisible(true);
                    b8.setVisible(true);
                   File oldfile =new File(file);
                   int index=file.lastIndexOf("\\");
                   int l_index=file.lastIndexOf("."); 
                   String extention=file.substring(l_index,file.length());
                   
                   String dtext=file.substring(index+1,l_index);  
                  
                   t2.setText(dtext);
                   b8.addActionListener(new java.awt.event.ActionListener() {
                    @Override
      
                    public void actionPerformed(java.awt.event.ActionEvent f) {
                        String new_file_name=t2.getText();
                        String new_name=file.substring(0, index+1)+new_file_name+extention;
                        System.out.println(new_name);
                        File newfile =new File(new_name);
                        if (newfile.exists())
                        JOptionPane.showMessageDialog(null,"File with this name already exist ");
                        else {
                        oldfile.renameTo(newfile);
                              JOptionPane.showMessageDialog(null,"File sucessfully renamed ");
                              t2.setVisible(false);
                              b8.setVisible(false);
                        }            
                     }            
                    
                   });
        
       
             }
 
            });
        
            b2.addActionListener(new java.awt.event.ActionListener() {
                    @Override
      
             public void actionPerformed(java.awt.event.ActionEvent f) {
            
                    b1.setVisible(false);
                    b2.setVisible(false);
                    b3.setVisible(false);
                    b4.setVisible(false);
                    b13.setVisible(false);
               
                    File f1 = new File(file);
                    boolean success = f1.delete();
                    if(success){
                           JOptionPane.showMessageDialog(null,"File Sucessfully deleted");
                    }
                    else
                          JOptionPane.showMessageDialog(null,"File not exist ");
                                return ;
                            }            
            });
        
        b3.addActionListener(new java.awt.event.ActionListener() {
                   // @Override
              
             public void actionPerformed(java.awt.event.ActionEvent e) {
                    b1.setVisible(false);
                    b2.setVisible(false);
                    b3.setVisible(false);
                    b4.setVisible(false);
                    b13.setVisible(false);
                   
        
        if ((new File(file)).exists()) {
            try {
                String open="rundll32 url.dll,FileProtocolHandler "+file;
                Process p = Runtime.getRuntime().exec(open);
            } catch (IOException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {

            JOptionPane.showMessageDialog(null,"File not exist ");

        }
       
      } 
             
                  
            });
           b4.addActionListener(new java.awt.event.ActionListener() {
                   // @Override
              
             public void actionPerformed(java.awt.event.ActionEvent e) {
                    b1.setVisible(false);
                    b2.setVisible(false);
                    b3.setVisible(false);
                    b4.setVisible(false);
                    b13.setVisible(false);
                    b9.setVisible(!false);
                    b10.setVisible(!false);
                  //  b11.setVisible(!false);
                   
       
      } 
             
                  
            });
           b9.addActionListener(new java.awt.event.ActionListener() {
                   // @Override
              
             public void actionPerformed(java.awt.event.ActionEvent e) {
                  t3.setVisible(true);
                   j2.setVisible(true);
                   b9.setVisible(false);
                   b10.setVisible(false);
                  // b11.setVisible(false);
                   b12.setVisible(true);
                   fb=true;
                   
       
      } 
             
                  
            });
          b10.addActionListener(new java.awt.event.ActionListener() {
                   // @Override
              
             public void actionPerformed(java.awt.event.ActionEvent e) {
                 twt=true;
                  t3.setVisible(true);
                  j2.setVisible(true);
                  b9.setVisible(false);
                  b10.setVisible(false);
               //   b11.setVisible(false);
                  b12.setVisible(true);
                   
      } 
             
                  
            });
          // take status as input
                  b12.addActionListener(new java.awt.event.ActionListener() {
                   // @Override
              
             public void actionPerformed(java.awt.event.ActionEvent e) {
                   String status=t3.getText();
                   if(fb){
                    Facebook fs= new Facebook();
                 try {
                     fs.shareonWall(file,status);
                 } catch (FileNotFoundException ex) {
                     Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                 }
                      
                   }
                   else if(twt){
                   TwitterShare ts= new  TwitterShare();
                       try {
                           ts.share(file,status);
                       } catch (TwitterException ex) {
                           Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                       }
                   }
      } 
             
                  
            });
                  //event for properties   
                  b13.addActionListener(new java.awt.event.ActionListener() {
                   // @Override
              
             public void actionPerformed(java.awt.event.ActionEvent e) {
                 File oldfile =new File(file);
                   int index=file.lastIndexOf("\\");
                   int l_index=file.lastIndexOf("."); 
                   String extention=file.substring(l_index,file.length());
                   
                   String dtext=file.substring(index+1,l_index); 
          
                JPanel panel =  new JPanel(new GridLayout(0, 1, 5, 5));
                JLabel nameLabel = new JLabel("File Name : " +dtext );
                JLabel ageLabel = new JLabel("File Path : " +file.substring(0,index));
                JLabel yearLabel = new JLabel("File Size : "+(double) file.length() / 1024  +"  kb");
                panel.add(nameLabel);
                panel.add(ageLabel);
                panel.add(yearLabel);
                 JOptionPane.showMessageDialog(null, panel, "Output : ",
                    JOptionPane.INFORMATION_MESSAGE);
                 
      } 
             
                  
            } );
     
}
public void Displayfile(String name, String nname){
  
       panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
         
       
        
      
         BufferedReader reader;
           String file_name;
		try {
		     reader = new BufferedReader(new FileReader(name));
                    
                     file_name= reader.readLine();
                 JButton b=new JButton();
                    int i=0;
                    while ( file_name != null) {
                        String str =file_name.substring(file_name.lastIndexOf("\\") + 1);
                    
                      b = new JButton(str);   
                     panel.add(b);
                     String s=file_name;
                 
                     b.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                  public void actionPerformed(java.awt.event.ActionEvent e) {
                    b8.setVisible(!true);
                    b9.setVisible(!true);
                    b10.setVisible(!true);
                   // b11.setVisible(!true);
                    b12.setVisible(!true);
                    j2.setVisible(false);
                    t2.setVisible(false);
                    t3.setVisible(false);
                    
                    Displaybutton(s);
                       
                   
                }


            });
        
             file_name = reader.readLine(); 
         
        }
			reader.close();
		} catch (IOException e) {	}
      

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0,100, 500, 500);
      
        contentPane.setPreferredSize(new Dimension(750, 700));
        contentPane.add(scrollPane);
        
      
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        frame.setVisible(true);
      
          b6.addActionListener(new java.awt.event.ActionListener() {
                   // @Override
              
             public void actionPerformed(java.awt.event.ActionEvent e) {
                Mainpage mp=new Mainpage();
                mp.setVisible(true);
             frame.dispose();
      } 
      
                  
            });
          // for searching a file
              b5.addActionListener(new java.awt.event.ActionListener() {
                   // @Override
              
             public void actionPerformed(java.awt.event.ActionEvent e) {
                  if(new File("search.txt").exists())
                  new File("search.txt").delete();
                 String s=t1.getText();
                 try {
                     GFG gf=new GFG();
                     gf.Search_Fun(name,s);
                 } catch (IOException ex) {
                     Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
               // Mainpage mp=new Mainpage();
               // mp.setVisible(true);
             
             frame.dispose();
              //Displaybutton("search.txt");
      } 
      
                  
            });
        b7.addActionListener(new java.awt.event.ActionListener() {
                   // @Override
              
             public void actionPerformed(java.awt.event.ActionEvent e) {
                    
                    Refresh(name, nname);  
                    frame.dispose();
      } 
                   
            });
         
    }
void Refresh(String name,String nname){
            try {
                Text txt;
                Rar rar;
                Jpeg jpg;
                Mp4 mp4;
                Mp3 mp3;
                Pdf pdf;
                Doc doc;
                if(name.equals("text.txt")||nname.equals("text.txt"))
                    txt= new Text();
                if(name.equals("rar.txt")||nname.equals("rar.txt"))
                    rar= new Rar();
                if(name.equals("pdf.txt")||nname.equals("pdf.txt"))
                    pdf= new Pdf();
                if(name.equals("doc.txt")||nname.equals("doc.txt"))
                    doc= new Doc();
                if(name.equals("mp3.txt")||nname.equals("mp3.txt"))
                    mp3= new Mp3();
                if(name.equals("mp4.txt")||nname.equals("mp4.txt"))
                    mp4= new Mp4();
                if(name.equals("jpeg.txt")||nname.equals("jpeg.txt"))
                    jpg= new Jpeg();
            } catch (IOException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
}
public void printt(String fname,String s)
    {
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter(fname, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            pw.println(s);
          
             pw.flush();

        }catch(Exception e)
        {
            
        }
        finally {
            try {
                pw.close();
                bw.close();
                fw.close();
            } catch (IOException io) {// can't do anything }
            }

        }
                 
    }
    
}
