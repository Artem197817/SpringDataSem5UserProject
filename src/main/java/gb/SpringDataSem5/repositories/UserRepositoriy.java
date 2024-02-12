package gb.SpringDataSem5.repositories;

import gb.SpringDataSem5.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoriy extends JpaRepository <User,Long> {
}
