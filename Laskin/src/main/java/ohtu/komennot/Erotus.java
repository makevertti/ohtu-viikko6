package ohtu.komennot;

import ohtu.Sovelluslogiikka;

import javax.swing.*;

public class Erotus implements Komento {
    private Sovelluslogiikka sovelluslogiikka;
    private JTextField syotekentta, tuloskentta;
    private int edellinenVahennys;

    public Erotus(Sovelluslogiikka sovelluslogiikka, JTextField tuloskentta, JTextField syotekentta) {
        this.sovelluslogiikka = sovelluslogiikka;
        this.syotekentta = syotekentta;
        this.tuloskentta = tuloskentta;
        this.edellinenVahennys = 0;
    }

    @Override
    public void suorita() {
        this.sovelluslogiikka.miinus(syote());
        this.tuloskentta.setText("" + this.sovelluslogiikka.tulos());
    }

    private int syote() {
        int syote = 0;
        try {
            syote = Integer.parseInt(this.syotekentta.getText());
            this.edellinenVahennys = syote;
        } catch (NumberFormatException e) {
            System.out.println("Syötteen on oltava numero");
        }
        return syote;
    }

    @Override
    public void peru() {
        this.sovelluslogiikka.plus(this.edellinenVahennys);
        this.tuloskentta.setText("" + this.sovelluslogiikka.tulos());
    }
}
