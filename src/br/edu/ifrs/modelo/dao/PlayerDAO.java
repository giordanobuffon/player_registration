package br.edu.ifrs.modelo.dao;

import br.edu.ifrs.modelo.bean.Player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String CONNECTION_BD = "jdbc:mysql://localhost:3306/player_registration";
    private static final String USER_BD = "root";
    private static final String PASSWORD_BD = "2534";

    public static void insert(Player bean) throws Exception {
        // inserir no banco de dados
        /* Estabelece a conexão com um banco de dados. */
        try {
            Class.forName(DRIVER); // Informa o driver jdbc do fornecedor do banco
            Connection conn = DriverManager.getConnection(CONNECTION_BD, USER_BD, PASSWORD_BD);

            /* Preparar a sentença SQL, que será executada no Banco de Dados */
            PreparedStatement ps = conn.prepareStatement("INSERT INTO player_registration.players (name, team, height, weight, age) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, bean.getName());
            ps.setString(2, bean.getTeam());
            ps.setDouble(3, bean.getHeight());
            ps.setDouble(4, bean.getWeight());
            ps.setInt(4, bean.getAge());

            /* Executar a setença SQL */
            ps.execute();

            ps.close();
            conn.close();
        } catch(Exception e) {
            throw new Exception("[br.edu.ifrs.modelo.Player.insert] Falha ao inserir no Banco de dados: "+e.getMessage());
        }
    }

    public static Player[] consult(Player bean) throws Exception {
        List<Player> players = new ArrayList();

        // consultar no banco de dados
        /* Estabelece a conexão com um banco de dados. */
        try {
            Class.forName(DRIVER); // Informa o driver jdbc do fornecedor do banco
            Connection conn = DriverManager.getConnection(CONNECTION_BD, USER_BD, PASSWORD_BD);

            /* Preparar a sentença SQL, que será executada no Banco de Dados */
            PreparedStatement ps = conn.prepareStatement("select * from player_registration.players where name like ? or team like ?");
            ps.setString(1, "%"+bean.getName()+"%");
            ps.setString(2, "%"+bean.getTeam()+"%");

            /* Executar a setença SQL */
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Player p = new Player();
                p.setName(resultSet.getString("name"));
                p.setTeam(resultSet.getString("team"));
                p.setHeight(resultSet.getDouble("height"));
                p.setWeight(resultSet.getDouble("weight"));
                p.setAge(resultSet.getInt("age"));

                players.add(p);
            }

            resultSet.close();
            ps.close();
            conn.close();
        } catch(Exception e) {
            throw new Exception("[br.edu.ifrs.modelo.Player.consult] Falha ao consultar no Banco de dados: "+e.getMessage());
        }

        return players.toArray(new Player[0]);
    }

    public static void atualizar() {
        // atualizar no banco de dados
    }

    public static void excluir() {
        // excluir no banco de dados
    }

}
