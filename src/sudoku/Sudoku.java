/*
Autor:          Sławomir Chabowski
Nr indeksu:     17833
Uczelnia:       PWSZ Elbląg
Rok:            2017
*/
package sudoku;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Sudoku extends JFrame {
    
    //plansze
    int[][][] plansze = {
        {
            {0, 0, 7, 0, 3, 0, 3, 0, 0},
            {0, 0, 0, 2, 0, 5, 0, 0, 0},
            {4, 0, 0, 9, 0, 6, 0, 0, 1},
            {0, 4, 3, 0, 0, 0, 2, 1, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 5},
            {0, 5, 8, 0, 0, 0, 6, 7, 0},
            {5, 0, 0, 1, 0, 8, 0, 0, 9},
            {0, 0, 0, 5, 0, 3, 0, 0, 0},
            {0, 0, 2, 0, 9, 0, 5, 0, 0}
        },
        {
            {8, 0, 0, 6, 0, 4, 0, 0, 0},
            {0, 3, 0, 0, 0, 0, 0, 6, 0},
            {0, 0, 6, 0, 5, 3, 8, 2, 0},
            {0, 0, 0, 5, 8, 0, 0, 0, 0},
            {0, 9, 0, 2, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 9, 5, 0},
            {0, 1, 0, 7, 0, 0, 2, 8, 0},
            {0, 6, 0, 0, 0, 0, 3, 7, 1},
            {3, 8, 0, 0, 0, 0, 0, 9, 0}
        },
        {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},                    
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        },
        {
            {0, 0, 0, 2, 6, 0, 7, 0, 1},
            {6, 8, 0, 0, 7, 0, 0, 9, 3},
            {1, 9, 0, 0, 0, 4, 5, 0, 0},
            {8, 2, 0, 1, 0, 0, 0, 4, 0},
            {0, 0, 4, 6, 0, 2, 9, 0, 0},
            {0, 5, 0, 0, 0, 3, 0, 2, 8},
            {0, 0, 9, 3, 0, 0, 0, 7, 4},
            {0, 4, 0, 0, 5, 0, 0, 3, 6},
            {7, 0, 3, 0, 1, 8, 0, 0, 0}
        },
        {
            {7, 8, 0, 4, 0, 0, 1, 2, 0},
            {6, 0, 0, 0, 7, 5, 0, 0, 9},
            {0, 0, 0, 6, 0, 1, 0, 7, 8},
            {0, 0, 7, 0, 4, 0, 2, 6, 0},
            {0, 0, 1, 0, 5, 0, 9, 3, 0},
            {9, 0, 4, 0, 6, 0, 0, 0, 5},
            {0, 7, 0, 3, 0, 0, 0, 1, 2},
            {1, 2, 0, 0, 0, 7, 4, 0, 0},
            {0, 4, 9, 2, 0, 6, 0, 0, 7}
        },
        {
            {8, 0, 0, 0, 3, 0, 0, 4, 0},
            {0, 0, 0, 0, 0, 9, 0, 0, 5},
            {0, 5, 1, 0, 0, 6, 0, 3, 0},
            {0, 0, 5, 0, 4, 0, 0, 0, 9},
            {9, 0, 0, 1, 0, 2, 0, 0, 4},
            {2, 0, 0, 0, 0, 0, 3, 0, 0},
            {0, 3, 0, 7, 0, 0, 6, 8, 1},
            {1, 0, 0, 9, 0, 0, 0, 0, 0},
            {0, 7, 0, 0, 8, 0, 0, 0, 0}
        },
        {
            {7, 0, 0, 0, 0, 6, 0, 0, 3},
            {0, 8, 6, 7, 0, 3, 2, 5, 0},
            {0, 9, 2, 5, 0, 0, 0, 4, 0},
            {0, 0, 9, 8, 5, 0, 6, 1, 7},
            {0, 0, 4, 0, 0, 0, 0, 0, 0},
            {0, 6, 7, 0, 0, 9, 0, 2, 0},
            {0, 0, 0, 6, 8, 0, 5, 0, 4},
            {4, 5, 8, 3, 7, 0, 0, 0, 0},
            {0, 0, 1, 4, 0, 0, 0, 0, 0}
        },
        {
            {6, 5, 0, 0, 3, 2, 0, 0, 8},
            {0, 0, 7, 6, 0, 0, 5, 4, 0},
            {1, 0, 0, 0, 8, 0, 0, 6, 0},
            {0, 6, 4, 1, 9, 0, 0, 0, 2},
            {8, 0, 0, 0, 0, 4, 6, 9, 0},
            {0, 7, 0, 3, 0, 0, 4, 0, 0},
            {0, 9, 0, 8, 0, 0, 3, 0, 5},
            {0, 2, 5, 0, 7, 6, 0, 0, 0},
            {4, 0, 0, 0, 5, 0, 0, 7, 6}
        },
        {
            {0, 8, 0, 9, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 4, 0, 0},
            {0, 1, 9, 0, 0, 0, 6, 0, 0},
            {0, 5, 0, 0, 7, 0, 0, 6, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 8, 0, 6, 2, 0, 5},
            {5, 0, 6, 0, 0, 2, 0, 0, 7},
            {0, 3, 0, 0, 9, 0, 0, 0, 0},
            {0, 0, 7, 5, 0, 0, 9, 1, 0}
        },
        {
            {4, 0, 0, 3, 9, 0, 0, 0, 0},
            {5, 0, 0, 0, 0, 0, 0, 0, 0},
            {7, 9, 0, 5, 0, 1, 0, 0, 6},
            {0, 0, 0, 0, 7, 0, 0, 1, 0},
            {2, 0, 0, 6, 0, 4, 0, 0, 5},
            {0, 8, 0, 0, 3, 0, 0, 0, 0},
            {1, 0, 0, 8, 0, 9, 0, 5, 3},
            {0, 0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 5, 6, 0, 0, 2}
        },
        //plansza do sprawdzania 1
        {
            {4, 3, 5, 2, 6, 9, 7, 8, 1},
            {6, 8, 2, 5, 7, 1, 4, 9, 3},
            {1, 9, 7, 8, 3, 4, 5, 6, 2},
            {8, 2, 6, 1, 9, 5, 3, 4, 7},
            {3, 7, 4, 6, 8, 2, 9, 1, 5},
            {9, 5, 1, 7, 4, 3, 6, 2, 8},
            {5, 1, 9, 3, 2, 6, 8, 7, 4},
            {2, 4, 8, 9, 5, 7, 1, 3, 6},
            {7, 6, 3, 4, 1, 8, 2, 5, 9}
        },
        //plansza do sprawdzania 2
        {
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1}
        }
    };
    
    //klasy nasłuchujące
    
    //zdarzenie wciśnięcia przycisku
    class ZdarzenieWcisnijPrzycisk implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof Przycisk) {
                ((Przycisk)e.getSource()).wstawLiczbe();
            }
        }
    }
    
    //menu "Losuj nową planszę"
    class ZdarzenieLosujPlansze implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            czasomierz.start();
            
            //uruchomienie/reset czasomierza
            if(czasDziala == false) {
                czasDziala = true;
                czasomierz.setRepeats(true);
            }
            else {
                czas = 0;
            }
                        
            //losowanie planszy
            Random rn = new Random();
            int losuj = rn.nextInt(plansze.length);
            
            //wyświetlenie numeru planszy
            numerPlanszy.setText("Numer planszy: " + losuj);
            
            //ustawianie przycisków do planszy
            int i, j;
            for(i=0;i<9;i++)
                for(j=0;j<9;j++) {
                    if(plansze[losuj][i][j] == 0) {
                        p[i][j].uwolnijPrzycisk();
                        p[i][j].setText("");
                    }
                    else
                        p[i][j].wstawStala(plansze[losuj][i][j]);
                }
            
            //włączenie przycisku wysyłania wyniku
            sprawdzPlansze.setEnabled(true);
        }
    }
    
    //menu "Wybierz planszę"
    class ZdarzenieWybierzPlansze implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            int ustawNumerPlanszy;
            String wybierzNumerPlanszy = JOptionPane.showInputDialog(rootPane, "Wybierz numer planszy\n"
                    + "z zakresu: 0 - " + (plansze.length-1));
            
            try {
                if (Integer.parseInt(wybierzNumerPlanszy) >= 0 && Integer.parseInt(wybierzNumerPlanszy) <= (plansze.length-1)) {
                    ustawNumerPlanszy = Integer.parseInt(wybierzNumerPlanszy);
                    czasomierz.start();
                    //uruchomienie/reset czasomierza
                    if(czasDziala == false) {
                        czasDziala = true;
                        czasomierz.setRepeats(true);
                    }
                    else {
                        czas = 0;
                    }

                    //wyświetlenie numeru planszy
                    numerPlanszy.setText("Numer planszy: " + ustawNumerPlanszy);
                    
                    //ustawianie przycisków do planszy
                    int i, j;
                    for(i=0;i<9;i++)
                        for(j=0;j<9;j++) {
                            if(plansze[Integer.parseInt(wybierzNumerPlanszy)][i][j] == 0) {
                                p[i][j].uwolnijPrzycisk();
                                p[i][j].setText("");
                            }
                            else
                                p[i][j].wstawStala(plansze[Integer.parseInt(wybierzNumerPlanszy)][i][j]);
                        }
                    
                    //włączenie przycisku wysyłania wyniku
                    sprawdzPlansze.setEnabled(true);
                }
                else
                    JOptionPane.showMessageDialog(rootPane, "Niepoprawna liczba", "Błąd!", JOptionPane.PLAIN_MESSAGE, null);
            }
            catch (NumberFormatException exception) {
                //JOptionPane.showMessageDialog(rootPane, "Niepoprawna liczba", "Błąd!", JOptionPane.PLAIN_MESSAGE, null);
            }
        }
    }
    
    //menu "Zakończ"
    class ZdarzenieZakoncz implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            Object[] opcje = {"Tak", "Nie"};
            JLabel wiadomosc = new JLabel("Czy chcesz zakończyć grę?");
            
            int wynik = JOptionPane.showOptionDialog(rootPane, wiadomosc, "Zamykanie gry", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcje, null);
            if (wynik == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }
    
    //menu "Zasady gry"
    class ZdarzenieZasadyGry implements ActionListener {

        private final String oAutorze = "Sudoku to gra wymyślona przez Amerykanina Howarda Garnsa w 1979 roku. Polega na"
                + "\ntakim ułożeniu liczb, by w żadnym wierszu, kolumnie i wyróżnionym obszarze 3x3 żadna\n"
                + "liczba nie powtarzała się."
                
                + "\n\nAby wylosować nową planszę, należy z menu \"Gra\" wybrać polecenie \"Losuj nową planszę\"."
                + "\nWówczas pojawi się kilka nieklikalnych przycisków - do nich trzeba dostosować"
                + "\nwprowadzane liczby."
                
                + "\n\nMożna też wybrać dowolną planszę, o ile pamięta się jej identyfikator. W tym celu należy"
                + "\nz menu \"Gra\" wybrać polecenie \"Wybierz planszę\", wpisać tam odpowiednią wartość i wcisnąć"
                + "\nprzycisk \"OK\"."
                
                + "\n\nLiczby wprowadza się poprzez kliknięcie w odpowiednie pole na planszy; każde kolejne"
                + "\nkliknięcie spowoduje, że wylosowana zostanie liczba o 1 większa od poprzedniej"
                + "\n(jeśli pole jest puste, zostanie wylosowana liczba 1; jeśli jednak na przycisku jest"
                + "\nliczba 9, po wciśnięciu z powrotem pojawi się jedynka.";

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(rootPane, oAutorze, "Zasady gry", JOptionPane.PLAIN_MESSAGE, null);
        }
    }
    
    //menu "O programie"
    class ZdarzenieOProgramie implements ActionListener {

        private final String oAutorze = "Autor: Sławomir Chabowski"
                + "\nRok utworzenia: 2017";

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(rootPane, oAutorze, "O programie", JOptionPane.PLAIN_MESSAGE, null);
        }
    }
    
    //przycisk "Sprawdź planszę"
    class ZdarzenieSprawdzPlansze implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            //przepisanie zawartości okna do tablicy dwuwymiarowej typu int
            int[][] podgladWartosci = new int[9][9];
            int i, j, temp;
            boolean czySprawdzac = true;
            
            //pętla sprawdza, czy występują na planszy miejsca puste
            //jeśli nie, tworzy tablicę z wartościami sudoku
            sprawdzUzupelnienie: {
                for(i=0;i<9;i++)
                    for(j=0;j<9;j++) {
                        if (p[i][j].getText().equals(null) || p[i][j].getText().equals("")) {
                            JOptionPane.showMessageDialog(rootPane, "Plansza nie jest uzupełniona do końca!", "Komunikat", JOptionPane.PLAIN_MESSAGE, null);
                            czySprawdzac = false;
                            break sprawdzUzupelnienie;
                        }
                        else {
                            temp = Integer.parseInt(p[i][j].getText());

                            if(temp >= 1 && temp <= 9)
                                podgladWartosci[i][j] = temp;
                            else
                                podgladWartosci[i][j] = 0;
                        }
                    }
            }
                            
            if(czySprawdzac) {
                //sprawdzenie tablicy
                Boolean[][] wyniki = new Boolean[3][9];
                for(i=0;i<9;i++) {
                    wyniki[0][i] = sprawdzKolumne(podgladWartosci, i);
                    wyniki[1][i] = sprawdzWiersz(podgladWartosci, i);
                    wyniki[2][i] = sprawdzKomorke(podgladWartosci, i);
                }

                //wyświetlenie wyników na ekranie
                String wiadomosc = null;
                for(i=0;i<9;i++) {
                    if(wyniki[0][i] == false || wyniki[1][i] == false || wyniki[2][i] == false) {
                        wiadomosc = "Plansza jest błędnie wypełniona!";
                        break;
                    }            
                    else {
                        czasomierz.stop();
                        if(czas >= 60.0)
                            wiadomosc = "Brawo! Plansza została poprawnie rozwiązana!\n"
                            + "Czas gry: " + String.format("%.0f", ((czas-czas%60.0))/60) + "m " + String.format("%.1f", (czas%60)) + "s.";
                        else
                            wiadomosc = "Brawo! Plansza została poprawnie rozwiązana!\n"
                            + "Czas gry: " + String.format("%.1f", czas) + " sekund.";
                    }
                }


                JOptionPane.showMessageDialog(rootPane, wiadomosc, "Komunikat", JOptionPane.PLAIN_MESSAGE, null);
            }
        }
        
        boolean sprawdzKolumne(int[][] sudoku, int numer) {
            
            boolean sprawdz = true;
            HashSet<Integer> hs = new HashSet<Integer>();
            for(int i=0;i<9;i++) {
                if(!hs.add(sudoku[numer][i])) {
                    sprawdz = false;
                    break;
                }
            }
            return sprawdz;
        }
        
        boolean sprawdzWiersz(int[][] sudoku, int numer) {
            
            boolean sprawdz = true;
            HashSet<Integer> hs = new HashSet<Integer>();
            for(int i=0;i<9;i++) {
                if(!hs.add(sudoku[i][numer])) {
                    sprawdz = false;
                    break;
                }
            }
            return sprawdz;
        }
        
        boolean sprawdzKomorke(int[][] sudoku, int numer) {
            
            int i = 0, j = 0;
            switch(numer) {
                case 1:
                    i=0;
                    j=0;
                    break;
                case 2:
                    i=0;
                    j=3;
                    break;
                case 3:
                    i=0;
                    j=6;
                    break;
                case 4:
                    i=3;
                    j=0;
                    break;
                case 5:
                    i=3;
                    j=3;
                    break;
                case 6:
                    i=3;
                    j=6;
                    break;
                case 7:
                    i=6;
                    j=0;
                    break;
                case 8:
                    i=6;
                    j=3;
                    break;
                case 9:
                    i=6;
                    j=6;
                    break;
            }

            boolean sprawdz = true;
            HashSet<Integer> hs = new HashSet<Integer>();
            sprawdzanie: {
                for(int pierwsza=i;pierwsza<i+3;pierwsza++) {
                    for(int druga=j;druga<j+3;druga++) {
                        if(!hs.add(sudoku[pierwsza][druga])) {
                            sprawdz = false;
                            break sprawdzanie;
                        }
                    }
                }
            }
            return sprawdz;
        }
    }
    
    //czasomierz
    Timer czasomierz = new Timer(100, new ActionListener(){        
        @Override
        public void actionPerformed(ActionEvent e) {
            czas = czas + 0.1;
            if(czasDziala) {
                czasGry.setText("<html><p style='padding-left: 5px;'>Czas gry: " + String.format("%.1f", czas) + "s</p></html>");
                int minutnik = 0;
                if(czas > 60.0) {
                    minutnik++;
                    czasGry.setText("<html><div style='width: 200px; padding-left: 5px;'>Czas gry: " + String.format("%.0f", ((czas-czas%60.0))/60) + "m " + String.format("%.1f", (czas%60.0)) + "s</div></html>");
                }
            }
        }
    });
    
    //elementy interfejsu
    Przycisk[][] p = new Przycisk[9][9];
    JPanel[] panel = new JPanel[9];
    JPanel kontener = new JPanel();
    JPanel menu = new JPanel();
    
    //pasek dolny - zawiera licznik czasu oraz przycisk wysłania wyniku
    JPanel pasekDolny = new JPanel();
        double czas = 0;
        boolean czasDziala = false;
        JLabel czasGry = new JLabel("<html><p style='padding-left: 5px;'>Czas gry: " + czas + "s</p></hmtl>");
        JLabel numerPlanszy = new JLabel();
        JButton sprawdzPlansze = new JButton("Sprawdź planszę");
        
    
    //pasek menu i jego elementy
    JMenuBar pasekMenu = new JMenuBar();
        JMenu gra = new JMenu("Gra");
            JMenuItem losujPlansze = new JMenuItem("Losuj nową planszę");
            JMenuItem wybierzPlansze = new JMenuItem("Wybierz planszę");
            JMenuItem zakoncz = new JMenuItem("Zakończ");
        JMenu pomoc = new JMenu("Pomoc");
            JMenuItem zasadyGry = new JMenuItem("Zasady gry");
            JMenuItem oProgramie = new JMenuItem("O programie");
    
    
    public Sudoku() {
        super("Sudoku");
        int i, j;
        
        //pasek dolny
        pasekDolny.setLayout(new BorderLayout());
        pasekDolny.add(czasGry, "West");
        czasGry.setPreferredSize(new Dimension(200, 25));
        pasekDolny.add(numerPlanszy, "Center");
        pasekDolny.add(sprawdzPlansze, "East");
        sprawdzPlansze.setEnabled(false);
        sprawdzPlansze.setFocusPainted(false);
        
        //dodanie elementów do menu
        gra.add(losujPlansze);
        gra.add(wybierzPlansze);
        gra.add(zakoncz);
        pomoc.add(zasadyGry);
        pomoc.add(oProgramie);
        pasekMenu.add(gra);
        pasekMenu.add(pomoc);
        
        //klasy nasłuchujące dla elementów menu
        losujPlansze.addActionListener(new ZdarzenieLosujPlansze());
        wybierzPlansze.addActionListener(new ZdarzenieWybierzPlansze());
        zakoncz.addActionListener(new ZdarzenieZakoncz());
        zasadyGry.addActionListener(new ZdarzenieZasadyGry());
        oProgramie.addActionListener(new ZdarzenieOProgramie());
        
        //utworzenie klasy nasłuchującej dla przycisku sprawdzania
        sprawdzPlansze.addActionListener(new ZdarzenieSprawdzPlansze());
        
        //utworzenie przycisków i dodanie ich do paneli
        for(i=0;i<9;i++)
            for(j=0;j<9;j++) {
                p[i][j] = new Przycisk();
                p[i][j].addActionListener(new ZdarzenieWcisnijPrzycisk());
            }
        
        //utworzenie dziewięciu paneli i wrzucenie ich do kontenera
        kontener.setLayout(new GridLayout(3, 3));
        
        for(i=0;i<9;i++) {
            panel[i] = new JPanel();
            panel[i].setLayout(new GridLayout(3, 3));
            panel[i].setBorder(BorderFactory.createLineBorder(Color.black));
            kontener.add(panel[i]);
        }

        //dodanie przycisków do paneli
        //panel[0]
        panel[0].add(p[0][0]);
        panel[0].add(p[0][1]);
        panel[0].add(p[0][2]);
        panel[0].add(p[1][0]);
        panel[0].add(p[1][1]);
        panel[0].add(p[1][2]);
        panel[0].add(p[2][0]);
        panel[0].add(p[2][1]);
        panel[0].add(p[2][2]);
        //panel[1]
        panel[1].add(p[0][3]);
        panel[1].add(p[0][4]);
        panel[1].add(p[0][5]);
        panel[1].add(p[1][3]);
        panel[1].add(p[1][4]);
        panel[1].add(p[1][5]);
        panel[1].add(p[2][3]);
        panel[1].add(p[2][4]);
        panel[1].add(p[2][5]);
        //panel[2]
        panel[2].add(p[0][6]);
        panel[2].add(p[0][7]);
        panel[2].add(p[0][8]);
        panel[2].add(p[1][6]);
        panel[2].add(p[1][7]);
        panel[2].add(p[1][8]);
        panel[2].add(p[2][6]);
        panel[2].add(p[2][7]);
        panel[2].add(p[2][8]);
        //panel[3]
        panel[3].add(p[3][0]);
        panel[3].add(p[3][1]);
        panel[3].add(p[3][2]);
        panel[3].add(p[4][0]);
        panel[3].add(p[4][1]);
        panel[3].add(p[4][2]);
        panel[3].add(p[5][0]);
        panel[3].add(p[5][1]);
        panel[3].add(p[5][2]);
        //panel[4]
        panel[4].add(p[3][3]);
        panel[4].add(p[3][4]);
        panel[4].add(p[3][5]);
        panel[4].add(p[4][3]);
        panel[4].add(p[4][4]);
        panel[4].add(p[4][5]);
        panel[4].add(p[5][3]);
        panel[4].add(p[5][4]);
        panel[4].add(p[5][5]);
        //panel[5]
        panel[5].add(p[3][6]);
        panel[5].add(p[3][7]);
        panel[5].add(p[3][8]);
        panel[5].add(p[4][6]);
        panel[5].add(p[4][7]);
        panel[5].add(p[4][8]);
        panel[5].add(p[5][6]);
        panel[5].add(p[5][7]);
        panel[5].add(p[5][8]);
        //panel[6]
        panel[6].add(p[6][0]);
        panel[6].add(p[6][1]);
        panel[6].add(p[6][2]);
        panel[6].add(p[7][0]);
        panel[6].add(p[7][1]);
        panel[6].add(p[7][2]);
        panel[6].add(p[8][0]);
        panel[6].add(p[8][1]);
        panel[6].add(p[8][2]);
        //panel[7]
        panel[7].add(p[6][3]);
        panel[7].add(p[6][4]);
        panel[7].add(p[6][5]);
        panel[7].add(p[7][3]);
        panel[7].add(p[7][4]);
        panel[7].add(p[7][5]);
        panel[7].add(p[8][3]);
        panel[7].add(p[8][4]);
        panel[7].add(p[8][5]);
        //panel[8]
        panel[8].add(p[6][6]);
        panel[8].add(p[6][7]);
        panel[8].add(p[6][8]);
        panel[8].add(p[7][6]);
        panel[8].add(p[7][7]);
        panel[8].add(p[7][8]);
        panel[8].add(p[8][6]);
        panel[8].add(p[8][7]);
        panel[8].add(p[8][8]);

        setLayout(new BorderLayout());
        add(pasekMenu, "North");
        add(kontener, "Center");
        add(pasekDolny, "South");
        
        setSize(500, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Sudoku();
    }
}