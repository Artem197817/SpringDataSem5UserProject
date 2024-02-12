package gb.SpringDataSem5.controller;

import gb.SpringDataSem5.model.Project;
import gb.SpringDataSem5.model.User;
import gb.SpringDataSem5.model.UsersProject;
import gb.SpringDataSem5.service.UserProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/user_project")
public class UserProjectController {


    private final UserProjectService userProjectService;

    /**
     * метод, возвращающий список пользователей, связанных с определенным проектом
     */
    @GetMapping("/project/{projectId}")
    public List<User> getUsersByProjectId(@PathVariable Long projectId) {
       return userProjectService.getUsersByProjectId(projectId);
    }

    /**
     *метод, возвращающий список проектов, связанных с определенным пользователем
     */
    @GetMapping("/user/{userId}")
    public List<Project> getProjectsByUserId(@PathVariable Long userId) {
      return userProjectService.getProjectsByUserId(userId);
    }
    /**
     *метод, добавляющий пользователя к проекту
     */
    @PostMapping("/add/{userId},{projectId}")
    public void addUserToProject(@PathVariable Long userId, @PathVariable Long projectId){
        userProjectService.addUserToProject(userId,projectId);
    }

    /**
     * метод, удаляющий пользователя из проекта
     */
    @DeleteMapping("/delete/{userId}/{projectId}")
    public void removeUserFromProject(@PathVariable Long userId, @PathVariable Long projectId) {
        userProjectService.removeUserFromProject(userId, projectId);
    }
    @GetMapping
    public List<UsersProject> findAll(){
        return userProjectService.findAll();
    }
}
