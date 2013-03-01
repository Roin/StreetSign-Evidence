package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;

import model.Primitive;
import model.Relation;

public class CSVParser {

	private File file;

	private String[] primString;
	private String[] relString;
	private ArrayList<Primitive> primitives;
	private ArrayList<Relation> relations;

	public CSVParser(String filepath) {
		primitives = new ArrayList<Primitive>();
		relations = new ArrayList<Relation>();
		
		file = new File(filepath);
		splitRegions();
		parse();
	}

	public void parse() {
		Primitive tmpPrim;
		Relation tmpRel;
		// Parse primitives
		for(String prim: primString)
		{
			String data[] = prim.trim().split(",");
			System.out.println(data[1]);
			

		}
		
		for(String rel: relString)
		{
			
		}

	}

	// Teilt in prmitives und relations auf
	private void splitRegions() {
		String fileData = getFileContents(file);

		String[] regions = fileData.split(";");
		primString = regions[0].trim().split("\n");
		relString = regions[1].trim().split("\n");
		


		// System.out.println("Primitives: \n" + primitives + "\nRelations: \n"
		// + relations);

	}

	private static String getFileContents(File file) {
		FileInputStream fin;
		try {
			fin = new FileInputStream(file);
			FileChannel fch = fin.getChannel();

			// map the contents of the file into ByteBuffer
			ByteBuffer byteBuff;

			byteBuff = fch.map(FileChannel.MapMode.READ_ONLY, 0, fch.size());

			// convert ByteBuffer to CharBuffer
			// CharBuffer chBuff = Charset.defaultCharset().decode(byteBuff);
			CharBuffer chBuff = Charset.forName("UTF-8").decode(byteBuff);
			return chBuff.toString();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println("Return null @ CSVParser/getFileContents");
		return null;

	}

}
