package com.excercise.service;

import com.excercise.BaseTest;
import com.excercise.utils.TestUtils;
import com.exercise.domain.enumeration.Permission;
import com.exercise.dto.UserDto;
import com.exercise.exception.NumberConvertException;
import com.exercise.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by mario on 25/05/2019.
 */
public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService service;

    @Test
    public void createTest() throws NumberConvertException {
        // Before
        UserDto dto = TestUtils.createUserDto();

        // Test
        service.create(dto);

        // After
        UserDto actual = service.findByUserName(TestUtils.USER_NAME);
        Assert.assertEquals(actual.getNombre(), dto.getNombre());
        Assert.assertNull(actual.getPassword());
        Assert.assertEquals(actual.getPermisos().size(), dto.getPermisos().size());
    }

    @Test
    public void updateTest() throws NumberConvertException {
        // Before
        UserDto dto = service.create(TestUtils.createUserDto());
        dto.getPermisos().add(Permission.DECIMAL);

        // Test
        service.update(dto);

        // After
        UserDto actual = service.findByUserName(TestUtils.USER_NAME);
        Assert.assertEquals(actual.getNombre(), dto.getNombre());
        Assert.assertNull(actual.getPassword());
        Assert.assertEquals(3, dto.getPermisos().size());
    }

    @Test
    public void updateDeletePermissionTest() throws NumberConvertException {
        // Before
        UserDto dto = service.create(TestUtils.createUserDto());
        dto.getPermisos().remove(Permission.BINARIO);

        // Test
        service.update(dto);

        // After
        UserDto actual = service.findByUserName(TestUtils.USER_NAME);
        Assert.assertEquals(actual.getNombre(), dto.getNombre());
        Assert.assertNull(actual.getPassword());
        Assert.assertEquals(1, dto.getPermisos().size());
        Assert.assertEquals(actual.getPermisos().get(0), dto.getPermisos().get(0));
    }

    @Test
    public void deleteTest() throws NumberConvertException {
        // Before
        UserDto dto = service.create(TestUtils.createUserDto());
        UserDto actual = service.findByUserName(TestUtils.USER_NAME);
        Assert.assertEquals(actual.getNombre(), dto.getNombre());

        // Test
        service.delete(TestUtils.USER_NAME);

        // After
        actual = service.findByUserName(TestUtils.USER_NAME);
        Assert.assertNull(actual);
    }
}
