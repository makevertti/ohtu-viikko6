package ohtu.komennot;

import ohtu.Sovelluslogiikka;

import javax.swing.*;

public class Nollaa implements Komento {
    private Sovelluslogiikka sovelluslogiikka;
    private JTextField syotekentta, tuloskentta;
    private int edellinenTulos;

    public Nollaa(Sovelluslogiikka sovelluslogiikka, JTextField tuloskentta, JTextField syotekentta) {
        this.sovelluslogiikka = sovelluslogiikka;
        this.syotekentta = syotekentta;
        this.tuloskentta = tuloskentta;
        this.edellinenTulos = 0;
    }

    @Override
    public void suorita() {
        this.edellinenTulos = this.sovelluslogiikka.tulos();
        this.sovelluslogiikka.nollaa();
        this.tuloskentta.setText("" + this.sovelluslogiikka.tulos());
    }

    @Override
    public void peru() {
        this.sovelluslogiikka.plus(this.edellinenTulos);
        this.tuloskentta.setText("" + this.sovelluslogiikka.tulos());
    }
}
