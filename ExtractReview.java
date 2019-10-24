/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package src.featureextraction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import net.htmlparser.jericho.Source;
import java.net.URL;

/**
 *
 * @author seabird
 */
public class ExtractReview
{

    public ArrayList getPage()
    {
        ArrayList al=new ArrayList();
        try
        {
            String url="http://www.testfreaks.co.in/digital-cameras/";
          
            al.add(url);
            System.out.println("Heba output 2" +al);
            URL ul=new URL(url);
            Source sd=new Source(ul);
            String cc=sd.toString();
            System.out.println("Heba output 3" +ul);
          // System.out.println("vvv" +cc);
          //  int ind1=cc.lastIndexOf("Compare Checked");
           int ind1=cc.lastIndexOf("controls clearfix");
            String sg1=cc.substring(ind1);
            
            int ind2=sg1.indexOf("bottom-of-box");
        //    int ind2=sg1.indexOf("bottom-left");
            
            String sg2=sg1.substring(0, ind2);
            
            String mt="<a href=\"(.+?)\">(.+?)</a>";
            Pattern p=Pattern.compile(mt);
            Matcher m=p.matcher(sg2);
            
            
            int ii=0;
            while(m.find())
            {
               ii++;
                int start=m.start();
                System.out.println("Heba output 5 " +start);
                int end=m.end();
                System.out.println("Heba output 6 " +end);
                String sf=sg2.substring(start,end);
                String as[]=sf.split("\"");
                String as2="http://www.testfreaks.co.in"+as[1];
                System.out.println("Heba output 7 " +as2);
                if(!al.contains(as2))
                {                    
                    al.add(as2);
                    System.out.println("heba output 4 " +al);
                }
                
            }

            System.out.println("vvv"+al);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return al;
    }

    public String extract(String s1)
    {
       // String xml="";
        String res="";
        try
        {            
            String rev="";
            String mt="<a href=\"(.+?)\">(.+?)</a>";
            Pattern p=Pattern.compile(mt);
            Matcher m=p.matcher(s1);
            ArrayList al=new ArrayList();
            int ii=0;
            while(m.find())
            {
                ii++;
                int start=m.start();
                int end=m.end();
                String sf=s1.substring(start,end);
              System.out.println(ii+"ssssssss"+sf);
                //if(i==2||i==4)
                if(ii==4)
                {
                    rev=sf;
                 //   System.out.println("vnbnb"+sf);
                    al.add(sf);
                }
            }
            //System.out.println(al);

            String rr[]=rev.split("\"");
             System.out.println("Heba Output 11 " +rr[1]); 
            String url1="http://www.testfreaks.co.in"+rr[1];
            System.out.println("Heba Output 10 " +url1);           
            ArrayList pgList=new ArrayList();

             pgList.add(url1);
             URL ul1=new URL(url1);
            Source sd1=new Source(ul1);
            String cc1=sd1.toString();
            int in1=cc1.indexOf("Next page");
            String sg1=cc1.substring(in1);
            
            int in2=sg1.indexOf("bottom-of-box");
            String sg2=sg1.substring(0, in2);

            String mt1="<a href=\"(.+?)\">(.+?)</a>";
            Pattern p1=Pattern.compile(mt1);
            Matcher m1=p1.matcher(sg2);
            while(m1.find())
            {

                int start1=m1.start();
                int end1=m1.end();
                String sf=sg2.substring(start1,end1);
                String as[]=sf.split("\"");
                String as2="http://www.testfreaks.co.in"+as[1];
                if(!pgList.contains(as2))
                {
                    pgList.add(as2);
                }
            }
            System.out.println("---"+pgList);
            int sz=pgList.size();
            if(sz>5)
                sz=5;            
           // String rr[]=rev.split("\"");
            //String url="http://www.testfreaks.co.in"+rr[1];
            //System.out.println("----  " +url);
            for(int k=0;k<sz;k++)
            //for(int k=0;k<pgList.size();k++)
            {
            //    xml=xml+"<Product>\n";
                String f1=pgList.get(k).toString();

                URL ul=new URL(f1);
                Source sd=new Source(ul);
                String cc=sd.toString();
               // System.out.println("Heba OUTPUT 13 " +cc);
                String cf[]=cc.split("<div class=\"review-box\">");
                System.out.println("cf -- "+cf);
                System.out.println("cf -- "+cf.length);
                for(int i=1;i<cf.length;i++)
                {
                    int ind1=cf[i].indexOf("<h3>");
                    int ind2=cf[i].indexOf("</h3>");
                    System.out.println("Heba outout 17 : " +ind2 );
                    String title=cf[i].substring(ind1+4, ind2).trim();
                    //System.out.println("Title "+title);

                   // xml=xml+"\t<Title>"+title+"</Title>\n";

                   // int ind3=cf[i].indexOf("Read full review");
                    int ind3=cf[i].indexOf("clearfix");
                    System.out.println("Heba Output 14 : "  +ind3);
                   // String sub1=cf[i].substring(ind2+5, ind3);
                    String sub1=cf[i].substring(ind2, ind3);
                    System.out.println("Heba output 16 :" +sub1);
                    System.out.println("Heba output 18 :" +sub1.contains("Summary"));
                            
                    String sum1="";
                    if(sub1.contains("Summary")|| sub1.contains("Excerpt"))
                    {
                        int ind4=sub1.indexOf("</strong>");
                        int ind5=sub1.indexOf("</li>");
                        sum1=sub1.substring(ind4+9, ind5);
                        System.out.println("Heba Output 15:" +sum1);
                    
                    }
                   // xml=xml+"\t<Summary>"+sum1+"</Summary>\n";
                    if(!(sum1.equals("")))
                        res=res+sum1+"@";
                    System.out.println("Heba output 12 "+res);
                    // xml=xml+"</Product>\n";
                    
                }
               
            }

 System.out.println("--------");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            //xml=xml+"</Product>\n";
            
        }
        System.out.println("Heba Output 9 :" +res);
//return xml;
        return res;
    }

}
