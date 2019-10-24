/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src.featureextraction;

import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.trees.GrammaticalStructure;
import edu.stanford.nlp.trees.GrammaticalStructureFactory;
import edu.stanford.nlp.trees.PennTreebankLanguagePack;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreebankLanguagePack;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author seabirds
 */
public class TagFrame extends javax.swing.JFrame {

    
    Connection con;
    /**
     * Creates new form TagFrame
     */
    ResultSet rs=null;
PreparedStatement pst = null;
    ArrayList stopList=new ArrayList();
    ArrayList review=new ArrayList();
    ArrayList ft1=new ArrayList();
    //MainFrame mf;
     String pro="" , pro1="";
     
     
    public TagFrame(ArrayList at) 
    {
        review=at;
        initComponents();
       // classify();
                
    }

     public ArrayList<String> positive()
    {
        ArrayList<String> st=new ArrayList<String>();
        try
        {
            
            Scanner scan1 = null;
            scan1 = new Scanner(new BufferedReader(new FileReader("positive.txt")));
            while (scan1.hasNext()){
                st.add(scan1.next()); 
            for(int i=0; i<st.size(); i++){
                if(st.get(i).equals("")){
                    st.remove(i);
                   
                }
            }
            }
        //    System.out.println(st);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return st;
    }
     
     public void classify(){
        ArrayList positive1 = new ArrayList();
             ArrayList negative1 = new ArrayList();
             ArrayList positive = positive();
             ArrayList negative = negative();
             //System.out.println(positive);
//             int pos=0;
//              int neg=0;
            
             for(int i=0;i<review.size();i++)
             {  
                 String s1=review.get(i).toString().toLowerCase();
                // String s3 = informaltxt1.get(i).toString();              
                 String ss=s1.replace("#","-->");
                 String s2[]=s1.split("#");
                 String sg=s2[1];
               //  System.out.println("b1"+sg);
                  String tt[]=sg.toLowerCase().split(" ");
                    System.out.println(" "+tt.length);
                    int pos=0;
              int neg=0;
               
                    for(int j=0; j< tt.length; j++)
                    {
                        //  System.out.println(tt[j]);
                          
                        if(positive.contains(tt[j].toString().toLowerCase())){
                        pos++;
                      //  positive1.add(tt[j]);
                    }
                        if(negative.contains(tt[j].toString().toLowerCase())){
                        neg++;
                      //  negative1.add(tt[j]);
                    }
                        //System.out.println(i+" :  "+pos+" : "+neg);
                    }
                 //   System.out.println(i+" :  "+pos+" : "+neg);
                    
                    if(pos > neg)
                    {
                        positive1.add(sg+"\n\n");               
                    }
                    else if(pos < neg){
                       negative1.add(sg+"\n\n");                   
                    }
//                    double dino = pos + positive1.size();
//                    double dino1 = pos + negative.size();
                    System.out.println(i+" :  "+positive1+" : "+negative1);                    

            }
             
              Output oo = new Output();
                    oo.setVisible(true);
                    oo.jTextPane1.setText(positive1.toString());
                    oo.jTextPane2.setText(negative1.toString());
             
//             System.out.println(precision+" : "+recall);
//             for(int i =0; i<positive1.size(); i++){
//                 String sql = "insert into"
//             }
            
    }

    public ArrayList<String> negative()
    {
        ArrayList<String> st=new ArrayList<String>();
        try
        {

            Scanner scan1 = null;

            scan1 = new Scanner(new BufferedReader(new FileReader("negative.txt")));
            while (scan1.hasNext())
                st.add(scan1.next());
            for(int i=0; i<st.size(); i++){
                if(st.get(i).equals("")){
                    st.remove(i);
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return st;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        jLabel1.setText("Tagged Sentence");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setFont(new java.awt.Font("Californian FB", 0, 18)); // NOI18N
        jButton1.setText("Extract Feature");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(jLabel1)
                .addContainerGap(245, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(245, 245, 245))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
try
        {
            classify();
            
            
            stopList=readStopWord();
         //   removeStop(review.toString());
            
            LexicalizedParser lp=LexicalizedParser.loadModel("edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz");
            //LexicalizedParser lp=LexicalizedParser.loadModel(".\\models\\englishPCFG.ser.gz");
            TreebankLanguagePack tlp = new PennTreebankLanguagePack();
            GrammaticalStructureFactory gsf = tlp.grammaticalStructureFactory();

            int k=0;
            for (List sentence : new DocumentPreprocessor("sen.txt")) 
            {
              // System.out.println("sen size "+sentence.size());
                Tree parse = lp.apply(sentence);
                //System.out.println("tag -- "+parse.taggedYield());
                String tt=parse.taggedYield().toString();
                String sg1[]=tt.split(",");
               try
                {
                    String sg2[]=review.get(k).toString().split("#");
                    pro=sg2[0];
                }
                catch(Exception e)
                {
                    continue;
                }               
                
                System.out.println("Product "+pro+" : "+sg1.length);
                for(int j=0;j<sg1.length-1;j++)
                {
                    String t1=sg1[j].trim();
                    String t2=sg1[j+1].trim();
                    System.out.println(t1+" : "+t2);
                    String m1=t1;
                    String m2=t2;
                    if(t1.contains("/"))
                       m1=t1.substring(0, t1.indexOf("/"));
                    if(t2.contains("/"))
                         m2=t2.substring(0, t2.indexOf("/"));
                     
                     if(m1.equals("")||m2.equals(""))
                        continue;
                     else if(t1.endsWith("/NN") && t2.endsWith("/JJ") )
                    {
                        String tag1=t1.substring(0, t1.indexOf("/"));
                        String tag2=t2.substring(0, t2.indexOf("/"));
                           ft1.add(pro+"#"+tag1+"#"+tag2);
                            update(pro,tag1,tag2);
                    }
//                     else if(t1.endsWith("/VB") && t2.endsWith("/NN") )
//                    {
//                        String tag1=t1.substring(0, t1.indexOf("/"));
//                        String tag2=t2.substring(0, t2.indexOf("/"));
//                           ft1.add(pro+"#"+tag2+"#"+tag1);
//                    }
                      else if(t1.endsWith("/JJ") && t2.endsWith("/NN") )
                    {
                        String tag1=t1.substring(0, t1.indexOf("/"));
                        String tag2=t2.substring(0, t2.indexOf("/"));
                           ft1.add(pro+"#"+tag2+"#"+tag1);
                           update(pro,tag2,tag1);
                    }
                     
                }
                k++;
            }
             System.out.println(ft1.size());
            System.out.println("ft1  "+ft1);
            
            FeatureFrame ff=new FeatureFrame();
            ff.setVisible(true);
            ff.setResizable(false);
            ff.setTitle("Feature List");
            
            DefaultTableModel dm=(DefaultTableModel)ff.jTable1.getModel();
            for(int i=0;i<ft1.size();i++)
            {
                String g1[]=ft1.get(i).toString().split("#");
                Vector v=new Vector();
                v.add(i+1);
                v.add(g1[0]);
                v.add(g1[1]);
                v.add(g1[2]);
                dm.addRow(v);
            }
            
            }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        DBConnection c = new DBConnection();
        con = c.DBConnection();
    }//GEN-LAST:event_formWindowOpened

    public void update(String p,String f, String o){
        String sql = "insert into output values('"+p+"','"+f+"','"+o+"')";
        try{            
           pst= con.prepareStatement(sql);
           pst.execute();
          // JOptionPane.showMessageDialog(null, " New Expense Added");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList readStopWord()
    {
        ArrayList<String> stp=new ArrayList<String>();
        Scanner scan1 = null;
        
        try
        {
            scan1 = new Scanner(new BufferedReader(new FileReader("stopwords.txt")));
            while (scan1.hasNext())
                stp.add(scan1.next());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return stp;
    }
    
    public String removeStop(String sr)
    {
        String re="";
        try
        {
//            ArrayList<String> stp=new ArrayList<String>();
//            Scanner scan1 = null;        
//            scan1 = new Scanner(new BufferedReader(new FileReader("sen.txt")));
//            while (scan1.hasNext())
//            {
//                stp.add(scan1.next());
//            }
//            String[] abc = stp.toString().split(".");
//            
//            String []rr = abc.toString().split(" ");
//            System.out.println("Size: "+rr.length);
            sr = sr.replaceAll("[^a-zA-Z 0-9]+","");
            sr=sr.replaceAll("[0-9]+","");
       //     System.out.println("SR: "+sr);
            String f[]=sr.split(" ");
            for(int i=0;i<f.length;i++)
            {
                if(!(stopList.contains(f[i].trim())))
                {
                    re=re+" "+f[i].trim();
                }
            }
            String s[]=review.get(0).toString().split("#");
            pro1=s[0];
            System.out.println("cvcv"+pro1);
            re = re.replaceAll(pro1,"\n");
//            String[] abc = re.split(pro);
//            for(int i=0; i<abc.length; i++){
//                 ww += abc[i];
//             }
            File fe=new File("final.txt");
            FileOutputStream fos=new FileOutputStream(fe);
         //   for(int i=0; i<abc.length; i++){
            fos.write(re.trim().getBytes());
        //    }
            
            fos.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
      //  System.out.println("RE: "+re);
         
        return re;
        
       
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TagFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TagFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TagFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TagFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               //new TagFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
