package Farmacia;

import java.util.ArrayList;

public class Medicamento {

    private String nome;
    private ArrayList<String> indicacoes;

    public Medicamento(String nome, ArrayList<String> indicacoes) {
        this.nome = nome;
        this.indicacoes = indicacoes;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<String> getIndicacoes() {
        return indicacoes;
    }

    public static Medicamento encontrarMedicamento(ArrayList<Medicamento> listaMedicamentos, String nome) {
        for (Medicamento m : listaMedicamentos) {
            if (m.getNome().equalsIgnoreCase(nome)) {
                return m;
            }
        }
        return null;
    }
}
