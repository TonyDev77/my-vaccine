package com.tony.myvaccine.repository;

import com.tony.myvaccine.domain.PriorityGroups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriorityGroupsRepository extends JpaRepository<PriorityGroups, Long> {
}
