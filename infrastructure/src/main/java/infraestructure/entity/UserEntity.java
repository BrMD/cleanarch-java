package infraestructure.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import core.domain.enums.UserTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
public class UserEntity {

    @Column(name="Id", nullable=false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name="Email", nullable=false)
    private String email;

    @Column(name="Password", nullable=false)
    private String Password;

    @Column(name="TaxNumber", nullable=false)
    private String taxNumber;

    @Column(name="FullName", nullable=false)
    private String fullName;

    @Column(name="Type", nullable=false)
    @Enumerated(EnumType.STRING)
    private UserTypeEnum type;

    @Column(name="CreatedAt", nullable=false)
    private LocalDateTime createdAt;

    @Column(name="UpdateAt")
    private LocalDateTime updateAt; 
}
