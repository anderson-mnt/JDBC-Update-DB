package aplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Program {

	public static void main(String[] args) {
		//Atualizar dados
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"UPDATE seller"
					+ "SET BaseSalary = BaseSalary + ?"
					+ "WHERE "
					+ "(Department = ?)");
			
			st.setDouble(1, 200.0);//substitui o valor usado no SET Salary
			st.setInt(2,2);//substitui o valor usado no where
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done! Rows Afeccted: "+ rowsAffected);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			DB.closeStatemente(st);
			DB.closeConnection();
		}
		
		
	}
}