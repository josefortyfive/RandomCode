package doomtest2;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.awt.Point;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;
import java.util.logging.Logger;

public class Test {

	
	public static class WADDirectory{
		
		public final long offSet;
		public final long length;
		public final String name;
		public final ByteBuffer data;
		
		
		public WADDirectory(long offSet, long length, String name, ByteBuffer data) {
			this.offSet = offSet;
			this.length = length;
			this.name  = name;
			this.data = data;
		}
		
		public String toString() {
			return "WADDirectory{" + "offSet=" +offSet+ ", length=" +length+ ", name=" +name+ ", data=" +data+"}";
		}
	}
	
	public static ByteBuffer bb;
	
	public static void loadWad(String wadFile) {
		try (InputStream is = new FileInputStream(wadFile);){
			
			bb = ByteBuffer.wrap(is.readAllBytes());
			bb.order(ByteOrder.LITTLE_ENDIAN);
			
			byte[] wadid = new byte[4];
			bb.get(wadid);
			
			System.out.println("wadid: " +new String(wadid));
			
			long lumpsSize = bb.getInt() & 0xffffffff;
			System.out.println("number of entries: " +lumpsSize);
			
			
			long directoryOffSet = bb.getInt() & 0xffffffff;
			System.out.println("directory offset: " +directoryOffSet);
		
			extractDirectories(bb, directoryOffSet, lumpsSize);
				
		}catch (IOException e) {
			
			Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
			
			System.exit(-1);
			
		}
	}
	
	public static List<WADDirectory> directories = new ArrayList<>();
	
	public static void extractDirectories(ByteBuffer bb, long directoryOffSet, long lumpsSize) {
		bb.position((int) directoryOffSet);
		directories.clear();
		
		for(int i = 0; i < lumpsSize; i++) {
			long offSet = bb.getInt() & 0xffffffff;
			long length = bb.getInt() & 0xffffffff;
			byte[] nameBytes = new byte[8];
			bb.get(nameBytes);
			String name = new String(nameBytes);
			ByteBuffer data = bb.slice((int) offSet, (int) length);
			
			WADDirectory directory = new WADDirectory(offSet, length, name, data);
			directories.add(directory);
			
		}
		
	}
	
	public static List<Point> vertexes = new ArrayList<>();
	
	
	public static void extractVertexes(ByteBuffer bb, int lumpIndex) {
		
		WADDirectory dir = directories.get(lumpIndex);
		System.out.println("extracting vertexes "+dir);
		
		bb.position((int) dir.offSet);
		int totalLength = 0;
		
		while(totalLength < dir.length) {
			int x = bb.getShort() & 0xffff;
			int y = bb.getShort() & 0xffff;
			vertexes.add(new Point(x, y));
			totalLength += 2 * 2;
		}
	}
	
	public static class LineDef {
		public final int startVertex;
		public final int endVertex;
		public final int flags;
		public final int specialType;
		public final int specialTag;
		public final int sectorTag;
		public final int frontSidedef;
		public final int backSidedef;
		
		public LineDef(int startVertex, int endVertex, int flags, int specialType, int specialTag, int sectorTag, int frontSidedef, int backSidedef) {
			this.startVertex = startVertex;
			this.endVertex = endVertex;
			this.flags = flags;
			this.specialType = specialType;
			this.specialTag = specialTag;
			this.sectorTag = sectorTag;
			this.frontSidedef = frontSidedef;
			this.backSidedef = backSidedef;
			
			
		}
		
	}
	
	
	public static void extractLineDefs(ByteBuffer bb, int lumpsIndex) {
		WADDirectory dir = directories.get(lumpsIndex);
		System.out.println("extracting lineDefs "+dir);
		
		int totalLength = 0;
		bb.position((int) dir.offSet);
		
		while(totalLength < dir.length) {
			int startVertex = bb.getShort() & 0xffff;
			int endVertex = bb.getShort() & 0xffff;
			int flags = bb.getShort() & 0xffff;
			int specialType = bb.getShort() & 0xffff;
		
		}
		
		
		
		
	}
	
	public static class Thing{
		
		public final int xPosition;
		public final int yPosition;
		public final int angle;
		public final int type;
		public final int flags;
		
		public Thing(int xPosition, int yPosition, int angle, int type, int flags) {
			this.xPosition = xPosition;
			this.yPosition = yPosition;
			this.angle = angle;
			this.type = type;
			this.flags = flags;
			
		}
		
		public static List<Thing> things = new ArrayList<>();
		
		public static void extractThings(ByteBuffer bb, int lumpIndex) {

			
		}
		
		
	}
}
