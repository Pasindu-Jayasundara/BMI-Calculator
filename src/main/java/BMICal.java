import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;
import javax.swing.GroupLayout;

public class BMICal extends JFrame {

    String item;
    public static final String KG = "Kg";
    public static final String POUND = "Pound";

    public BMICal() {
        initComponents();
    }

    private void clearBtn(ActionEvent e) {

        textField1.setText("");
        textField2.setText("");

        comboBox1.setSelectedIndex(0);
        comboBox2.setSelectedIndex(0);

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

        //======== this ========
        setTitle("BMI Calculator");
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
            var dialog1ContentPane = dialog1.getContentPane();

            GroupLayout dialog1ContentPaneLayout = new GroupLayout(dialog1ContentPane);
            dialog1ContentPane.setLayout(dialog1ContentPaneLayout);
            dialog1ContentPaneLayout.setHorizontalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGap(0, 198, Short.MAX_VALUE)
            );
            dialog1ContentPaneLayout.setVerticalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGap(0, 169, Short.MAX_VALUE)
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
