package com.training.center.Service;

import com.training.center.Entity.TrainingCenter;
import com.training.center.Repository.TrainingCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

    @Service
    public class TrainingCenterService {

        @Autowired
        private TrainingCenterRepository repository;

        public TrainingCenter saveTrainingCenter(TrainingCenter center) {
            center.setCreatedOn(Instant.now().getEpochSecond());
            return repository.save(center);
        }

        public List<TrainingCenter> getAllTrainingCenters() {
            return repository.findAll();
        }
    }
