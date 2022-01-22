package it.unisa.emaa.www.sito.Model.dao;

import it.unisa.emaa.www.sito.Model.ConnPool;
import it.unisa.emaa.www.sito.Model.entity.Commento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe CommentoDao è il dao dell'entità commento la classe estende un interfaccia dao contenente i metodi da
 * effettuare
 * @author Antonio Scotellaro
 *
 *
 */




public class CommentoDao implements ICommentoDao{
    /**
     * effettua una query di selezione di ogni commento
     * @return
     * @throws SQLException
     */
    @Override
    public List<Commento> doRetrieveAll() throws SQLException {
        try(Connection conn = ConnPool.getConnection()) {
            try(PreparedStatement ps = conn.prepareStatement("Select * from commento")){
                ResultSet rs = ps.executeQuery();
                ArrayList<Commento> list =  new ArrayList<>();
                while(rs.next()){
                    Commento commento = new Commento();
                    commento.setId(rs.getInt("id"));
                    commento.setIdStoria(rs.getInt("idStoria"));
                    commento.setUsername(rs.getString("username"));
                    commento.setContenuto(rs.getString("contenuto"));
                    list.add(commento);
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
     * effettua una query di selezione di ogni commento in base alla storia
     * @param idStoria
     * @return
     */
    @Override
    public List<Commento> doRetrieveByStoria(int idStoria) {
        try(Connection conn = ConnPool.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement("Select * from commento  where idStoria =?")){
                ps.setInt(1,idStoria);
                ResultSet rs = ps.executeQuery();
                if(!rs.isBeforeFirst())
                    return null;
                List<Commento> commenti = new ArrayList<>();
                while(rs.next()) {
                    Commento commento = new Commento();
                    commento.setId(rs.getInt("id"));
                    commento.setIdStoria(rs.getInt("idStoria"));
                    commento.setUsername(rs.getString("username"));
                    commento.setContenuto(rs.getString("contenuto"));
                    commenti.add(commento);
                }
                rs.close();
                return commenti;
            } catch (SQLException e){
                e.printStackTrace();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * salva un commento nella base di dati
     * @param commento
     * @return
     */
    @Override
    public boolean doSave(Commento commento) {
        try(Connection conn = ConnPool.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement("INSERT into commento (idStoria,username,contenuto) values (?,?,?)",Statement.RETURN_GENERATED_KEYS)){
                ps.setInt(1, commento.getIdStoria());
                ps.setString(2, commento.getUsername());
                ps.setString(3, commento.getContenuto());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                commento.setId(rs.getInt(1));  // viene preso l'id autoincrementato dopo l'insert e settato
                return true;

            }catch (SQLException e){
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }


}
