/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.trainermvc.controllers;

import java.util.List;
import org.afdemp.trainermvc.entities.Trainer;
import org.afdemp.trainermvc.services.ITrainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ticho
 */
@Controller
@RequestMapping("/")
public class TrainerController {
    private String listurl = "list";
    private String editurl = "edit";
    private String deleteurl = "delete";
    private String updateurl = "update";
    private String newurl="new";
    
     @Autowired
    ITrainer trainerService;
    
    @Autowired
    MessageSource messageSource;
    
    //first page with the trainer's list
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listAllTrainers(ModelMap view, @RequestParam(required = false) String msg) {
        List<Trainer> trainers = trainerService.findAllTrainers();
        view.addAttribute("trainers", trainers);
        view.addAttribute("editurl", editurl);
        view.addAttribute("deleteurl", deleteurl);
        view.addAttribute("newurl", newurl);
        view.addAttribute("msg", msg);
        return("trainerlist");
    }
    
    
    
     // get form for new student
//    @RequestMapping("/new")
//    public String newTrainer(ModelMap view) {
//        Trainer trainer=new Trainer();
//        view.addAttribute("trainer", trainer);
//        view.addAttribute("listurl", listurl);
//        return("newstrainer");
//    }
//   
    
    
    
    
    
    
    
}
