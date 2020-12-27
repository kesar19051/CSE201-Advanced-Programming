import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.text.DefaultEditorKit;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Test_Swing {

    static ArrayList<Patient> towerA;
    static ArrayList<Patient> towerB;
    static ArrayList<Patient> towerC;
    static ArrayList<Patient> towerD;

    public static void main(String[] args){

        SwingTest obj = new SwingTest();
        towerA = new ArrayList<Patient>();
        towerB = new ArrayList<Patient>();
        towerC = new ArrayList<Patient>();
        towerD = new ArrayList<Patient>();
        Patient p1 = new Patient("Flora", 6, "01/04", "22/04");
        towerA.add(p1);
        Patient p2 = new Patient("Denys", 24, "01/04","22/04");
        towerB.add(p2);
        Patient p3 = new Patient("Jim", 42, "18/05", "08/06");
        towerC.add(p3);
        Patient p4 = new Patient("Hazel", 87, "23/06","14/07");
        towerD.add(p4);
        Patient p5 = new Patient("Caery", 72, "01/06","22/06");
        towerA.add(p5);
        Patient p6 = new Patient("David", 7, "14/06", "05/07");
        towerB.add(p6);
        Patient p7 = new Patient("Kevim", 37, "05/06","26/06");
        towerD.add(p7);
        Patient p8 = new Patient("Tom", 67, "20/06","11/07");
        towerD.add(p8);
        Patient p9 = new Patient("Bob", 74, "04/07","25/07");
        towerA.add(p9);
        Patient p10 = new Patient("Rachel", 48, "24/07","14/08");
        towerC.add(p10);
        Patient p11 = new Patient("Thomas",21,"11/06","02/07");
        towerC.add(p11);
        Patient p12 = new Patient("Mary", 17,"21/06","12/07");
        towerD.add(p12);
        Patient p13 = new Patient("Smith", 89,"07/08","28/08");
        towerA.add(p13);
        Patient p14 = new Patient("Pearson",47,"04/06","25/06");
        towerB.add(p14);
        Patient p15 = new Patient("Anderson",62,"27/07","17/08");
        towerB.add(p15);
        Patient p16 = new Patient("Johnson",10,"01/08","22/08");
        towerD.add(p16);
        Patient p17 = new Patient("Robertz",50,"09/08","30/08");
        towerA.add(p17);
        Patient p18 = new Patient("Julie",86,"02/05","23/05");
        towerB.add(p18);
        Patient p19 = new Patient("Edith",42,"07/06","28/06");
        towerD.add(p19);
        Patient p20 = new Patient("John",95, "01/06","22/06");
        towerD.add(p20);
    }

    static class Patient{
        String name;
        int age;
        String date;
        String recDate;

        Patient(String name, int age, String date, String recDate){
            this.name = name;
            this.age = age;
            this.date = date;
            this.recDate = recDate;
        }
    }

    static class SwingTest extends JFrame{
        JPanel panel1;
        JPanel panel2;
        JPanel panel3;
        JPanel panel4;
        JPanel panel5;
        JPanel panel6;
        JPanel panel7;
        JPanel panel8;
        JPanel panel9;
//        JPanel panel10;

        JLabel tower;

        JCheckBox a;
        JCheckBox b;
        JCheckBox c;
        JCheckBox d;

        JLabel date;
        JTextField dateInput;
        JLabel month;
        JTextField monthInput;
        JLabel year;
        JTextField yearInput;

        JButton showResult;

        JLabel numActiveCasesA;
        JTextField casesA;
        JLabel numActiveCasesB;
        JTextField casesB;
        JLabel numActiveCasesC;
        JTextField casesC;
        JLabel numActiveCasesD;
        JTextField casesD;

        JLabel numRecoveredCasesA;
        JTextField casesrA;
        JLabel numRecoveredCasesB;
        JTextField casesrB;
        JLabel numRecoveredCasesC;
        JTextField casesrC;
        JLabel numRecoveredCasesD;
        JTextField casesrD;

        JLabel A;
        DefaultListModel<String> lA1;
        JList<String> listA1;
        DefaultListModel<String> lA2;
        JList<String> listA2;
        DefaultListModel<String> lA3;
        JList<String> listA3;
        DefaultListModel<String> lA4;
        JList<String> listA4;
        DefaultListModel<String> lA5;
        JList<String> listA5;

        JLabel B;
        DefaultListModel<String> lB1;
        JList<String> listB1;
        DefaultListModel<String> lB2;
        JList<String> listB2;
        DefaultListModel<String> lB3;
        JList<String> listB3;
        DefaultListModel<String> lB4;
        JList<String> listB4;
        DefaultListModel<String> lB5;
        JList<String> listB5;

        JLabel C;
        DefaultListModel<String> lC1;
        JList<String> listC1;
        DefaultListModel<String> lC2;
        JList<String> listC2;
        DefaultListModel<String> lC3;
        JList<String> listC3;
        DefaultListModel<String> lC4;
        JList<String> listC4;
        DefaultListModel<String> lC5;
        JList<String> listC5;

        JLabel D;
        DefaultListModel<String> lD1;
        JList<String> listD1;
        DefaultListModel<String> lD2;
        JList<String> listD2;
        DefaultListModel<String> lD3;
        JList<String> listD3;
        DefaultListModel<String> lD4;
        JList<String> listD4;
        DefaultListModel<String> lD5;
        JList<String> listD5;


        JOptionPane invalidDate;


        public SwingTest(){

            lA1 = new DefaultListModel<>();
            listA1 = new JList<>(lA1);
            lA2 = new DefaultListModel<>();
            listA2 = new JList<>(lA2);
            lA3 = new DefaultListModel<>();
            listA3 = new JList<>(lA3);
            lA4 = new DefaultListModel<>();
            listA4 = new JList<>(lA4);
            lA5 = new DefaultListModel<>();
            listA5 = new JList<>(lA5);
            lB1 = new DefaultListModel<>();
            listB1 = new JList<>(lB1);
            lB2 = new DefaultListModel<>();
            listB2 = new JList<>(lB2);
            lB3 = new DefaultListModel<>();
            listB3 = new JList<>(lB3);
            lB4 = new DefaultListModel<>();
            listB4 = new JList<>(lB4);
            lB5 = new DefaultListModel<>();
            listB5 = new JList<>(lB5);
            lC1 = new DefaultListModel<>();
            listC1 = new JList<>(lC1);
            lC2 = new DefaultListModel<>();
            listC2 = new JList<>(lC2);
            lC3 = new DefaultListModel<>();
            listC3 = new JList<>(lC3);
            lC4 = new DefaultListModel<>();
            listC4 = new JList<>(lC4);
            lC5 = new DefaultListModel<>();
            listC5 = new JList<>(lC5);
            lD1 = new DefaultListModel<>();
            listD1 = new JList<>(lD1);
            lD2 = new DefaultListModel<>();
            listD2 = new JList<>(lD2);
            lD3 = new DefaultListModel<>();
            listD3 = new JList<>(lD3);
            lD4 = new DefaultListModel<>();
            listD4 = new JList<>(lD4);
            lD5 = new DefaultListModel<>();
            listD5 = new JList<>(lD5);

            panel1 = new JPanel();
            panel2 = new JPanel();
            panel3 = new JPanel();
            panel4 = new JPanel();
            panel5 = new JPanel();
            panel6 = new JPanel();
            panel7 = new JPanel();
            panel8 = new JPanel();
            panel9 = new JPanel();
//            panel10 = new JPanel();

            tower = new JLabel("Select the tower(s)");
            date = new JLabel("Date(DD)");
            month = new JLabel("Month(MM)");
            year = new JLabel("Year(YYYY)");
            a = new JCheckBox("A");
            b = new JCheckBox("B");
            c = new JCheckBox("C");
            d = new JCheckBox("D");
            dateInput = new JTextField(5);
            monthInput = new JTextField(5);
            yearInput = new JTextField(10);
            showResult = new JButton("Show result!");
            A = new JLabel("Tower A");
            B = new JLabel("Tower B");
            C = new JLabel("Tower C");
            D = new JLabel("Tower D");

            numActiveCasesA = new JLabel("Number of active cases in tower A");
            casesA = new JTextField(5);
            numActiveCasesB = new JLabel("Number of active cases in tower B");
            casesB = new JTextField(5);
            numActiveCasesC = new JLabel("Number of active cases in tower C");
            casesC = new JTextField(5);
            numActiveCasesD = new JLabel("Number of active cases in tower D");
            casesD = new JTextField(5);
            numRecoveredCasesA = new JLabel("Number of recovered cases in tower A");
            casesrA = new JTextField(5);
            numRecoveredCasesB = new JLabel("Number of recovered cases in tower B");
            casesrB = new JTextField(5);
            numRecoveredCasesC = new JLabel("Number of recovered cases in tower C");
            casesrC = new JTextField(5);
            numRecoveredCasesD = new JLabel("Number of recovered cases in tower D");
            casesrD = new JTextField(5);

            invalidDate = new JOptionPane();


            panel1.add(tower);
            panel1.add(a);
            panel1.add(b);
            panel1.add(c);
            panel1.add(d);
            add(panel1);

            panel2.add(date);
            panel2.add(dateInput);
            panel2.add(month);
            panel2.add(monthInput);
            panel2.add(year);
            panel2.add(yearInput);
            add(panel2);

            panel3.add(showResult);
            add(panel3);

            panel4.add(numActiveCasesA);
            panel4.add(casesA);
            panel4.add(numActiveCasesB);
            panel4.add(casesB);
            panel4.add(numActiveCasesC);
            panel4.add(casesC);
            panel4.add(numActiveCasesD);
            panel4.add(casesD);
            add(panel4);

            panel5.add(numRecoveredCasesA);
            panel5.add(casesrA);
            panel5.add(numRecoveredCasesB);
            panel5.add(casesrB);
            panel5.add(numRecoveredCasesC);
            panel5.add(casesrC);
            panel5.add(numRecoveredCasesD);
            panel5.add(casesrD);
            add(panel5);

            panel6.add(A);
            panel6.add(listA1);
            panel6.add(listA2);
            panel6.add(listA3);
            panel6.add(listA4);
            panel6.add(listA5);

            panel7.add(B);
            panel7.add(listB1);
            panel7.add(listB2);
            panel7.add(listB3);
            panel7.add(listB4);
            panel7.add(listB5);

            panel8.add(C);
            panel8.add(listC1);
            panel8.add(listC2);
            panel8.add(listC3);
            panel8.add(listC4);
            panel8.add(listC5);

            panel9.add(D);
            panel9.add(listD1);
            panel9.add(listD2);
            panel9.add(listD3);
            panel9.add(listD4);
            panel9.add(listD5);

            add(invalidDate);
            invalidDate.setMessage("");

            showResult.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    invalidDate.setMessage("");
                    int dot = Integer.parseInt(dateInput.getText().replaceAll("\\s", ""));
                    int month = Integer.parseInt(monthInput.getText().replaceAll("\\s", ""));
                    int yoear = Integer.parseInt(yearInput.getText().replaceAll("\\s", ""));

                    if ((((month == 4 || month == 6) && (1 <= dot && dot <= 30)) ||
                            ((month == 5 || month == 7 || month == 8) && (1 <= dot && dot <= 31))) && yoear == 2020){

                        if (a.isSelected()) {
                            lA1.clear();
                            lA2.clear();
                            lA3.clear();
                            lA4.clear();
                            lA5.clear();
                            lA1.addElement("Name");
                            lA2.addElement("Age");
                            lA3.addElement("Reported On");
                            lA4.addElement("Recovered on");
                            lA5.addElement("Recovered/Active");
                            ArrayList<Patient> activeCases = new ArrayList<Patient>();
                            ArrayList<Patient> recoveredCases = new ArrayList<Patient>();
                            int dt = Integer.parseInt(dateInput.getText().replaceAll("\\s", ""));
                            int mnth = Integer.parseInt(monthInput.getText().replaceAll("\\s", ""));
                            int numActiveCases = 0;
                            int numRecoveredCases = 0;
                            for (int i = 0; i < towerA.size(); i++) {
                                Patient p = towerA.get(i);
                                int sickdt = Integer.parseInt(p.date.substring(0, 2).replaceAll("\\s", ""));
                                int sickmnth = Integer.parseInt(p.date.substring(3).replaceAll("\\s", ""));
                                int recdt = Integer.parseInt(p.recDate.substring(0, 2).replaceAll("\\s", ""));
                                int recmnth = Integer.parseInt(p.recDate.substring(3).replaceAll("\\s", ""));
                                if (mnth > recmnth) {
                                    numRecoveredCases += 1;
                                    recoveredCases.add(p);
                                }
                                else if (mnth == recmnth) {
                                    if (recdt <= dt) {
                                        numRecoveredCases += 1;
                                        recoveredCases.add(p);
                                    } else if (recdt > dt ) {
                                        if(sickmnth==mnth){
                                            if(dt>=sickdt){
                                                numActiveCases+=1;
                                                activeCases.add(p);
                                            }
                                        }
                                        else if(sickmnth<mnth){
                                            numActiveCases+=1;
                                            activeCases.add(p);
                                        }

                                    }
                                }
                                else {
                                    if (mnth == sickmnth) {
                                        if (sickdt <= dt) {
                                            numActiveCases += 1;
                                            activeCases.add(p);
                                        }
                                    }
                                }
                            }
                            casesA.setText(numActiveCases + "");
                            casesrA.setText(numRecoveredCases + "");
                            add(panel6);
                            A.setVisible(true);
                            for (int i = 0; i < activeCases.size(); i++) {
                                Patient patient = activeCases.get(i);
                                lA1.addElement(patient.name + "");
                                lA2.addElement(patient.age + "");
                                lA3.addElement(patient.date + "/2020");
                                lA4.addElement("N/A");
                                lA5.addElement("Active");
                            }
                            for (int i = 0; i < recoveredCases.size(); i++) {
                                Patient patient = recoveredCases.get(i);
                                lA1.addElement(patient.name + "");
                                lA2.addElement(patient.age + "");
                                lA3.addElement(patient.date + "/2020");
                                lA4.addElement(patient.recDate + "/2020");
                                lA5.addElement("Recovered");
                            }
                        }
                        else{
                            lA1.clear();
                            lA2.clear();
                            lA3.clear();
                            lA4.clear();
                            lA5.clear();
                            A.setVisible(false);
                            casesA.setText("");
                            casesrA.setText("");
                        }

                    if (b.isSelected()) {
                        lB1.clear();
                        lB2.clear();
                        lB3.clear();
                        lB4.clear();
                        lB5.clear();
                        lB1.addElement("Name");
                        lB2.addElement("Age");
                        lB3.addElement("Reported On");
                        lB4.addElement("Recovered on");
                        lB5.addElement("Recovered/Active");
                        ArrayList<Patient> activeCases = new ArrayList<Patient>();
                        ArrayList<Patient> recoveredCases = new ArrayList<Patient>();
                        int dt = Integer.parseInt(dateInput.getText().replaceAll("\\s", ""));
                        int mnth = Integer.parseInt(monthInput.getText().replaceAll("\\s", ""));
                        int year = Integer.parseInt(yearInput.getText().replaceAll("\\s", ""));
                        int numActiveCases = 0;
                        int numRecoveredCases = 0;

                            for (int i = 0; i < towerB.size(); i++) {
                                Patient p = towerB.get(i);
                                int sickdt = Integer.parseInt(p.date.substring(0, 2).replaceAll("\\s", ""));
                                int sickmnth = Integer.parseInt(p.date.substring(3).replaceAll("\\s", ""));
                                int recdt = Integer.parseInt(p.recDate.substring(0, 2).replaceAll("\\s", ""));
                                int recmnth = Integer.parseInt(p.recDate.substring(3).replaceAll("\\s", ""));
                                if (mnth > recmnth) {
                                    numRecoveredCases += 1;
                                    recoveredCases.add(p);
                                }
                                else if (mnth == recmnth) {
                                    if (recdt <= dt) {
                                        numRecoveredCases += 1;
                                        recoveredCases.add(p);
                                    } else if (recdt > dt ) {
                                        if(sickmnth==mnth){
                                            if(dt>=sickdt){
                                                numActiveCases+=1;
                                                activeCases.add(p);
                                            }
                                        }
                                        else if(sickmnth<mnth){
                                            numActiveCases+=1;
                                            activeCases.add(p);
                                        }

                                    }
                                }
                                else {
                                    if (mnth == sickmnth) {
                                        if (sickdt <= dt) {
                                            numActiveCases += 1;
                                            activeCases.add(p);
                                        }
                                    }
                                }
                            }

                            casesB.setText(numActiveCases + "");
                            casesrB.setText(numRecoveredCases + "");
                            add(panel7);
                            B.setVisible(true);
                            for (int i = 0; i < activeCases.size(); i++) {
                                Patient patient = activeCases.get(i);
                                lB1.addElement(patient.name + "");
                                lB2.addElement(patient.age + "");
                                lB3.addElement(patient.date + "/2020");
                                lB4.addElement("N/A");
                                lB5.addElement("Active");
                            }
                            for (int i = 0; i < recoveredCases.size(); i++) {
                                Patient patient = recoveredCases.get(i);
                                lB1.addElement(patient.name + "");
                                lB2.addElement(patient.age + "");
                                lB3.addElement(patient.date + "/2020");
                                lB4.addElement(patient.recDate + "/2020");
                                lB5.addElement("Recovered");
                            }
                    }
                    else{
                        lB1.clear();
                        lB2.clear();
                        lB3.clear();
                        lB4.clear();
                        lB5.clear();
                        B.setVisible(false);
                        casesB.setText("");
                        casesrB.setText("");
                    }

                    if (c.isSelected()) {
                        lC1.clear();
                        lC2.clear();
                        lC3.clear();
                        lC4.clear();
                        lC5.clear();
                        lC1.addElement("Name");
                        lC2.addElement("Age");
                        lC3.addElement("Reported On");
                        lC4.addElement("Recovered on");
                        lC5.addElement("Recovered/Active");
                        ArrayList<Patient> activeCases = new ArrayList<Patient>();
                        ArrayList<Patient> recoveredCases = new ArrayList<Patient>();
                        int dt = Integer.parseInt(dateInput.getText().replaceAll("\\s", ""));
                        int mnth = Integer.parseInt(monthInput.getText().replaceAll("\\s", ""));
                        int numActiveCases = 0;
                        int numRecoveredCases = 0;
                        for (int i = 0; i < towerC.size(); i++) {
                            Patient p = towerC.get(i);
                            int sickdt = Integer.parseInt(p.date.substring(0, 2).replaceAll("\\s", ""));
                            int sickmnth = Integer.parseInt(p.date.substring(3).replaceAll("\\s", ""));
                            int recdt = Integer.parseInt(p.recDate.substring(0, 2).replaceAll("\\s", ""));
                            int recmnth = Integer.parseInt(p.recDate.substring(3).replaceAll("\\s", ""));
                            if (mnth > recmnth) {
                                numRecoveredCases += 1;
                                recoveredCases.add(p);
                            }
                            else if (mnth == recmnth) {
                                if (recdt  <= dt) {
                                    numRecoveredCases += 1;
                                    recoveredCases.add(p);
                                } else if (recdt  > dt ) {
                                    if(sickmnth==mnth){
                                        if(dt>=sickdt){
                                            numActiveCases+=1;
                                            activeCases.add(p);
                                        }
                                    }
                                    else if(sickmnth<mnth){
                                        numActiveCases+=1;
                                        activeCases.add(p);
                                    }

                                }
                            }
                            else {
                                if (mnth == sickmnth) {
                                    if (sickdt <= dt) {
                                        numActiveCases += 1;
                                        activeCases.add(p);
                                    }
                                }
                            }
                        }
                        casesC.setText(numActiveCases + "");
                        casesrC.setText(numRecoveredCases + "");
                        add(panel8);
                        C.setVisible(true);
                        for (int i = 0; i < activeCases.size(); i++) {
                            Patient patient = activeCases.get(i);
                            lC1.addElement(patient.name + "");
                            lC2.addElement(patient.age + "");
                            lC3.addElement(patient.date + "/2020");
                            lC4.addElement("N/A");
                            lC5.addElement("Active");
                        }
                        for (int i = 0; i < recoveredCases.size(); i++) {
                            Patient patient = recoveredCases.get(i);
                            lC1.addElement(patient.name + "");
                            lC2.addElement(patient.age + "");
                            lC3.addElement(patient.date + "/2020");
                            lC4.addElement(patient.recDate + "/2020");
                            lC5.addElement("Recovered");
                        }
                    }
                    else{
                        lC1.clear();
                        lC2.clear();
                        lC3.clear();
                        lC4.clear();
                        lC5.clear();
                        C.setVisible(false);
                        casesC.setText("");
                        casesrC.setText("");
                    }

                    if (d.isSelected()) {
                        lD1.clear();
                        lD2.clear();
                        lD3.clear();
                        lD4.clear();
                        lD5.clear();
                        lD1.addElement("Name");
                        lD2.addElement("Age");
                        lD3.addElement("Reported On");
                        lD4.addElement("Recovered on");
                        lD5.addElement("Recovered/Active");
                        ArrayList<Patient> activeCases = new ArrayList<Patient>();
                        ArrayList<Patient> recoveredCases = new ArrayList<Patient>();
                        int dt = Integer.parseInt(dateInput.getText().replaceAll("\\s", ""));
                        int mnth = Integer.parseInt(monthInput.getText().replaceAll("\\s", ""));
                        int numActiveCases = 0;
                        int numRecoveredCases = 0;
                        for (int i = 0; i < towerD.size(); i++) {
                            Patient p = towerD.get(i);
                            int sickdt = Integer.parseInt(p.date.substring(0, 2).replaceAll("\\s", ""));
                            int sickmnth = Integer.parseInt(p.date.substring(3).replaceAll("\\s", ""));
                            int recdt = Integer.parseInt(p.recDate.substring(0, 2).replaceAll("\\s", ""));
                            int recmnth = Integer.parseInt(p.recDate.substring(3).replaceAll("\\s", ""));
                            if (mnth > recmnth) {
                                numRecoveredCases += 1;
                                recoveredCases.add(p);
                            }
                            else if (mnth == recmnth) {
                                if (recdt <= dt) {
                                    numRecoveredCases += 1;
                                    recoveredCases.add(p);
                                } else if (recdt > dt ) {
                                    if(sickmnth==mnth){
                                        if(dt>=sickdt){
                                            numActiveCases+=1;
                                            activeCases.add(p);
                                        }
                                    }
                                    else if(sickmnth<mnth){
                                        numActiveCases+=1;
                                        activeCases.add(p);
                                    }

                                }
                            }
                            else {
                                if (mnth == sickmnth) {
                                    if (sickdt <= dt) {
                                        numActiveCases += 1;
                                        activeCases.add(p);
                                    }
                                }
                            }
                        }
                        casesD.setText(numActiveCases + "");
                        casesrD.setText(numRecoveredCases + "");
                        add(panel9);
                        D.setVisible(true);
                        for (int i = 0; i < activeCases.size(); i++) {
                            Patient patient = activeCases.get(i);
                            lD1.addElement(patient.name + "");
                            lD2.addElement(patient.age + "");
                            lD3.addElement(patient.date + "/2020");
                            lD4.addElement("N/A");
                            lD5.addElement("Active");
                        }
                        for (int i = 0; i < recoveredCases.size(); i++) {
                            Patient patient = recoveredCases.get(i);
                            lD1.addElement(patient.name + "");
                            lD2.addElement(patient.age + "");
                            lD3.addElement(patient.date + "/2020");
                            lD4.addElement(patient.recDate + "/2020");
                            lD5.addElement("Recovered");
                        }
                    }
                    else{
                        lD1.clear();
                        lD2.clear();
                        lD3.clear();
                        lD4.clear();
                        lD5.clear();
                        D.setVisible(false);
                        casesD.setText("");
                        casesrD.setText("");
                    }
                }
                    else{
                        invalidDate.showOptionDialog(null,
                                "All the input dates must lie within these 5 months(April 2020 - August 2020) only.",
                                "Invalid Date!", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,
                                null, new Object[]{}, null);

                        A.setVisible(false);
                        B.setVisible(false);
                        C.setVisible(false);
                        D.setVisible(false);

                        lA1.clear();
                        lA2.clear();
                        lA3.clear();
                        lA4.clear();
                        lA5.clear();

                        lB1.clear();
                        lB2.clear();
                        lB3.clear();
                        lB4.clear();
                        lB5.clear();

                        lC1.clear();
                        lC2.clear();
                        lC3.clear();
                        lC4.clear();
                        lC5.clear();

                        lD1.clear();
                        lD2.clear();
                        lD3.clear();
                        lD4.clear();
                        lD5.clear();

                        casesrD.setText("");
                        casesD.setText("");
                        casesrC.setText("");
                        casesC.setText("");
                        casesrB.setText("");
                        casesB.setText("");
                        casesrA.setText("");
                        casesA.setText("");
//                        System.out.println("done");
                    }
                }

            });

            setTitle("COVID-19 Status");
            setSize(900, 800);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new FlowLayout());

        }
}

}
