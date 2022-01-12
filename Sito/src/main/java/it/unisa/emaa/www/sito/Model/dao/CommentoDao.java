package it.unisa.emaa.www.sito.Model.dao;

import it.unisa.emaa.www.sito.Model.ConnPool;
import it.unisa.emaa.www.sito.Model.entity.Commento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentoDao implements ICommentoDao{
    @Override
    public List<Commento> doRetrieveByAll() throws SQLException {
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

    @Override
    public Commento doRetrieveByStoria(int idStoria) {
        try(Connection conn = ConnPool.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement("Select * from storia  where idStoria =?")){
                ps.setInt(1,idStoria);
                ResultSet rs = ps.executeQuery();
                if(!rs.isBeforeFirst())
                    return null;
                rs.next();
                Commento commento = new Commento();
                commento.setId(rs.getInt("id"));
                commento.setIdStoria(rs.getInt("idStoria"));
                commento.setUsername(rs.getString("username"));
                commento.setContenuto(rs.getString("contenuto"));
                rs.close();
                return commento;
            } catch (SQLException e){
                e.printStackTrace();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean doSave(Commento commento) {
        try(Connection conn = ConnPool.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement("INSERT into commento (idStoria,username,contenuto) values (?,?,?)")){
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
