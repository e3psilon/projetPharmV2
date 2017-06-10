package com.projetPharmV2.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="caisse")
//@Cacheable(value = true)
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Caisse implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCaisse;
	private BigDecimal totalCaisse;
	private Date date;
	@OneToMany(mappedBy = "caisse")
	private Collection<Transaction> transactions;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idUser",nullable=true,referencedColumnName="idUser")
	private User users;
	public Long getIdCaisse() {
		return idCaisse;
	}
	public void setIdCaisse(Long idCaisse) {
		this.idCaisse = idCaisse;
	}
	public BigDecimal getTotalCaisse() {
		return totalCaisse;
	}
	public void setTotalCaisse(BigDecimal totalCaisse) {
		this.totalCaisse = totalCaisse;
	}

	public Collection<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(Collection<Transaction> transactions) {
		this.transactions = transactions;
	}
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Caisse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Caisse(Long idCaisse, BigDecimal totalCaisse, Date date) {
		super();
		this.idCaisse = idCaisse;
		this.totalCaisse = totalCaisse;
		this.date = date;
	}



}
