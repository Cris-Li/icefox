package icefox.htmlinfohandletest;

import static org.junit.Assert.*;

import org.junit.Test;

import icefox.htmlinfohandle.GrabWebInfo;

public class GrabWebInfoTest {

	@Test
	public void testWebInfoHandle() throws Exception {
		GrabWebInfo grabwebinfo = new GrabWebInfo();
		grabwebinfo.toExcel();
	}

}
