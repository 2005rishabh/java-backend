package ticket.booking.services;

import ticket.booking.entities.User;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class UserBookingService {

    private User user;

    private List<User> userList;

    private ObjectMapper objectMapper = new ObjectMapper();

    private static final String USERS_PATH = "../../../localDB/users.json";
    private static final String TRAINS_PATH = "../../../localDB/trains.json";

    public UserBookingService(User user)    {
        this.user = user;
        try {
            File users = new File(USERS_PATH);
            userList = objectMapper.readValue(users, new TypeReference<List<User>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Boolean loginUser()

}
