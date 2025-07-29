package com.book.store.infrastructure.entity;

import java.util.Objects;

import lombok.Getter;

@Getter
public class BaseInfraEntity<ID> {

    private ID id;

    public void setId(ID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof BaseInfraEntity<?> that))
            return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
