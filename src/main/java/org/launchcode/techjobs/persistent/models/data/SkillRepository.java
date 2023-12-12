package org.launchcode.techjobs.persistent.models.data;

import org.launchcode.techjobs.persistent.models.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SkillRepository extends CrudRepository<Skill, Integer> {
   // Iterable<Skill> findAllById(List<Integer> skills);
    // Additional custom query methods can be added here if needed
}
