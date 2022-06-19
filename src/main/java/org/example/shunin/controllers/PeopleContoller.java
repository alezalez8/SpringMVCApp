package org.example.shunin.controllers;

import javax.validation.Valid;

import org.example.shunin.models.Person;
import org.example.shunin.services.ItemService;
import org.example.shunin.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleContoller {

    private final PeopleService peopleService;
    private final ItemService itemService;

    @Autowired
    public PeopleContoller(PeopleService peopleService, ItemService itemService) {

        this.peopleService = peopleService;
        this.itemService = itemService;
    }

    @GetMapping()
    public String index(Model model) {
       // model.addAttribute("people", personDAO.index());
        model.addAttribute("people", peopleService.findAll());

        itemService.findByItemName("Airpods");
        itemService.findByOwner(peopleService.findAll().get(0));

        peopleService.test();
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        //model.addAttribute("person", personDAO.show(id));
        model.addAttribute("person", peopleService.findOne(id));
        return "people/show";
    }


    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }


    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/new";

        //personDAO.save(person);
        peopleService.save(person);
        return "redirect:/people";
    }


    @GetMapping("/{id}/edit")  // получаем тело из базы и запихиваем в модель
    public String edit(Model model, @PathVariable("id") int id) {
       // model.addAttribute("person", personDAO.show(id));
        model.addAttribute("person", peopleService.findOne(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if(bindingResult.hasErrors())
            return "people/edit";
        //personDAO.update(id, person);
        peopleService.update(person, id);
        return "redirect:/people";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") int id) {
        //personDAO.delete(id);
        peopleService.delete(id);
        return "redirect:/people";
    }
}
