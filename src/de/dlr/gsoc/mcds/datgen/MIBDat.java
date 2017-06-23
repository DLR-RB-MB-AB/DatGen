package de.dlr.gsoc.mcds.datgen;

import java.util.Hashtable;
import java.util.List;

/// Prototype class for tab separated ASCII files
public class MIBDat {
	String[] stripped_field_names;
	String icd_version;
	String vcd_version;
	String[] foreignKeys; //name of matching field in other table
	String[] ownKeys; // name of matchingfield in this table
	MIBDat[] foreignTables;
	// key retrieves a list of records Each is an assoc List
	// like dataset
	Hashtable<String,List<Hashtable<String,String>>> content ;
}
