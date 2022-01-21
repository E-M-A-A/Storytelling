package it.unisa.emaa.www.sito.Model.dao;

import it.unisa.emaa.www.sito.Model.ConnPool;
import it.unisa.emaa.www.sito.Model.entity.Storia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe StoriaDao è il dao dell'entità storia la classe estende un interfaccia dao contenente i metodi da
 * effettuare
 * @author Antonio Scotellaro
 *
 *
 */




public class StoriaDao implements IStoriaDao {
    /**
     * effettua una query di selezione di ogni storia
     * @return
     */
    @Override
    public List<Storia> doRetrieveAll() {
        try(Connection conn = ConnPool.getConnection()) {
            try(PreparedStatement ps = conn.prepareStatement("Select * from storia")){
                ResultSet rs = ps.executeQuery();
                ArrayList<Storia> list =  new ArrayList<>();
                while(rs.next()){
                    Storia storia = new Storia();
                    storia.setContenuto(rs.getString("contenuto"));
                    storia.setDataCreazione(rs.getDate("dataCreazione").toLocalDate());
                    storia.setNCommenti(rs.getInt("nCommenti"));
                    storia.setNReazioni(rs.getInt("nReazioni"));
                    storia.setUsername(rs.getString("username"));
                    storia.setId(rs.getInt("id"));
                    list.add(storia);
                }
                rs.close();
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * effettua una query di selezione di ogni storia in base all'ID
     * @param id
     * @return
     */
    @Override
    public Storia doRetrieveById(int id) {
        try(Connection conn = ConnPool.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement("Select * from storia  where id =?")){
                ps.setInt(1,id);
                ResultSet rs = ps.executeQuery();
                if(!rs.isBeforeFirst())
                    return null;
                rs.next();
                Storia storia = new Storia();
                storia.setContenuto(rs.getString("contenuto"));
                storia.setDataCreazione(rs.getDate("dataCreazione").toLocalDate());
                storia.setNCommenti(rs.getInt("nCommenti"));
                storia.setNReazioni(rs.getInt("nReazioni"));
                storia.setUsername(rs.getString("username"));
                storia.setId(rs.getInt("id"));
                rs.close();
                return storia;
            } catch (SQLException e){
                e.printStackTrace();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;

    }

    /**
     * cancella una storia dalla base di dati partendo dall'ID
     * @param id
     * @return
     */
    @Override
    public boolean doDelete(int id) {
        try(Connection conn = ConnPool.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement("DELETE FROM Users WHERE id=?;")){
                ps.setInt(1,id);
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

    /**
     * salva una storia nella base di dati
     * @param storia
     * @return
     */
    @Override
    public boolean doSave(Storia storia) {
        try(Connection conn = ConnPool.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement("INSERT into storia (username,contenuto,nReazioni,nCommenti,dataCreazione) values (?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS)){
                ps.setString(1, storia.getUsername());
                ps.setString(2, storia.getContenuto());
                ps.setInt(3,storia.getNReazioni());
                ps.setInt(4,storia.getNCommenti());
                ps.setDate(5, Date.valueOf(storia.getDataCreazione()));
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                storia.setId(rs.getInt(1));  // viene preso l'id autoincrementato dopo l'insert e settato
                return true;

            }catch (SQLException e){
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }
/*
    @Override
    public List<Storia> doRetrieveByDate(Date date) {
        try(Connection conn = ConnPool.getConnection()) {
            try(PreparedStatement ps = conn.prepareStatement("Select * from storia where dataCreazione =?")){
                ResultSet rs = ps.executeQuery();
                ArrayList<Storia> list =  new ArrayList<>();
                while(rs.next()){
                    Storia storia = new Storia();
                    storia.setContenuto(rs.getString("contenuto"));
                    storia.setDataCreazione(rs.getDate("dataCreazione"));
                    storia.setNCommenti(rs.getInt("nCommenti"));
                    storia.setNReazioni(rs.getInt("nReazioni"));
                    storia.setId(rs.getInt("id"));
                    list.add(storia);
                }
                rs.close();    ???????????????????????? da vedereeeeeeee ??????????????????????????????
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }
*/

    /**
     * effettua una query prendendo le storie in base ad un limit ed offset che indicano la pagina
     * @param limit
     * @param offset
     * @return
     */
    @Override
    public List<Storia> doRetrieveByPage(int limit, int offset) {
        try(Connection conn = ConnPool.getConnection()) {
            try(PreparedStatement ps = conn.prepareStatement("Select * from storia order by dataCreazione DESC LIMIT ?,? ")){ // primo punto interrogativo offset, il secondo limit
                 ps.setInt(1,offset);
                 ps.setInt(2,limit);
                 ResultSet rs = ps.executeQuery();
                ArrayList<Storia> list =  new ArrayList<>();
                while(rs.next()){
                    Storia storia = new Storia();
                    storia.setContenuto(rs.getString("contenuto"));
                    storia.setDataCreazione(rs.getDate("dataCreazione").toLocalDate());
                    storia.setNCommenti(rs.getInt("nCommenti"));
                    storia.setNReazioni(rs.getInt("nReazioni"));
                    storia.setId(rs.getInt("id"));
                    storia.setUsername(rs.getString("username"));
                    list.add(storia);
                }
                rs.close();
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }
}

