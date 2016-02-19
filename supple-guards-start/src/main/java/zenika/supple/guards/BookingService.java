package zenika.supple.guards;

import java.util.Optional;
import java.util.Set;

public class BookingService {
    
    private final Rooms rooms;

    public BookingService(Rooms rooms) {
        this.rooms = rooms;
    }
    // Optional : return 0 ou n element.
    public Optional<Room> book(int minCapacity) {// capacite de la salle que on veux reserver.
    	if(minCapacity < 0 || minCapacity>150){
    		throw new IllegalArgumentException("minCapacity is negative");
    	}
        Set<Room> allRooms = rooms.findAllRooms();
        
        if (allRooms == null) {
        	return Optional.empty();
        }
        
        return allRooms.stream()
                .filter(r -> r.capacity() >= minCapacity)
                .findAny();
    }
    
}
