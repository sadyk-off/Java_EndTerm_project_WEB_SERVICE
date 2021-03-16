package services;

import entities.Deliveryman;
import repositories.interfaces.IDeliverymanRepository;
import services.interfaces.IDeliverymanService;

import javax.inject.Inject;
import java.util.List;

public class DeliverymanService implements IDeliverymanService {
    @Inject
    private IDeliverymanRepository workerRepository;

    @Override
    public List<Deliveryman> getAll() {
        List<Deliveryman> deliverymen = workerRepository.getAll();
        return deliverymen;
    }

    @Override
    public boolean create(Deliveryman deliveryman) {
        return workerRepository.create(deliveryman);
    }

    @Override
    public Deliveryman get(int id) {
        return workerRepository.get(id);
    }

    @Override
    public boolean delete(int id) {
        return workerRepository.delete(id);
    }
}
