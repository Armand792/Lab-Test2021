package ie.tudublin;

import java.util.ArrayList;

import ie.tudublin.Note;

import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{
	//String score = "DEFGABcd";
	//String score = "D2E2F2G2A2B2c2d2";
	String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";

	ArrayList<Note> notes;
	
	public void settings()
	{
		size(1000, 500);
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
		drawStaveLines();
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
			System.out.printf(note.getNote() + " " + note.getDuration() );
			if(note.getDuration() == 1){
				System.out.println(" Quaver");
			}
			else{
				System.out.println(" Crotchet");
			}s
		}
	}

	void drawStaveLines(){
		stroke(0);
		line(200, 200, 800, 200);
		line(200, 220, 800, 220);
		line(200, 240, 800, 240);
		line(200, 260, 800, 260);
		line(200, 280, 800, 280);
	}


	void drawNotes()
	{
	}
}
