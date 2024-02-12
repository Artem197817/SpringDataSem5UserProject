package gb.SpringDataSem5.repositories;


import gb.SpringDataSem5.model.UsersProject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersProjectRepository extends JpaRepository<UsersProject, UsersProject.UserProjectID> {

    List<Long> findAllUserIdByProjectId(Long projectId);
    List<Long> findAllProjectIdByUserId(Long userId);

    void deleteById(UsersProject.UserProjectID userProjectID);
}
