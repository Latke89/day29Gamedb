package com.tiy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brett on 9/19/16.
 */
@RestController
public class GameJsonRestController {

	@Autowired
	GameRepository games;


	@RequestMapping(path = "/games.json", method = RequestMethod.GET) //does not need to be named .json
	public ArrayList<Game> gamesJson() {
		ArrayList<Game> gameList = new ArrayList<Game>();
		Iterable<Game> allGames = games.findAll();
		for (Game game : allGames) {
			gameList.add(game);
		}

		try {
			System.out.println("Catching a nap!");
			Thread.sleep(3000);
			System.out.println("waking up!");
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return gameList;
	}

	@RequestMapping(path = "/toggleGame.json", method = RequestMethod.GET)
	public List<Game> toggleGame(int gameID) {
		System.out.println("toggling game with ID " + gameID);
		Game game = games.findOne(gameID);
		game.name = "**" + game.name;
		games.save(game);

		return gamesJson();
	}

	@RequestMapping(path = "/addGame.json", method = RequestMethod.POST)
	public List<Game> addGame(HttpSession session, @RequestBody Game game) throws Exception {
		User user = (User)session.getAttribute("user");

		if (user == null) {
			throw new Exception("Unable to add game without an active user in the session");
		}
		game.user = user;

		games.save(game);

		return gamesJson();
	}


}
