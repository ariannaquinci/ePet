package model;

public class RoutinesID {


    private RoutinesID() {
        /**/
    }

    public static final String LOGIN = "call ePetDB.login(?, ?, ?)";
    public static final String GET_PROFILE = "call ePetDB.getProfile(?)";

    public static final String DELETE_APP="call ePetDB.deleteAppointment(?)";
    public static final String DELETE_SLOT="call ePetDB.deleteSlot(?,?)";

    public static final String CREATE_PROFILE= "call ePetDB.CreateProfile(?,?,?,?,?,?)";
    public static final String EDIT_NICKNAME= "call ePetDB.editNickname(?,?)";
    public static final String EDIT_PROFILE_PIC= "call ePetDB.editProfilePic(?,?)";

    public static final String EDIT_TEL_NUM= "call ePetDB.editTelNumber(?,?)";
    public static final String INSERT_SLOT= "call ePetDB.insertSlot(?,?,?)";

    public static final String SELECT_SLOT= "call ePetDB.selectSlot(?,?,?)";
    public static final String RESEARCH= "call ePetDB.research(?,?,?,?)";
    public static final String SCHEDULE_APP= "call ePetDB.scheduleApp(?,?,?)";
    public static final String SHOW_FAVORITES= "call ePetDB.showFavorites(?)";
    public static final String WRITE_POST= "call ePetDB.WritePost(?,?,?,?,?,?,?)";
    public static final String DELETE_POST= "call ePetDB.deletePost(?)";
    public static final String DELETE_USER= "call ePetDB.deleteUser(?)";
    public static final String INSERT_FAVORITE= "call ePetDB.insertFavorite(?,?)";
    public static final String REMOVE_FAVORITE= "call ePetDB.removeFromFavorites(?,?)";

    public static final String SEE_SCHEDULED_APP="call ePetDB.seeScheduledApp(?)";
    public static final String REGISTER="call ePetDB.registrazione(?,?,?)";

    public static final String DENY_APP_REQ="call ePetDB.denyAppRequest(?,?)";
    public static final String SHOW_APP_REQUESTS="call ePetDB.showAppRequests(?)";

    public static final String GET_POSTS="call ePetDB.getPosts(?)";
    public static final String SHOW_SLOTS="call ePetDB.showSlots(?)";
}