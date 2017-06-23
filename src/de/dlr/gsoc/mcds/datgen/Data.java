package de.dlr.gsoc.mcds.datgen;

import java.io.IOException;
import java.io.OutputStream;

public abstract class Data {
public final int bitlength=0;
public byte[] bytes;
public enum aspect {binary, hex};
// LSByte of Current OCtet is the actual byte
// next higer bye is pointer to the bit which is to be filled next
// starting form 7 decrementing to 0
// 0 and a full octet is flushed to output and ever returned
// instead a empty byte and 0x7 is initialized
public abstract int append (OutputStream out,aspect a, int currentOctet) throws IOException;
// like append butnoutt fie is written even with incomplete byte and closed
public abstract int flush (OutputStream out,aspect a, int currentOctet) throws IOException;
public abstract void setInternalState(Object value);
public abstract Object switchToNextState(); // iterates throug test pattern like 0-1 for bit 
                                            //-max,-1,0,1,max for signed
											//m 0, masb-1,msb=1,max for unsigned int,
}
