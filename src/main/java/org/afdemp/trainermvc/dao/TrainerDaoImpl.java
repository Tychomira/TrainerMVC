/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.trainermvc.dao;

import java.util.List;
import org.afdemp.trainermvc.entities.Trainer;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ticho
 */
@Repository("trainerDao")
public class TrainerDaoImpl extends AbstractDao<Integer, Trainer> implements ITrainerDao {

    public List<Trainer> findAllTrainers() {

        Criteria criteria = createEntityCriteria();
        return (List<Trainer>) criteria.list();

    }

    public Trainer findById(int id) {
        Trainer tr = getByKey(id);
        if (tr != null) {
            return tr;
        }
        return null;
    }

    public boolean save(Trainer trainer) {
        boolean notSaved = persist(trainer);
        if (notSaved) {
            return false;
        }
        return true;
    }

    public boolean delete(int id) {
        Trainer tr = getByKey(id);
        if (tr != null) {
            delete(tr);
        }
        if (getByKey(id) == null) {
            return true;
        }
        return false;

    }

    public boolean update(Trainer trainer) {
        Trainer db_trainer = findById(trainer.getId());
        if (db_trainer != null) {
            db_trainer.setFirstName(trainer.getFirstName());
            db_trainer.setLastName(trainer.getLastName());
            db_trainer.setSubject(trainer.getSubject());

            return save(db_trainer);
        } else {
            return false;
        }
    }
}
