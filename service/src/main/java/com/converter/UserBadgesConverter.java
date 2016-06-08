package com.converter;

import com.view.UserBadgesView;
import model.Badge;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by amusat on 6/8/2016.
 */
public class UserBadgesConverter {
    public UserBadgesView convert(Badge badgeSet){
        if(badgeSet==null){
            return  null;
        }
        return new UserBadgesView(badgeSet.getId(),badgeSet.getName(),badgeSet.getDescription(),badgeSet.getPoints(),badgeSet.getImage());
    }

    public Set<UserBadgesView> convert(Set<Badge> badgeSet) {
        Set<UserBadgesView> response = new HashSet<>();
        if (badgeSet == null || badgeSet.isEmpty()) {
            return response;
        }

        for (Badge badgeItem : badgeSet) {
            response.add(this.convert(badgeItem));
        }

        return response;
    }
}
