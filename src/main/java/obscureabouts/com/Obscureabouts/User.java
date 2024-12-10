package obscureabouts.com.Obscureabouts;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class User
{
    private String storedUsername = "MatHern";
    private String storedPassword = hashPassword("Password123");
    private String name;
    private String address;
    private String email;

    public User()
    {
        this.name = "";
        this.address = "";
        this.email = "";
    }

    public User(String name, String homeTown, String email, String username, String password)
    {
        this.name = name;
        this.address = homeTown;
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getStoredUsername()
    {
        return storedUsername;
    }

    public String getStoredPassword()
    {
        return storedPassword;
    }


    private String hashPassword(String password)
    {
        try {

            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] messageDigest = md.digest(password.getBytes());

            BigInteger num = new BigInteger(1, messageDigest);


            String hashTest = num.toString(16);


            while (hashTest.length() < 40) {
                hashTest = "0" + hashTest;
            }

            return hashTest;
        }


        catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException(e);
        }
    }

        public boolean checkPassword(String password)
        {
            if (hashPassword(password).equals(storedPassword))
            {
                return true;
            }
            return false;
        }

}