package com.itmo.onlineshop.db.entity;

import com.itmo.onlineshop.db.ProductType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  @Column(name = "name")
  private String name;

  @Enumerated(EnumType.STRING)
  @Column(name = "type")
  private ProductType type;

  @Column(name = "colour")
  private String colour;

  @Column(name = "size")
  private String size;

  @Column(name = "price")
  private double price;

  // todo decrement when item bought successfully
  // todo when == 0 then can't buy
  @Column(name = "quantity")
  private int quantity;

  @Column(name = "picture_url")
  private String pictureUrl;
}