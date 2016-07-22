package pers.cris.li.htmlinfohandle;

import static org.junit.Assert.*;

import org.junit.Test;

public class GrabWebInfoTest {

	@Test
	public void testWebInfoHandle() throws Exception {
		GrabWebInfo grabwebinfo = new GrabWebInfo();
		grabwebinfo.toExcel();
	}

}
