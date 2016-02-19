package zenika.smells.mf.primitive.exo1;

public class Salle {

	boolean reservationPossible(ReservationService reservationService, TimeSlot timeSlot) {		
		return reservationService.reservations.findReservations(this, timeSlot.getJour())
	        .stream()
	        .noneMatch(existingReservation -> existingReservation.chevauche(timeSlot));
	}
}
