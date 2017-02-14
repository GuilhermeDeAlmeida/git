package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.ConnectionFactory;
import to.MercadoriaTO;
public class MercadoriaDAO {
	public void incluir(MercadoriaTO to){
		String compra = "Compra";
		String sql = "INSERT INTO `basemercadorias`.`tbloperacao` (`codMercadoria`, `nomeMercadoria`, `tipoMercadoria`, `tipoOperacao`, `quantidadeMercadoria`, `precoMercadoria`) VALUES (?, ?, ?, ?, ?, ?)";
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sql);){
			stm.setInt(1, to.getCod());
			stm.setString(2, to.getNome());
			stm.setString(3, to.getTipo());
			stm.setString(4, compra);
			stm.setInt(5, to.getQuantidade());
			stm.setDouble(6, to.getPreco());
			stm.execute();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void incluirVenda(MercadoriaTO to){
		String compra = "Venda";
		String sql = "INSERT INTO `basemercadorias`.`tbloperacao` (`codMercadoria`, `nomeMercadoria`, `tipoMercadoria`, `tipoOperacao`, `quantidadeMercadoria`, `precoMercadoria`) VALUES (?, ?, ?, ?, ?, ?)";
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sql);){
			stm.setInt(1, to.getCod());
			stm.setString(2, to.getNome());
			stm.setString(3, to.getTipo());
			stm.setString(4, compra);
			stm.setInt(5, to.getQuantidade());
			stm.setDouble(6, to.getPreco());
			stm.execute();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void excluir(int codOperacao){
		String sql = "DELETE FROM `basemercadorias`.`tbloperacao` WHERE `codOperacao`=?";
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sql)){
			stm.setInt(1, codOperacao);
			stm.execute();
		}catch(SQLException e){
					e.printStackTrace();
				}
	}
	public void atualizar(MercadoriaTO to, int codOp){
		String sql = "UPDATE `basemercadorias`.`tbloperacao` SET `codMercadoria`=?, `nomeMercadoria`=?, `tipoMercadoria`=?, `quantidadeMercadoria`=?, `precoMercadoria`=? WHERE `codOperacao`=?";
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sql)){
			stm.setInt(1, to.getCod());
			stm.setString(2, to.getNome());
			stm.setString(3, to.getTipo());
			stm.setInt(4, to.getQuantidade());
			stm.setDouble(5, to.getPreco());
			stm.setInt(6, codOp);
			stm.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//Carrega os dados de uma operação de uma mercadoria, e a coloca em uma TO
	public MercadoriaTO carregar(int cod){
		MercadoriaTO to = new MercadoriaTO();
		String sql = "Select * from tbloperacao where codOperacao = ?";	
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sql);){
			stm.setInt(1, cod);
			try(ResultSet rs = stm.executeQuery();){
				if(rs.next()){
					to.setNome(rs.getString("nomeMercadoria"));
					to.setPreco(rs.getDouble("precoMercadoria"));
					to.setQuantidade(rs.getInt("quantidadeMercadoria"));
					to.setTipo(rs.getString("tipoMercadoria"));
					to.setCod(rs.getInt("codMercadoria"));
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			
		}catch(SQLException e){
			System.out.print(e.getStackTrace());
		}		
		return to;
	}
	
}
