/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj_clientes;

import java.sql.*;
import java.time.Clock;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoBDA {
    
    private Connection conx=null;
    
    
    ConexaoBDA()
    {
        try{
            //instalar o driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //conexao  criada
            conx = DriverManager.getConnection("jdbc:mysql://localhost/cadastro", "root", "123456");
            
          //  getLista(1);
                    
        }catch(Exception e)
        {
            System.out.println("erro:"+e);
        }
    }
    
    private Statement st=null;
    private ResultSet resultado=null;
    
    public List<String> getLista()
    {
        List<String> lista= new Vector<String>();
        try{
            st =conx.createStatement();
             resultado= 
                    st.executeQuery("Select * from clientes");
            
            while(resultado.next())
            {
                lista.add(
               resultado.getInt(1) + " - "+
               resultado.getString(2));
                
            }
            
            resultado.beforeFirst();
        }catch(Exception e)
        {
            System.out.print("erro e"+e);
        }
        return lista;
    }
    
    public void getLista(int i){
        try{
            Statement st=conx.createStatement();
            ResultSet resultado =
                    st.executeQuery("Select * from clientes");
            
        }catch(Exception e){
            System.out.println("Erro");
        }
    }
    
    public String[] getPrimeiro()
    {
        try{
            resultado.first();
            String aux[]=new String[2];
            //codigo
            aux[0]=resultado.getInt(1)+"";
            //nome
            aux[1]=resultado.getString(2);
            
            return aux;
            
        }catch(Exception e){
            System.out.println("erro");
        }
        return null;
    }
    
        public String[] getSegundo()
    {
        try{
            resultado.next();
            String aux[]=new String[2];
            //codigo
            aux[0]=resultado.getInt(1)+"";
            //nome
            aux[1]=resultado.getString(2);
            
            return aux;
            
        }catch(Exception e){
            System.out.println("erro");
        }
        return null;
    }
        
            public String[] getTerceiro()
    {
        try{
            resultado.previous();
            String aux[]=new String[2];
            //codigo
            aux[0]=resultado.getInt(1)+"";
            //nome
            aux[1]=resultado.getString(2);
            
            return aux;
            
        }catch(Exception e){
            System.out.println("erro");
        }
        return null;
    }
            
                public String[] getQuarto()
    {
        try{
            resultado.last();
            String aux[]=new String[2];
            //codigo
            aux[0]=resultado.getInt(1)+"";
            //nome
            aux[1]=resultado.getString(2);
            
            return aux;
            
        }catch(Exception e){
            System.out.println("erro");
        }
        return null;
    }
    
                public boolean add(String aux[])
                {
                       try { 
                   String sql="insert into clientes values" +"("+ aux[0]+",'"+ aux[1]+"')";
     
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBDA.class.getName()).log(Level.SEVERE, null, ex);
        }
                  
                   return false;
                    
                }
                
                              public boolean remove(String aux[])
                {
                       try { 
                   String sql="Delete from clientes where "+ " codigo="+ aux[0];
     
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBDA.class.getName()).log(Level.SEVERE, null, ex);
        }
                  
                   return false;
                    
                }
                              
                                public boolean update(String aux[])
                {
                       try { 
                   String sql="Update clientes SET " +"nome = '" + aux[1] + "'"+
                      "where codigo ="+ aux[0];
     
            st.execute(sql);
            return true;
        } catch (Exception e) {
            System.out.println("erro" + e);
        }
                  
                   return false;
                    
                }
    
}
