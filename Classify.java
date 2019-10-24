/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src.featureextraction;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;

/**
 *
 * @author seabirds
 */
public class Classify 
{
    ReviewFrame rf;
    ArrayList review=new ArrayList();
    ArrayList informal=new ArrayList();
    ArrayList formal=new ArrayList();
    ArrayList undef=new ArrayList();
     ArrayList<String> stp=new ArrayList<String>();
      String sen="";
    Classify(ReviewFrame re,ArrayList at)
    {
        rf=re;
        review=at;
        System.out.println("MMMMM"+review);
        readStopWord();
    }
    public ArrayList<String> readFormal()
    {
        ArrayList<String> st=new ArrayList<String>();
        try
        {
            
            Scanner scan1 = null;
            scan1 = new Scanner(new BufferedReader(new FileReader("Formal.txt")));
            while (scan1.hasNext())
            st.add(scan1.next());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return st;
    }

    public ArrayList<String> readInformal()
    {
        ArrayList<String> st=new ArrayList<String>();
        try
        {

            Scanner scan1 = null;

            scan1 = new Scanner(new BufferedReader(new FileReader("Informal.txt")));
            while (scan1.hasNext())
                st.add(scan1.next());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return st;
    }
    
    public void classifyReview()
    {
        try
        {
             ArrayList formal1 = new ArrayList();
             ArrayList Informal1 = new ArrayList();
             ArrayList form1=readFormal();
             ArrayList inform1=readInformal();
             String res="" , a = "",b="";
            
             for(int i=0;i<review.size();i++)
             {
                 String s1=review.get(i).toString().toLowerCase();
                 String ss=s1.replace("#","-->");
                 String s2[]=s1.split("#");
                 String sg=s2[1];
                 System.out.println("b1"+sg);
                 sg = sg.replaceAll("[^\\p{L}]", " ");
                 System.out.println("bbb"+sg);
                 String tt[]=sg.toLowerCase().split(" ");
                 int fo=0;
                 int info=0;
                 for(int j=0;j<tt.length;j++)
                 {
                     if(form1.contains(tt[j]))
                     {                                                   
                            fo++;
                            formal1.add(tt[j]);
                     }
                     if(inform1.contains(tt[j]))
                     {
                            info++;
                            Informal1.add(tt[j]);
                     }
                 }
                 System.out.println(i+" :  "+fo+" : "+info);
                 if(fo<info)
                 {
                     informal.add(s1);
                     res=res+ss+"\n\n";
                     String g1=s2[1].replace(".", " ");
                     sen=sen+g1.trim()+"."+"\n";
                 }
                 else if(fo>info){
                      formal.add(s1);
                      a=a+ss+"\n\n";
                 }                    
                 else{
                     undef.add(s1);
                     b=b+ss+"\n\n";
                 }                     
             }
             res=res+a+b;
             System.out.println("tt "+review.size()+" : "+informal.size()+" : "+formal.size());
             ClassifyFrame cf=new ClassifyFrame(informal);
            /// Formal ff = new Formal();
            // ff.setVisible(true);
             cf.setVisible(true);
             cf.setTitle("Review classification");
             cf.setResizable(false);
             
             cf.jLabel5.setText(String.valueOf(review.size()));
             //cf.jLabel6.setText(String.valueOf(formal.size()));
            // cf.jLabel7.setText(String.valueOf(informal.size()));
           //  cf.jLabel9.setText(String.valueOf(undef.size()));
             cf.jTextArea1.setText(res);
            // cf.jTextArea3.setText(a);
             //cf.jTextArea2.setText(b);
            // ff.words(formal1, Informal1);
//             ff.jTextArea1.setText(formal1.toString());
//             ff.jTextArea2.setText(Informal1.toString());
             String stpw[] = sen.split(" ");
             for(int i = 0; i <stpw.length ; i++){
                 for(int j = 0 ; j <stp.size(); j++){
                     if(stpw[i].equals(stp.get(j).toString())){
                     //System.out.println(stp.get(j).toString());
                     sen = sen.replace(" "+stpw[i]+" "," ");
                   //  sen.replaceAll(stpw[i],"");
                 }
                 }
                              
             }
             
             File fe=new File("sen.txt");
             FileOutputStream fos=new FileOutputStream(fe);
             fos.write(sen.trim().getBytes());
             fos.close();
             
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void readStopWord()
    {
       
        Scanner scan1 = null;
        
        try
        {
            scan1 = new Scanner(new BufferedReader(new FileReader("stopwords.txt")));
            while (scan1.hasNext())
                stp.add(scan1.next());
            System.out.println(stp.size()+"cvbcmcmcmcmcmcmcm"+stp.toString());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //return stp;
    }
}
