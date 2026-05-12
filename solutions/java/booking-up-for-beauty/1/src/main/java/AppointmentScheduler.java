import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

class AppointmentScheduler {
    public LocalDateTime schedule(String appointmentDateDescription) {
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(appointmentDateDescription, parser);
        return dateTime;
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        LocalDateTime today = LocalDateTime.now();
        return appointmentDate.isBefore(today) ? true : false;
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        int hour = appointmentDate.getHour();
        return (hour >= 12 && hour < 18) ? true : false;
    }

    public String getDescription(LocalDateTime appointmentDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
        String formattedDate = appointmentDate.format(formatter); 
        return "You have an appointment on " + appointmentDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH) + ", " + appointmentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH) + " " + appointmentDate.getDayOfMonth() + ", " + appointmentDate.getYear() + ", at " + formattedDate + ".";
    }

    public LocalDate getAnniversaryDate() {
        LocalDate anniversaryDate = LocalDate.of(LocalDate.now().getYear(), 9, 15);
        return anniversaryDate;
    }
}
