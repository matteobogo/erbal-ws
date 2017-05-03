package domain.dto;

import domain.BaseEntity;
import lombok.Data;

@Data
public class MessageDTO<T extends BaseEntity> {

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