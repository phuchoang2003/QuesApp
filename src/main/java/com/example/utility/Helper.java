package com.example.utility;

import com.example.entity.History;

import java.util.List;

public class Helper {
    public static int parseId(String idParameter) {
        try {
            return Integer.parseInt(idParameter);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static <T> String supportINClause(List<T> lists) {
        if (lists.isEmpty()) {
            throw new IllegalArgumentException("Cannot generate IN clause for empty list");
        }

        StringBuilder inClause = new StringBuilder(" IN (");
        for (int i = 0; i < lists.size(); i++) {
            inClause.append("?");
            if (i < lists.size() - 1) {
                inClause.append(",");
            }
        }

        inClause.append(")");

        return inClause.toString();
    }

}
