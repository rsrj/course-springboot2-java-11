package com.rsrj.coursewebservices.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rsrj.coursewebservices.entities.pk.OrderItemPK;


@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable{
	 static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private OrderItemPK id = new OrderItemPK();
	
	private Integer quantity;
	private Double price;
	
	public OrderItem() {
		
	}

	public OrderItem( Order order, Product product, Integer quantity, Double price) {
		super();
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}
	
	/*Para o mundo exterior não há OrdemItemPK, apenas Order e Product*/
	/*O getOrder é quem chama o pedido através do Jackson. Por isso se
	 * usa o JsonIgnore para não provocar o loop*/
	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}
	
	public void setOrder(Order order) {
		 id.setOrder(order);
	}
	
	
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setProduct(Product product) {
		 id.setProduct(product);
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	
	/*O get permite que o Java EE identifique o subtotal como atributo e imprima
	 * no Json quando for feita a requisição*/
	public Double getSubTotal() {	
		return price*quantity;
	}
	
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
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}

	
}
