package services.interfaces;

import entities.Deliveryman;

import java.util.List;

public interface IDeliverymanService {
    List<Deliveryman> getAll();

    boolean create(Deliveryman deliveryman);

    Deliveryman get(int id);

    boolean delete(int id);
}
