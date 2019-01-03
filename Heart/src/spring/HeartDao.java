package spring;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class HeartDao {

	private Connection connec;
	
	public HeartDao() {
		try {
			connec = new ConnectionFactory().getConnection();
		} catch (ClassNotFoundException mensagem) {
			throw new RuntimeException("Erro na conexão"+ mensagem.getMessage());
		}
	}

	public void Adiciona(HeartRates heart) {
		String sql = "INSERT INTO PACIENTE" + "(id,nome,sobrenome,dia,mes,ano)"+"values(?,?,?,?,?,?)";
		try { 
			PreparedStatement stmt = connec.prepareStatement(sql);
			stmt.setInt(1, heart.getId());
			stmt.setString(2, heart.getNome());
			stmt.setString(3, heart.getSobrenome());
			stmt.setInt(4, heart.getDia());
			stmt.setInt(5, heart.getMes());
			stmt.setInt(6, heart.getAno());
			stmt.execute();
			stmt.close();
		}catch (SQLException mensagem) {
			
		throw new RuntimeException(mensagem);
		}
	}
	public List<HeartRates> getList(){
	try {
		List<HeartRates> heart = new ArrayList<>();
		String sql = ("Select * from paciente");
		PreparedStatement stmt = connec.prepareStatement(sql);
		ResultSet resultSet = stmt.executeQuery();
		while(resultSet.next()) {
			HeartRates hearts = new HeartRates();
						hearts.setId(resultSet.getInt("id"));
						hearts.setNome(resultSet.getString("nome"));
						hearts.setSobrenome(resultSet.getString("sobrenome"));
						hearts.setDia(resultSet.getInt("dia"));
						hearts.setMes(resultSet.getInt("mes"));
						hearts.setAno(resultSet.getInt("ano"));
						heart.add(hearts);
        }
        resultSet.close();
        stmt.close();

        return heart;

    }catch (SQLException mensagem) {
		
	throw new RuntimeException(mensagem); 
			
		}
	}
	public void Remover(HeartRates heart) {
		String sql = "DELETE FROM paciente WHERE id=?";
		try { 
			PreparedStatement stmt = connec.prepareStatement(sql);
			stmt.setInt(1, heart.getId());
			stmt.execute();
			stmt.close();
		}catch (SQLException mensagem) {
			
		throw new RuntimeException(mensagem);
		}
	}
	public void altera(HeartRates heart){
		String sql = "UPDATE paciente SET id=?,nome=?,sobrenome=?,dia=?,mes=?,ano=? "+"WHERE id=?";
		try{
			PreparedStatement stmt = connec.prepareStatement(sql);
			stmt.setInt(1, heart.getId());
			stmt.setString(2, heart.getNome());
			stmt.setString(3, heart.getSobrenome());
			stmt.setInt(4, heart.getDia());
			stmt.setInt(5, heart.getMes());
			stmt.setInt(6, heart.getAno());
			stmt.setInt(7, heart.getId());
			stmt.execute();
			stmt.close();
		}catch (SQLException mensagem){
			
			throw new RuntimeException(mensagem);
		}
	}
	
	 public HeartRates buscaPorId(int id) {
	    	try {
				HeartRates heart = new HeartRates();
				String sql = "SELECT * FROM paciente WHERE id=?";
				
				PreparedStatement stmt = connec.prepareStatement(sql);
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next()) {
					heart.setId(rs.getInt("id"));
					heart.setNome(rs.getString("nome"));
					heart.setSobrenome(rs.getString("sobrenome"));
					heart.setDia(rs.getInt("dia"));
					heart.setMes(rs.getInt("mes"));
					heart.setAno(rs.getInt("ano"));
					
				}
				stmt.close();
				rs.close();
				return heart; 
	    	}catch (SQLException mensagem){
				
				throw new RuntimeException(mensagem);
			}
		}
}		
