package BLL;

public abstract class StoreUserID {
    private static int id;
    private static String fullname;
    private static String username;
    private static String password;
    private static String phoneNumber;
    private static int admin;

    public static int getId() {
        return id;
    }

    public static int getAdmin() {
        return admin;
    }

    public static void setAdmin(int admin) {
        StoreUserID.admin = admin;
    }

    public static void setId(int id) {
        StoreUserID.id = id;
    }

    public static String getFullname() {
        return fullname;
    }

    public static void setFullname(String fullname) {
        StoreUserID.fullname = fullname;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        StoreUserID.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        StoreUserID.password = password;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static void setPhoneNumber(String phoneNumber) {
        StoreUserID.phoneNumber = phoneNumber;
    }


}
