package programa;

import java.util.ArrayList;

public class Turma {


    private int anoLetivo, serie;
    private Aluno aluno;
    ArrayList<Aluno> listaAlunos;


    public Turma() {
        this.anoLetivo = 2022;
        this.listaAlunos = new ArrayList<Aluno>();
    }

    public int getAnoLetivo() {
        return this.anoLetivo;
    }

    public int getSerie() {
        return this.serie;
    }


    public void setAnoLetivo(int anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }


}



