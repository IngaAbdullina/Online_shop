package com.itmo.onlineshop.db.entity;

import com.itmo.onlineshop.db.Address;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  @Column(name = "customer_id")
  private long customerId;

  @Column(name = "product_id")
  private long productId;

  @Column(name = "final_cost")
  private double finalCost;

  @Column(name = "delivery_address")
  private Address deliveryAddress;

  @Column(name = "created_time")
  private Date date;
}
