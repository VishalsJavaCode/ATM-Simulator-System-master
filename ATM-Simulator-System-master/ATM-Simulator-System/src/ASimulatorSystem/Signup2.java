package ASimulatorSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JComboBox;

import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener{

    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, occupation, education, income;

    String formno;

    Signup2(String formno){
        this.formno = formno;

        setLayout(null);

       setTitle("NEW APPLICATION ACCOUNT FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290,150,400,30);
        add(additionalDetails);

        JLabel rel = new JLabel("Religion:");
        rel.setFont(new Font("Raleway", Font.BOLD, 20));
        rel.setBounds(100,200,150,30);
        add(rel);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,200,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel cat = new JLabel("Category:");
        cat.setFont(new Font("Raleway", Font.BOLD, 20));
        cat.setBounds(100,250,150,30);
        add(cat);

        String valCategory[] = {"General", "OBC", "SC","ST","Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300,250,400,30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel inc = new JLabel("Income:");
        inc.setFont(new Font("Raleway", Font.BOLD, 20));
        inc.setBounds(100,300,200,30);
        add(inc);

        String incomeCategory[] = {"Null", "< 1,50,000", "< 2,50,000","< 5,00,000","Upto 10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300,300,400,30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel educational = new JLabel("Educational");
        educational.setFont(new Font("Raleway", Font.BOLD, 20));
        educational.setBounds(100,350,150,30);
        add(educational);

        JLabel qulification = new JLabel("Qualification:");
        qulification.setFont(new Font("Raleway", Font.BOLD, 20));
        qulification.setBounds(100,375,200,30);
        add(qulification);

        String educationValue[] = {"Non-Graduate", "Graduate", "Post-Graduaate","Doctrate","Others"};
        education = new JComboBox(educationValue);
        education.setBounds(300,365,400,30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel occup = new JLabel("Occupation:");
        occup.setFont(new Font("Raleway", Font.BOLD, 20));
        occup.setBounds(100,430,200,30);
        add(occup);

        String occupationValue[] = {"salaried", "Self-Employed", "Business","Student","Retired","Other"};
        occupation = new JComboBox(occupationValue);
        occupation.setBounds(300,430,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel pan_no = new JLabel("PAN Number:");
        pan_no.setFont(new Font("Raleway", Font.BOLD, 20));
        pan_no.setBounds(100,480,150,30);
        add(pan_no);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300,480,400,30);
        add(pan);

        JLabel aadhar_no = new JLabel("Aadhar Number:");
        aadhar_no.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar_no.setBounds(100,530,200,30);
        add(aadhar_no);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300,530,400,30);
        add(aadhar);

        JLabel sc = new JLabel("Senior Citizen:");
        sc.setFont(new Font("Raleway", Font.BOLD, 20));
        sc.setBounds(100,580,200,30);
        add(sc);

        syes = new JRadioButton("Yes");
        syes.setBounds(300,580,60,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450,580,80,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup citizenGroup = new ButtonGroup();
        citizenGroup.add(syes);
        citizenGroup.add(sno);

        JLabel exist_acco = new JLabel("Existing Account:");
        exist_acco.setFont(new Font("Raleway", Font.BOLD, 20));
        exist_acco.setBounds(100,630,200,30);
        add(exist_acco);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,630,60,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450,630,80,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup exist = new ButtonGroup();
        exist.add(eyes);
        exist.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(450,700,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = null;

        if(syes.isSelected()){
            seniorcitizen = "Yes";
        }else if (sno.isSelected()){
            seniorcitizen ="No";
        }


        String existingaccount = null;
        if(eyes.isSelected()){
            existingaccount = "Yes";
        }else if (eno.isSelected()){
            existingaccount ="No";
        }

        String span = pan.getText();
        String saadhar = aadhar.getText();

        try{

                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+seniorcitizen+"', '"+existingaccount+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new Signup2(formno).setVisible(true);

                //Signup3 object
                setVisible(false);
                new Signup3(formno).setVisible(true);

            } catch(Exception e){
            System.out.println(e);
        }
    }


    public static void main(String args[]){

        new Signup2("");
    }
}