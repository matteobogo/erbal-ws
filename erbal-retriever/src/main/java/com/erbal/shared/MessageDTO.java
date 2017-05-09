package com.erbal.shared;

import lombok.Data;

@Data
public class MessageDTO<T> {

  private T entity;
  private String description;

  public MessageDTO(
          T entity,
          String description) {

    this.entity = entity;
    this.description = description;
  }

  public T getEntity() { return this.entity; }
  public String getDescription() { return this.description; }
}