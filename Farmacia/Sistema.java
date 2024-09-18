package Farmacia;

import java.util.ArrayList;

public class Sistema {

    private ArrayList<Medicamento> listaMedicamentos;
    private ArrayList<Pessoa> listaPessoas;

    public Sistema(ArrayList<Medicamento> listaMedicamentos, ArrayList<Pessoa> listaPessoas) {
        this.listaMedicamentos = listaMedicamentos;
        this.listaPessoas = listaPessoas;
    }

    public void cadastrarMedicamento(String nome, ArrayList<String> indicacoes) {
        Medicamento medicamento = new Medicamento(nome, indicacoes);
        listaMedicamentos.add(medicamento);
    }

    public void cadastrarPessoa(String nome, String sintoma) {
        Pessoa pessoa = new Pessoa(nome, sintoma);
        listaPessoas.add(pessoa);
    }

    public void prescreverMedicamento(String nomePessoa , String nomeMedicamento) {
        Pessoa pessoa = Pessoa.encontrarPessoa(listaPessoas , nomePessoa);
        Medicamento medicamento = Medicamento.encontrarMedicamento(listaMedicamentos , nomeMedicamento);

        if (pessoa != null && medicamento != null) {
            pessoa.prescreverMedicamentoPessoas(medicamento);
        } else {
            System.out.println("Pessoa ou Medicamento não encontrados.");
        }
    }

    public void listarPessoasComMedicamentos() {
        for (Pessoa pessoa : listaPessoas) {
            System.out.println(pessoa.getNome() + " (Sintoma: " + pessoa.getSintoma() + ")");
            ArrayList<Medicamento> medicamentosPrescritos = pessoa.getMedicamentosPrescritos();
            if (medicamentosPrescritos.isEmpty()) {
                System.out.println("Nenhum medicamento prescrito.");
            } else {
                for (Medicamento medicamento : medicamentosPrescritos) {
                    System.out.println("  Medicamento prescrito: " + medicamento.getNome());
                }
            }
        }
    }
}
