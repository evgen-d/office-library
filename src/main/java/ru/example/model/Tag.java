package ru.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tag")
@Getter @Setter
@Schema(description = "Tag")
public class Tag extends BaseEntity<Long> {

    @Schema(description = "Tag name")
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "tags")
    private List<Book> books;
}
