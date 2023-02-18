/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package session;

/**
 *
 * @author mendieto
 */
public class UserId {
    private static String kd;
    
    public static void setUserLogin(String kode) {
        kd = kode;
    }
    
    public static String getUserLogin() {
        return kd;
    }
}
