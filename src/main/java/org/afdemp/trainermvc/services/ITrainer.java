/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.trainermvc.services;

import java.util.List;
import org.afdemp.trainermvc.entities.Trainer;

/**
 *
 * @author ticho
 */
public interface ITrainer {

    public List<Trainer> findAllTrainers();

    public Trainer findById(int id);

    public boolean save(Trainer trainer);

    public boolean delete(int id);

    public boolean update(Trainer trainer);
}
