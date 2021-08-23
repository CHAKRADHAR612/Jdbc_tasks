package com.sonata.jobtrack.dao.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sonata.jobtrack.dao.JobTracker;
import com.sonata.jobtrack.model.Task;
import com.sonata.jobtrack.model.User;

public class JobTrackerImpl implements JobTracker {

	@Override
	public boolean addTask(Task t) {
		boolean added=false;
		Connection con=new MyConnectionImpl().connectToMySql();
//		String sql="INSERT INTO Task VALUES(2,2,'MySQL Training','learning JDBC connectivity','new','high','we have to use JDBC driver',true,'2021-08-20 10:32:30','2021-08-20 10:32:30');";
		String sql="INSERT INTO Task(taskId,ownerId,name,description,status,priority,notes,isBookmarked,createdOn,statusChangedOn) VALUES(?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstatement=con.prepareStatement(sql);
			pstatement.setInt(1,t.getTaskId());
			pstatement.setInt(2, t.getOwnerId());
			pstatement.setString(3,t.getName());
			pstatement.setString(4,t.getDescription());
			pstatement.setString(5,t.getStatus());
			pstatement.setString(6,t.getPriority());
			pstatement.setString(7,t.getNotes());
			pstatement.setBoolean(8,t.getIsBookmarked());
			pstatement.setDate(9, (Date) t.getCreatedOn());
			pstatement.setDate(10, (Date) t.getStatusChangedOn());
			int r=pstatement.executeUpdate();
			pstatement.close();
			con.close();
			if(r>0) {
				added=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return added;
	}

	@Override
	public boolean addUser(User user) {
		boolean added=false;
		Connection con=new MyConnectionImpl().connectToMySql();
		String sql="INSERT INTO User(userId,userName,password,email,firstname,lastname,contactno,role,isActive,dob,createdOn) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstatement=con.prepareStatement(sql);
			pstatement.setInt(1,user.getUserId());
			pstatement.setString(2, user.getUserName());
			pstatement.setString(3, user.getPassword());
			pstatement.setString(4,user.getEmail());
			pstatement.setString(5,user.getFirstName());
			pstatement.setString(6,user.getLastName());
			pstatement.setString(7,user.getContactNumber());
			pstatement.setString(8,user.getRole());
			pstatement.setBoolean(9,user.getIsActive());
			pstatement.setDate(10, (Date) user.getDob());
			pstatement.setDate(11, (Date) user.getCreatedOn());
			int r=pstatement.executeUpdate();
			pstatement.close();
			con.close();
			if(r>0) {
				added=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return added;
	}

	@Override
	public List<Task> getAllTasks() {
		Connection con=new MyConnectionImpl().connectToMySql();
		String sql="SELECT * FROM Task";
		List<Task> taskList=new ArrayList<>();
		try {
			PreparedStatement pstatement=con.prepareStatement(sql);
			ResultSet rs=pstatement.executeQuery();
			while(rs.next()) {
				Task t=new Task();
				t.setTaskId(rs.getInt("taskId"));
				t.setOwnerId(rs.getInt("ownerId"));
				t.setName(rs.getString("name"));
				t.setCreatedOn(rs.getDate("createdOn"));
				t.setDescription(rs.getString("description"));
				t.setIsBookmarked(rs.getBoolean("isBookmarked"));
				t.setNotes(rs.getString("notes"));
				t.setPriority(rs.getString("priority"));
				t.setStatus(rs.getString("status"));
				t.setStatusChangedOn(rs.getDate("statusChangedOn"));
				taskList.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return taskList;
	}

	@Override
	public int updateTaskStatus(int taskId, String status) {
		Connection con=new MyConnectionImpl().connectToMySql();
		String sql="UPDATE Task SET status=? WHERE taskId=?";
		int result=0;
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, status);
			pst.setInt(2, taskId);
			result=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateTaskPriority(int taskId, String priority) {
		Connection con=new MyConnectionImpl().connectToMySql();
		String sql="UPDATE Task SET priority=? WHERE taskId=?";
		int result=0;
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, priority);
			pst.setInt(2, taskId);
			result=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Task> getAllTasksByStatus(String status) {
		Connection con=new MyConnectionImpl().connectToMySql();
		String sql="SELECT * FROM Task WHERE status=?";
		List<Task> taskList=new ArrayList<>();
		try {
			PreparedStatement pstatement=con.prepareStatement(sql);
			pstatement.setString(1,status);
			ResultSet rs=pstatement.executeQuery();
			while(rs.next()) {
				Task t=new Task();
				t.setTaskId(rs.getInt("taskId"));
				t.setOwnerId(rs.getInt("ownerId"));
				t.setName(rs.getString("name"));
				t.setCreatedOn(rs.getDate("createdOn"));
				t.setDescription(rs.getString("description"));
				t.setIsBookmarked(rs.getBoolean("isBookmarked"));
				t.setNotes(rs.getString("notes"));
				t.setPriority(rs.getString("priority"));
				t.setStatus(rs.getString("status"));
				t.setStatusChangedOn(rs.getDate("statusChangedOn"));
				taskList.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return taskList;
	}

	@Override
	public List<Task> getAllTasksByOwner(int ownerId) {
		Connection con=new MyConnectionImpl().connectToMySql();
		String sql="SELECT * FROM Task WHERE ownerId=?";
		List<Task> taskList=new ArrayList<>();
		try {
			PreparedStatement pstatement=con.prepareStatement(sql);
			pstatement.setInt(1,ownerId);
			ResultSet rs=pstatement.executeQuery();
			while(rs.next()) {
				Task t=new Task();
				t.setTaskId(rs.getInt("taskId"));
				t.setOwnerId(rs.getInt("ownerId"));
				t.setName(rs.getString("name"));
				t.setCreatedOn(rs.getDate("createdOn"));
				t.setDescription(rs.getString("description"));
				t.setIsBookmarked(rs.getBoolean("isBookmarked"));
				t.setNotes(rs.getString("notes"));
				t.setPriority(rs.getString("priority"));
				t.setStatus(rs.getString("status"));
				t.setStatusChangedOn(rs.getDate("statusChangedOn"));
				taskList.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return taskList;
	}

	@Override
	public int updateTaskNotes(int taskId, String notes) {
		Connection con=new MyConnectionImpl().connectToMySql();
		String sql="UPDATE Task SET notes=? WHERE taskId=?";
		int result=0;
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, notes);
			pst.setInt(2, taskId);
			result=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateTaskBookmark(int taskId, boolean isBookmarked) {
		Connection con=new MyConnectionImpl().connectToMySql();
		String sql="UPDATE Task SET isBookmarked=? WHERE taskId=?";
		int result=0;
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setBoolean(1, isBookmarked);
			pst.setInt(2, taskId);
			result=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int assignTaskUser(int taskId, int ownerId) {
		Connection con=new MyConnectionImpl().connectToMySql();
		String sql="UPDATE Task SET ownerId=? WHERE taskId=?";
		int result=0;
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, ownerId);
			pst.setInt(2, taskId);
			result=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int callableDemo() throws SQLException {
		Connection con=new MyConnectionImpl().connectToMySql();
			CallableStatement cs=con.prepareCall("{call get_merit_student()}");
			ResultSet rs=cs.executeQuery();
			int count=0;
			while(rs.next()) {
				System.out.println(rs.getInt("stud_id"));
				count++;
			}
			return count;
	}

	@Override
	public void transactionDemo() throws SQLException {
		Connection con=new MyConnectionImpl().connectToMySql();
		con.setAutoCommit(false);
			con.commit();
			con.close();			
	}

	@Override
	public boolean verifyUser(int userId, String password) throws SQLException {
		Connection con=new MyConnectionImpl().connectToMySql();
		PreparedStatement ps=con.prepareStatement("SELECT userId,password FROM user WHERE userId=? AND password=?");
		ps.setInt(1, userId);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		if(rs.next()==true) {
			return true;
		}else
			return false;
	}

	@Override
	public int imageDemo(String path) throws SQLException{
		Connection con=new MyConnectionImpl().connectToMySql();
		PreparedStatement ps=con.prepareStatement("INSERT INTO image VALUES(?)");
		try {
			FileInputStream fin=new FileInputStream(path);
			ps.setBinaryStream(1,fin,fin.available());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int result=ps.executeUpdate();
		return result;
	}

	@Override
	public int[] batchDemo() throws SQLException {
		Connection con=new MyConnectionImpl().connectToMySql();
		String sql1="INSERT INTO task(taskId,ownerId,name) VALUES(5,2,'JDBC1')";
		String sql2="INSERT INTO task(taskId,ownerId,name) VALUES(6,3,'JDBC2')";
		String sql3="INSERT INTO task(taskId,ownerId,name) VALUES(7,4,'JDBC3')";
		String sql4="INSERT INTO task(taskId,ownerId,name) VALUES(8,5,'JDBC4')";
		String sql5="INSERT INTO task(taskId,ownerId,name) VALUES(9,6,'JDBC5')";
		PreparedStatement ps=con.prepareStatement(sql1);
		ps.addBatch(sql2);
		ps.addBatch(sql3);
		ps.addBatch(sql4);
		ps.addBatch(sql5);
		int[] result=ps.executeBatch();
		ps.close();
		con.close();
		return result;
	}

	@Override
	public void resultSetDemo() throws SQLException {
		Connection con=new MyConnectionImpl().connectToMySql();
		Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sql="SELECT * FROM task";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()) {			
			System.out.println(rs.getInt("taskId")+" "+rs.getInt("ownerId")+" "+rs.getString("name"));
		}
	}

}
