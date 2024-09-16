package modelos;

import java.util.Objects;

public class CalificacionModelo {

    private int idCalificacion;
    private int idAlumno;
    private int idDocente;
    private MateriaModelo materia;
    private GrupoModelo grupo;
    private Float p1U1;
    private Float p2U1;
    private Float p3U1;
    private Float p4U1;
    private Float p1U2;
    private Float p2U2;
    private Float p3U2;
    private Float p4U2;
    private Float p1U3;
    private Float p2U3;
    private Float p3U3;
    private Float p4U3;
    private Float p1U4;
    private Float p2U4;
    private Float p3U4;
    private Float p4U4;
    private Float trabjoFinal;
    private Float promedioU1;
    private Float promedioU2;
    private Double promedioFinal;
    private Periodo periodo;

    public int getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(int idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public MateriaModelo getMateria() {
        return materia;
    }

    public void setMateria(MateriaModelo materia) {
        this.materia = materia;
    }

    public GrupoModelo getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoModelo grupo) {
        this.grupo = grupo;
    }

    public Float getP1U1() {
        return p1U1;
    }

    public void setP1U1(Float p1U1) {
        this.p1U1 = p1U1;
    }

    public Float getP2U1() {
        return p2U1;
    }

    public void setP2U1(Float p2U1) {
        this.p2U1 = p2U1;
    }

    public Float getP3U1() {
        return p3U1;
    }

    public void setP3U1(Float p3U1) {
        this.p3U1 = p3U1;
    }

    public Float getP4U1() {
        return p4U1;
    }

    public void setP4U1(Float p4U1) {
        this.p4U1 = p4U1;
    }

    public Float getP1U2() {
        return p1U2;
    }

    public void setP1U2(Float p1U2) {
        this.p1U2 = p1U2;
    }

    public Float getP2U2() {
        return p2U2;
    }

    public void setP2U2(Float p2U2) {
        this.p2U2 = p2U2;
    }

    public Float getP1U3() {
        return p1U3;
    }

    public void setP1U3(Float p1U3) {
        this.p1U3 = p1U3;
    }

    public Float getP3U2() {
        return p3U2;
    }

    public void setP3U2(Float p3U2) {
        this.p3U2 = p3U2;
    }

    public Float getP4U2() {
        return p4U2;
    }

    public void setP4U2(Float p4U2) {
        this.p4U2 = p4U2;
    }

    public Float getP2U3() {
        return p2U3;
    }

    public void setP2U3(Float p2U3) {
        this.p2U3 = p2U3;
    }

    public Float getP3U3() {
        return p3U3;
    }

    public void setP3U3(Float p3U3) {
        this.p3U3 = p3U3;
    }

    public Float getP4U3() {
        return p4U3;
    }

    public void setP4U3(Float p4U3) {
        this.p4U3 = p4U3;
    }

    public Float getP1U4() {
        return p1U4;
    }

    public void setP1U4(Float p1U4) {
        this.p1U4 = p1U4;
    }

    public Float getP2U4() {
        return p2U4;
    }

    public void setP2U4(Float p2U4) {
        this.p2U4 = p2U4;
    }

    public Float getP3U4() {
        return p3U4;
    }

    public void setP3U4(Float p3U4) {
        this.p3U4 = p3U4;
    }

    public Float getP4U4() {
        return p4U4;
    }

    public void setP4U4(Float p4U4) {
        this.p4U4 = p4U4;
    }

    public Float getTrabjoFinal() {
        return trabjoFinal;
    }

    public void setTrabjoFinal(Float trabjoFinal) {
        this.trabjoFinal = trabjoFinal;
    }

    public Float getPromedioU1() {
        return promedioU1;
    }

    public void setPromedioU1(Float promedioU1) {
        this.promedioU1 = promedioU1;
    }

    public Float getPromedioU2() {
        return promedioU2;
    }

    public void setPromedioU2(Float promedioU2) {
        this.promedioU2 = promedioU2;
    }

    public Double getPromedioFinal() {
        return promedioFinal;
    }

