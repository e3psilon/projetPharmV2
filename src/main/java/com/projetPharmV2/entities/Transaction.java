package com.projetPharmV2.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Transaction")
//@Cacheable(value = true)
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Transaction implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iDTransaction;
	private BigDecimal total;
	@NotNull
	private Date dateTransaction;
	private String information;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUser", nullable = false, referencedColumnName = "idUser")
	private User user;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idVente", nullable = false, referencedColumnName = "idVente")
	private Vente vente;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCaisse", nullable = false, referencedColumnName = "idCaisse")
	private Caisse caisse;

	public Long getiDTransaction() {
		return iDTransaction;
	}

	public void setiDTransaction(Long iDTransaction) {
		this.iDTransaction = iDTransaction;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Date getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public Vente getVente() {
		return vente;
	}

	public void setVente(Vente vente) {
		this.vente = vente;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Caisse getCaisse() {
		return caisse;
	}

	public void setCaisse(Caisse caisse) {
		this.caisse = caisse;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(BigDecimal total, Date dateTransaction, String information) {
		super();
		this.total = total;
		this.dateTransaction = dateTransaction;
		this.information = information;
	}

}
