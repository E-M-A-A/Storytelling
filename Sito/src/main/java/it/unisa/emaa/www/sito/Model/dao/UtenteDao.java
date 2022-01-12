package it.unisa.emaa.www.sito.Model.dao;

import it.unisa.emaa.www.sito.Model.ConnPool;
import it.unisa.emaa.www.sito.Model.entity.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Questo è il dao dell'entità utente la classe estende un interfaccia dao contenente i metodi da
 * effettuare, e tramite una connpoll connection ci colleghiamo al database per far sì che
 * vengano effettuate le query scritte qui di seguito
 *
 *
 * @author Antonio
 *
 *
*/

public class UtenteDao implements IUtenteDao{
    @Override

    public List<Utente> doRetrieveAll() {
        try(Connection conn = ConnPool.getConnection()) {
            try(PreparedStatement ps = conn.prepareStatement("Select * from utente")){
                ResultSet rs = ps.executeQuery();
                ArrayList<Utente> list =  new ArrayList<>();
                while(rs.next()){
                    Utente utente = new Utente();
                    utente.setId(rs.getString("email"));
                    utente.setUsername(rs.getString("username"));
                    list.add(utente);
                }
                rs.close();
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Utente doRetrieveByUsername(String username) {
        try(Connection conn = ConnPool.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement("Select * from utente  where username =?")){
                ps.setString(1,username);
                ResultSet rs = ps.executeQuery();
                if(!rs.isBeforeFirst())
                    return null;
                rs.next();
                Utente utente = new Utente();
                utente.setId(rs.getString("email"));
                utente.setUsername(rs.getString("username"));
                utente.setPassword(rs.getString("password"));
                rs.close();
                return utente;
            } catch (SQLException e){
                e.printStackTrace();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Utente doRetrieveByEmail(String email) {
        try(Connection conn = ConnPool.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement("Select * from utente  where email =?")){
                ps.setString(1,email);
                ResultSet rs = ps.executeQuery();
                if(!rs.isBeforeFirst())
                    return null;
                rs.next();
                Utente utente = new Utente();
                utente.setId(rs.getString("email"));
                utente.setUsername(rs.getString("username"));
                utente.setPassword(rs.getString("password"));
                rs.close();
                return utente;
            } catch (SQLException e){
                e.printStackTrace();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean doSave(Utente utente) {
        try(Connection conn = ConnPool.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement("INSERT into utente (email,password,username) values (?,?,?)")){
                ps.setString(1, utente.getId());
                ps.setString(2, utente.getPassword());
                ps.setString(3, utente.getUsername());
                return ps.executeUpdate()>0;

            }catch (SQLException e){
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean doDelete(String email)  {
        try(Connection conn = ConnPool.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement("DELETE FROM Users WHERE email=?;")){
                ps.setString(1,email.toLowerCase());
                return ps.executeUpdate()>0;
            }
            catch(SQLException e){
                throw new SQLException();
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
