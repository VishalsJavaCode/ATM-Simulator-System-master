package ASimulatorSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JButton login, signup, clear;

    JTextField cardTextField;
    JPasswordField pinTextField;

    Login(){
        setLayout(null);
        
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/logo.jpg"));
            Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(70, 10, 100, 100);
           add(image);
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
        setTitle("AUTOMATED TELLER MACHINE");

        JLabel text = new JLabel("Welcom To ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardno = new JLabel("Card NO:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120,150,150,30);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,250,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120,220,250,30);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,250,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton ("Sign Up");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        }else if (ae.getSource() == login) {
            Conn conn=new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card number or Pin");
                }
            }catch (Exception e){
                System.out.println(e);
            }

        }else if (ae.getSource() == signup) {

            setVisible(false);
            new Signup().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();

    }
}
