import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;
import javax.swing.GroupLayout;

public class BMICal extends JFrame {

    String item;
    public static final String KG = "Kg";
    public static final String POUND = "Pound";
    public static final String UNDER_WEIGHT = "Under-Weight";
    public static final String NORMAL = "Normal";
    public static final String OVER_WEIGHT = "Over-Weight";
    public static final String OBESE = "Obese";

    public BMICal() {
        initComponents();

        textField1.grabFocus();
    }

    private void clearBtn(ActionEvent e) {

        textField1.setText("");
        textField2.setText("");

        comboBox1.setSelectedIndex(0);
        comboBox2.setSelectedIndex(0);

        textField1.grabFocus();

    }

    private void calculateBtn(ActionEvent e) {

        String weight = String.valueOf(textField1.getText().trim());
        String height = String.valueOf(textField2.getText().trim());

        if(validateValue(weight,height)){

            double weightDouble = Double.parseDouble(weight);
            double heightDouble = Double.parseDouble(height);

            double bmi = 0.0;

            if(item.equals(KG)){
                // metric unit
                bmi = calculateInMetricUnit(weightDouble,heightDouble);
            }else if(item.equals(POUND)){
                // english
                bmi = calculateInEnglishUnit(weightDouble,heightDouble);
            }

            displayBMIValue(bmi);

        }

    }

    private void displayBMIValue(double bmi) {

        label2.setText(String.format("%.2f",bmi));

        if(bmi < 18.5){

            label3.setText(UNDER_WEIGHT);
            label3.setForeground(Color.PINK);
            label2.setForeground(Color.PINK);

        }else if(bmi >= 18.5 && bmi < 24.9){

            label3.setText(NORMAL);
            label3.setForeground(Color.GREEN);
            label2.setForeground(Color.GREEN);

        }else if(bmi >= 25.0 && bmi < 29.9){

            label3.setText(OVER_WEIGHT);
            label3.setForeground(Color.ORANGE);
            label2.setForeground(Color.ORANGE);

        }else{
            label3.setText(OBESE);
            label3.setForeground(Color.RED);
            label2.setForeground(Color.RED);
        }

        dialog1.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);

