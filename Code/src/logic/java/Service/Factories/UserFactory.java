package Service.Factories;

import Entities.User;
import Service.Entity;

public class UserFactory implements Entity {
    @Override
    public User createObject() {
        return new User();
    }
}
