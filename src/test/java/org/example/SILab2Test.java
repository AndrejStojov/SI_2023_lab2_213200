package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    private final User user1=new User("Andrej","password!","andrej@gmail.com");
    private final User user2=new User("Stojov","aeeaaaa@","stojov@gmail.com");
    private final List<User> allUser=new ArrayList<User>();

    @Test
    void everybranch() {
        RuntimeException exception;
        allUser.add(user1);
        allUser.add(user2);
        exception=assertThrows(RuntimeException.class, ()->SILab2.function(null,allUser));
        assertTrue(exception.getMessage().contains("Mandatory information missing!"));
        assertEquals(false,SILab2.function(new User(null,"password!","andrej@gmail.com"),allUser));
        assertEquals(false,SILab2.function(new User("Andrej","pas","andrejgmail.com"),allUser));
        assertEquals(false,SILab2.function(new User("Andrej","pas sword!","andrej@gmail.com"),allUser));
        assertEquals(false,SILab2.function(new User("Andrej","password!","andrej@gmail.com"),allUser));
    }
    @Test
    void MultipleCondition(){
        RuntimeException exception;
        allUser.add(user1);
        allUser.add(user2);

        exception=assertThrows(RuntimeException.class, ()->SILab2.function(null,allUser));
        assertTrue(exception.getMessage().contains("Mandatory information missing!"));

        exception=assertThrows(RuntimeException.class, ()->SILab2.function(new User("Andrej",null,"andrej@gmail.com"),allUser));
        assertTrue(exception.getMessage().contains("Mandatory information missing!"));

        exception=assertThrows(RuntimeException.class, ()->SILab2.function(new User("Andrej","password!",null),allUser));
        assertTrue(exception.getMessage().contains("Mandatory information missing!"));

        assertEquals(false, SILab2.function(new User("Andrej","password!","andrej@gmail.com"),allUser));

    }
}