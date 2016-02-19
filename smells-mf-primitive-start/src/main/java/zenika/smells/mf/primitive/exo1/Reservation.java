package zenika.smells.mf.primitive.exo1;

import java.time.LocalDate;

public class Reservation {
    
    private final TimeSlot timeSlot;
    
    @Deprecated
    public Reservation(LocalDate jour, int heureDebut, int heureFin) {
        this(new TimeSlot(jour, heureDebut, heureFin));
    }
    
    
    public Reservation(TimeSlot timeSlot) {
		super();
		this.timeSlot = timeSlot;
	}

	public LocalDate getJour() {
        return timeSlot.getJour();
    }

    public int getHeureDebut() {
        return timeSlot.getHeureDebut();
    }

    public int getHeureFin() {
        return timeSlot.getHeureFin();
    }

	boolean chevauche(TimeSlot timeSlot) {
	    return getHeureFin() > timeSlot.getHeureDebut()
	        && getHeureDebut() < timeSlot.getHeureFin();
	}
}
