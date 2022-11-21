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
@Table(name = "autor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autor.findAll", query = "SELECT a FROM Autor a")
    , @NamedQuery(name = "Autor.findByIdAutor", query = "SELECT a FROM Autor a WHERE a.idAutor = :idAutor")
    , @NamedQuery(name = "Autor.findByNombre", query = "SELECT a FROM Autor a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Autor.findByApellido", query = "SELECT a FROM Autor a WHERE a.apellido = :apellido")
    , @NamedQuery(name = "Autor.findByPais", query = "SELECT a FROM Autor a WHERE a.pais = :pais")
    , @NamedQuery(name = "Autor.findByCiudad", query = "SELECT a FROM Autor a WHERE a.ciudad = :ciudad")
    , @NamedQuery(name = "Autor.findByEstudio", query = "SELECT a FROM Autor a WHERE a.estudio = :estudio")})
public class Autor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idAutor")
    private Integer idAutor;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "Pais")
    private String pais;
    @Basic(optional = false)
    @Column(name = "Ciudad")
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "Estudio")
    private String estudio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAutor")
    private Collection<Libro> libroCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAutor")
    private Collection<Venta> ventaCollection;

    public Autor() {
    }

    public Autor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public Autor(Integer idAutor, String nombre, String apellido, String pais, String ciudad, String estudio) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pais = pais;
        this.ciudad = ciudad;
        this.estudio = estudio;
    }

    public Integer getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    @XmlTransient
    public Collection<Libro> getLibroCollection() {
        return libroCollection;
    }

    public void setLibroCollection(Collection<Libro> libroCollection) {
        this.libroCollection = libroCollection;
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
        hash += (idAutor != null ? idAutor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autor)) {
            return false;
        }
        Autor other = (Autor) object;
        if ((this.idAutor == null && other.idAutor != null) || (this.idAutor != null && !this.idAutor.equals(other.idAutor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "libreria.Persistence.Autor[ idAutor=" + idAutor + " ]";
    }
    
}
