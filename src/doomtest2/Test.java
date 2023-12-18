package doomtest2;

import java.awt.Color;
import java.awt.Point;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
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
		public final int sectorTag;
		public final int frontSidedef;
		public final int backSidedef;
		
		public LineDef(int startVertex, int endVertex, int flags, int specialType, int sectorTag, int frontSidedef, int backSidedef) {
			this.startVertex = startVertex;
			this.endVertex = endVertex;
			this.flags = flags;
			this.specialType = specialType;
			this.sectorTag = sectorTag;
			this.frontSidedef = frontSidedef;
			this.backSidedef = backSidedef;
			
			
		}
		
	}
	
	public static List<LineDef> lineDefs = new ArrayList<>();
	
	
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
			int sectorTag = bb.getShort() & 0xffff;
			int frontSidedef = bb.getShort() & 0xffff;
			int backSidedef = bb.getShort() & 0xffff;
			lineDefs.add(new LineDef(startVertex, endVertex, flags, specialType, sectorTag, frontSidedef, backSidedef));	
			totalLength += 7 * 2;
		}
	}
	
	
	public static class SideDef {
		
		public final int offSetX;
		public final int offSetY;
		public final String upperTextureName;
		public final String lowerTextureName;
		public final String middleTextureName;
		public final int sectorNumber;
		
		
		public SideDef(int offSetX, int offSetY, String upperTextureName, String lowerTextureName, String middleTextureName, int sectorNumber) {
			this.offSetX = offSetX;
			this.offSetY = offSetY;
			this.upperTextureName = upperTextureName;
			this.lowerTextureName = lowerTextureName;
			this.middleTextureName = middleTextureName;
			this.sectorNumber = sectorNumber;
			
		}
		
	}
	
	public static List<SideDef> sideDefs = new ArrayList<>();
	
	public static void extractSideDefs(ByteBuffer bb, int lumpIndex) {
		WADDirectory dir = directories.get(lumpIndex);
		System.out.println("extracting sideDefs "+dir);
		
		int totalLength = 0;
		bb.position((int) dir.offSet);
		while(totalLength < dir.length) {
			int offSetX = bb.getShort() & 0xffff;
			int offSetY = bb.getShort() & 0xffff;

			byte[] upperTextureNameBytes = new byte[8];
			bb.get(upperTextureNameBytes);			
			String upperTextureName = new String(upperTextureNameBytes);
			
			byte[] lowerTextureNameBytes = new byte[8];
			bb.get(lowerTextureNameBytes);
			String lowerTextureName = new String(lowerTextureNameBytes);
			
			byte[] middleTextureNameBytes = new byte[8];
			bb.get(middleTextureNameBytes);
			String middleTextureName = new String (middleTextureNameBytes);
			
			int sectorNumber = bb.getShort() & 0xffff;
			
			sideDefs.add(new SideDef(offSetX, offSetY, upperTextureName, lowerTextureName, middleTextureName, sectorNumber));
			totalLength += 3 * 2 + 3 * 8;
							
		}
	
	}
	
	public static class Seg {
		
		public final int startingVertexNumber;
		public final int endingVertexNumber;
		public final int angle;
		public final int lineDefNumber;
		public final int direction;
		public final int offSet;
		public final Color color = new Color(0xff000000 + (int) (0xaaaaaa * Math.random()));
		
		public Seg(int startingVertexNumber, int endingVertextNumber, int angle, int lineDefNumber, int direction, int offSet) {
			this.startingVertexNumber = startingVertexNumber;
			this.endingVertexNumber = endingVertextNumber;
			this.angle = angle;
			this.lineDefNumber = lineDefNumber;
			this.direction = direction;
			this.offSet = offSet;
		}
	}
	
	public static List<Seg> segs = new ArrayList<>();
	
	public static void extractSegs(ByteBuffer bb, int lumpIndex) {
		WADDirectory dir = directories.get(lumpIndex);
		System.out.println("extracting segs " +dir);
		
		int totalLength = 0;
		bb.position((int) dir.offSet);
		
		while(totalLength < dir.length) {
			int startingVertexNumber = bb.getShort() & 0xffff;
			int endingVertexNumber = bb.getShort() & 0xffff;
			int angle = bb.getShort() & 0xffff;
			int lineDefNumber = bb.getShort() & 0xffff;
			int direction = bb.getShort() & 0xffff;
			int offSet = bb.getShort() & 0xffff;
			
			Seg seg = new Seg(startingVertexNumber, endingVertexNumber, angle, lineDefNumber, direction, offSet);
			segs.add(seg);
			totalLength += 6 * 2;
		}
		
	}
	
	public static class Node {
		
		public final int XPartition;
		public final int YPartition;
		public final int ChangeXPartition;
		public final int ChangeYPartition;
		
		public final int RightBoxTop;
		public final int RightBoxBottom;
		public final int RightBoxLeft;
		public final int RightBoxRight;
		
		public final int LeftBoxTop;
		public final int LeftBoxBottom;
		public final int LeftBoxLeft;
		public final int LeftBoxRight;
		
		public final int RightChildID;
		public final int LeftChildID;
		
		
		public final int
		
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
