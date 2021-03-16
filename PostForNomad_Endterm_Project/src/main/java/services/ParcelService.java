package services;

import entities.Parcel;
import repositories.interfaces.IParcelRepository;
import services.interfaces.IParcelService;

import javax.inject.Inject;
import java.util.List;

public class ParcelService implements IParcelService {
    @Inject
    private IParcelRepository parcelRepository;

    @Override
    public List<Parcel> getAll() {
        List<Parcel> parcels = parcelRepository.getAll();
        return parcels;
    }

    @Override
    public Parcel getParcelById(int id) {
        return parcelRepository.get(id);
    }
    @Override
    public boolean create(Parcel parcel) {
        return parcelRepository.create(parcel);
    }

    @Override
    public Parcel get(int id) {
        return parcelRepository.get(id);
    }

    @Override
    public boolean delete(int id) {
        return parcelRepository.delete(id);
    }
}