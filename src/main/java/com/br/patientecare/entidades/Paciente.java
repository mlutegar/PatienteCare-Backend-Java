package entidades;

import java.util.List;

public class Paciente {
    private String nomeCompleto;
    private String genero;
    private String dataNascimento;
    private String contato;
    private String email;
    private String cpf;
    private String rg;

    private List<String> alergias;
    private List<String> medicamentosEmUso;
    private List<String> condicoesPreexistentes;
}
