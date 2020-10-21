package ru.library.model

import io.swagger.v3.oas.annotations.media.Schema
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.io.Serializable
import java.time.ZonedDateTime
import java.util.*
import javax.persistence.*

@MappedSuperclass
abstract class BaseEntity<T : Serializable> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID")
    var id: T? = null

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP", updatable = false, nullable = false)
    @Schema(description = "Create at Timestamp")
    lateinit var created: ZonedDateTime

    @UpdateTimestamp
    @Column(columnDefinition = "TIMESTAMP", nullable = false)
    @Schema(description = "Update at Timestamp")
    lateinit var modified: ZonedDateTime

    override fun hashCode(): Int {
        return Objects.hashCode(id)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as BaseEntity<*>
        return id == that.id
    }
}