import java.util.*;
import java.lang.*;

abstract class Artifact
{
	int index;
	String creator;
	int year;

	// Constructor
	public Artifact(final int my_index, final String my_creator, final int my_year)
	{
		index = my_index;
		creator = my_creator;
		year = my_year;
		System.out.println("Creating an instance of artifact");
	}

	// Accessors
	public void getIndex() { System.out.println("Index: " + index); }
	public void getInfo()
	{
		System.out.println("Creator: " + creator + "\n"
			 			   + "Year: " + year);
	}

	// Evaluate
	abstract public int evaluate(final int my_movement, final int my_condition);
	abstract public int evaluate(final int my_movement);
}