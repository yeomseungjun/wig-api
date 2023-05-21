package kr.co.lucas.wigapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name="user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {
    @Id
    private String seq;
    private String user_id;
    private String user_pass;
}
