package services.interfaces;

import entities.Parcel;

import java.util.List;

public interface IParcelService {
    List<Parcel> getAll();

    boolean create(Parcel parcel);

    Parcel get(int id);

    boolean delete(int id);

    Parcel getParcelById(int id);
}