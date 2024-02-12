package gb.SpringDataSem5.model;


import jakarta.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Идентификатор проекта (projectId) типа Long
 * Идентификатор пользователя (userId) типа Long
 */
@Data
@Entity
@NoArgsConstructor
@IdClass(UsersProject.UserProjectID.class)
@EqualsAndHashCode(callSuper = true)
public class UsersProject extends EntityWithRelation {



    @Id
    private Long projectId;
    @Id
    private Long userId;

    public UsersProject(Long projectId, Long userId) {
        this.projectId = projectId;
        this.userId = userId;
    }

    @Override
    public Long getRelatedEntityId() {
        return super.getRelatedEntityId();
    }

    @Override
    public Long getId() {
        return super.getId();
    }

   // @Embeddable
    @Data
    @NoArgsConstructor
    @Component
    public static class UserProjectID {

        private Long projectId;
        private Long userId;

       public UserProjectID(Long projectId, Long userId) {
           this.projectId = projectId;
           this.userId = userId;
       }
   }
}