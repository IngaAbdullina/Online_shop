package com.itmo.onlineshop.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "customer_id")
  @NotNull(message = "не должно быть пустым")
  private Long customerId;

  @Column(name = "final_cost")
  @NotNull(message = "не должно быть пустым")
  private BigDecimal finalCost;

  @Column(name = "delivery_address")
  @NotNull(message = "не должно быть пустым")
  private String deliveryAddress;

  @Column(name = "created_time")
  @NotNull(message = "не должно быть пустым")
  private Date date;
}
