package zenika.smells.mf.primitive.exo1;

import java.util.Optional;

public class ReservationService {
        
    private final Salles salles;      	
	final Reservations reservations;

    public ReservationService(Salles salles, Reservations reservations) {
        this.salles = salles;
        this.reservations = reservations;
    }
    
    public Optional<Salle> findSalleReservable(int nbPersonnes, TimeSlot timeSlot) {
		return salles.findSallesByCapacite(nbPersonnes)
            .stream()
			.filter(salle -> salle.reservationPossible(this, timeSlot))
            .findAny();		
	}
    
}
