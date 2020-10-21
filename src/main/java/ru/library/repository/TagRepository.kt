package ru.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.library.model.Tag;

@RepositoryRestResource(collectionResourceRel = "catalogs", path = "catalogs")
public interface TagRepository extends JpaRepository<Tag, Long> {
}
