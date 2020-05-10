/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.trainermvc.services;

import java.util.List;
import org.afdemp.trainermvc.dao.TrainerDaoImpl;
import org.afdemp.trainermvc.entities.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ticho
 */
@Service("trainerService")
@Transactional
public class TrainerImpl implements ITrainer {

    @Autowired
    TrainerDaoImpl dao;

    public List<Trainer> findAllTrainers() {
        List<Trainer> trainers = dao.findAllTrainers();
        return trainers;
    }

    public Trainer findById(int id) {
        return dao.findById(id);
    }

    public boolean save(Trainer trainer) {
        return dao.save(trainer);
    }

    public boolean delete(int id) {
        return dao.delete(id);
    }

    public boolean update(Trainer trainer) {
        dao.update(trainer);
        return true;
    }

}
