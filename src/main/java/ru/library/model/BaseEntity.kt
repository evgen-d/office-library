package ru.library.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

@Getter @Setter
@MappedSuperclass
public class BaseEntity<T extends Serializable> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID")
    private T id;

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP", updatable = false, nullable = false)
    @Schema(description = "Create at Timestamp")
    ZonedDateTime created;

    @UpdateTimestamp
    @Column(columnDefinition = "TIMESTAMP", nullable = false)
    @Schema(description = "Update at Timestamp")
    ZonedDateTime modified;

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntity<?> that = (BaseEntity<?>) o;

        return Objects.equals(id, that.id);
    }
}
