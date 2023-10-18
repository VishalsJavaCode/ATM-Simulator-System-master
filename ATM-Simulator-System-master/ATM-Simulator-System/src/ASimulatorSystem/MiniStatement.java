package ASimulatorSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {

    JLabel mini, bank, card, balance ;

    MiniStatement(String pinnumber){
        setTitle("Mini Statement");
        setLayout(null);

        mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);

        bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number:" + rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }

        try {
            int bal = 0;
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("tdate")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your Current Account Balance is Rs "+bal);
        }catch (Exception e){
            System.out.println(e);
        }



        setSize(400,600);
        setLocation(570,150);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    public static void main(String args[]){
        new MiniStatement("").setVisible(true);
    }


}
