package gb.SpringDataSem5.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Идентификатор (id) типа Long, генерируемый автоматически при создании записи
 * Имя пользователя (username) типа String
 * Пароль (password) типа String
 * Электронная почта (email) типа String
 * Роль (role) типа String
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    @Email
    private String email;
    private String role;
}
