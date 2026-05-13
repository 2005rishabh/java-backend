package ticket.booking.services;

import ticket.booking.entities.User;

import java.io.File;

public class UserBookingService {

    private User user;

    private static final String USERS_PATH = "../../../localDB/users.json";
    private static final String TRAINS_PATH = "../../../localDB/trains.json";

    public UserBookingService(User user) {
        this.user = user;
        File users =  new File(USERS_PATH);
        
    }
    
    
}
