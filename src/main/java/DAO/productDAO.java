package DAO;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import com.oracle.wls.shaded.org.apache.bcel.generic.RETURN;
import com.oracle.wls.shaded.org.apache.xml.utils.ListingErrorHandler;

import BEAN.Acount;
import BEAN.category;
import BEAN.product;

public class productDAO {
	private String jdbcUrl ="jdbc:mysql://localhost:3306/data1";
	//private String jdbcUrl ="jdbc:mysql://node289440-admin.j.layershift.co.uk";
	private String jdbcName ="root";
	private String jdbcPass ="12345";
	//private String jdbcPass ="PBRygb95227";
	private String jdbcDriver ="com.mysql.cj.jdbc.Driver";
	
	private static final String INSERT ="INSERT INTO newUser(name,email,ct) VALUES(?,?,?)";
	private static final String SELECT_BY_ID ="select id,name,email,ct from newUser where id =?;";
	private static final String SELECT_ALL ="select * from ";
	private static final String DELETE ="delete from newUser where id = ?;";
	private static final String UPDATE ="update newUser set name =? , email=? , ct =? where id=?;";
	
	protected Connection getConnect() {
		Connection connection = null;
		try {
			Class.forName(jdbcDriver);
			connection = DriverManager.getConnection(jdbcUrl, jdbcName, jdbcPass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public productDAO() {
		// TODO Auto-generated constructor stub
	}
	
	// product
	public List<product> getAllproduct() {
		List<product> list = new ArrayList<product>();
		try(Connection connection = getConnect();
				PreparedStatement pt = connection.prepareStatement(SELECT_ALL +"data1.data;")){
				ResultSet rs = pt.executeQuery();
				while(rs.next()) {
					list.add(new product(
							rs.getInt(1), 
							rs.getString(2), 
							rs.getString(3), 
							rs.getDouble(4), 
							rs.getString(5), 
							rs.getString(6))
							
							);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return list;
	}
	
	
	public List<product> get_top4_product() {
		List<product> list = new ArrayList<product>();
		try(Connection connection = getConnect();
				PreparedStatement pt = connection.prepareStatement("SELECT * FROM data1.data\r\n"
						+ "LIMIT 4;")){
				ResultSet rs = pt.executeQuery();
				while(rs.next()) {
					list.add(new product(
							rs.getInt(1), 
							rs.getString(2), 
							rs.getString(3), 
							rs.getDouble(4), 
							rs.getString(5), 
							rs.getString(6))
							
							);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return list;
	}
	
	
	public List<product> get_next_product(String amount) {
		List<product> list = new ArrayList<product>();
		try(Connection connection = getConnect();
				PreparedStatement pt = connection.prepareStatement("SELECT * FROM data1.data LIMIT 4 OFFSET "+amount)){
				
				ResultSet rs = pt.executeQuery();
				
				while(rs.next()) {
					list.add(new product(
							rs.getInt(1), 
							rs.getString(2), 
							rs.getString(3), 
							rs.getDouble(4), 
							rs.getString(5), 
							rs.getString(6))
							
							);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return list;
	}
	
	
	
	//category
	public List<category> getAll_category() {
		List<category> listc = new ArrayList<category>();
		try(Connection connection = getConnect();
				PreparedStatement pt = connection.prepareStatement(SELECT_ALL + "data1.category;")){
				ResultSet rs = pt.executeQuery();
				while(rs.next()) {
					listc.add(new category (
							rs.getInt(1), 
							rs.getString(2) )
							);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return listc;
	}
	
	// max_id_prodcut
	public product get_MAX_idProduct() {
		try(Connection connection = getConnect();
				PreparedStatement pt = connection.prepareStatement("SELECT * FROM data ORDER BY id DESC" )){
				ResultSet rs = pt.executeQuery();
				while(rs.next()) {
					return	new product(rs.getInt(1), 
									rs.getString(2), 
									rs.getString(3), 
									rs.getDouble(4), 
									rs.getString(5), 
									rs.getString(6)
									);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;			
		
	}
	
	// product by category id
	public List<product> getAllproduct_byid(String cid) {
		 final String query ="SELECT * FROM data1.data where cID = ?";
				
		List<product> list = new ArrayList<product>();
		try(Connection connection = getConnect();
				PreparedStatement pt = connection.prepareStatement(query)){
				pt.setString(1, cid);
				ResultSet rs = pt.executeQuery();
				while(rs.next()) {
					list.add(new product(
							rs.getInt(1), 
							rs.getString(2), 
							rs.getString(3), 
							rs.getDouble(4), 
							rs.getString(5), 
							rs.getString(6))
							
							);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return list;
	}
	
	// get product by id 
	public product get_one_product_by_id(String id) {
		 final String query ="SELECT * FROM data1.data where id = ?";
		try(Connection connection = getConnect();
				PreparedStatement pt = connection.prepareStatement(query)){
				pt.setString(1, id);
				ResultSet rs = pt.executeQuery();
				while(rs.next()) {
					return (new product(
							rs.getInt(1), 
							rs.getString(2), 
							rs.getString(3), 
							rs.getDouble(4), 
							rs.getString(5), 
							rs.getString(6))
							
							);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return null;
	}
	
	// Acount register
	
	public void Register(String name, String pass) {
		final String query = "Insert into acount(name,pass,isAdmin,Issell) values(?,?,0,0)";
		try(Connection connection = getConnect();
				PreparedStatement pt = connection.prepareStatement(query)){
				pt.setString(1, name);
				pt.setString(2, pass);
				pt.executeUpdate();
				pt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		
	}
	public boolean check_acount(String name) {
		final String query = "SELECT * FROM data1.acount\r\n"
				                  + "where name = ?";
		try(Connection connection = getConnect();
				PreparedStatement pt = connection.prepareStatement(query)){
				pt.setString(1, name);
				ResultSet resultSet = pt.executeQuery();
				while(resultSet.next()) {
					 Acount acount =new Acount(resultSet.getInt(1),resultSet.getString(2), resultSet.getString(3), 0, 0);
					if(acount!=null)return true;
					}
				pt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return false;
	}
	
	public Acount check_acount_login(String name,String pass) {
		final String query = "SELECT * FROM data1.acount\r\n"
				                  + "where name = ? and pass = ?";
		try(Connection connection = getConnect();
				PreparedStatement pt = connection.prepareStatement(query)){
				pt.setString(1, name);
				pt.setString(2, pass);
				ResultSet resultSet = pt.executeQuery();
				while(resultSet.next()) {
				 return new Acount(
						 resultSet.getInt(1), 
						 resultSet.getString(2), 
						 resultSet.getString(3), 
						 resultSet.getInt(4), 
						 resultSet.getInt(5)
						 
						 );
				}
				
				pt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}
	
	
	public void Delete_Product(String pid) {
		final String query = "delete from data1.data\r\n"
							+ "where id = ?";
		try(Connection connection = getConnect();
				PreparedStatement pt = connection.prepareStatement(query)){
				pt.setString(1, pid);
				pt.executeUpdate();
				pt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		
	}
	
	public List<product> getAllproduct_by_seachtxt(String txt) {
		 final String query ="SELECT * FROM data1.data\r\n"
		 		+ "where name like ?";
				
		List<product> list = new ArrayList<product>();
		try(Connection connection = getConnect();
				PreparedStatement pt = connection.prepareStatement(query)){
				pt.setString(1, "%" + txt +"%");
				ResultSet rs = pt.executeQuery();
				while(rs.next()) {
					list.add(new product(
							rs.getInt(1), 
							rs.getString(2), 
							rs.getString(3), 
							rs.getDouble(4), 
							rs.getString(5), 
							rs.getString(6))
							
							);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return list;
	}
	public List<product> getAllproduct_by_sell_ID(int sid) {
		 final String query ="SELECT * FROM data1.data where sID = ?";
				
		List<product> list = new ArrayList<product>();
		try(Connection connection = getConnect();
				PreparedStatement pt = connection.prepareStatement(query)){
				pt.setInt(1, sid);
				ResultSet rs = pt.executeQuery();
				while(rs.next()) {
					list.add(new product(
							rs.getInt(1), 
							rs.getString(2), 
							rs.getString(3), 
							rs.getDouble(4), 
							rs.getString(5), 
							rs.getString(6))
							
							);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return list;
	}
	
	
	
	
	
	public void Add(String name, String image,String price,
			String title,String description,String category ,int sid) {
		
		final String query = "insert into data1.data (name,image,price,title,des,cID,sId)\r\n"
				+ "values(?,?,?,?,?,?,?)";
		try(Connection connection = getConnect();
				PreparedStatement pt = connection.prepareStatement(query)){
				pt.setString(1, name);
				pt.setString(2, image);
				pt.setString(3, price);
				pt.setString(4, title);
				pt.setString(5, description);
				pt.setString(6, category);
				pt.setInt(7, sid);
				pt.executeUpdate();
				pt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		
	}
	
	
	
	public void edit(String name, String image,String price,
			String title,String description,String category,String id ) {
		
		final String query = "update data1.data\r\n"
				+ "set name = ?,image = ?,price = ?, title = ?,des  = ?,cId = ? where id = ?";
		try(Connection connection = getConnect();
				PreparedStatement pt = connection.prepareStatement(query)){
				pt.setString(1, name);
				pt.setString(2, image);
				pt.setString(3, price);
				pt.setString(4, title);
				pt.setString(5, description);
				pt.setString(6, category);	
				pt.setString(7, id);	
				pt.executeUpdate();
				pt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		
	}
	
	 public static void main(String[] args) {
		productDAO DAO = new productDAO();
		
		
		System.out.println(DAO.get_next_product("3"));
		
		
		
	}
}
