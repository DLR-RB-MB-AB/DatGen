package de.dlr.gsoc.mcds.datgen;

import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class testBit {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void testSetInternalState() {
		Bit b = new Bit();
		b.setInternalState(1);

		java.io.ByteArrayOutputStream bw = new ByteArrayOutputStream();
		StringWriter sw = new StringWriter();
		bw.toString();
		try {
			b.flush(bw,de.dlr.gsoc.mcds.datgen.Data.aspect.hex,0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s =sw.toString();
		boolean b = s.equals("80");
		Assert.assertTrue("",b);
}

	@Test
	public final void testSwitchToNextState() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testFlushBufferedOutputStreamAspectInt() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testAppendBufferedOutputStreamAspectInt() {
		fail("Not yet implemented"); // TODO
	}

}
