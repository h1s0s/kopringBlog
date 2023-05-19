package com.example.kopringBlog.common

import lombok.Getter
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@Getter
@EntityListeners(AuditingEntityListener::class)
@MappedSuperclass
open class BaseEntity {

    @CreatedDate
    open val createdDt: LocalDateTime? = null

    @LastModifiedDate
    open val updatedDt: LocalDateTime? = null
}