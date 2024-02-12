package gb.SpringDataSem5.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Идентификатор (id) типа Long, генерируемый автоматически при создании записи
 * Название проекта (name) типа String
 * Описание проекта (description) типа String
 * Дата создания (createdDate) типа LocalDate
 */
@Data
@Entity
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;
    private String name;
    private String description;
    private LocalDate createdDate;

}
