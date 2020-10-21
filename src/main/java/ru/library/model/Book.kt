package ru.library.model

import io.swagger.v3.oas.annotations.media.Schema
import javax.persistence.*

@Entity
@Table(name = "book")
@Schema(description = "Book")
class Book(
        @Schema(description = "Book title", required = true)
        var title: String,

        @ManyToMany
        @JoinTable(name = "books_tags",
                joinColumns = [JoinColumn(name = "book_id")],
                inverseJoinColumns = [JoinColumn(name = "tag_id")])
        @Schema(description = "Book tags")
        val tags: MutableList<Tag>,

        @ManyToMany
        @JoinTable(name = "books_authors",
                joinColumns = [JoinColumn(name = "book_id")],
                inverseJoinColumns = [JoinColumn(name = "author_id")])
        @Schema(description = "Book's authors")
        val authors: MutableList<Author>
) : BaseEntity<Long>()