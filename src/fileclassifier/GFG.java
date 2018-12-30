package fileclassifier;

/**
 *
 * @author viranjan
 */
import static com.sun.javafx.fxml.expression.Expression.set;
import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.System.in;
import static java.lang.reflect.Array.set;
class GFG
 {
   
    public GFG() throws IOException{
       
    }
     public static void Search_Fun(String name,String s) throws FileNotFoundException, IOException{
           BufferedReader read = new BufferedReader(new FileReader(name));
                               int lines = 0;
                               while (read.readLine() != null) lines++;
                               read.close();
             String file_name; 
             Trie root = new Trie();
             
             BufferedReader reader;
		try {
                       HashSet<String> set = new HashSet<String>();
                         int i=0;
			reader = new BufferedReader(new FileReader(name));
			file_name=reader.readLine();
                        String[] st = new String[lines];
                        while (file_name != null) {
                         String str =file_name.substring(file_name.lastIndexOf("\\") + 1);
                         // str=str.substring(0,str.lastIndexOf("."));
                         st[i]  = str;
                          i++;
                         //  System.out.println(str);
                          file_name = reader.readLine(); 
                         
                        }
                  
                   Arrays.sort(st);
                   for(String k:st){
                       if(!set.contains(k)){
                           root.add(k);
                           set.add(k);
                       }
                   }
                        
		   reader.close();
		} catch (IOException e) {
			//e.printStackTrace();
		}
		
	

                
                  root.search(s); 
                Test t=new Test();
                t.Displayfile("search.txt",name);
     }
	public static void main (String[] args) throws FileNotFoundException, IOException 
	 {
                           
	 }
}
class Trie{
     public void printfile(String fname,String s)
    {
        System.out.println(s);
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
    // File ff;
        try {
            fw = new FileWriter(fname, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            System.out.println(s);
            File ff= new File(s);
            System.out.println(ff.getAbsolutePath());
            pw.println(new File(s).getAbsolutePath());
          
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
     
    boolean first;
    Trie[] child;
    ArrayList<String> al;
    public Trie(){
        first=false;
        child = new Trie[256];
        al = new ArrayList<String>();
    }
    public void add(String s){
        if(s.length()==0){
            return;
        }
        if(this.child[(int) s.charAt(0)]==null){
            this.child[(int) s.charAt(0)] = new Trie();
        }
        this.child[(int) s.charAt(0)].add(s,1);
    }
    public void add(String s,int i){
        if(i==s.length()){
            this.al.add(s);
            return;
        }
        if(s.length()<i){
            return;
        }
        this.al.add(s);
        if(this.child[(int) s.charAt(i)]==null){
            this.child[(int) s.charAt(i)] = new Trie();
        }
        this.child[(int) s.charAt(i)].add(s,i+1);
    }
    public void search(String s){
        if(s.length()==0){
            return;
        }
  
        else{
            this.child[(int) s.charAt(0)].search(s,s.length());
        }
    }
    public void search(String s,int i){
        if(i==s.length()){
            //Collections.sort(this.al);
            for(String k:this.al){
                if(s.equals(k.substring(0,s.length()))){
                System.out.print(k+" ");
                printfile("search.txt",k);
                }
            }
            System.out.println();
            return;
        }
        
        if(s.length()<i){
            return;
        }
        //Collections.sort(this.al);
        for(String k:this.al){
             if(s.equals(k.substring(0,s.length()))){
            System.out.print(k+" ");
            printfile("search.txt",k);
             }
        }
        System.out.println();
        if(this.child[(int) s.charAt(i)]==null){
            for(;i<s.length();i++){
                System.out.println("0");
            }
        }
        else{
            this.child[(int) s.charAt(i)].search(s,i+1);
        }
    }
    
}/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

