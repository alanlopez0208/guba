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
    private Float trabjoFinal;
    private Float promedioU1;
    private Float promedioU2;
    private Double promedioFinal;

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.idCalificacion;
        hash = 47 * hash + this.idAlumno;
        hash = 47 * hash + this.idDocente;
        hash = 47 * hash + Objects.hashCode(this.materia);
        hash = 47 * hash + Objects.hashCode(this.grupo);
        hash = 47 * hash + Objects.hashCode(this.p1U1);
        hash = 47 * hash + Objects.hashCode(this.p2U1);
        hash = 47 * hash + Objects.hashCode(this.p3U1);
        hash = 47 * hash + Objects.hashCode(this.p4U1);
        hash = 47 * hash + Objects.hashCode(this.p1U2);
        hash = 47 * hash + Objects.hashCode(this.p2U2);
        hash = 47 * hash + Objects.hashCode(this.p3U2);
        hash = 47 * hash + Objects.hashCode(this.p4U2);
        hash = 47 * hash + Objects.hashCode(this.trabjoFinal);
        hash = 47 * hash + Objects.hashCode(this.promedioU1);
        hash = 47 * hash + Objects.hashCode(this.promedioU2);
        hash = 47 * hash + Objects.hashCode(this.promedioFinal);
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
        if (!Objects.equals(this.trabjoFinal, other.trabjoFinal)) {
            return false;
        }
        if (!Objects.equals(this.promedioU1, other.promedioU1)) {
            return false;
        }
        if (!Objects.equals(this.promedioU2, other.promedioU2)) {
            return false;
        }
        return Objects.equals(this.promedioFinal, other.promedioFinal);
    }

    public Object[] toRowTable() {
        Float promedioU1 = obtenerPromedioUnidad(this.getP1U1(), this.getP2U1(), this.getP3U1(), this.getP4U1());
        Float promedioU2 = obtenerPromedioUnidad(this.getP1U2(), this.getP2U2(), this.getP3U2(), this.getP4U2());
        if (promedioU1 != null && promedioU2 != null && this.getTrabjoFinal() != null) {
            this.setPromedioFinal((double) (promedioU1 + promedioU2 + this.getTrabjoFinal()) / 3);
        }

        return new Object[]{
            this.getGrupo().getSemestre(),
            this.getGrupo().getNombre(),
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

}
