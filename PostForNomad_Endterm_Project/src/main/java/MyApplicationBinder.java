import data.PostgresDB;
import data.interfaces.IDB;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import repositories.ParcelRepository;
import repositories.UserRepository;
import repositories.interfaces.IParcelRepository;
import repositories.interfaces.IUserRepository;
import services.AuthService;
import services.ParcelService;
import services.UserService;
import services.interfaces.IAuthService;
import services.interfaces.IParcelService;
import services.interfaces.IUserService;

public class MyApplicationBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(PostgresDB.class).to(IDB.class);
        bind(UserRepository.class).to(IUserRepository.class);
        bind(ParcelRepository.class).to(IParcelRepository.class);
        bind(ParcelService.class).to(IParcelService.class);
        bind(UserService.class).to(IUserService.class);
        bind(AuthService.class).to(IAuthService.class);
    }
}