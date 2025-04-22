package UserManagment;

public class User {

    //attributes of the user class
    private String name ;
    private String  id ;
    private String email ;
    private String password ;

    //constructor

    //user created by the admin
    public User(String name , String id , String email){
        this.id = id ;
        this.name = name ;
        this.email = email ;
        this.password= "";
    }

    public User(String name , String id , String email,String password){
        this.id = id ;
        this.name = name ;
        this.email = email ;
        this.password= password;
    }

//getter methods
    public String getName() { return name; }
    public String getId() { return id; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }

//setter methods
    public void setPassword(String password){ this.password= password;}

    //display details of user
    public String display(){

        return "Name: "+getName()+"\nId: "+getId();
    }




}
