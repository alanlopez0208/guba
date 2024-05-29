package modelos;

public class CalificacionModelo {

    private String semestre;
    private String grupo;
    private String materia;
    private float u1P1;
    private float u1P2;
    private float u1P3;
    private float u2P1;
    private float u2P2;
    private float u2P3;
    private float trabajoFinal;

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }



    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public float getU1P1() {
        return u1P1;
    }

    public void setU1P1(float u1P1) {
        this.u1P1 = u1P1;
    }

    public float getU1P2() {
        return u1P2;
    }

    public void setU1P2(float u1P2) {
        this.u1P2 = u1P2;
    }

    public float getU1P3() {
        return u1P3;
    }

    public void setU1P3(float u1P3) {
        this.u1P3 = u1P3;
    }

    public float getU2P1() {
        return u2P1;
    }

    public void setU2P1(float u2P1) {
        this.u2P1 = u2P1;
    }

    public float getU2P2() {
        return u2P2;
    }

    public void setU2P2(float u2P2) {
        this.u2P2 = u2P2;
    }

    public float getU2P3() {
        return u2P3;
    }

    public void setU2P3(float u2P3) {
        this.u2P3 = u2P3;
    }

    public float getTrabajoFinal() {
        return trabajoFinal;
    }

    public void setTrabajoFinal(float trabajoFinal) {
        this.trabajoFinal = trabajoFinal;
    }

    public Object[] toRowTable() {
        return new Object[]{this.getSemestre(), this.getGrupo(), this.getMateria(),
            this.getU1P1(), this.getU1P2(), this.getU1P3(),
            this.getU2P1(), this.getU2P2(), this.getU2P3(),
            this.getTrabajoFinal()};
    }
}
