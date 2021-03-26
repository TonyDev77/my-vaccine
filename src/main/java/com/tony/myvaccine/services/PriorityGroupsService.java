package com.tony.myvaccine.services;

import com.tony.myvaccine.domain.PriorityGroups;
import com.tony.myvaccine.repository.PriorityGroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PriorityGroupsService {

    @Autowired
    private PriorityGroupsRepository priorityGroupsRepository;

    // add
    public PriorityGroups saveGroup(PriorityGroups groups) {

        PriorityGroups groupExists = priorityGroupsRepository.findByName(groups.getName());

        if (groupExists != null && groupExists.equals(groups)) {
            throw new RuntimeException("Já existe um grupo cadastrado com esse nome!");
        }

        return priorityGroupsRepository.save(groups);
    }

    // remove
    public void removeGroup(Long patientId) {
        priorityGroupsRepository.deleteById(patientId);
    }

}
