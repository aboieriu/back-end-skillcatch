package domain;

import java.util.Arrays;

/**
 * Created by aboieriu on 6/29/16.
 */
public enum TaskStatus {
    TODO,
    IN_PROGRESS,
    DONE;

    public static boolean contains(String targetValue) {
        if (null == targetValue) {
            return false;
        }
        return Arrays.stream(TaskStatus.values()).anyMatch(item -> item.name().equalsIgnoreCase(targetValue));
    }
}
