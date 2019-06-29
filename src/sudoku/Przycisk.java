package sudoku;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import static java.lang.Integer.parseInt;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Przycisk extends JButton {
    public Przycisk() {
        setForeground(Color.black);
        setFont(new Font("Calibri", Font.PLAIN, 28));
        setFocusPainted(false);
        setPreferredSize(new Dimension(48, 48));
        setEnabled(false);
    }
    
    //wstawia pod przycisk liczbę, której nie można zmienić
    public void wstawStala(int liczba) {
        setEnabled(false);
        setForeground(Color.gray);
        String podajLiczbe = new String(""+liczba);
        setText(podajLiczbe);
    }
    
    //sprawia, że przyciski "do wypełnienia" stają się edytowalne
    public void uwolnijPrzycisk() {
        setEnabled(true);
        setForeground(Color.black);
    }
    
    //wstawia liczbę pod przycisk
    public void wstawLiczbe() {
        int licznik = 0;
        if(getText() == "" || getText() == null)
            licznik = 1;
        else {
            licznik = Integer.parseInt(getText());
            if(licznik >= 9)
                licznik = 1;
            else
                licznik++;
        }
            
        String podajLiczbe = new String("" + licznik);
        setText(podajLiczbe);
    }
}