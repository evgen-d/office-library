package ru.library.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import ru.library.model.Author;
import ru.library.model.Book;
import ru.library.model.Tag;

public class RepositoryConfiguration {

    @Bean
    public RepositoryRestConfigurer repositoryConfig() {
        return RepositoryRestConfigurer.withConfig(
                repositoryRestConfiguration -> {
                    repositoryRestConfiguration.exposeIdsFor(
                            Book.class,
                            Tag.class,
                            Author.class
                    );
                });
    }
}
