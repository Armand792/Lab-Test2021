package ie.tudublin;

import java.util.ArrayList;

import ie.tudublin.Note;

import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{
	String score = "DEFGABcd";
	//String score = "D2E2F2G2A2B2c2d2";
	//String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";

	ArrayList<Note> notes;
	
	public void settings()
	{
		size(1000, 500);

		// How to convert a character to a number
		char c = '7'; // c holds the character 7 (55)
		int i = c - '0'; // i holds the number 7 (55 - 48) 
		println(i);
	}

	public void setup() 
	{ 
		
		notes = new ArrayList<Note>();

		loadScore();
		printScore();
		
	}

	public void draw()
	{
		background(255);
		
	}

	void loadScore(){

		for(int i=0;i<score.length(); i++){
			char currentNote = score.charAt(i);
			int currentDuration = 1;

			if(i+1 != score.length()){
				char nextChar = score.charAt(i+1);
				if(Character.isDigit(nextChar)){
					currentDuration = nextChar - '0';
					i++;
				}
			}
			Note note = new Note(currentNote, currentDuration);
			notes.add(note);
			
		}
	}

	void printScore(){
		for (Note note:notes){
			println(note.getNote() + note.getDuration());

		}
	}

	void drawNotes()
	{
	}
}
