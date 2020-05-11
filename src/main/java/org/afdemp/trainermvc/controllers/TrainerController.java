/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.trainermvc.controllers;

import java.util.List;
import javax.validation.Valid;
import org.afdemp.trainermvc.entities.Trainer;
import org.afdemp.trainermvc.services.ITrainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listAllTrainers(ModelMap view, @RequestParam(required = false) String msg) {
        List<Trainer> trainers = trainerService.findAllTrainers();
        view.addAttribute("trainers", trainers);
        view.addAttribute("editurl", editurl);
        view.addAttribute("deleteurl", deleteurl);
        view.addAttribute("newurl", newurl);
        view.addAttribute("msg", msg);
        return ("trainerlist");
    }

    //get form for new trainer
    @RequestMapping("/new")
    public String newTrainer(ModelMap view) {
        Trainer trainer=new Trainer();
        view.addAttribute("trainer", trainer);
        view.addAttribute("listurl", listurl);
        return("newtrainer");
    } 
    
    
     // post form for new trainer
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveTrainer(@ModelAttribute("trainer") @Validated Trainer trainer, BindingResult bindingResult,ModelMap view) {
        if (bindingResult.hasErrors()) {
            return "newtrainer";
        }
        
        if(trainerService.save(trainer)) {
                   
         

		view.addAttribute("success", "Trainer " + trainer.getFirstName() + " "+ trainer.getLastName() + " registered successfully");
                return ("registrationsuccess");
        }
        else {
            
            view.addAttribute("message", new String("Something went wrong! Please try again! "));
        }
            view.addAttribute("listurl", listurl);
        return("newtrainer");
    }


    
      // delete for an existing trainer
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteTrainer(ModelMap view, @PathVariable int id) {
        if(trainerService.delete(id)) {
            view.addAttribute("msg", new String("Trainer deleted Successfully!"));
        } else {
            view.addAttribute("msg", new String("Trainer has not been Deleted!"));
        }
        return("redirect:/list");
    }
    
     // show edit / update for an existing trainer
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editTrainer(ModelMap view, @PathVariable int id) {
        Trainer trainer = trainerService.findById(id);
        view.addAttribute("trainer", trainer);
        view.addAttribute("updateurl", updateurl);
        return("edittrainer");
    }
    
     // store edit / update for an existing trainer
    @RequestMapping(value ="/edit/{id}" , method = RequestMethod.POST)
    public String updateTrainer(@Valid Trainer trainer, BindingResult result, ModelMap view,  @PathVariable int id) {
        
       
            if (result.hasErrors()) {
                   trainer.setId(id);
                   
        return ("edittrainer");
			
            }
               trainerService.update(trainer);
       
		view.addAttribute("success", "Trainer " + trainer.getFirstName() + " "+ trainer.getLastName() + " updated successfully");
		return ("registrationsuccess");
//        view.addAttribute("msg", new String(""));
//        return("redirect:/list");
    }
    
    
    }   


