package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                return user;
            }
        }
        throw new UserNotFoundException("пользователя не найдено");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if ((user.getUsername().length() < 3) || (!user.isValid())) {
            throw new UserInvalidException("пользователь не валидный");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true), new User("Petr Arsentev2", false)
        };
        try {
            User user = findUser(users, "Petr Arsentev2");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            e.printStackTrace();
        } catch (UserNotFoundException en) {
            en.printStackTrace();
        }
    }
}