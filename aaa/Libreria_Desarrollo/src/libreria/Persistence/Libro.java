/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.Persistence;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "libro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l")
    , @NamedQuery(name = "Libro.findByIdLibro", query = "SELECT l FROM Libro l WHERE l.idLibro = :idLibro")
    , @NamedQuery(name = "Libro.findByNombre", query = "SELECT l FROM Libro l WHERE l.nombre = :nombre")
    , @NamedQuery(name = "Libro.findByImprenta", query = "SELECT l FROM Libro l WHERE l.imprenta = :imprenta")
    , @NamedQuery(name = "Libro.findByCapitulos", query = "SELECT l FROM Libro l WHERE l.capitulos = :capitulos")
    , @NamedQuery(name = "Libro.findByNroPaginas", query = "SELECT l FROM Libro l WHERE l.nroPaginas = :nroPaginas")
    , @NamedQuery(name = "Libro.findByGenero", query = "SELECT l FROM Libro l WHERE l.genero = :genero")})
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idLibro")
    private Integer idLibro;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Imprenta")
    private String imprenta;
    @Basic(optional = false)
    @Column(name = "Capitulos")
    private int capitulos;
    @Basic(optional = false)
    @Column(name = "nroPaginas")
    private int nroPaginas;
    @Basic(optional = false)
    @Column(name = "Genero")
    private String genero;
    @JoinColumn(name = "idAutor", referencedColumnName = "idAutor")
    @ManyToOne(optional = false)
    private Autor idAutor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLibro")
    private Collection<Venta> ventaCollection;

    public Libro() {
    }

    public Libro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public Libro(Integer idLibro, String nombre, String imprenta, int capitulos, int nroPaginas, String genero) {
        this.idLibro = idLibro;
        this.nombre = nombre;
        this.imprenta = imprenta;
        this.capitulos = capitulos;
        this.nroPaginas = nroPaginas;
        this.genero = genero;
    }

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImprenta() {
        return imprenta;
    }

    public void setImprenta(String imprenta) {
        this.imprenta = imprenta;
    }

    public int getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(int capitulos) {
        this.capitulos = capitulos;
    }

    public int getNroPaginas() {
        return nroPaginas;
    }

    public void setNroPaginas(int nroPaginas) {
        this.nroPaginas = nroPaginas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Autor getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Autor idAutor) {
        this.idAutor = idAutor;
    }

    @XmlTransient
    public Collection<Venta> getVentaCollection() {
        return ventaCollection;
    }

    public void setVentaCollection(Collection<Venta> ventaCollection) {
        this.ventaCollection = ventaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLibro != null ? idLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.idLibro == null && other.idLibro != null) || (this.idLibro != null && !this.idLibro.equals(other.idLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "libreria.Persistence.Libro[ idLibro=" + idLibro + " ]";
    }
    
}
