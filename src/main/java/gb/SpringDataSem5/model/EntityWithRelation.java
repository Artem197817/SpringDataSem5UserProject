package gb.SpringDataSem5.model;



import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Идентификатор (id) типа Long, генерируемый автоматически при создании записи
 * Идентификатор связанной сущности (relatedEntityId) типа Long
 */

@NoArgsConstructor
@Data
public abstract class EntityWithRelation {


    private Long id;
    private Long relatedEntityId;

    public EntityWithRelation(Long id, Long relatedEntityId) {
        this.id = id;
        this.relatedEntityId = relatedEntityId;
    }
}
