package Farmacia;

import java.util.ArrayList;

public class Pessoa {

    private String nome;
    private String sintoma;
    private ArrayList<Medicamento> medicamentosPrescritos;

    public Pessoa(String nome, String sintoma) {
        this.nome = nome;
        this.sintoma = sintoma;
        this.medicamentosPrescritos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getSintoma() {
        return sintoma;
    }

    public ArrayList<Medicamento> getMedicamentosPrescritos() {
        return medicamentosPrescritos;
    }

    public static Pessoa encontrarPessoa(ArrayList<Pessoa> listaPessoas, String nome) {
        for (Pessoa p : listaPessoas) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    public void prescreverMedicamentoPessoas(Medicamento medicamento) {
        for (String indicacao : medicamento.getIndicacoes()) {
            if (indicacao.equalsIgnoreCase(getSintoma())) {
                System.out.println("O sintoma " + getSintoma() + " já faz parte das indicações do medicamento " + medicamento.getNome());
                return;
            }
        }
    }
}
