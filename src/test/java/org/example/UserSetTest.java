package org.example; // Make sure this matches your package

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class UserSetTest {

    private UserSet userSet;

    @Before
    public void setUp() {
        userSet = new UserSet();
        userSet.addUser("user123");
        userSet.addUser("user456");
        userSet.addUser("test789");
    }

    @Test
    public void testAddUser_Success() {
        assertTrue(userSet.addUser("newuser"));
        assertTrue(userSet.containsUser("newuser"));
        assertEquals(4, userSet.getUserCount());
    }

    @Test
    public void testAddUser_Duplicate() {
        assertFalse(userSet.addUser("user123"));
        assertEquals(3, userSet.getUserCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddUser_Null() {
        userSet.addUser(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddUser_Empty() {
        userSet.addUser("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddUser_Whitespace() {
        userSet.addUser("   ");
    }

    @Test
    public void testRemoveUser_Success() {
        assertTrue(userSet.removeUser("user456"));
        assertFalse(userSet.containsUser("user456"));
        assertEquals(2, userSet.getUserCount());
    }

    @Test
    public void testRemoveUser_NotFound() {
        assertFalse(userSet.removeUser("nonexistent"));
        assertEquals(3, userSet.getUserCount());
    }

    @Test
    public void testContainsUser_Exists() {
        assertTrue(userSet.containsUser("user123"));
    }

    @Test
    public void testContainsUser_NotExists() {
        assertFalse(userSet.containsUser("nonexistent"));
    }

    @Test
    public void testGetUserCount() {
        assertEquals(3, userSet.getUserCount());
    }

    @Test
    public void testGetUsersWithPrefix_Found() {
        String[] expected = {"user123", "user456"};
        String[] actual = userSet.getUsersWithPrefix("user").toArray(new String[0]);
        Arrays.sort(expected);
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetUsersWithPrefix_NotFound() {
        String[] expected = {};
        String[] actual = userSet.getUsersWithPrefix("xyz").toArray(new String[0]);
        assertArrayEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetUsersWithPrefix_NullPrefix() {
        userSet.getUsersWithPrefix(null);
    }

    @Test
    public void testAreAllUsersUnique_True() {
        String[] arr = {"a", "b", "c", "d"};
        assertTrue(userSet.areAllUsersUnique(arr));
    }

    @Test
    public void testAreAllUsersUnique_False() {
        String[] arr = {"a", "b", "c", "a"};
        assertFalse(userSet.areAllUsersUnique(arr));
    }

    @Test
    public void testAreAllUsersUnique_EmptyArray() {
        String[] arr = {};
        assertTrue(userSet.areAllUsersUnique(arr)); // Empty array has no duplicates
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAreAllUsersUnique_NullArray() {
        String[] arr = null;
        userSet.areAllUsersUnique(arr);
    }
}