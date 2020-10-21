package ru.library.repository

import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import ru.library.model.Tag

@RepositoryRestResource(collectionResourceRel = "catalogs", path = "catalogs")
interface TagRepository : CrudRepository<Tag, Long>, JpaSpecificationExecutor<Tag>