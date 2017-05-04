package com.erbal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageDTO<T> {

    private T entity;
    private String description;

    public MessageDTO(
            T entity,
            String description) {

        this.entity = entity;
        this.description = description;
    }
}