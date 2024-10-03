package com.example.load;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LoadService {

    @Autowired
    private LoadRepo loadRepo;

    public Load createLoad(Load load) {
        return loadRepo.save(load);
    }

    public List<Load> getLoadsByShipperId(UUID shipperId) {
        return loadRepo.findByShipperId(shipperId);
    }

    public Load getLoadById(UUID loadId) {
        return loadRepo.findById(loadId).orElseThrow(() -> new RuntimeException("Load not found"));
    }

    public Load updateLoad(UUID loadId, Load loadDetails) {
        Load load = getLoadById(loadId);
        load.setLoadingPoint(loadDetails.getLoadingPoint());
        load.setUnloadingPoint(loadDetails.getUnloadingPoint());
        load.setProductType(loadDetails.getProductType());
        load.setTruckType(loadDetails.getTruckType());
        load.setNoOfTrucks(loadDetails.getNoOfTrucks());
        load.setWeight(loadDetails.getWeight());
        load.setComment(loadDetails.getComment());
        load.setDate(loadDetails.getDate());
        return loadRepo.save(load);
    }

    public void deleteLoad(UUID loadId) {
        Load load = getLoadById(loadId);
        loadRepo.delete(load);
    }
}
