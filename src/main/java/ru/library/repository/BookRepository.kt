package ru.library.repository

import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import ru.library.model.Book

@RepositoryRestResource(collectionResourceRel = "books", path = "books")
interface BookRepository : CrudRepository<Book, Long>, JpaSpecificationExecutor<Book>