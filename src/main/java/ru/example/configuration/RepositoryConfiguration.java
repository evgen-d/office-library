package ru.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import ru.example.model.Author;
import ru.example.model.Book;
import ru.example.model.Tag;

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
