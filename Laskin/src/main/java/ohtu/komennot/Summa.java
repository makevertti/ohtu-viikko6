package ohtu.komennot;

import ohtu.Sovelluslogiikka;

import javax.swing.*;

public class Summa implements Komento {
    private Sovelluslogiikka sovelluslogiikka;
    private JTextField syotekentta, tuloskentta;
    private int edellinenlisays;

    public Summa(Sovelluslogiikka sovelluslogiikka, JTextField tuloskentta, JTextField syotekentta) {
        this.sovelluslogiikka = sovelluslogiikka;
        this.syotekentta = syotekentta;
        this.tuloskentta = tuloskentta;
        this.edellinenlisays = 0;
    }

    @Override
    public void suorita() {
        this.sovelluslogiikka.plus(syote());
        this.tuloskentta.setText("" + this.sovelluslogiikka.tulos());
    }

    private int syote() {
        int syote = 0;
        try {
            syote = Integer.parseInt(this.syotekentta.getText());
            this.edellinenlisays = syote;
        } catch (NumberFormatException e) {
            System.out.println("Syötteen on oltava numero");
        }
        return syote;
    }

    @Override
    public void peru() {
        this.sovelluslogiikka.miinus(this.edellinenlisays);
        this.tuloskentta.setText("" + this.sovelluslogiikka.tulos());
    }
}
