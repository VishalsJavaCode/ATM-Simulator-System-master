package ASimulatorSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{

    JTextField amount;
    JButton withdrawl, back;
    String pinnumber;

    Withdrawl(String pinnumber){

        this.pinnumber = pinnumber;
        setLayout(null);

       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
       Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to withdrawl");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD, 16));
        text.setBounds(170,300,400,20);
        image.add(text);
        //add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170,350,320,25);
        image.add(amount);
        //add(amount);

        withdrawl = new JButton("Withdraw");
        withdrawl.setBounds(355,460,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        //add(withdrawl);

        back = new JButton("Back");
        back.setBounds(355,490,150,30);
        back.addActionListener(this);
        image.add(back);
        //add(back);

        setSize(900,900);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == withdrawl){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdrawl");
            }else{
                try{
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+ number +" Withdrawl Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }else if (ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String args[])
    {

        new Withdrawl("").setVisible(true);

    }

}