    public void setPromedioFinal(Double promedioFinal) {
        this.promedioFinal = promedioFinal;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.idCalificacion;
        hash = 83 * hash + this.idAlumno;
        hash = 83 * hash + this.idDocente;
        hash = 83 * hash + Objects.hashCode(this.materia);
        hash = 83 * hash + Objects.hashCode(this.grupo);
        hash = 83 * hash + Objects.hashCode(this.p1U1);
        hash = 83 * hash + Objects.hashCode(this.p2U1);
        hash = 83 * hash + Objects.hashCode(this.p3U1);
        hash = 83 * hash + Objects.hashCode(this.p4U1);
        hash = 83 * hash + Objects.hashCode(this.p1U2);
        hash = 83 * hash + Objects.hashCode(this.p2U2);
        hash = 83 * hash + Objects.hashCode(this.p3U2);
        hash = 83 * hash + Objects.hashCode(this.p4U2);
        hash = 83 * hash + Objects.hashCode(this.p1U3);
        hash = 83 * hash + Objects.hashCode(this.p2U3);
        hash = 83 * hash + Objects.hashCode(this.p3U3);
        hash = 83 * hash + Objects.hashCode(this.p4U3);
        hash = 83 * hash + Objects.hashCode(this.p1U4);
        hash = 83 * hash + Objects.hashCode(this.p2U4);
        hash = 83 * hash + Objects.hashCode(this.p3U4);
        hash = 83 * hash + Objects.hashCode(this.p4U4);
        hash = 83 * hash + Objects.hashCode(this.trabjoFinal);
        hash = 83 * hash + Objects.hashCode(this.promedioU1);
        hash = 83 * hash + Objects.hashCode(this.promedioU2);
        hash = 83 * hash + Objects.hashCode(this.promedioFinal);
        hash = 83 * hash + Objects.hashCode(this.periodo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CalificacionModelo other = (CalificacionModelo) obj;
        if (this.idCalificacion != other.idCalificacion) {
            return false;
        }
        if (this.idAlumno != other.idAlumno) {
            return false;
        }
        if (this.idDocente != other.idDocente) {
            return false;
        }
        if (!Objects.equals(this.materia, other.materia)) {
            return false;
        }
        if (!Objects.equals(this.grupo, other.grupo)) {
            return false;
        }
        if (!Objects.equals(this.p1U1, other.p1U1)) {
            return false;
        }
        if (!Objects.equals(this.p2U1, other.p2U1)) {
            return false;
        }
        if (!Objects.equals(this.p3U1, other.p3U1)) {
            return false;
        }
        if (!Objects.equals(this.p4U1, other.p4U1)) {
            return false;
        }
        if (!Objects.equals(this.p1U2, other.p1U2)) {
            return false;
        }
        if (!Objects.equals(this.p2U2, other.p2U2)) {
            return false;
        }
        if (!Objects.equals(this.p3U2, other.p3U2)) {
            return false;
        }
        if (!Objects.equals(this.p4U2, other.p4U2)) {
            return false;
        }
        if (!Objects.equals(this.p1U3, other.p1U3)) {
            return false;
        }
        if (!Objects.equals(this.p2U3, other.p2U3)) {
            return false;
        }
        if (!Objects.equals(this.p3U3, other.p3U3)) {
            return false;
        }
        if (!Objects.equals(this.p4U3, other.p4U3)) {
            return false;
        }
        if (!Objects.equals(this.p1U4, other.p1U4)) {
            return false;
        }
        if (!Objects.equals(this.p2U4, other.p2U4)) {
            return false;
        }
        if (!Objects.equals(this.p3U4, other.p3U4)) {
            return false;
        }
        if (!Objects.equals(this.p4U4, other.p4U4)) {
            return false;
        }
        if (!Objects.equals(this.trabjoFinal, other.trabjoFinal)) {
            return false;
        }
        if (!Objects.equals(this.promedioU1, other.promedioU1)) {
            return false;
        }
        if (!Objects.equals(this.promedioU2, other.promedioU2)) {
            return false;
        }
        if (!Objects.equals(this.promedioFinal, other.promedioFinal)) {
            return false;
        }
        return Objects.equals(this.periodo, other.periodo);
    }

    public Object[] toRowTable() {
        Float promedioU1 = obtenerPromedioUnidad(this.getP1U1(), this.getP2U1(), this.getP3U1(), this.getP4U1());
        Float promedioU2 = obtenerPromedioUnidad(this.getP1U2(), this.getP2U2(), this.getP3U2(), this.getP4U2());

        Float promedioU3 = obtenerPromedioUnidad(this.getP1U3(), this.getP2U3(), this.getP3U3(), this.getP4U3());
        Float promedioU4 = obtenerPromedioUnidad(this.getP1U4(), this.getP2U4(), this.getP3U4(), this.getP4U4());

        if (promedioU1 != null && this.getTrabjoFinal() != null) {
            this.setPromedioFinal((double) obtenerPromedioUnidad(promedioU1, promedioU2, promedioU3, promedioU4, this.getTrabjoFinal()));
        }

        return new Object[]{
            this.getMateria().getSemestre(),
            this.periodo.getNombre(),
            this.getMateria().getNombre(),
            (this.getP1U1() == null) ? "" : this.getP1U1(),
            (this.getP2U1() == null) ? "" : this.getP2U1(),
            (this.getP3U1() == null) ? "" : this.getP3U1(),
            (this.getP4U1() == null) ? "" : this.getP4U1(),
            (promedioU1 == null) ? "" : String.format("%.2f", promedioU1),
            (this.getP1U2() == null) ? "" : this.getP1U2(),
            (this.getP2U2() == null) ? "" : this.getP2U2(),
            (this.getP3U2() == null) ? "" : this.getP3U2(),
            (this.getP4U2() == null) ? "" : this.getP4U2(),
            (promedioU2 == null) ? "" : String.format("%.2f", promedioU2),
            (this.getP1U3() == null) ? "" : this.getP1U3(),
            (this.getP2U3() == null) ? "" : this.getP2U3(),
            (this.getP3U3() == null) ? "" : this.getP3U3(),
            (this.getP4U3() == null) ? "" : this.getP4U3(),
            (promedioU3 == null) ? "" : String.format("%.2f", promedioU3),
            (this.getP1U4() == null) ? "" : this.getP1U4(),
            (this.getP2U4() == null) ? "" : this.getP2U4(),
            (this.getP3U4() == null) ? "" : this.getP3U4(),
            (this.getP4U4() == null) ? "" : this.getP4U4(),
            (promedioU4 == null) ? "" : String.format("%.2f", promedioU4),
            (this.getTrabjoFinal() == null) ? "" : this.getTrabjoFinal(),
            (this.getPromedioFinal() == null) ? "" : String.format("%.2f", this.getPromedioFinal())};
    }

    public Float obtenerPromedioUnidad(Float... unidades) {
        float promedio = (float) 0.0;
        float unidadesConPromedio = 0;
        int contador = 0;

        while (contador < unidades.length) {
            if (unidades[contador] != null) {
                promedio += unidades[contador];
                unidadesConPromedio++;
            }
            contador++;
        }

        return unidadesConPromedio == 0 ? null : promedio / unidadesConPromedio;
    }

    public void establecerPromedioFinal() {
        Float promedioU1 = obtenerPromedioUnidad(this.getP1U1(), this.getP2U1(), this.getP3U1(), this.getP4U1());
        Float promedioU2 = obtenerPromedioUnidad(this.getP1U2(), this.getP2U2(), this.getP3U2(), this.getP4U2());

        Float promedioU3 = obtenerPromedioUnidad(this.getP1U3(), this.getP2U3(), this.getP3U3(), this.getP4U3());
        Float promedioU4 = obtenerPromedioUnidad(this.getP1U4(), this.getP2U4(), this.getP3U4(), this.getP4U4());

        if (promedioU1 != null && this.getTrabjoFinal() != null) {
            this.setPromedioFinal((double) obtenerPromedioUnidad(promedioU1, promedioU2, promedioU3, promedioU4, this.getTrabjoFinal()));
        }
    }

}
