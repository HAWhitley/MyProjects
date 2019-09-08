/*
* Hangman game that repeats if the user wants to play again
*
* by Holland Whitley
*/

#include <iostream>
#include <string>
#include <fstream>
#include <cctype>
#include <iomanip>

using namespace std;

const int ARRAY_SIZE = 100;
const int MAX_INCORRECT = 5;

//stores a phrase, number of letters in phrase, and if phrase has been used
struct Phrase
{
	string text;
	string::size_type guessesRequired;
	bool isUsed;
};

//gets phrases from a file
void loadPhrasesFromFile(string fileName, Phrase filePhrases[], int& length);

//returns number of letters in a phrase
int uniqueLetterCount(const string& input);

//sorts the phrases by length
void sortPhrases(int length, Phrase filePhrases[]);

//swaps strings according to string length
void swapValues(int index, int smallestGuesses, Phrase filePhrases[]);

//receives the desired difficulty level from the user
int getDifficultyLevel(int length);

//gets a random index number based on difficulty level
int getRandomNumber(int length, int diffLev);

//determines if a character is a letter or not
bool isLetter(char specLetter);

//runs the game
void runGame(Phrase gamePhrase);

//creates a phrase with blanks
string phraseWithBlanks(const string& text, const string& correctGuess);

//draws the setup for hangman
void drawGallows(int missCount);

int main()
{
	int selectedPhrase, randomNum, index;
	char yesOrNo;

	//allows the array size to be changed
	int phraseCount = ARRAY_SIZE;

	//file name of list of phrases
	string fileName = "phrases.txt";

	//array of phrases
	Phrase filePhrases[ARRAY_SIZE];

	srand(static_cast<unsigned int>(time(nullptr)));

	//gets phrases from a file
	loadPhrasesFromFile(fileName, filePhrases, phraseCount);

	//sorts phrases according to amount of unique letters
	sortPhrases(phraseCount, filePhrases);

	//assigns the index of the selected phrase to selectedPhrase
	selectedPhrase = getDifficultyLevel(phraseCount);

	do
	{
		//generates a random index based on the difficulty level
		do
		{
			index = getRandomNumber(phraseCount, selectedPhrase);
		}
		while (filePhrases[index].isUsed);

		//runs the game
		runGame(filePhrases[index]);

		//once a phrase has been used, assigns the phrase as used
		filePhrases[index].isUsed = true;

		//counts how many time the loop runs
		randomNum++;

		//if the number of loop runs equals amount of phrases in difficulty
		//level, ends the program. Otherwise go to else statement
		if(randomNum == (phraseCount / 3) && selectedPhrase != 3)
		{
			return 0;
		}
		else if (randomNum == ((phraseCount / 3) + (phraseCount % 3)))
		{
			return 0;
		}
		else
		{
			//asks user if they want to play again
			cout << "Do you want to play again? (y/n)" << endl;
			cin >> yesOrNo;
			
			while (yesOrNo != 'y' && yesOrNo != 'n' && 
				yesOrNo != 'Y' && yesOrNo != 'N')
			{
				cout << "Invalid input. Enter 'y' or 'n': ";
				cin >> yesOrNo;
			}
		}
		//if users answers with yes, restarts game	
	}
	while (yesOrNo == 'y' || yesOrNo == 'Y');

	return 0;
}

//Part 1
void loadPhrasesFromFile(string fileName, Phrase filePhrases[], int& length)
{
	ifstream phraseIn;
	int realLength = 0;

	//opens a file
	phraseIn.open(fileName);

	//inputs strings until the end of file or array
	while(!phraseIn.eof() && realLength < length)
	{
		//gets a line of text and inputs it into one array component
		getline(phraseIn, filePhrases[realLength].text);

		//initializes the use of each phrase to false
		filePhrases[realLength].isUsed = false;

		//gets the amounts of guesses required by amount of unique letters
		filePhrases[realLength].guessesRequired = 
			uniqueLetterCount(filePhrases[realLength].text);

		//increases current array length
		realLength++;
	}

	//assigns the current array length to the array length used
	length = realLength;

	//closes file
	phraseIn.close();
}

//Part 1
int uniqueLetterCount(const string& input)
{
	string lowerCase;
	
	//accounts for each character in a string
	for (char ch : input)
	{
		//allows string to be case insensitive
		ch = tolower(ch);
		if (isLetter(ch) && lowerCase.find(ch) == string::npos)
		{
			//adds all unique letters to one string
			lowerCase += ch;
		}
	}

	//returns amount of unique letters
	return lowerCase.length();
}

//Part 1
void sortPhrases(int length, Phrase filePhrases[])
{
	int smallestGuesses; 
	int index;

	for (index = 0; index < length - 1; index++)
	{
		//initially assigns the smallest amount of guesses to first component
		smallestGuesses = index;
		for (int newIndex = index + 1; newIndex < length; newIndex++)
		{
			//reassigns smallest index if there is a smaller index
			if (filePhrases[newIndex].guessesRequired <
				filePhrases[smallestGuesses].guessesRequired)
			{
				smallestGuesses = newIndex;
			}
		}

		//swaps the value of smaller index with the value of current index
		swapValues(index, smallestGuesses, filePhrases);
	}
}

//Part 1
void swapValues(int index, int smallestGuesses, Phrase filePhrases[])
{
	//swaps values of each phrase
	Phrase temp = filePhrases[smallestGuesses];
	filePhrases[smallestGuesses] = filePhrases[index];
	filePhrases[index] = temp;
}

