package com.beingjavaguys.dao.user;

import java.util.List;

import com.beingjavaguys.models.UserData;

public interface UserDao {
	public void add(UserData userData);

	public List<Object> get(int limit, int pageno);

	public UserData get(int userId);

	public void delete(UserData userData);

}
