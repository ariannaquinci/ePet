package service;


import service.factories.*;

public class Factory{

    private static Factory instance = null;

    private Factory() {
        //Default constructor
    }

    public static Factory getInstance() {
        if(instance == null) {
            instance = new Factory();
        }

        return instance;}
    public Entity getObject(Types type) {
        switch(type) {
            case APPOINTMENT:
                return new AppointmentFactory();
            case APPOINTMENTREQUEST:
                return new AppointmentRequestFactory();
            case FAVORITE:
                return new FavoriteFactory();

            case POST:
                return new PostFactory();
            case PROFILE:
                return new ProfileFactory();
            case SCHEDULEDAPPOINTMENT:
                return new ScheduledAppointmentFactory();
            case SLOTAPPUNTAMENTO:
                return new SlotAppuntamentoFactory();
            case USER:
                return new UserFactory();
            default:
                return null;
        }
    }
}
