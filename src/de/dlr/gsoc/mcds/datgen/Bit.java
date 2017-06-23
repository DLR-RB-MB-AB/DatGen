package de.dlr.gsoc.mcds.datgen;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;

public class Bit extends Data {
    private byte _internalState = 0;
	public Bit() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int flush(OutputStream out, aspect a, int currentOctet) throws IOException {
		int i =0;
		for (i = append(out,a,currentOctet);i / 256 == 7;i = append(out,a,i)) {}
		return i;
	}
	
	@Override
	public int append(OutputStream out, aspect a, int currentOctet) throws IOException {
		byte current = (byte) (currentOctet & 255);
		int cursor=(currentOctet / 256) & 255;
		if(cursor==0)
		{
			current = (byte) (current + _internalState);
			byte[] b=null;
			switch (a) {
			case binary:
				b = new byte[1];
				b[0] = current;
				out.write(b);
				break; 
			case hex:
				b = new byte[2];
				b[0] = (byte) ((current >> 4) + '0');
				b[1] = (byte) ((current & 15) + '0');
				out.write(b);
				break;
			}
			current = 0;
			cursor = 7;
		} else {
			current = (byte) (current + (_internalState << cursor));
			cursor--;
		}
		return cursor * 256 + current;
	}

	
	@Override
	public void setInternalState(Object value) {
		// TODO Auto-generated method stub
		_internalState = (byte) value;
	}

	@Override
	public Object switchToNextState() {
		// TODO Auto-generated method stub
		return null;
	}

}
