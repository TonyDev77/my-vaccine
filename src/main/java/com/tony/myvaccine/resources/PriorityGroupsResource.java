package com.tony.myvaccine.resources;

import com.tony.myvaccine.domain.Patient;
import com.tony.myvaccine.domain.PriorityGroups;
import com.tony.myvaccine.repository.PriorityGroupsRepository;
import com.tony.myvaccine.services.PriorityGroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/groups")
public class PriorityGroupsResource {

    @Autowired
    private PriorityGroupsRepository priorityGroupsRepository;
    @Autowired
    private PriorityGroupsService priorityGroupsService;

    @GetMapping
    public List<PriorityGroups> findAll() {
        List<PriorityGroups> allProducts = priorityGroupsRepository.findAll();
        return allProducts;
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<PriorityGroups> findById(@PathVariable Long groupId) {
        Optional<PriorityGroups> group = priorityGroupsRepository.findById(groupId);
        if (group.isPresent()) {
            return ResponseEntity.ok(group.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PriorityGroups saveGroup(@RequestBody PriorityGroups group) {
        return priorityGroupsService.saveGroup(group);
    }


}
