package com.rsrj.coursewebservices.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rsrj.coursewebservices.entities.enums.OrderStatus;

@Entity
/*Caso o nome da tabela seja deixado como Order, dá erro porque entra em conflito com
 * o comando Order*/
@Table(name = "tb_order")
public class Order implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	/*Para garantir o valor a ser salvo no banco de dados será inteiro
	 * Mas as classes irão enxergar externamente como OrderStatus*/
	private Integer orderStatus;

	/* Necessário associar as classes para criar a relação de chaves estrangeiras 
	 * no banco de dados*/
	@ManyToOne
	/* O Jpa já faz a associação com a primary key da classe User no banco de dados,
	 * quando a requisição é feita e o banco de dados é chamado, automaticamente faz 
	 * o left outer join para recuperar o registro correspondente do User relacionado 
	 * com id do User presente em Order*/
	@JoinColumn(name = "client_id")
	private User client;
	
	/*Define o mapeamento com o ponto para identificar o elemento interior à classe
	 * ou seja, encontra o atributo id e acessa o atributo order interno ao id.*/
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<OrderItem>();
	
	/*Cascade mapeia os Id do pagamento e do pedido com o mesmo Id*/
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;
	
	public Order() {
		
	}

	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
		super();
		this.id = id;
		this.moment = moment;
		this.client = client;
		setOrderStatus(orderStatus);
	}
	
	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if (orderStatus != null) {
			this.orderStatus = orderStatus.getCode();
		}
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public Set<OrderItem> getItems(){
		return items;
	}
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	//Hash code and equals para o id
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	
}
