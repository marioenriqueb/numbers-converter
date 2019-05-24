package com.exercise.conf;

import com.exercise.dao.UserDao;
import com.exercise.domain.User;
import com.exercise.domain.UserPermission;
import com.exercise.domain.enumeration.Permission;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * Created by mario on 24/05/2019.
 */
@Component
public class DbInitializer implements CommandLineRunner {
    private UserDao dao;

    public DbInitializer(UserDao dao){
        this.dao = dao;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.dao.deleteAll();
        User user = new User();
        user.setUserName("master");
        user.setPassword("password");

        UserPermission master = new UserPermission();
        master.setPermission(Permission.MASTER);
        master.setUserName(user.getUserName());
        user.getPermisos().add(master);

        this.dao.save(user);
        System.out.println(" -- Database has been initialized");
    }
}
