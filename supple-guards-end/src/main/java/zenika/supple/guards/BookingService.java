package zenika.supple.guards;

import java.util.Optional;
import java.util.Set;

import static java.lang.String.format;

public class BookingService {
    
    private final Rooms rooms;

    public BookingService(Rooms rooms) {
        this.rooms = rooms;
    }

    public Optional<Room> book(int minCapacity) {
        if(minCapacity < 0) throw new IllegalArgumentException(format(
                "Invalid minCapacity(%d): minCapacity < 0", 
                minCapacity
        ));
        
        Set<Room> allRooms = rooms.findAllRooms();
        return allRooms.stream()
                .filter(r -> r.capacity() >= minCapacity)
                .findAny();
    }
    
}