//Part 3
int getDifficultyLevel(int length)
{
	int diffLev;
	cout << "Please enter a desired difficulty level: " << endl;
	cout << "\t 1- Easy" << endl;
	cout << "\t 2- Medium" << endl;
	cout << "\t 3- Hard" << endl;

	//gets a desired difficulty level from user
	cin >> diffLev;

	while(diffLev < 1 || diffLev > 3)
	{
		cout << "Invalid input. Enter a number from 1 to 3: ";
		cin >> diffLev;
	}
	
	return diffLev;
}

//Part 3
int getRandomNumber(int length, int diffLev)
{
	int min, range;

	//generates a random number based on the difficulty level
	range = length / 3;
	min = range * (diffLev - 1);
	if (diffLev == 3)
	{
		range += length % 3;
	}

	return rand() % range + min;
}

bool isLetter(char specLetter)
{
	//determines if a character is a letter or not
	if (specLetter >= 'A' && specLetter <= 'Z' ||
		specLetter >= 'a' && specLetter <= 'z')
	{
		return true;
	}
	else
	{
		return false;
	}
}

//Part 4
void runGame(Phrase gamePhrase)
{
	int incorrect = 0;
	string::size_type correct = 0;
	string correctGuess, printPhrase;
	char userGuess;

	do
	{
		//initially draws the gallows
		drawGallows(incorrect);

		//outputs the phrase with blanks
		cout << phraseWithBlanks(gamePhrase.text, correctGuess) << endl;
		cout << endl;

		//asks user to enter a letter
		cout << "Enter a letter: ";
		cin >> userGuess;
		cout << endl;
		
		//if the input is not a letter, continues to ask for letter
		while (!isLetter(userGuess))
		{
			cout << userGuess << " is not a valid guess." << endl;
			cout << " Please enter a letter.";
			cin >> userGuess;
			cout << endl;
		}

		//makes user input lowercase
		userGuess = tolower(userGuess);

		//if the letter has already been guessed, asks for new letter
		if (printPhrase.find(userGuess) != string::npos || 
			correctGuess.find(userGuess) != string::npos)
		{
			cout << "You have already guessed " << userGuess << endl;

			//Outputs incorrectly guessed letters
			cout << "Incorrect letters Guessed: " << printPhrase << endl;
			cout << endl;
		}
		//if a guess is incorrect, adds to the number of incorrect guesses
		else if (gamePhrase.text.find(userGuess) == string::npos && 
			gamePhrase.text.find(toupper(userGuess)) == string::npos)
		{
			incorrect++;
			//outputs the letters that have been guessed
			printPhrase += userGuess;
			cout << "Sorry, bad guess." << endl;

			//Outputs incorrectly guessed letters
			cout << "Incorrect letters guessed: " << printPhrase << endl;
			cout << endl;
		}
		//if guess is correct, adds to number of correct guesses
		else
		{
			correct++;
			//list of correct guesses
			correctGuess += userGuess;

			cout << "Good guess!" << endl;

			//Outputs incorrectly guessed letters
			cout << "Incorrect letters guessed: " << printPhrase << endl;
			cout << endl;
		}
	}
	while (incorrect < MAX_INCORRECT && correct < gamePhrase.guessesRequired);

	//draws the final gallows and outputs final format of guessed phrase
	drawGallows(incorrect);
	cout << phraseWithBlanks(gamePhrase.text, correctGuess) << endl;

	//outputs if the player died or won
	if (incorrect < 5)
	{
		cout << "You win!" << endl;
	}
	else
	{
		cout << "You're dead.";
		cout << "The phrase was: " << gamePhrase.text << endl;
	}
}

//Part 2
string phraseWithBlanks(const string& text, const string& correctGuess)
{
	int count = 0;
	string blanks;
	for (char ch : text)
	{
		ch = tolower(ch);
		if (isLetter(ch) && correctGuess.find(ch) == string::npos)
		{
			//adds a blank if the letter guessed is not in the phrase
			blanks += "_ ";
		}
		else
		{
			if (text[count] == toupper(ch))
			{
				//adds uppercase letter to phrase
				blanks += toupper(ch);
				blanks += " ";
			}
			else
			{
				//adds lowercase letter or punctuation to phrase
				blanks += ch;
				blanks += " ";
			}
		}
		count++;
	}

	return blanks;
}

void drawGallows(int missCount)
{
	// Output the top of the gallows
	cout
		<< "   +----+     \n"
		<< "   |    |     \n";

	// Output the stand and body
	switch (missCount)
	{
	case 0:
		cout
			<< "   |       \n"
			<< "   |       \n"
			<< "   |       \n"
			<< "   |       \n";
		break;

	case 1:
		cout
			<< "   |    O  \n"
			<< "   |    |  \n"
			<< "   |       \n"
			<< "   |       \n";
		break;

	case 2:
		cout
			<< "   |    O  \n"
			<< "   |   /|  \n"
			<< "   |       \n"
			<< "   |       \n";
		break;

	case 3:
		// The '\\' will output as '\', because it is a special char
		cout
			<< "   |    O   \n"
			<< "   |   /|\\ \n"
			<< "   |        \n"
			<< "   |        \n";
		break;

	case 4:
		cout
			<< "   |    O   \n"
			<< "   |   /|\\ \n"
			<< "   |     \\ \n"
			<< "   |        \n";
		break;

	default:
		cout
			<< "   |    O    \n"
			<< "   |   /|\\  \n"
			<< "   |   / \\  \n"
			<< "   |You're Dead\n";
	}

	// Output the base
	cout << "  =============\n" << endl;
}