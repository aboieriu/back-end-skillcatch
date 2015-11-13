package dao;

import model.Badge;
import model.Group;

/**
 * Created by CataVlad on 13-Nov-15.
 */
public interface IBadgeDao extends IGenericDao<Badge> {

    void updateBadge(Badge badge);
}
