package objectiveworld160553;

/**
 *
 * @author Kontekstowy
*/
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class ChoiceDialog extends JDialog implements ActionListener {

    private int y, x;
    private JButton[] organisms;
    private World world;
    private String[] names;

    public ChoiceDialog(int y, int x, World world) {
        JPanel panelDialog = new JPanel();
        Box boxButtons = Box.createHorizontalBox();
        this.y = y;
        this.x = x;
        this.world = world;

        organisms = new JButton[9];
        names = new String[9];

        organisms[0] = new JButton("Antylopa");
        names[0] = "antelope.png";
        organisms[1] = new JButton("Lis");
        names[1] = "fox.png";
        organisms[2] = new JButton("Owca");
        names[2] = "sheep.png";
        organisms[3] = new JButton("Żółw");
        names[3] = "turtle.png";
        organisms[4] = new JButton("Wilk");
        names[4] = "wolf.png";
        organisms[5] = new JButton("Trawa");
        names[5] = "grass.png";
        organisms[6] = new JButton("Guarana");
        names[6] = "guarana.png";
        organisms[7] = new JButton("Mlecz");
        names[7] = "mill.png";
        organisms[8] = new JButton("Wilcze jagody");
        names[8] = "wolfberries.png";

        for (int i = 0; i < 9; i++) {
            organisms[i].addActionListener(this);
            boxButtons.add(organisms[i]);
        }

        panelDialog.add(boxButtons);
        add(panelDialog);
        pack();
        setVisible(true);
        setResizable(false);
        setTitle("Wybierz organizm");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //zabije proces
   }

    @Override
    public void actionPerformed(ActionEvent event) {
        for (int i = 0; i < 9; i++) {
            if (event.getSource() == organisms[i]) {
               
               world.addNewest(i,x,y); 
               dispose();
            }
        }

    }

}