                clearBtn(null);
            }
        });

        dialog1.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        dialog1.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog1.setVisible(true);

    }

    private boolean validateValue(String weight, String height) {

        if(weight.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter weight");
            return false;
        }

        if(height.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter height");
            return false;
        }

        if(item==null){
            JOptionPane.showMessageDialog(this, "Please select Height Type");
            return false;
        }

        try {
            Double.parseDouble(weight);
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Invalid Weight Value");
            return false;
        }

        try {
            Double.parseDouble(height);
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Invalid Height Value");
            return false;
        }

        double weightDouble = Double.parseDouble(weight);
        double heightDouble = Double.parseDouble(height);

        if(weightDouble < 0){
            JOptionPane.showMessageDialog(this, "Weight cannot be negative");
            return false;
        }

        if(heightDouble < 0){
            JOptionPane.showMessageDialog(this, "Height cannot be negative");
            return false;
        }

        return true;
    }

    private double calculateInEnglishUnit(double weight, double height) {

        return (weight*703)/Math.pow(height,2);
    }

    private double calculateInMetricUnit(double weight, double height) {

        return weight/Math.pow(height,2);
    }

    private void comboBox1PropertyChange(PropertyChangeEvent e) {

        System.out.println(e.getPropertyName());

    }

    private void comboBox1ItemStateChanged(ItemEvent e) {

        if (e.getStateChange() == ItemEvent.SELECTED) {

            item = (String) e.getItem();
            switch (item) {
                case KG:{
                    comboBox2.setSelectedIndex(1);
                    break;
                }
                case POUND:{
                    comboBox2.setSelectedIndex(2);
                    break;
                }
                default:{
                    comboBox2.setSelectedIndex(0);
                    break;
                }
            }
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Pasindu
        Weight = new JLabel();
        textField1 = new JTextField();
        comboBox1 = new JComboBox<>();
        Weight2 = new JLabel();
        textField2 = new JTextField();
        comboBox2 = new JComboBox<>();
        button1 = new JButton();
        button2 = new JButton();
        dialog1 = new JDialog();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        separator1 = new JSeparator();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        separator2 = new JSeparator();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();

        //======== this ========
        setTitle("BMI Calculator");
        setBackground(Color.white);
        var contentPane = getContentPane();

        //---- Weight ----
        Weight.setText("Weight");

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "Select Type",
            "Kg",
            "Pound"
        }));
        comboBox1.addPropertyChangeListener("selectedItem", e -> comboBox1PropertyChange(e));
        comboBox1.addItemListener(e -> comboBox1ItemStateChanged(e));

        //---- Weight2 ----
        Weight2.setText("Height");

        //---- comboBox2 ----
        comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
            "Select Type",
            "Meters",
            "Intches"
        }));
        comboBox2.setEnabled(false);

        //---- button1 ----
        button1.setText("Clear");
        button1.addActionListener(e -> clearBtn(e));

        //---- button2 ----
        button2.setText("Calculate");
        button2.addActionListener(e -> calculateBtn(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(Weight)
                            .addGap(18, 18, 18)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(comboBox1, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(button1)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(Weight2)
                                    .addGap(18, 18, 18)
                                    .addComponent(textField2, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(95, 95, 95)
                                    .addComponent(button2))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(13, 13, 13)
                                    .addComponent(comboBox2)))))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField1))
                        .addComponent(Weight, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(Weight2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(41, 41, 41)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addContainerGap(32, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());

        //======== dialog1 ========
        {
            dialog1.setTitle("Your BMI");
            var dialog1ContentPane = dialog1.getContentPane();

            //---- label1 ----
            label1.setText("BMI :");
            label1.setFont(new Font("Segoe UI", Font.BOLD, 16));

            //---- label2 ----
            label2.setForeground(Color.blue);
            label2.setFont(new Font("Segoe UI", Font.BOLD, 16));

            //---- label3 ----
            label3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            label3.setHorizontalAlignment(SwingConstants.CENTER);

            //---- label4 ----
            label4.setText("BMI Values");
            label4.setFont(new Font("Segoe UI", Font.BOLD, 12));

            //---- label5 ----
            label5.setText("Under-weight");

            //---- label6 ----
            label6.setText("Normal");

            //---- label7 ----
            label7.setText("Over-weight");

            //---- label8 ----
            label8.setText("Obese");

            //---- label9 ----
            label9.setText("> 18.5");

            //---- label10 ----
            label10.setText("18.5 - 24.9");

            //---- label11 ----
            label11.setText("25.0 - 29.9");

            //---- label12 ----
            label12.setText(">= 30.0");

            GroupLayout dialog1ContentPaneLayout = new GroupLayout(dialog1ContentPane);
            dialog1ContentPane.setLayout(dialog1ContentPaneLayout);
            dialog1ContentPaneLayout.setHorizontalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addGroup(dialog1ContentPaneLayout.createParallelGroup()
                            .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(separator1, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
                            .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                                .addGroup(dialog1ContentPaneLayout.createParallelGroup()
                                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(label4))
                                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                                        .addGap(71, 71, 71)
                                        .addGroup(dialog1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(label5)
                                            .addComponent(label6)
                                            .addComponent(label7)
                                            .addComponent(label8))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(separator2, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(dialog1ContentPaneLayout.createParallelGroup()
                                            .addComponent(label10)
                                            .addComponent(label9)
                                            .addComponent(label11)
                                            .addComponent(label12))))
                                .addGap(0, 85, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(41, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, dialog1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap(114, Short.MAX_VALUE)
                        .addComponent(label1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))
            );
            dialog1ContentPaneLayout.setVerticalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, dialog1ContentPaneLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(label4)
                        .addGroup(dialog1ContentPaneLayout.createParallelGroup()
                            .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(dialog1ContentPaneLayout.createParallelGroup()
                                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                                        .addComponent(label9)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label10)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label11)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label12))
                                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                                        .addComponent(label5)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label6)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label7)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label8)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, dialog1ContentPaneLayout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                .addComponent(separator2, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)))
                        .addComponent(separator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(dialog1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label1)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
            );
            dialog1.pack();
            dialog1.setLocationRelativeTo(dialog1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Pasindu
    private JLabel Weight;
    private JTextField textField1;
    private JComboBox<String> comboBox1;
    private JLabel Weight2;
    private JTextField textField2;
    private JComboBox<String> comboBox2;
    private JButton button1;
    private JButton button2;
    private JDialog dialog1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JSeparator separator1;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JSeparator separator2;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
