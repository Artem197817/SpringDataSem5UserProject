package gb.SpringDataSem5.service;

import gb.SpringDataSem5.model.Project;
import gb.SpringDataSem5.model.User;
import gb.SpringDataSem5.model.UsersProject;
import gb.SpringDataSem5.repositories.ProjectRepository;
import gb.SpringDataSem5.repositories.UserRepositoriy;
import gb.SpringDataSem5.repositories.UsersProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserProjectService {

    private final UsersProjectRepository usersProjectRepository;
    private final UserRepositoriy userRepositoriy;
    private final ProjectRepository projectRepository;

    /**
     * метод, возвращающий список пользователей, связанных с определенным проектом
     */
    public List<User> getUsersByProjectId(Long projectId) {
        List<Long> listUserId = usersProjectRepository.findAllUserIdByProjectId(projectId);
        List<User> users = listUserId.stream()
                .map(userId -> userRepositoriy.findById(userId).get()).toList();
        if (users.isEmpty())
            return new ArrayList<>();
        return users;
    }

    /**
     * метод, возвращающий список проектов, связанных с определенным пользователем
     */
    public List<Project> getProjectsByUserId(Long userId) {
        List<Long> listProjectId = usersProjectRepository.findAllProjectIdByUserId(userId);
        return listProjectId.stream()
                .map(projectId -> projectRepository.findById(projectId).get())
                .collect(Collectors.toList());
    }

    /**
     * метод, добавляющий пользователя к проекту
     */
    public void addUserToProject(Long userId, Long projectId) {
        UsersProject usersProject = new UsersProject(projectId, userId);
        usersProjectRepository.save(usersProject);
    }

    /**
     * метод, удаляющий пользователя из проекта
     */
    public void removeUserFromProject(Long userId, Long projectId) {
        UsersProject.UserProjectID userProjectID= new UsersProject.UserProjectID(projectId,userId);
        usersProjectRepository.deleteById(userProjectID);

    }

    public List<UsersProject> findAll() {
        return usersProjectRepository.findAll();
    }
}
