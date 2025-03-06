import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import javax.swing.*;

public class MainMethod {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                BMICal bmical = new BMICal();
                bmical.setLocationRelativeTo(null);
                bmical.setVisible(true);
                bmical.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                bmical.setResizable(false);

            }
        });

    }
}
