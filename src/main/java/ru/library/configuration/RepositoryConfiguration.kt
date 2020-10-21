package ru.library.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
import ru.library.model.Author
import ru.library.model.Book
import ru.library.model.Tag

@Configuration
class RepositoryConfiguration {
    @Bean
    fun repositoryConfig(): RepositoryRestConfigurer {
        return RepositoryRestConfigurer.withConfig { repositoryRestConfiguration: RepositoryRestConfiguration ->
            repositoryRestConfiguration.exposeIdsFor(
                    Book::class.java,
                    Tag::class.java,
                    Author::class.java
            )
        }
    }
}