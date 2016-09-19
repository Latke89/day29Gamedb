package com.tiy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

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
}
