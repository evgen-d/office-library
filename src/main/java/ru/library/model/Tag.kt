package ru.library.model

import com.fasterxml.jackson.annotation.JsonIgnore
import io.swagger.v3.oas.annotations.media.Schema
import javax.persistence.Entity
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name = "tag")
@Schema(description = "Tag")
class Tag(
        @Schema(description = "Tag name")
        var name: String,

        @JsonIgnore
        @ManyToMany(mappedBy = "tags")
        val books: MutableList<Book>
) : BaseEntity<Long>()