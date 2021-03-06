package de.scandio.e4.worker.services;

import de.scandio.e4.client.WorkerRestUtil;
import de.scandio.e4.worker.util.UserCredentials;
import de.scandio.e4.worker.util.WorkerUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Saves and provides user credentials for the target application.
 */
@Service
public class UserCredentialsService {
	/**
	 * Currently every user has the same password - this might change in the future.
	 */
	public static final String STANDARD_PASSWORD = "password";

	private List<UserCredentials> storedUsers = new ArrayList<>();

	public final void reset() {
		storedUsers = new ArrayList<>();
	}

	/**
	 * When the PreparationService has successfully created a user it will store it in here.
	 * @param user The username.
	 */
//	public final void store(String user) {
//		storedUsers.add(user);
//	}

	/**
	 * Returns all stored users.
	 * @return All users.
	 */
	public final List<UserCredentials> getAllUsers() {
		return storedUsers;
	}

	public void storeUsers(List<UserCredentials> users) {
		this.storedUsers = users;
	}

	public UserCredentials getRandomUser() {
		return WorkerUtils.getRandomItem(getAllUsers());
	}
}
