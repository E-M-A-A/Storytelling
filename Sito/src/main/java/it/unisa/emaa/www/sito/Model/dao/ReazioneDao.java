package it.unisa.emaa.www.sito.Model.dao;

import it.unisa.emaa.www.sito.Model.ConnPool;
import it.unisa.emaa.www.sito.Model.entity.Reazione;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReazioneDao implements IReazioneDao{



    @Override
    public List<Reazione> doRetrieveByStoria(int idStoria) {
        try(Connection conn = ConnPool.getConnection()) {
            try(PreparedStatement ps = conn.prepareStatement("Select * from reazione where idStoria =?")){
                ps.setInt(1,idStoria);
                ResultSet rs = ps.executeQuery();
                ArrayList<Reazione> list =  new ArrayList<>();
                while(rs.next()){
                    Reazione reazione = new Reazione();
                    reazione.setIdStoria(rs.getInt("idStoria"));
                    reazione.setEmailUtente(rs.getString("emailUtente"));
                    list.add(reazione);
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
    public List<Reazione> doRetrieveByEmail(String email) {
        try(Connection conn = ConnPool.getConnection()) {
            try(PreparedStatement ps = conn.prepareStatement("Select * from reazione where emailUtente =?")){
                ps.setString(1,email);
                ResultSet rs = ps.executeQuery();
                ArrayList<Reazione> list =  new ArrayList<>();
                while(rs.next()){
                    Reazione reazione = new Reazione();
                    reazione.setIdStoria(rs.getInt("idStoria"));
                    reazione.setEmailUtente(rs.getString("emailUtente"));
                    list.add(reazione);
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
    public boolean doSave(Reazione reazione) {
        try(Connection conn = ConnPool.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement("INSERT into reazione (idStoria,emailUtente) values (?,?)")){
                ps.setInt(1, reazione.getIdStoria());
                ps.setString(2, reazione.getEmailUtente());

                return ps.executeUpdate()>0;

            }catch (SQLException e){
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
