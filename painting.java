import java.util.*;
import java.lang.*;

class Painting extends Masterpiece
{
	enum technique_type
	{
		OIL,
		AQUARELLE,
		TEMPERA;
	}

	int length;
	int width;
	int surface;
	technique_type technique;

	// Constructor
	public Painting(final int my_index, final String my_creator, final int my_year)
	{
		super(my_index,my_creator,my_year);
		Random rand = new Random();
		length = rand.nextInt(1920)+1;
		width = rand.nextInt(1280)+1;
		surface = length*width;
		technique = technique_type.values()[rand.nextInt(3)];
		System.out.println("Creating an instance of painting");
	}

	// Accessor
	public void getInfo()
	{
		super.getInfo();
		System.out.println("Length: " + length + "\n"
			 			   + "Width: " + width + "\n"
			 			   + "Surface: " + surface);
		switch(technique)
		{
			case OIL: System.out.println("Technique: oil"); break;
			case AQUARELLE: System.out.println("Technique: aquarelle"); break;
			case TEMPERA: System.out.println("Technique: tempera"); break;
		}
	}

	// Comparison
	public int evaluate(final int my_movement, final int my_condition)
	{
		if ((movement_type.values()[my_movement] == movement) && ((condition_type.values()[my_condition] == condition) || (my_condition == 1 && condition == condition_type.values()[2])))
			return 1;
		return 0;
	}
	public int evaluate(final int my_movement) { return evaluate(my_movement, 1); }
}