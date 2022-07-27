package db;

import java.util.ArrayList;

public class IntMemoryDB {
    private static ArrayList<User> userDatabase = new ArrayList();

    public static boolean registerUser(User newUser){
        if (findUser(newUser.getNic())!=null) return false;
        /*for (User user : userDatabase) {
            if (user.getNic().equalsIgnoreCase(newUser.getNic())) return false;
        }*/
        userDatabase.add(newUser);
        return true;
    }

    public static User findUser(String nic){
        for (User user : userDatabase) {
            if (user.getNic().equalsIgnoreCase(nic)) return user;
        }
        return null;
    }

    public static void removeUser(String nic){
        User user = findUser(nic);
        if (user!=null) userDatabase.remove(user);
        /*for (User user : userDatabase) {
            if (user.getNic().equals(nic)){
                userDatabase.remove(user);
                return;
            }
        }*/
    }

    public static ArrayList<User> getUserDatabase(){
        return userDatabase;
    }
}
