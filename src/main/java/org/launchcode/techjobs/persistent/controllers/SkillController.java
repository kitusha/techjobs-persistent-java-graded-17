package org.launchcode.techjobs.persistent.controllers;




        import jakarta.validation.Valid;
        import org.launchcode.techjobs.persistent.models.Skill;
        import org.launchcode.techjobs.persistent.models.data.SkillRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.validation.Errors;
        import org.springframework.web.bind.annotation.*;


        import java.util.List;
        import java.util.Optional;

@Controller
@RequestMapping("skills")
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;

    @GetMapping
    public String index(Model model) {

        model.addAttribute("skills", skillRepository.findAll());
        model.addAttribute("skill", new Skill());  // For the "Add Skill" form
        return "skills/index";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                      Errors errors, Model model) {

        if (errors.hasErrors()) {

            model.addAttribute("skills", skillRepository.findAll());
            return "skills/index";
        }

        skillRepository.save(newSkill);  // Save the new skill
        return "redirect:/skills";
    }

    @GetMapping("/{skillId}")
    public String displayViewSkill(Model model, @PathVariable Integer skillId) {

        Optional<Skill> optSkill = skillRepository.findById(skillId);
        if (optSkill.isPresent()) {
            Skill skill = optSkill.get();
            model.addAttribute("skill", skill);
            return "skills/view";
        } else {
            return "redirect:/skills";
        }
    }
}

