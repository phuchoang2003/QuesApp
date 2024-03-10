package com.example.utility;

import com.example.entity.Subject;
import com.example.entity.User;

public class Validate {
    public static boolean isInvalidRegisterUserData(User user) {
        return user.getEmail() == null || user.getEmail().trim().isEmpty() ||
                user.getUserName() == null || user.getUserName().trim().isEmpty() ||
                user.getPassword() == null || user.getPassword().trim().isEmpty();
    }

    public static boolean isInvalidLoginUserData(User user) {
        return user.getEmail() == null || user.getEmail().trim().isEmpty() ||
                user.getPassword() == null || user.getPassword().trim().isEmpty();
    }

    public static boolean isInvalidSubjectUserData(Subject subject) {
        return subject.getNameSubject() == null || subject.getNameSubject().trim().isEmpty();
    }


}
