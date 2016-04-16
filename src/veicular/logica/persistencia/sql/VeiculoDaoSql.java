package veicular.logica.persistencia.sql;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import veicular.logica.dominio.Aeronave;
import veicular.logica.dominio.Embarcacoes;
import veicular.logica.dominio.Terrestres;
import veicular.logica.dominio.Veiculo;


public class VeiculoDaoSql extends DBDAO implements VeiculoDaoIF{
	
	private static final int TIPO_AERONAVE = 0;
	private static final int TIPO_EMBARCACOES = 1;	
	private static final int TIPO_TERRESTRE = 2;
	private static final int TIPO_OUTRO = 3;
	
	private static final String INSERT_VEICULO = "INSERT INTO VEICULO (PLACA, ANOFABRICACAO, CLASSE, valorCompra, proprietario) VALUES (?, ?, ?, ?, ?)";
	private static final String UPDATE_VEICULO = "UPDATE veiculo SET ANOFABRICACAO = ?  where PLACA = ?";
	private static final String FINDBYNOME = "select CLASSE, PLACA, ANOFABRICACAO, valorCompra, proprietario from veiculo where PLACA = ?";
	private static final String FINDALL = "select CLASSE, PLACA, ANOFABRICACAO, valorCompra, proprietario from veiculo";
	private static final String DELETE = "delete from veiculo where placa = ?";
	
	private ProprietarioDaoSql proprietarioDao;
	
	@Override
	public void salvar(Veiculo veiculo) throws Exception {
		Veiculo v = this.findByPlaca(veiculo.getPlaca());
		
		if(v == null)
			this.create(veiculo);
		else
			this.update(veiculo);
		
	}

	private void update(Veiculo veiculo) throws SQLException {
		
		Connection conn = this.getConnection();
		PreparedStatement pstam = conn.prepareStatement(UPDATE_VEICULO);
		pstam.setInt(1, veiculo.getAnoFabricacao());
		pstam.setString(2, veiculo.getPlaca());
		
		/*if(veiculo.getClass().equals(Aeronave.class))
			pstam.setInt(3, VeiculoDaoSql.TIPO_AERONAVE);
		else if(veiculo.getClass().equals(Embarcacoes.class))
			pstam.setInt(3, VeiculoDaoSql.TIPO_EMBARCACOES);
		else if (veiculo.getClass().equals(Terrestres.class))
			pstam.setInt(3, VeiculoDaoSql.TIPO_TERRESTRE);
		else
			pstam.setInt(3, VeiculoDaoSql.TIPO_OUTRO);*/
		System.out.println(pstam.toString());
		
		pstam.executeUpdate();
		pstam.close();
		conn.close();
	}
	

	private void create(Veiculo veiculo) throws SQLException {
		
		Connection conn = this.getConnection();
		PreparedStatement pstam = conn.prepareStatement(INSERT_VEICULO);
		pstam.setString(1, veiculo.getPlaca());
		pstam.setInt(2, veiculo.getAnoFabricacao());

		if(veiculo.getClass().equals(Aeronave.class))
			pstam.setInt(3, VeiculoDaoSql.TIPO_AERONAVE);
		else if(veiculo.getClass().equals(Embarcacoes.class))
			pstam.setInt(3, VeiculoDaoSql.TIPO_EMBARCACOES);
		else if (veiculo.getClass().equals(Terrestres.class))
			pstam.setInt(3, VeiculoDaoSql.TIPO_TERRESTRE);
		else
			pstam.setInt(3, VeiculoDaoSql.TIPO_OUTRO);
		
		pstam.setDouble(4, veiculo.getValorCompra());
		pstam.setString(5, veiculo.getProprietario().getNome());
		
		pstam.executeUpdate();
		pstam.close();
		conn.close();
	}

	
	@Override
	public Veiculo findByPlaca(String placa) throws ClassNotFoundException, SQLException {
		Connection conn = this.getConnection();
		PreparedStatement pstam = conn.prepareStatement(FINDBYNOME);
		pstam.setString(1, placa);
		ResultSet rs = pstam.executeQuery();
		Veiculo veiculo = null;
		
		if(rs.next()){			
			proprietarioDao = new ProprietarioDaoSql();
			if(rs.getInt("CLASSE") == 0)			
				veiculo = new Aeronave(rs.getString("PLACA"), rs.getInt("ANOFABRICACAO"), rs.getDouble("valorCompra"), proprietarioDao.findByNome(rs.getString("proprietario")));			
			else if(rs.getInt("CLASSE") == 1	)		
				veiculo = new Embarcacoes(rs.getString("PLACA"), rs.getInt("ANOFABRICACAO"), rs.getDouble("valorCompra"), proprietarioDao.findByNome(rs.getString("proprietario")));
			else if(rs.getInt("CLASSE") == 2	)		
				veiculo = new Terrestres(rs.getString("PLACA"), rs.getInt("ANOFABRICACAO"), rs.getDouble("valorCompra"), proprietarioDao.findByNome(rs.getString("proprietario")));
			
			//else veiculo = new Terrestres(rs.getString("DESCRICAO"), rs.getString("PLACA"), rs.getInt("ANOFABRICACAO"));
			
		}
	
		rs.close();
		pstam.close();
		conn.close();
		
		return veiculo;
	}

	@Override
	public Collection<Veiculo> findAll() throws ClassNotFoundException, SQLException {
		Connection conn = this.getConnection();
		PreparedStatement pstam = conn.prepareStatement(FINDALL);
		ResultSet rs = pstam.executeQuery();
		List<Veiculo> listVeiculo = new ArrayList<>();	
		Veiculo veiculo = null;
		proprietarioDao = new ProprietarioDaoSql();
		while(rs.next()){
			
			if(rs.getInt("CLASSE") == 0)			
				veiculo = new Aeronave(rs.getString("PLACA"), rs.getInt("ANOFABRICACAO"), rs.getDouble("valorCompra"), proprietarioDao.findByNome(rs.getString("proprietario")));
			
			else if(rs.getInt("CLASSE") == 1	)		
				veiculo = new Embarcacoes(rs.getString("PLACA"), rs.getInt("ANOFABRICACAO"), rs.getDouble("valorCompra"), proprietarioDao.findByNome(rs.getString("proprietario")));
			
			else if(rs.getInt("CLASSE") == 2	)		
				veiculo = new Terrestres(rs.getString("PLACA"), rs.getInt("ANOFABRICACAO"), rs.getDouble("valorCompra"), proprietarioDao.findByNome(rs.getString("proprietario")));
			
			listVeiculo.add(veiculo);
		}
		rs.close();
		pstam.close();
		conn.close();
		
		return listVeiculo;
	}

	@Override
	public void remove(String placa) throws Exception {
		Connection conn = this.getConnection();
		PreparedStatement pstam = conn.prepareStatement(DELETE);
		pstam.setString(1, placa);
		pstam.executeUpdate();
		pstam.close();
		conn.close();
		
	}

	/*public static void main(String[] args) {
		VeiculoDaoSql daoSql = new VeiculoDaoSql();
		Veiculo veiculo = new Veiculo("FIAT", 1, "MGE-3654", 2006);
		try {
			daoSql.create(veiculo);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC n�o encontrado");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("uri, user ou senha incorretos");
			e.printStackTrace();
		};
		
	}*/
	
}
