package com.exercise.adapter;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Adapter<E, D> {
    abstract E toEntity(D dto);
    abstract D toDto(E entity);

    public List<D> toDtoList(List<E> entities) {
        return entities.stream()
                .map(entity -> toDto(entity))
                .collect(Collectors.toList());
    }

    public List<E> toEntityList(List<D> dtos) {
        return dtos.stream()
                .map(dto -> toEntity(dto))
                .collect(Collectors.toList());
    }
}
