package zenika.supple.guards;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BookingTest {
    // rooms : comme un dao
    private final Rooms rooms = mock(Rooms.class);;
    private final BookingService sut = new BookingService(rooms); 
    
    @Before public void setup() {
        Set<Room> oneBigRoom = new HashSet<Room>() {{
            add(new Room(20));
        }};
        
        when(rooms.findAllRooms()).thenReturn(oneBigRoom);
    }
    
    @Test public void should_book_when_big_enough_room_is_available() {
        Optional<Room> optionalRoom = sut.book(10);
        assertTrue(optionalRoom.isPresent()); 
    } 

    @Rule
    public ExpectedException ex = ExpectedException.none();
    
    @Test
    public void should_reject_when_capacity_negative() {
    	ex.expect(IllegalArgumentException.class);
    	ex.reportMissingExceptionWithMessage("minCapacity is negative");
    	
    	//GIVEN
    	int negativeCapacity = -1;
    	
    	//WHEN
    	sut.book(negativeCapacity);
    }
    
    @Test
    public void should_reject_when_capacity_is_overlapped() {
    	ex.expect(IllegalArgumentException.class);
    	ex.reportMissingExceptionWithMessage("minCapacity is overlapped");
    	
    	//GIVEN
    	int negativeCapacity = 151;
    	
    	//WHEN
    	sut.book(negativeCapacity);
    }
    
    @Test
    public void should_return_emty_room_when_rooms_is_null() {
    	Set<Room> expected = null;
		//GIVEN
    	when(rooms.findAllRooms()).thenReturn(expected );
    	//WHEN
    	Optional<Room> optionalRoom = sut.book(10);
    	//THEN
    	assertFalse(optionalRoom.isPresent()); 
    	
    }
    

}
