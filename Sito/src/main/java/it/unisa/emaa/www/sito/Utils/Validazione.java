package it.unisa.emaa.www.sito.Utils;

import it.unisa.emaa.www.sito.Model.dao.IUtenteDao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class Validazione {
    public static boolean emailIsPresent(String email){
        UtenteDao userDao = new UtenteDao();
        Utente utente = utenteDao.doRetrieveByEmail(email);
        return utente != null;
    }

    public static boolean usernameIsPresent(String username){
        UtenteDao utenteDao = new UtenteDao();
        Utente utente = utenteDao.doRetrieveByUsername(username);
        return utente != null;
    }

    public static boolean reactionIsPresent(String email,int idStoria){
        ReazioneDao reazioneDao = new ReazioneDao();
        Reazione reazione = reazioneDao.doRetrieve(email,idStoria);
        return reazione != null;

    }
    public static boolean emailRegex(String email){
        Pattern patternEmail = Pattern.compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
        return patternEmail.matcher(email).matches();
    }

    public static boolean passwordRegex(String password){
        Pattern patternPassword = Pattern.compile("^(?=.*[a-z])(?=.*\\d)(?=.*[@#$._%-])(?=.*[A-Z]).{8,16}$");
        return patternPassword.matcher(password).matches();
    }
    public static boolean passwordTest(String password,String passwordTest){
        return password.equals(passwordTest);
    }
    public static String passwordHasher(String password){
        try {
            // getInstance() method is called with algorithm SHA-512
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(password.getBytes());
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
            // Convert message digest into hex value
            String hashtext = no.toString(16);
            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            // return the HashText
            return hashtext;
        }
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
