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
import java.util.HashMap;
import java.util.ListIterator;

import model.Primitive;
import model.Relation;

public class CSVParser {

	private File file;

	private HashMap<Integer, Primitive> primitives;
	private ArrayList<Relation> relations;

	public CSVParser(String filepath) {
		primitives = new HashMap<Integer, Primitive>();
		relations = new ArrayList<Relation>();

		file = new File(filepath);
		parse();
	}

	public void parse() {
		Primitive tmpPrim;
		Relation tmpRel;

		// Teilt das file in primitives und relations auf
		String fileData = getFileContents(file);
		String[] regions = fileData.split(";");
		String[] primString = regions[0].trim().split("\n");
		String[] relString = regions[1].trim().split("\n");

		// Parse primitives
		for (String prim : primString) {
			String data[] = prim.trim().split(",");
			int id = new Integer(data[1].split("x")[1]);
			
			// Does this Primitive already exist?
			if (primitives.containsKey(id)) {
				// Yes: Add to existing Primitive
				primitives.get(id).addToMap(data[0].trim(), Double.parseDouble(data[2].trim()));
			} else {
				// No: Create to new Primitive
				tmpPrim = new Primitive();
				tmpPrim.setId(id);
				tmpPrim.addToMap(data[0].trim(), Double.parseDouble(data[2]));
				primitives.put(id, tmpPrim);
			}
		}
		

		// Parse relations
		for (String rel : relString) {
			String data[] = rel.trim().split(",");
			tmpRel = new Relation();
			tmpRel.setType(data[0].trim());
			
			int idPrim1 = new Integer(data[1].split("x")[1]);
			int idPrim2 = new Integer(data[2].split("x")[1]);
			
			tmpRel.setPrim1(primitives.get(idPrim1));
			tmpRel.setPrim2(primitives.get(idPrim2));
			
			relations.add(tmpRel);
		}

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
