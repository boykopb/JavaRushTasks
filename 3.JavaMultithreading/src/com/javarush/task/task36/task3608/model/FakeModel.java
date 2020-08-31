package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model {
    private ModelData modelData;


    @Override
    public ModelData getModelData() {
        return this.modelData;
    }

    @Override
    public void loadUsers() {
        List<User> usersModelData = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            usersModelData.add(new User());
        }

        modelData.setUsers(usersModelData);
    }
}
