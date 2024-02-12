package gb.SpringDataSem5.repositories;

import gb.SpringDataSem5.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long> {
}
