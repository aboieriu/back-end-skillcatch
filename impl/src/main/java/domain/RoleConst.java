package domain;

import java.util.Arrays;

/**
 * Created by aboieriu on 7/2/16.
 */
public enum RoleConst {
    ROLE_ADMIN,
    ROLE_DEV,
    ROLE_USER;

    public static boolean contains(String targetValue){
        if(targetValue==null){
            return false;
        }
        return Arrays.stream(RoleConst.values()).anyMatch(item->item.name().equalsIgnoreCase(targetValue));
    }
}