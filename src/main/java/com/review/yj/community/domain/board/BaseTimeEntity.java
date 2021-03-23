package com.review.yj.community.domain.board;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "MMMM DD, YYYY h:mm a", timezone = "Asia/Seoul")
    @CreatedDate
    @Column(name = "createdDate")
    private LocalDateTime createdDate;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "MMMM DD, YYYY h:mm a", timezone = "Asia/Seoul")
    @LastModifiedDate
    @Column(name = "modifiedDate")
    private LocalDateTime modifiedDate;
}
