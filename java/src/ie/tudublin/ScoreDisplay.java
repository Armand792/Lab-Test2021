package ie.tudublin;

import java.util.ArrayList;

import javax.swing.border.Border;

import ie.tudublin.Note;

import processing.core.PApplet;

public class ScoreDisplay extends PApplet {
	// String score = "DEFGABcd";
	// String score = "D2E2F2G2A2B2c2d2";
	String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";

	ArrayList<Note> notes;

	public void settings() {
		size(1000, 500);
	}

	public void setup() {

		notes = new ArrayList<Note>();

		loadScore();
		printScore();

	}

	public void draw() {
		background(255);
		drawStaveLines();
		drawNotes();
	}

	void loadScore() {

		for (int i = 0; i < score.length(); i++) {
			char currentNote = score.charAt(i);
			int currentDuration = 1;

			if (i + 1 != score.length()) {
				char nextChar = score.charAt(i + 1);
				if (Character.isDigit(nextChar)) {
					currentDuration = nextChar - '0';
					i++;
				}
			}
			Note note = new Note(currentNote, currentDuration);
			notes.add(note);

		}
	}

	void printScore() {
		for (Note note : notes) {
			System.out.printf(note.getNote() + " " + note.getDuration());
			if (note.getDuration() == 1) {
				System.out.println(" Quaver");
			} else {
				System.out.println(" Crotchet");
			}
		}
	}

	void drawStaveLines() {
		int topborder = 300;
		int border = 100;
		stroke(0);

		float y;
		for (int i = 0; i < 5; i++)
		{
			y = map(i, 0, 4, topborder, height - topborder);
			stroke(0);
			line(border, y, width - border, y);
		}
	}

	void drawNotes() {
		float posX = 0;
		float posY = 150;
		float ellipseX = 0;
		float ellipseY = 0;
		float lineX = 0;
		float lineY1 = 0;
		float lineY2 = 0;

		int border = 100;

		for (int i = 0; i < notes.size(); i++) {
			posX = map(i, 0, notes.size(), border, width - border);
			ellipseX = map(i, 0, notes.size(), border, width - border);
			ellipseY = map(i, 0, notes.size(), 290, 190);
			lineX = map(i, 0, notes.size(), border + 10, width - border);
			lineY1 = map(i, 0, notes.size(), 285, 195);
			lineY2 = map(i, 0, notes.size(), 240, 150);

			float x = map(i, 0, notes.size(), 210, 790);

			if (mouseX > (x - 12) && mouseX < (x + 12)) {
				stroke(255, 0, 0);
				fill(255, 0, 0);
			} else {
				fill(0);
				stroke(0);
			}

			textSize(30);
			text(notes.get(i).getNote(), posX, posY);
			ellipse(ellipseX, ellipseY, 24, 24);
			fill(0);
			line(lineX, lineY1, lineX, lineY2);

			strokeWeight(2);
		}
	}
}
