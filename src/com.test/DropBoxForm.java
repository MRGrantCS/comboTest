import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DropBoxForm extends JPanel{
    private JComboBox comboBox1;

    private JPanel panel1;
    private JButton button1;
    private JCheckBox checkBox1;

    public DropBoxForm() {

        JFrame frame = new JFrame("Drop down");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(1000,1000);
        frame.pack(); //Packs the frame with all of the objects from the form
        frame.setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(comboBox1.getSelectedItem());
                if(checkBox1.isSelected()){
                    System.out.println("Checkbox is on and works");
                }
                else{
                    System.out.println("Checkbox is off but still works");
                }
            }
        });
        checkBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("I clicked the check box");
            }
        });
    }
}

