package com.sonata.jobtrack.dao;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import com.sonata.jobtrack.model.Task;
import com.sonata.jobtrack.model.User;

public interface JobTracker {
	public boolean addTask(Task task);
	public boolean addUser(User user);
	public List<Task> getAllTasks();
	public List<Task> getAllTasksByStatus(String status);
	public List<Task> getAllTasksByOwner(int ownerId);
	public int updateTaskStatus(int taskId,String status);
	public int updateTaskPriority(int taskId,String priority);
	public int updateTaskNotes(int taskId,String notes);
	public int updateTaskBookmark(int taskId,boolean isBookmarked);
	public int assignTaskUser(int taskId,int ownerId);
	public int callableDemo() throws SQLException;
	public void transactionDemo() throws SQLException;
	public boolean verifyUser(int userId,String password) throws SQLException;
	public int imageDemo(String path) throws SQLException, FileNotFoundException;
	public int[] batchDemo() throws SQLException;
	public void resultSetDemo() throws SQLException;
}
