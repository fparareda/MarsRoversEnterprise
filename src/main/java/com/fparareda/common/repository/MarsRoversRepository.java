package com.fparareda.common.repository;

import com.fparareda.common.model.MarsRover;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarsRoversRepository extends CrudRepository<MarsRover, Long> {
}
