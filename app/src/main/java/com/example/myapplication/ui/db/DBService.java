package com.example.myapplication.ui.db;

import com.example.myapplication.ui.data.entities.Client;
import com.example.myapplication.ui.data.entities.Game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 Para llamar a DBService es necesario pedir una instancia con DBService.getInstance()
 Es recomendable usar funciones encadenadas a la instancia llamada.
 Ejemplo: DBService.getInstance().login(username,password);
 */
public class DBService {

    private static DBService dbService;
    private Connection connection;

    private DBService(){
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://204.2.195.90:30794/CS2901sec01?currentSchema=kito"
                    ,"sec01grupo01"
                    ,"utec2021");
        }catch (Exception e){
            System.out.println("Sucedio un error");
        }
    }

    public static DBService getInstance(){
        if(dbService ==null) {
            dbService = new DBService();
        }
        return dbService;
    }

    public Client getClientById(Long id){
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT username, password, balance FROM a_client WHERE id="+id);
            return new Client(id,resultSet.getString("username"),resultSet.getString("password"),resultSet.getDouble("balance"));
        }catch (Exception e){
            return null;
        }
    }

    public Client getClientByUsername(String username){
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, password, balance FROM a_client WHERE username="+username);
            return new Client(resultSet.getLong("id"),username,resultSet.getString("password"),resultSet.getDouble("balance"));
        }catch (Exception e){
            return null;
        }
    }

    public Client createClient(String username, String password){
        try{
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO a_client(username, password, balance) VALUES" +
                            "('"+username+"','"+password+"',200); COMMIT;");
            return getClientByUsername(username);
        }catch (Exception e){
            return null;
        }
    }

    public Game getGameById(Long id){
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name, price, img_link FROM a_game WHERE id="+id);
            return new Game(id,resultSet.getString("name"),resultSet.getInt("price"),resultSet.getString("img_link"));
        }catch (Exception e){
            return null;
        }
    }

    public Client login(String username, String password){
        try{
            Client client = getClientByUsername(username);
            if(password.equals(client.getPassword())){
                return client;
            }
            return null;
        }catch (Exception e){
            return null;
        }
    }

    public Boolean changeBalance(Client client, double amount){
        try{
            if(client.getBalance()+amount < 0){
                return false;
            }
            Statement statement = connection.createStatement();
            statement.execute("UPDATE a_client SET balance= balance+"+amount+" WHERE username="+client.getUsername());
            client.setBalance(client.getBalance()+amount);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Client register(String username, String password){
        try{
            Client client = getClientByUsername(username);
            if(client != null){
                return null;
            }
            return createClient(username,password);
        }catch (Exception e){
            return null;
        }
    }

    public Boolean buy(Client client, Long game_id){
        try{
            Game game = getGameById(game_id);
            changeBalance(client, game.getPrice());
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO a_inventory VALUES ("+client.getId()+","+game_id+")");
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void deleteFromInventory(Client client, Long game_id){
        try{
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM a_inventory WHERE c_id="+client.getId()+" AND g_id="+game_id);
        }catch (Exception ignore){
        }
    }
}
