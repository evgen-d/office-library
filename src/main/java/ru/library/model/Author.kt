package ru.library.model

import com.fasterxml.jackson.annotation.JsonIgnore
import io.swagger.v3.oas.annotations.media.Schema
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name = "author")
@Schema(description = "Author")
class Author(
        @Column(name = "first_name")
        @Schema(description = "First name", required = true)
        var firstName: String,

        @Column(name = "second_name")
        @Schema(description = "Second name")
        var secondName: String? = null,

        @Column(name = "last_name")
        @Schema(description = "Last name")
        var lastName: String? = null,

        @JsonIgnore
        @ManyToMany(mappedBy = "authors")
        val books: MutableList<Book>
) : BaseEntity<Long>()