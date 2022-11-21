/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "celulares")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Celulares.findAll", query = "SELECT c FROM Celulares c")
    , @NamedQuery(name = "Celulares.findByIdcelular", query = "SELECT c FROM Celulares c WHERE c.idcelular = :idcelular")
    , @NamedQuery(name = "Celulares.findByTipoCelular", query = "SELECT c FROM Celulares c WHERE c.tipoCelular = :tipoCelular")
    , @NamedQuery(name = "Celulares.findByMarca", query = "SELECT c FROM Celulares c WHERE c.marca = :marca")
    , @NamedQuery(name = "Celulares.findByModelo", query = "SELECT c FROM Celulares c WHERE c.modelo = :modelo")
    , @NamedQuery(name = "Celulares.findByPrecio", query = "SELECT c FROM Celulares c WHERE c.precio = :precio")})
public class Celulares implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcelular")
    public Integer idcelular;
    @Basic(optional = false)
    @Column(name = "tipo_celular")
    private String tipoCelular;
    @Basic(optional = false)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @Column(name = "precio")
    private int precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcelular")
    private List<Factura> facturaList;

    public Celulares() {
    }

    public Celulares(Integer idcelular) {
        this.idcelular = idcelular;
    }

    public Celulares(Integer idcelular, String tipoCelular, String marca, String modelo, int precio) {
        this.idcelular = idcelular;
        this.tipoCelular = tipoCelular;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public Integer getIdcelular() {
        return idcelular;
    }

    public void setIdcelular(Integer idcelular) {
        this.idcelular = idcelular;
    }

    public String getTipoCelular() {
        return tipoCelular;
    }

    public void setTipoCelular(String tipoCelular) {
        this.tipoCelular = tipoCelular;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcelular != null ? idcelular.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Celulares)) {
            return false;
        }
        Celulares other = (Celulares) object;
        if ((this.idcelular == null && other.idcelular != null) || (this.idcelular != null && !this.idcelular.equals(other.idcelular))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Celulares[ idcelular=" + idcelular + " ]";
    }
    
}
