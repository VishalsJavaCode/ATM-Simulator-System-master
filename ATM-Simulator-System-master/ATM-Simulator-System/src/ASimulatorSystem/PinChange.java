package ASimulatorSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{

    JLabel text, pintext, repintext ;
    JPasswordField pin, repin ;
    JButton change, back ;
    String pinnumber;

    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250,280,500,35);
        image.add(text);
        //add(text);

        pintext = new JLabel("New Pin");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(165,320,180,25);
        image.add(pintext);
        //add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330,320,180,25);
        image.add(pin);
       // add(pin);

        repintext = new JLabel("Re-Enter New Pin");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(165,360,180,25);
        image.add(repintext);
        //dd(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(330,360,180,25);
        image.add(repin);
        //add(repin);

        change = new JButton("CHANGE");
        change.setBounds(355,460,150,30);
        change.addActionListener(this);
        image.add(change);
        //add(change);

        back = new JButton("BACK");
        back.setBounds(355,490,150,30);
        back.addActionListener(this);
        image.add(back);
        //add(back);


        setSize(900,900);
        setLocation(350,10);
        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == change)
            try{
                String npin = pin.getText();
                String rpin = repin.getText();

                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }
                if (rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }
                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN changed Successfully");

                setVisible(false);
                new Transactions(rpin).setVisible(true);

            }catch (Exception e){
                System.out.println(e);
            }
             if (ae.getSource() == back){
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
    }
    public static void main(String args[]){
        new PinChange("").setVisible(true);
    }
}
