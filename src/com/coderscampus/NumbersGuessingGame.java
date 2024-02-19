package com.coderscampus;

import java.util.Random;
import java.util.Scanner;

public class NumbersGuessingGame {

	public static void main(String[] args) {
		guessTheNumber();
	}

	public static void guessTheNumber() {

		Random random = new Random();
		int randomNumber = random.nextInt(100) + 1;
		int attemptsLeft = 5;

		Scanner scanner = new Scanner(System.in);

		while (attemptsLeft > 0) {
			try {

				System.out.print("Pick a number between 1 and 100: ");
				int playerGuess = scanner.nextInt();

				if (playerGuess >= 1 && playerGuess <= 100) {

					if (playerGuess == randomNumber) {
						System.out.println("You win!");
						break;
					} else if (playerGuess < randomNumber) {
						System.out.println("Please pick a higher number.");
					} else {
						System.out.println("Please pick a lower number.");
					}

					attemptsLeft--;
					System.out.println("Attempts left: " + attemptsLeft);
				} else {
					System.out.println("Your guess is not between 1 and 100, please try again.");
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid integer.");
				scanner.next();
			}
		}

		if (attemptsLeft == 0) {
			System.out.println("You lose. The number to guess was " + randomNumber);
		}

		scanner.close();
	}
}
