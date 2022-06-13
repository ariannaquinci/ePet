package service.factories;

import entities.User;
import service.Entity;

public class UserFactory implements Entity {
    @Override
    public User createObject() {
        return new User();
    }
}
