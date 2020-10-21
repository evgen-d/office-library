package ru.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "author")
@Getter @Setter
@Schema(description = "Author")
public class Author extends BaseEntity<Long> {
    @Column(name = "first_name")
    @Schema(description = "First name", required = true)
    private String firstName;
    @Column(name = "second_name")
    @Schema(description = "Second name")
    private String secondName;
    @Column(name = "last_name")
    @Schema(description = "Last name")
    private String lastName;

    @JsonIgnore
    @ManyToMany(mappedBy = "authors")
    private List<Book> books;
}
